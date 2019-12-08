package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        new Thread(new ConsoleMessenger());
        Thread.setDaemon(true);
        Thread.start();

        try {
            server = new ServerSocket(5577);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
