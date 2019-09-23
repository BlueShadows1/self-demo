package com.example.demo.io.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SelfServer {

	private static ExecutorService pool = Executors.newCachedThreadPool();
	private static Map<Integer, BufferedWriter> clients = new ConcurrentHashMap<Integer, BufferedWriter>();
	private static AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(7070);
			while (true) {
				Socket s = ss.accept();
				pool.execute((Runnable) new SocketChannel(s));
//			InputStream in = s.getInputStream();
//			OutputStream out = s.getOutputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
//			while (true) {
//				String msg = br.readLine();
//				bw.write("将客户端发送的消息返回:" + msg);
//				bw.newLine();
//				bw.flush();
//			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class SocketChannel implements Runnable {
		public Socket ss;
		private Integer id;

		private SocketChannel(Socket s) {
			ss = s;
			id = counter.incrementAndGet();
		}

		public void run() {
			try {
				InputStream in = ss.getInputStream();
				OutputStream out = ss.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
				clients.put(id, bw);
				while (true) {
					String msg = br.readLine();
					clients.forEach((k, v) -> {
						sysout(k, v, msg);
					});
//					for (BufferedWriter b : clients.values()) {
//
//					}
//					bw.write("将客户端发送的消息返回:" + msg);
//					bw.newLine();
//					bw.flush();
				}
//         }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void sysout(Integer k, BufferedWriter v, String msg) {
			try {
				v.write(msg);
				v.newLine();
				v.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
