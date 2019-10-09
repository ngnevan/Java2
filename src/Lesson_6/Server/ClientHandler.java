package Lesson_6.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private MainServ serv;

    private String nick;

    public ClientHandler(MainServ serv, Socket socket) {
        try {
            this.serv = serv;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String currentNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);

                                if (serv.isLoggedIn(currentNick)) {
                                    sendMsg("/already_logged_in: Вход под данным логином уже выполнен");
                                } else if (currentNick != null) {
                                    sendMsg("/authok");
                                    nick = currentNick;
                                    serv.subscribe(ClientHandler.this);
                                    break;
                                } else {
                                    sendMsg("неверный логин/пароль");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if (str.equalsIgnoreCase("/end")) {
                                sendMsg("/clientClose");
                                break;
                            } else if (str.startsWith("/w")) {
                                String[] words = str.split(" ");
                                String receiverNick = words[1];
                                String msg = getMsgFromStrArr(words);
                                serv.unicastMsg(receiverNick, nick + ": " + msg);
                            } else
                                serv.broadcastMsg(nick + ": " + str);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        serv.unsubscribe(ClientHandler.this);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    private String getMsgFromStrArr(String[] strArr) {
        String result = "";
        for (int i = 2; i < strArr.length - 1; i++) {
            result = result + strArr[i] + " ";
        }
        result = result + strArr[strArr.length - 1];
        return result;
    }
}
