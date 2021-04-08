import org.junit.jupiter.api.Test;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.*;
//проверка подключения к другому порту
class TCPClientTest {

    @Test
    void main() {
        int PORT = 1567;
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
    }
}