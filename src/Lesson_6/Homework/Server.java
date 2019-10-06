package Lesson_6.Homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    final int PORT = 8189;

    DataInputStream in;
    DataOutputStream out;


    public Server() {
        runServer();
        listenConsole();
    }

    private void listenConsole() {
        Scanner consoleIn = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Введите строку для отправки:");
                String str = consoleIn.nextLine();
                out.writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runServer() {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = null;
                            str = in.readUTF();

                            if (str.equalsIgnoreCase("/end"))
                                break;
                            System.out.println("Получено сообщение: " + str);
                            System.out.println("Введите строку для отправки:");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ServerMain {
    public static void main(String[] args) {
        new Server();
    }
}
