package com.atguigu.test17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * UDP：非面向连接的，不可靠的，基于数据报的传输协议
 * 
 * DatagramSocket
 * DatagramPacket
 * 
 * 发送端
 * 接收端
 * 
 * 实际中，一般是服务器客户端推送消息。
 *  当客户端连接服务器，服务器就获取的客户端IP地址和端口号，服务器就给客户端推送广告消息
 *  
 * 发送端：
 * DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port) 
 * 参数一：要发送的数据的字节数组
 * 参数二：从字节数组的哪个下标开始
 * 参数三：发送几个字节
 * 参数四：接收方的IP
 * 参数五：接收方的端口号
 */
public class TestSend {
	public static void main(String[] args) throws IOException {
		//1、发送方，建立一个Socket
		//发送方的端口号和IP地址，自动获取
		DatagramSocket ds = new DatagramSocket();
		
		//2、准备把要发送的数据打包
		String str = "马上下课了";
		byte[] bytes = str.getBytes();
		InetAddress ip = InetAddress.getByName("192.168.137.1");
		DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length, ip, 9999);
		
		//3、发送，通过socket发送
		ds.send(dp);
		System.out.println("发送完毕");
		
		//4、关闭
		ds.close();
		
	}
}
/***********************************/

package com.atguigu.test17;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * 接收方：
 * 	DatagramPacket(byte[] buf, int length) 
 * 	参数一：用来装数据的字节数组
 *  参数二：数组的长度
 */
public class TestReceive {
	public static void main(String[] args) throws IOException {
		//1、接收方也要socket
		//接收方的端口号，指定，IP自动获取
		DatagramSocket ds = new DatagramSocket(9999);
		
		//2、准备一个数据报，接收数据
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data,data.length);
		
		//3、接收数据
		ds.receive(dp);
		
		//4、把数据拆解出来
		byte[] bs = dp.getData();//接收的数据
		int len = dp.getLength();//接收的数据的实际长度
		System.out.println(new String(bs,0,len));
		
		//5、断开
		ds.close();
	}
}
