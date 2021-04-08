import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

class TCPServerTest {
//одновременно два сервера с одного порта
    @Test
    void main() {
        final int PORT = 1234;
        TCPServerSender tcpServerSender = new TCPServerSender();
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server start!");
            while (true){
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, tcpServerSender.getId());
                tcpServerSender.addNewClient(clientThread);
                tcpServerSender.update(tcpServerSender);
                System.out.println("New client accepted. " + clientSocket.getInetAddress());
                clientThread.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
