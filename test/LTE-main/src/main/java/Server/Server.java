package Server;

import Connection.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Server {
    private ServerSocket serverSocket;
    private static ViewGuiServer gui; //объект класса представления
    private static ModelGuiServer model; //объект класса модели
    private static volatile boolean isServerStart = false; //флаг отражающий состояние сервера запущен/остановлен


    //метод, запускающий сервер
    protected void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            isServerStart = true;
            gui.refreshDialogWindowServer("Сервер запущен.\n");
        } catch (Exception e) {
            gui.refreshDialogWindowServer("Не удалось запустить сервер.\n");
        }
    }

    //метод останавливающий сервер
    protected void stopServer() {
        try {
            //если серверныйСокет не имеет ссылки или не запущен
            if (serverSocket != null && !serverSocket.isClosed()) {
                for (Map.Entry<String, Connection> user : model.getAllUsersMultiChat().entrySet()) {
                    user.getValue().close();
                }
                serverSocket.close();
                model.getAllUsersMultiChat().clear();
                gui.refreshDialogWindowServer("Сервер остановлен.\n");
            } else gui.refreshDialogWindowServer("Сервер не запущен - останавливать нечего!\n");
        } catch (Exception e) {
            gui.refreshDialogWindowServer("Остановить сервер не удалось.\n");
        }
    }

    //метод, в котором в бесконечном цикле сервер принимает новое сокетное подключение от клиента
    protected void acceptServer() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new ServerThread(socket).start();
            } catch (Exception e) {
                gui.refreshDialogWindowServer("Связь с сервером потеряна.\n");
                break;
            }
        }
    }

    //метод, рассылающий заданное сообщение всем клиентам из мапы
    protected void sendMessageAllUsers(Message message) {
        for (Map.Entry<String, Connection> user : model.getAllUsersMultiChat().entrySet()) {
            try {
                user.getValue().send(message);
            } catch (Exception e) {
                gui.refreshDialogWindowServer("Ошибка отправки сообщения всем пользователям!\n");
            }
        }
    }

    //точка входа для приложения сервера
    public static void main(String[] args) {
        Server server = new Server();
        gui = new ViewGuiServer(server);
        model = new ModelGuiServer();
        gui.initFrameServer();
        //цикл снизу ждет true от флага isServerStart (при старте сервера в методе startServer устанавливается в true)
        //после чего запускается бесконечный цикл принятия подключения от клиента в  методе acceptServer
        //до тех пор пока сервер не остановится, либо не возникнет исключение
        while (true) {
            if (isServerStart) {
                server.acceptServer();
                isServerStart = false;
            }
        }
    }

    //класс-поток, который запускается при принятии сервером нового сокетного соединения с клиентом, в конструктор
    //передается объект класса Socket
    private class ServerThread extends Thread {
        private Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        //метод, реализующий обмен сообщениями
        private void messagingBetweenUsers(Connection connection) {
            while (true) {
                try {
                    ObjectMapper objectMapper = connection.receiveJSON();
                    gui.addMessage(objectMapper.toString());
                    /*Message message = connection.receive();
                    //приняли сообщение от клиента, если тип сообщения TEXT_MESSAGE то пересылаем его всем пользователям
                    if (message.getTypeMessage() == MessageType.TEXT_MESSAGE) {
                        String textMessage = String.format("%s:\n", message.getTextMessage());
                        gui.addMessage(message.getTextMessage());
                        //sendMessageAllUsers(new Message(MessageType.TEXT_MESSAGE, textMessage));
                    }*/
                } catch (Exception e) {
                    gui.refreshDialogWindowServer(String.format("Произошла ошибка при получении файла!\n"));
                    break;
                }
            }
        }

        @Override
        public void run() {
            gui.refreshDialogWindowServer(String.format("Подключился новый пользователь с удаленным сокетом - %s.\n", socket.getRemoteSocketAddress()));
            try {
                //получаем connection при помощи принятого сокета от клиента и запрашиваем имя, регистрируем, запускаем
                //цикл обмена сообщениями между пользователями
                Connection connection = new Connection(socket);
                messagingBetweenUsers(connection);
            } catch (Exception e) {
                gui.refreshDialogWindowServer(String.format("Произошла ошибка при рассылке сообщения от пользователя!\n"));
            }
        }
    }
}
