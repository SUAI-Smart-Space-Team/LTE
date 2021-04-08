import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//меняем порт у сервера, у клиента старый 1234
public class TestServer {
        public static void main(String[] args) throws IOException {
            final int PORT = 1576;
            TCPServerSender test_tcpServerSender = new TCPServerSender();

            try {

                ServerSocket serverSocket = new ServerSocket(PORT);
                System.out.println("Server start!");

                while (true){
                    Socket clientSocket = serverSocket.accept();
                    ClientThread clientThread = new ClientThread(clientSocket, test_tcpServerSender.getId());
                    test_tcpServerSender.addNewClient(clientThread);
                    test_tcpServerSender.update(test_tcpServerSender);
                    System.out.println("New client accepted. " + clientSocket.getInetAddress());
                    clientThread.start();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
