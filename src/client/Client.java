package client;

import com.sun.corba.se.spi.activation.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Server server;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public Client() {

            try {
                this.server = server;
                this.socket = socket;

//            System.out.println("LocalPort: "+socket.getLocalPort());
//            System.out.println("Port: "+socket.getPort());
//            System.out.println("InetAddress: "+socket.getInetAddress());
//            System.out.println("RemoteSocketAddress: "+socket.getRemoteSocketAddress());

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                new Thread(() -> {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                System.out.println("Клиент отключился");
                                break;
                            }
//                        System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void sendMsg(String msg){
            try {
                out.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
