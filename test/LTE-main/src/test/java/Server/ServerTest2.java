package Server;

import Connection.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Before;


public class ServerTest2 {

    @Before
    public void before() {
        System.out.println("@Before");
        Thread myThread = new Thread() {
            public void run() {
                System.out.println("@Before myThread run()");
                Socket ServerSocket = null;
                try {
                    ServerSocket myServer = new ServerSocket(3000);
                    System.out.println("@Before myThread run() - server socket created.");
                    ServerSocket = myServer.accept();
                    System.out.println("@Before myThread run() - accepted connection");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

            ///- Использование аннотации Before приведет к созданию нового потока ServerSocket
  //  для каждого метода тестирования. Что приведет к невозможности использования
    //тот же адрес. Старый поток все еще будет жив.

    @Test
    public void test1() throws Exception {
        System.out.println("test1");
        synchronized (this) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                // do nothing.
            }
        }
        System.out.println("test1 - after wait");
        //повторно отправляем сокет
        new Socket("localhost", 3000);
        synchronized (this) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                // do nothing.
            }
        }
        System.out.println("test1 - after second wait");
    }
}