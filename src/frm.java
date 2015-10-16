import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class frm {
	
	static ActionListener startAction, exitAction, joinAction, connectAction, cancelConnectAction;
	static JFrame frm = new JFrame("UDB");
	static Container cp = frm.getContentPane();
	static JButton start = new JButton("Start");
	static JButton exit = new JButton("Exit");
	/******************/
	static JButton CreateRoom = new JButton("Create");
	static JButton JoinRoom = new JButton("Join");
	/******************/
	static JInternalFrame ipInsertframe;
	static JTextField ipAddress = new JTextField();
	static JButton connect = new JButton("Connect");
	static JButton cancelConnect = new JButton("Cancel");
	/******************/
	public static void main(String[] args) {
		ListenerInit();
		frameStart();
	}
	
	private static void frameStart(){
		//frm.setUndecorated(true);
		frm.setSize(800, 500);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocation((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/4,
						(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/4);
		start.addActionListener(startAction);
		exit.addActionListener(exitAction);
		start.setBounds(frm.getWidth()-350, frm.getHeight()-210, 300, 70);
		exit.setBounds(frm.getWidth()-350, frm.getHeight()-120, 300, 70);
		CreateRoom.addActionListener(null);
		JoinRoom.addActionListener(joinAction);
		connect.addActionListener(connectAction);
		cancelConnect.addActionListener(cancelConnectAction);
		cp.add(start);
		cp.add(exit);
		cp.setLayout(null);
		frm.setVisible(true);
	}
	
	private static void ListenerInit(){
		startAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.removeAll();
				CreateRoom.setBounds(frm.getWidth()/2-150, frm.getHeight()/2-100, 300, 70);
				JoinRoom.setBounds(frm.getWidth()/2-150, frm.getHeight()/2+100, 300, 70);
				cp.add(CreateRoom);
				cp.add(JoinRoom);
				cp.repaint();
			}
		};
		
		exitAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.dispose();
			}
		};
		
		joinAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ipInsertframe = new JInternalFrame("IP");
				CreateRoom.setVisible(false);
				JoinRoom.setVisible(false);
				ipInsertframe.setBounds(frm.getWidth()/4, frm.getHeight()/4, 400, 250);
				ipInsertframe.setLayout(null);
				ipAddress.setBounds(30, 30, 350, 40);
				ipInsertframe.add(ipAddress);
				connect.setBounds(ipInsertframe.getWidth()/8, ipInsertframe.getHeight()-80, 100, 40);
				ipInsertframe.add(connect);
				cancelConnect.setBounds((ipInsertframe.getWidth()/8)*5, ipInsertframe.getHeight()-80, 100, 40);
				ipInsertframe.add(cancelConnect);
				ipInsertframe.setVisible(true);
				cp.add(ipInsertframe);
				cp.repaint();
			}
		};
		
		connectAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomPanel roomPanel = new RoomPanel(frm);
				ipInsertframe.setVisible(false);
				cp.add(roomPanel);
				cp.repaint();
				
			}
		};
		
		cancelConnectAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ipInsertframe.dispose();
				CreateRoom.setVisible(true);
				JoinRoom.setVisible(true);
				cp.repaint();
			}
		};
	}
}
