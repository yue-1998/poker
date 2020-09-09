import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.*;

//////////*������������*///////////////
// ��ʽ��ͼƬ1
public class ServerFrame extends JFrame implements ActionListener {
	// �������
	// JList���б�����
	public  JList list;
	// ����Java�����л�����
	// Java�����л�������ͨ���ж����serialVersionUID����֤�汾һ���Ե�
	// ��汾�������й�
	private static final long serialVersionUID = -8936397327038098620L;

	// ��������Ϣ���
	JPanel pnlServer, pnlServerInfo;
	// Label:��ӦͼƬ1���
	JLabel lblStatus, lblNumber, lblMax, lblServerName, lblProtocol, lblIP,
			lblPort, lblLog;
	// ��Ӧ����Label���ı���
	public JTextField txtStatus, txtNumber, txtMax, txtServerName, txtProtocol, txtIP,
			txtPort;
	// ����ײ�������ť
	JButton btnStop, btnSaveLog;
	// �ı�����
	public TextArea taLog;
	// ��ǩ���
	JTabbedPane tpServer;
	// �ı�����
	public TextArea taMessage;

	// �û���Ϣ���
	JPanel pnlUser;
	// ����Label
	public JLabel lblMessage, lblUser, lblNotice, lblUserCount;
	// JList���б�����
	JList lstUser;
	// ������
	JScrollPane spUser;
	// �ı�����
	JTextField txtNotice;
	// ��ť
	JButton btnSend, btnKick;
	
	public String serverMessage ="";

	// ��ķ���
	// ���캯��
	public ServerFrame() {
		// ����������
		// ���ø��๹�캯�� �丸��ΪJFrame Ч����ͼƬ1���Ͻ�
		super("���������");
		// ���������С (width, height)
		setSize(550, 500);
		// �����û�����closeʱ(���x��ʱ)ִ�еĲ���
		// JFrame.EXIT_ON_CLOSE:�˳�Ӧ�ó���
		// �����������Ϊ��
		// DO_NOTHING_ON_CLOSE
		// HIDE_ON_CLOSE
		// HIDE_ON_CLOSE:�Զ����ز��ͷŴ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô����Ƿ�ɵ��ڴ�С
		setResizable(false);
		// ��ȡ��Ļ��С
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();// ����Ļ������ʾ
		// ��ȡ�˴����С
		Dimension fra = this.getSize();
		// ��������Ӧ
		if (fra.width > scr.width) {
			fra.width = scr.width;
		}
		if (fra.height > scr.height) {
			fra.height = scr.height;
		}
		// setLocation(x, y) (x,y):�������Ͻ�λ��
		this.setLocation((scr.width - fra.width) / 2,
				(scr.height - fra.height) / 2);

		// ==========��������Ϣ���=========================
		pnlServer = new JPanel();    // ʵ���� ֮ǰֻ�ж���
		// ����Ĳ���
		// һ����5�� FlowLayout��BorderLayout��GridLayout��CardLayout��GridBagLayout
		pnlServer.setLayout(null);
		// ���ñ���ɫ ��ɫ
		pnlServer.setBackground(new Color(52, 130, 203));
		// ������ʵ���� ����Ϊ14 * 1 �ĸ���
		pnlServerInfo = new JPanel(new GridLayout(14, 1));
		// ���ñ�����ɫ
		pnlServerInfo.setBackground(new Color(52, 130, 203));
		// ��������
		pnlServerInfo.setFont(new Font("����", 0, 12));
		// ���ñ߿�
		pnlServerInfo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder(""), BorderFactory
						.createEmptyBorder(1, 1, 1, 1)));

		// ������ʾ����
		lblStatus = new JLabel("��ǰ״̬:");
		// ������ɫ
		lblStatus.setForeground(Color.YELLOW);
		// ������ʽ
		lblStatus.setFont(new Font("����", 0, 12));
		// �ı�����
		txtStatus = new JTextField(10);
		// �ı����򱳾�ɫ
		txtStatus.setBackground(Color.decode("#d6f4f2"));
		// �ı�����������ʽ
		txtStatus.setFont(new Font("����", 0, 12));
		// �ı������Ƿ�ɱ༭
		txtStatus.setEditable(false);

		lblNumber = new JLabel("��ǰ��������:");
		lblNumber.setForeground(Color.YELLOW);
		lblNumber.setFont(new Font("����", 0, 12));
		txtNumber = new JTextField("0 ��", 10);
		txtNumber.setBackground(Color.decode("#d6f4f2"));
		txtNumber.setFont(new Font("����", 0, 12));
		txtNumber.setEditable(false);

		lblMax = new JLabel("�����������:");
		lblMax.setForeground(Color.YELLOW);
		lblMax.setFont(new Font("����", 0, 12));
		txtMax = new JTextField("50 ��", 10);
		txtMax.setBackground(Color.decode("#d6f4f2"));
		txtMax.setFont(new Font("����", 0, 12));
		txtMax.setEditable(false);

		lblServerName = new JLabel("����������:");
		lblServerName.setForeground(Color.YELLOW);
		lblServerName.setFont(new Font("����", 0, 12));
		txtServerName = new JTextField(10);
		txtServerName.setBackground(Color.decode("#d6f4f2"));
		txtServerName.setFont(new Font("����", 0, 12));
		txtServerName.setEditable(false);

		lblProtocol = new JLabel("����Э��:");
		lblProtocol.setForeground(Color.YELLOW);
		lblProtocol.setFont(new Font("����", 0, 12));
		txtProtocol = new JTextField("HTTP", 10);
		txtProtocol.setBackground(Color.decode("#d6f4f2"));
		txtProtocol.setFont(new Font("����", 0, 12));
		txtProtocol.setEditable(false);

		lblIP = new JLabel("������IP:");
		lblIP.setForeground(Color.YELLOW);
		lblIP.setFont(new Font("����", 0, 12));
		txtIP = new JTextField(10);
		txtIP.setBackground(Color.decode("#d6f4f2"));
		txtIP.setFont(new Font("����", 0, 12));
		txtIP.setEditable(false);

		lblPort = new JLabel("�������˿�:");
		lblPort.setForeground(Color.YELLOW);
		lblPort.setFont(new Font("����", 0, 12));
		txtPort = new JTextField("8000", 10);
		txtPort.setBackground(Color.decode("#d6f4f2"));
		txtPort.setFont(new Font("����", 0, 12));
		txtPort.setEditable(false);

		// �ײ���ť
		btnStop = new JButton("�رշ�����(C)");
		// ��ťע�������
		btnStop.addActionListener(new ActionListener() {
			// ��������ʵ��
			public void actionPerformed(ActionEvent arg0) {
				// �Զ��庯�� ʵ��������
				closeServer();
			}
		});
		// ��ť����ɫ
		btnStop.setBackground(Color.ORANGE);
		// ��ť����
		btnStop.setFont(new Font("����", 0, 12));

		lblLog = new JLabel("[��������־]");
		lblLog.setForeground(Color.YELLOW);
		lblLog.setFont(new Font("����", 0, 12));

		taLog = new TextArea(20, 50);
		taLog.setFont(new Font("����", 0, 12));
		btnSaveLog = new JButton("������־(S)");
		btnSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveLog();
			}
		});
		btnSaveLog.setBackground(Color.ORANGE);
		btnSaveLog.setFont(new Font("����", 0, 12));

		// �����������ӵ�Panel�� ������ʾ (��߲���)
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
		// ===========�����û����====================
		pnlUser = new JPanel();
		pnlUser.setLayout(null);
		pnlUser.setBackground(new Color(52, 130, 203));
		pnlUser.setFont(new Font("����", 0, 12));
		lblMessage = new JLabel("[�û���Ϣ]");
		lblMessage.setFont(new Font("����", 0, 12));
		lblMessage.setForeground(Color.YELLOW);
		taMessage = new TextArea(20, 20);
		taMessage.setFont(new Font("����", 0, 12));
		lblNotice = new JLabel("֪ͨ��");
		lblNotice.setFont(new Font("����", 0, 12));
		txtNotice = new JTextField(20);
		txtNotice.setFont(new Font("����", 0, 12));
		btnSend = new JButton("����");
		btnSend.setBackground(Color.ORANGE);
		btnSend.setFont(new Font("����", 0, 12));
		btnSend.setEnabled(true);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// �Զ��巽�� ���嶨����·�
				serverMessage();
			}
		});

		lblUserCount = new JLabel("���������� 0 ��");
		lblUserCount.setFont(new Font("����", 0, 12));

		lblUser = new JLabel("[�����û��б�]");
		lblUser.setFont(new Font("����", 0, 12));
		lblUser.setForeground(Color.YELLOW);

		lstUser = new JList();
		lstUser.setFont(new Font("����", 0, 12));
		lstUser.setVisibleRowCount(17);
		lstUser.setFixedCellWidth(180);
		lstUser.setFixedCellHeight(18);

		spUser = new JScrollPane();
		spUser.setBackground(Color.decode("#d6f4f2"));
		spUser.setFont(new Font("����", 0, 12));
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

		// ============����ǩ���========================

		tpServer = new JTabbedPane(JTabbedPane.TOP);
		tpServer.setBackground(Color.decode("#d6f4f2"));
		tpServer.setFont(new Font("����", 0, 12));
		tpServer.add("����������", pnlServer);
		tpServer.add("�û���Ϣ����", pnlUser);
		this.getContentPane().add(tpServer);
		setVisible(true);
	}

	protected void serverMessage() {
		// txtNotice��һ���ı���
		// ��ȡ�ı�������������� ֪ͨ����
		this.serverMessage = txtNotice.getText();
		// ����ı���
		txtNotice.setText("");
	}

	protected void closeServer() {
		// �ͷŴ���ռ�е���Դ
		this.dispose();
	}
	// �����������־
	protected void saveLog() {
		try {
			// ָ�����뵽lox.txt�ļ���
			// true����׷�ӵ���ʽ ���Ǹ��ǵ���ʽ
			FileOutputStream fileoutput = new FileOutputStream("log.txt",
					true);
			// taMessage��һ���ı��� ��ȡ�ı����е�����
			String temp = taMessage.getText();
			// д��
			fileoutput.write(temp.getBytes());
			// �ر������
			fileoutput.close();
			// �Զ����� ��ʾ�û� ��ʽ��ͼƬ5
			JOptionPane.showMessageDialog(null, "��¼������log.txt");
		} catch (Exception e) {
			// ��׽�쳣 ����쳣
			System.out.println(e);
		}
	}
	// ����Ļ��������־
	// ��һ������ʱ����־д���ļ�
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