package com.atguigu.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 群聊
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.137.1",9999);
		
		//2、开启两个线程，一个收消息，一个发消息
		SendThread st = new SendThread(socket);
		ReceiveThread rt = new ReceiveThread(socket);
		
		st.start();
		rt.start();
		
		//等发送线程停下来再往下走
		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//让接收数据的线程停下
		rt.setFlag(false);
		
		//等接收线程停下来，再往下走，断开连接
		try {
			rt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		socket.close();
	}
}
class SendThread extends Thread{
	private Socket socket;
	
	public SendThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//键盘输入
			Scanner input = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			PrintStream ps = new PrintStream(out);
			while(true){
				//从键盘输入
				System.out.print("请输入要发送的消息：");
				String content = input.nextLine();
				System.out.println("content:" + content);
				
				//给服务器发送
				ps.println(content);
				
				//如果bye，就结束发送
				if("bye".equals(content)){
					break;
				}
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class ReceiveThread extends Thread{
	private Socket socket;
	private boolean flag = true;
	
	public ReceiveThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run(){
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			while(flag){
				String line = br.readLine();
				System.out.println(line);
				if("bye".equals(line)){
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

/*****************************/
package com.atguigu.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * 群聊
 */
public class TestServer {
	private static ArrayList<Socket> online = new ArrayList<Socket>();
	
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			//2、接收客户端的连接
			Socket socket = server.accept();
			
			//把这个客户端加入到online中
			online.add(socket);
			
			//每一个客户端独立的线程
			MessageHandler mh = new MessageHandler(socket);
			mh.start();
		}
	}

	//私有的静态的内部类
	//这里用内部类的原因，是为了用上面的online集合
	private static class MessageHandler extends Thread{
		private Socket socket;
		private String ip;
		
		public MessageHandler(Socket socket) {
			super();
			this.socket = socket;
			this.ip = socket.getInetAddress().getHostAddress();
		}

		public void run(){
			//这个客户端的一连接成功，线程一启动，就可以告诉其他人我上线了
			sendToOthers(ip+"上线了");
			
			/*
			 * （1）接收当前的客户端发送的消息
			 * （2）给其他在线的客户端转发
			 */
			//（1）接收当前的客户端发送的消息
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				String content;
				while((content = br.readLine()) !=null){
					if("bye".equals(content)){
						//给自己发一句bye
						OutputStream out = socket.getOutputStream();
						PrintStream ps = new PrintStream(out);
						ps.println("bye");
						
						break;
					}
					
					//收到一句，转发一句
					sendToOthers(ip+"说:" + content);
				}
				
				sendToOthers(ip+"下线了");
			} catch (IOException e) {
				sendToOthers(ip+"掉线了");
			}
		}
		
		//因为转发的代码也很长，独立为一个方法
		public void sendToOthers(String str){
			//遍历所有online的客户端
			Iterator<Socket> iterator = online.iterator();
			while(iterator.hasNext()){
				Socket on = iterator.next();
				if(!on.equals(socket)){//只给其他客户端转发
					try {
						OutputStream out = on.getOutputStream();
						PrintStream ps = new PrintStream(out);
						
						ps.println(str);
					} catch (IOException e) {
						//说明on这个客户端要么下线了，要么掉线了
						iterator.remove();
					}
				}
			}
		}
	}
	
}
