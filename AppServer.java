import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 聊天系统服务器程序
 */
public class AppServer extends Thread
{
	// 类的属性
	
	// ServerSocket负责接收客户连接请求，并生成与客户端连接的Socket
	// ServerSocket由java提供
	private ServerSocket serverSocket;
	// ServerFrame:服务器的窗口类(自定义)
	private ServerFrame sFrame;
	// Vector:实现一个动态数组，类似ArrayList 
	// Vector是同步访问的
	// Vector保存在线列表
	// 创建一个Vector保存在线列表，初始值为1，且只有1个元素
	// new Vector(int init, int capa) init给出Vector的容量，capa给出每次扩充的扩充值
	private static Vector userOnline = new Vector(1, 1);
	// 同上 用来保存???
	private static Vector v = new Vector(1, 1);

	// 类的方法
	/**
	 * 创建服务器 启动服务监听1001端口
	 */
	// 类的构造函数
	public AppServer()
	{
		// 为服务端创建一个窗口（即页面） 具体见图片1
		sFrame = new ServerFrame();
		try
		{
			// 服务器绑定到1001号端口
			serverSocket = new ServerSocket(1001);
			// 获取本地的网络地址
			InetAddress address = InetAddress.getLocalHost();
			// 服务器窗口类需要的参数 主机名 网络地址 端口号
			// 详情见图片1左下角
			// 以下三个字段均定义在ServerFrame中
			sFrame.txtServerName.setText(address.getHostName());
			sFrame.txtIP.setText(address.getHostAddress());
			sFrame.txtPort.setText("1001");
		} catch (IOException e)
		{
			// 服务启动失败
			// fail函数：自定义函数 具体定义在下面
			fail(e, "不能启动服务！");
		}
		// 服务启动成功
		// txtStatus字段定义在ServerFrame类中
		// 见图片1左上角
		sFrame.txtStatus.setText("已启动...");
		// 启动线程 此类继承了Thread
		this.start(); 
	}

	/**
	 * 退出服务器
	 * 
	 * @param e
	 *                异常
	 * @param str
	 *                退出信息
	 */
	public static void fail(Exception e, String str)
	{
		// 服务启动失败
		// 被构造函数调用
		System.out.println(str + " 。" + e);
	}

	/**
	 * 监听客户的请求，当有用户请求时创建 Connection线程
	 */
	public void run()
	{
		try
		{
			while (true)
			{
				// ServerSocket开启监听 返回类型为Socket
				// Socket -> 客户端
				// 当用户连接进来时代码将继续向下执行
				// 否则代码阻塞
				Socket client = serverSocket.accept();
				// Connection类：自定义类???
				new Connection(sFrame, client, userOnline, v); // 支持多线程
			}
		} catch (IOException e)
		{
			// fail函数：自定义函数
			fail(e, "不能监听！");
		}
	}

	/** 
	 * 主函数 启动服务器
	 */
	public static void main(String args[])
	{
		new AppServer();
	}
}
