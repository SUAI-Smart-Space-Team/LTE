import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main (String[] args) throws IOException {

        System.out.println("Затем можете ввести свой ник через @ник");
        System.out.println("Выйти через @quit");
        System.out.println("Отправить сокет всем клиентам @sendall");
        System.out.println("Отправить сокет пределенному клиенту @senduser");
        System.out.println("Для начала введите порт для подключения к серверу: (1234)");
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String pORT = bufferedReader.readLine(); //читаем строку с клавиатуры
        int PORT = Integer.parseInt(pORT);

       //int PORT = 1234;
        final String HOST = "localhost";

        try {
            Socket socket = new Socket(HOST,PORT);
            System.out.println("Connected to: " + socket.getInetAddress());

            TCPClientThreadIn tcpClientThreadIn = new TCPClientThreadIn(socket);
            tcpClientThreadIn.start();

            TCPClientThreadOut tcpClientThreadOut = new TCPClientThreadOut(socket);
            tcpClientThreadOut.start();

            tcpClientThreadIn.join();
            tcpClientThreadOut.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Не удалось подключиться к порту сервера");
    }
}
