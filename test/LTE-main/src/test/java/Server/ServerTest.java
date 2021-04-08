package Server;

import org.junit.jupiter.api.Test;

import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest extends Server {
    private ServerSocket serverSocket;
    private static ViewGuiServer gui; //объект класса представления
    private static ModelGuiServer model; //объект класса модели
    private static volatile boolean isServerStart = false; //флаг отражающий состояние сервера запущен/остановлен


    int port= 12;
    @Test
    void testStartServer() {
        try {
            serverSocket = new ServerSocket(port);
            isServerStart = true;
            System.out.println("Заданный разработчиком сервер и введенный не совпали. Сервер не запущен");
            gui.refreshDialogWindowServer("Сервер запущен.\n");
        }
        catch (Exception e) {
            gui.refreshDialogWindowServer("Не удалось запустить сервер.\n");
        }
    }
}
