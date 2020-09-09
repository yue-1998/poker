import java.io.*;
import java.net.*;
import java.util.*;

/**
 * ����ϵͳ����������
 */
public class AppServer extends Thread
{
	// �������
	
	// ServerSocket������տͻ��������󣬲�������ͻ������ӵ�Socket
	// ServerSocket��java�ṩ
	private ServerSocket serverSocket;
	// ServerFrame:�������Ĵ�����(�Զ���)
	private ServerFrame sFrame;
	// Vector:ʵ��һ����̬���飬����ArrayList 
	// Vector��ͬ�����ʵ�
	// Vector���������б�
	// ����һ��Vector���������б���ʼֵΪ1����ֻ��1��Ԫ��
	// new Vector(int init, int capa) init����Vector��������capa����ÿ�����������ֵ
	private static Vector userOnline = new Vector(1, 1);
	// ͬ�� ��������???
	private static Vector v = new Vector(1, 1);

	// ��ķ���
	/**
	 * ���������� �����������1001�˿�
	 */
	// ��Ĺ��캯��
	public AppServer()
	{
		// Ϊ����˴���һ�����ڣ���ҳ�棩 �����ͼƬ1
		sFrame = new ServerFrame();
		try
		{
			// �������󶨵�1001�Ŷ˿�
			serverSocket = new ServerSocket(1001);
			// ��ȡ���ص������ַ
			InetAddress address = InetAddress.getLocalHost();
			// ��������������Ҫ�Ĳ��� ������ �����ַ �˿ں�
			// �����ͼƬ1���½�
			// ���������ֶξ�������ServerFrame��
			sFrame.txtServerName.setText(address.getHostName());
			sFrame.txtIP.setText(address.getHostAddress());
			sFrame.txtPort.setText("1001");
		} catch (IOException e)
		{
			// ��������ʧ��
			// fail�������Զ��庯�� ���嶨��������
			fail(e, "������������");
		}
		// ���������ɹ�
		// txtStatus�ֶζ�����ServerFrame����
		// ��ͼƬ1���Ͻ�
		sFrame.txtStatus.setText("������...");
		// �����߳� ����̳���Thread
		this.start(); 
	}

	/**
	 * �˳�������
	 * 
	 * @param e
	 *                �쳣
	 * @param str
	 *                �˳���Ϣ
	 */
	public static void fail(Exception e, String str)
	{
		// ��������ʧ��
		// �����캯������
		System.out.println(str + " ��" + e);
	}

	/**
	 * �����ͻ������󣬵����û�����ʱ���� Connection�߳�
	 */
	public void run()
	{
		try
		{
			while (true)
			{
				// ServerSocket�������� ��������ΪSocket
				// Socket -> �ͻ���
				// ���û����ӽ���ʱ���뽫��������ִ��
				// �����������
				Socket client = serverSocket.accept();
				// Connection�ࣺ�Զ�����???
				new Connection(sFrame, client, userOnline, v); // ֧�ֶ��߳�
			}
		} catch (IOException e)
		{
			// fail�������Զ��庯��
			fail(e, "���ܼ�����");
		}
	}

	/** 
	 * ������ ����������
	 */
	public static void main(String args[])
	{
		new AppServer();
	}
}
