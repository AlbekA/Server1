package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleMessenger extends Thread{
        DataOutputStream out;
        Scanner scanner = new Scanner(System.in);

        public void ServerMessenger(DataOutputStream out){
            this.out = out;
        }

        @Override
        public void run() {
            while (true){
                try {
                    out.writeUTF("SERVER: " + scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(out.equals("/end")){
                    System.out.println("Клиент отключился");
                    break;
                }
            }
        }
}
