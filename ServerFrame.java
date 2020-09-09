import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.*;

//////////*服务器窗口类*///////////////
// 样式见图片1
public class ServerFrame extends JFrame implements ActionListener {
	// 类的属性
	// JList：列表框组件
	public  JList list;
	// 用于Java的序列化机制
	// Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的
	// 与版本兼容性有关
	private static final long serialVersionUID = -8936397327038098620L;

	// 服务器信息面板
	JPanel pnlServer, pnlServerInfo;
	// Label:对应图片1左边
	JLabel lblStatus, lblNumber, lblMax, lblServerName, lblProtocol, lblIP,
			lblPort, lblLog;
	// 对应以上Label的文本框
	public JTextField txtStatus, txtNumber, txtMax, txtServerName, txtProtocol, txtIP,
			txtPort;
	// 定义底部两个按钮
	JButton btnStop, btnSaveLog;
	// 文本区域
	public TextArea taLog;
	// 标签面板
	JTabbedPane tpServer;
	// 文本区域
	public TextArea taMessage;

	// 用户信息面板
	JPanel pnlUser;
	// 定义Label
	public JLabel lblMessage, lblUser, lblNotice, lblUserCount;
	// JList：列表框组件
	JList lstUser;
	// 滚动条
	JScrollPane spUser;
	// 文本区域
	JTextField txtNotice;
	// 按钮
	JButton btnSend, btnKick;
	
	public String serverMessage ="";

	// 类的方法
	// 构造函数
	public ServerFrame() {
		// 服务器窗口
		// 调用父类构造函数 其父类为JFrame 效果见图片1左上角
		super("聊天服务器");
		// 调整组件大小 (width, height)
		setSize(550, 500);
		// 设置用户发起close时(点击x号时)执行的操作
		// JFrame.EXIT_ON_CLOSE:退出应用程序
		// 其他三种情况为：
		// DO_NOTHING_ON_CLOSE
		// HIDE_ON_CLOSE
		// HIDE_ON_CLOSE:自动隐藏并释放窗体
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体是否可调节大小
		setResizable(false);
		// 获取屏幕大小
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();// 在屏幕居中显示
		// 获取此窗体大小
		Dimension fra = this.getSize();
		// 窗体自适应
		if (fra.width > scr.width) {
			fra.width = scr.width;
		}
		if (fra.height > scr.height) {
			fra.height = scr.height;
		}
		// setLocation(x, y) (x,y):窗体左上角位置
		this.setLocation((scr.width - fra.width) / 2,
				(scr.height - fra.height) / 2);

		// ==========服务器信息面板=========================
		pnlServer = new JPanel();    // 实例化 之前只有定义
		// 界面的布局
		// 一共有5种 FlowLayout、BorderLayout、GridLayout、CardLayout、GridBagLayout
		pnlServer.setLayout(null);
		// 设置背景色 蓝色
		pnlServer.setBackground(new Color(52, 130, 203));
		// 左边面板实例化 布局为14 * 1 的格子
		pnlServerInfo = new JPanel(new GridLayout(14, 1));
		// 设置背景颜色
		pnlServerInfo.setBackground(new Color(52, 130, 203));
		// 设置字体
		pnlServerInfo.setFont(new Font("宋体", 0, 12));
		// 设置边框
		pnlServerInfo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(""), BorderFactory
						.createEmptyBorder(1, 1, 1, 1)));

		// 设置显示文字
		lblStatus = new JLabel("当前状态:");
		// 文字颜色
		lblStatus.setForeground(Color.YELLOW);
		// 文字样式
		lblStatus.setFont(new Font("宋体", 0, 12));
		// 文本区域
		txtStatus = new JTextField(10);
		// 文本区域背景色
		txtStatus.setBackground(Color.decode("#d6f4f2"));
		// 文本区域字体样式
		txtStatus.setFont(new Font("宋体", 0, 12));
		// 文本区域是否可编辑
		txtStatus.setEditable(false);

		lblNumber = new JLabel("当前在线人数:");
		lblNumber.setForeground(Color.YELLOW);
		lblNumber.setFont(new Font("宋体", 0, 12));
		txtNumber = new JTextField("0 人", 10);
		txtNumber.setBackground(Color.decode("#d6f4f2"));
		txtNumber.setFont(new Font("宋体", 0, 12));
		txtNumber.setEditable(false);

		lblMax = new JLabel("最多在线人数:");
		lblMax.setForeground(Color.YELLOW);
		lblMax.setFont(new Font("宋体", 0, 12));
		txtMax = new JTextField("50 人", 10);
		txtMax.setBackground(Color.decode("#d6f4f2"));
		txtMax.setFont(new Font("宋体", 0, 12));
		txtMax.setEditable(false);

		lblServerName = new JLabel("服务器名称:");
		lblServerName.setForeground(Color.YELLOW);
		lblServerName.setFont(new Font("宋体", 0, 12));
		txtServerName = new JTextField(10);
		txtServerName.setBackground(Color.decode("#d6f4f2"));
		txtServerName.setFont(new Font("宋体", 0, 12));
		txtServerName.setEditable(false);

		lblProtocol = new JLabel("访问协议:");
		lblProtocol.setForeground(Color.YELLOW);
		lblProtocol.setFont(new Font("宋体", 0, 12));
		txtProtocol = new JTextField("HTTP", 10);
		txtProtocol.setBackground(Color.decode("#d6f4f2"));
		txtProtocol.setFont(new Font("宋体", 0, 12));
		txtProtocol.setEditable(false);

		lblIP = new JLabel("服务器IP:");
		lblIP.setForeground(Color.YELLOW);
		lblIP.setFont(new Font("宋体", 0, 12));
		txtIP = new JTextField(10);
		txtIP.setBackground(Color.decode("#d6f4f2"));
		txtIP.setFont(new Font("宋体", 0, 12));
		txtIP.setEditable(false);

		lblPort = new JLabel("服务器端口:");
		lblPort.setForeground(Color.YELLOW);
		lblPort.setFont(new Font("宋体", 0, 12));
		txtPort = new JTextField("8000", 10);
		txtPort.setBackground(Color.decode("#d6f4f2"));
		txtPort.setFont(new Font("宋体", 0, 12));
		txtPort.setEditable(false);

		// 底部按钮
		btnStop = new JButton("关闭服务器(C)");
		// 按钮注册监听器
		btnStop.addActionListener(new ActionListener() {
			// 监听器的实现
			public void actionPerformed(ActionEvent arg0) {
				// 自定义函数 实现在下面
				closeServer();
			}
		});
		// 按钮背景色
		btnStop.setBackground(Color.ORANGE);
		// 按钮字体
		btnStop.setFont(new Font("宋体", 0, 12));

		lblLog = new JLabel("[服务器日志]");
		lblLog.setForeground(Color.YELLOW);
		lblLog.setFont(new Font("宋体", 0, 12));

		taLog = new TextArea(20, 50);
		taLog.setFont(new Font("宋体", 0, 12));
		btnSaveLog = new JButton("保存日志(S)");
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveLog();
			}
		});
		btnSaveLog.setBackground(Color.ORANGE);
		btnSaveLog.setFont(new Font("宋体", 0, 12));

		// 将所有组件添加的Panel中 否则不显示 (左边部分)
		pnlServerInfo.add(lblStatus);
		pnlServerInfo.add(txtStatus);
		pnlServerInfo.add(lblNumber);
		pnlServerInfo.add(txtNumber);
		pnlServerInfo.add(lblMax);
		pnlServerInfo.add(txtMax);
		pnlServerInfo.add(lblServerName);
		pnlServerInfo.add(txtServerName);
		pnlServerInfo.add(lblProtocol);
		pnlServerInfo.add(txtProtocol);
		pnlServerInfo.add(lblIP);
		pnlServerInfo.add(txtIP);
		pnlServerInfo.add(lblPort);
		pnlServerInfo.add(txtPort);

		// setBounds(x, y, width, height)
		pnlServerInfo.setBounds(5, 5, 100, 400);
		lblLog.setBounds(110, 5, 100, 30);
		taLog.setBounds(110, 35, 400, 370);
		btnStop.setBounds(200, 410, 120, 30);
		btnSaveLog.setBounds(320, 410, 120, 30);
		pnlServer.add(pnlServerInfo);
		pnlServer.add(lblLog);
		pnlServer.add(taLog);
		pnlServer.add(btnStop);
		pnlServer.add(btnSaveLog);
		// ===========在线用户面板====================
		pnlUser = new JPanel();
		pnlUser.setLayout(null);
		pnlUser.setBackground(new Color(52, 130, 203));
		pnlUser.setFont(new Font("宋体", 0, 12));
		lblMessage = new JLabel("[用户消息]");
		lblMessage.setFont(new Font("宋体", 0, 12));
		lblMessage.setForeground(Color.YELLOW);
		taMessage = new TextArea(20, 20);
		taMessage.setFont(new Font("宋体", 0, 12));
		lblNotice = new JLabel("通知：");
		lblNotice.setFont(new Font("宋体", 0, 12));
		txtNotice = new JTextField(20);
		txtNotice.setFont(new Font("宋体", 0, 12));
		btnSend = new JButton("发送");
		btnSend.setBackground(Color.ORANGE);
		btnSend.setFont(new Font("宋体", 0, 12));
		btnSend.setEnabled(true);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 自定义方法 具体定义见下方
				serverMessage();
			}
		});

		lblUserCount = new JLabel("在线总人数 0 人");
		lblUserCount.setFont(new Font("宋体", 0, 12));

		lblUser = new JLabel("[在线用户列表]");
		lblUser.setFont(new Font("宋体", 0, 12));
		lblUser.setForeground(Color.YELLOW);

		lstUser = new JList();
		lstUser.setFont(new Font("宋体", 0, 12));
		lstUser.setVisibleRowCount(17);
		lstUser.setFixedCellWidth(180);
		lstUser.setFixedCellHeight(18);

		spUser = new JScrollPane();
		spUser.setBackground(Color.decode("#d6f4f2"));
		spUser.setFont(new Font("宋体", 0, 12));
		spUser.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spUser.getViewport().setView(lstUser);

		lblMessage.setBounds(5, 5, 100, 25);
		taMessage.setBounds(5, 35, 300, 360);
		lblUser.setBounds(310, 5, 100, 25);
		spUser.setBounds(310, 35, 220, 360);
		lblNotice.setBounds(5, 410, 40, 25);
		txtNotice.setBounds(50, 410, 160, 25);
		btnSend.setBounds(210, 410, 80, 25);
		lblUserCount.setBounds(320, 410, 100, 25);

		pnlUser.add(lblMessage);
		pnlUser.add(taMessage);
		pnlUser.add(lblUser);
		pnlUser.add(spUser);

		list = new JList();
		list.setListData(new String[] { "" });
		spUser.setViewportView(list);
		pnlUser.add(lblNotice);
		pnlUser.add(txtNotice);
		pnlUser.add(btnSend);
		pnlUser.add(lblUserCount);

		// ============主标签面板========================

		tpServer = new JTabbedPane(JTabbedPane.TOP);
		tpServer.setBackground(Color.decode("#d6f4f2"));
		tpServer.setFont(new Font("宋体", 0, 12));
		tpServer.add("服务器管理", pnlServer);
		tpServer.add("用户信息管理", pnlUser);
		this.getContentPane().add(tpServer);
		setVisible(true);
	}

	protected void serverMessage() {
		// txtNotice是一个文本框
		// 获取文本框中输入的内容 通知内容
		this.serverMessage = txtNotice.getText();
		// 清空文本框
		txtNotice.setText("");
	}

	protected void closeServer() {
		// 释放此类占有的资源
		this.dispose();
	}
	// 保存服务器日志
	protected void saveLog() {
		try {
			// 指定输入到lox.txt文件中
			// true：以追加的形式 而非覆盖的形式
			FileOutputStream fileoutput = new FileOutputStream("log.txt",
					true);
			// taMessage是一个文本框 获取文本框中的内容
			String temp = taMessage.getText();
			// 写入
			fileoutput.write(temp.getBytes());
			// 关闭输出流
			fileoutput.close();
			// 自动弹框 提示用户 样式见图片5
			JOptionPane.showMessageDialog(null, "记录保存在log.txt");
		} catch (Exception e) {
			// 捕捉异常 输出异常
			System.out.println(e);
		}
	}
	// 在屏幕上输入日志
	// 上一个函数时将日志写入文件
	private void log(String string) {
		String newta = taMessage.getText();
		newta += ("\n"+string);
		taMessage.setText(newta);
	}

	public void actionPerformed(ActionEvent evt) {

	}

	public static void main(String args[]) {
		new ServerFrame();
	}
}