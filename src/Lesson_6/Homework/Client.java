package Lesson_6.Homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        System.out.println("Подключение к серверу выполнено успешно");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equalsIgnoreCase("/end"))
                            break;
                        System.out.println("Получено сообщение: " + str);
                        System.out.println("Введите строку для отправки:");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}

class ClientMain {
    public static void main(String[] args) {
        new Client();
    }
}