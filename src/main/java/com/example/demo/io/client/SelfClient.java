package com.example.demo.io.client;

import java.io.*;
import java.net.Socket;

public class SelfClient {
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1", 7070);
            // 往服务端写信息
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            // 服务端返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // 连接成功后先给服务端发送连接成功信息
//            if (s.isConnected()) {
//                bw.write("客户端发送消息说:你好");
//                bw.newLine();
//                bw.flush();
//            }
            // 用户输入的信息
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            new Thread(new ServerResponseHandler(br)).start();
            String msg1 = null;
            while ((msg1 = userInput.readLine()) !=null) {
                bw.write(msg1);
                bw.newLine();
                bw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static class ServerResponseHandler implements Runnable {
        BufferedReader br;

        public ServerResponseHandler(BufferedReader br) {
            this.br = br;
        }

        @Override
        public void run() {
            String msg1 = null;
            try {
                while ((msg1 = br.readLine()) != null) {
                    System.out.println("服务端返回信息:" + msg1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
