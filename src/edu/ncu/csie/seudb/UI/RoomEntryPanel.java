package edu.ncu.csie.seudb.UI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RoomEntryPanel extends JPanel {
	
	private MainFrame frm;
	private Container cp;
	private StartPanel previousPanel;
	private RoomEntryPanel self;
	private JButton CreateRoom, JoinRoom, ReturnStart;
	private int createRoomWidth = 300, createRoomHeight = 70;
	private int joinRoomWidth = 300, joinRoomHeight = 70;
	private int returnStartWidth = 300, returnStartHeight = 70;
	private JInternalFrame ipInsertframe;
	private JTextField ipAddress;
	private JButton connect;
	private JButton cancelConnect;
	private ActionListener createRoomAction, joinRoomAction, connectAction, cancleConnectAction, returnStartAction;
	
	public RoomEntryPanel(MainFrame frm, StartPanel previousPanel){
		super();
		this.frm = frm;
		cp = frm.getContentPane();
		this.setBounds(0, 0, frm.getWidth(), frm.getHeight());
		this.setLayout(null);
		self = this;
		this.previousPanel = previousPanel;
		constructActionListener();
		constructJoinInternalPanel();
		
		CreateRoom = new JButton("Create Room");
		CreateRoom.setBounds((frm.getWidth()/2)-(createRoomWidth/2), (frm.getHeight()/4)-(createRoomHeight/2), 300, 70);
		CreateRoom.addActionListener(createRoomAction);
		this.add(CreateRoom);
		
		JoinRoom = new JButton("Join Room");
		JoinRoom.setBounds((frm.getWidth()/2)-(joinRoomWidth/2), (frm.getHeight()/2)-(joinRoomHeight/2), 300, 70);
		JoinRoom.addActionListener(joinRoomAction);
		this.add(JoinRoom);
		
		ReturnStart = new JButton("Return to Start");
		ReturnStart.setBounds((frm.getWidth()/2)-(returnStartWidth/2), ((frm.getHeight()/4)*3)-(returnStartHeight/2), 300, 70);
		ReturnStart.addActionListener(returnStartAction);
		this.add(ReturnStart);
	}

	private void constructJoinInternalPanel(){
		ipInsertframe = new JInternalFrame("IP");
		ipInsertframe.setBounds((frm.getWidth()/2)-200, (frm.getHeight()/2)-125, 400, 250);
		ipInsertframe.setLayout(null);
		
		ipAddress = new JTextField();
		ipAddress.setBounds(30, 30, 350, 40);
		ipInsertframe.add(ipAddress);
		
		connect = new JButton("Connect");
		connect.setBounds(ipInsertframe.getWidth()/8, ipInsertframe.getHeight()-80, 100, 40);
		connect.addActionListener(connectAction);
		ipInsertframe.add(connect);
		
		cancelConnect = new JButton("Cancel");
		cancelConnect.setBounds((ipInsertframe.getWidth()/8)*5, ipInsertframe.getHeight()-80, 100, 40);
		cancelConnect.addActionListener(cancleConnectAction);
		ipInsertframe.add(cancelConnect);
		
		ipInsertframe.setVisible(false);
		this.add(ipInsertframe);
	}
	
	private void constructActionListener() {
		createRoomAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomWaitPanel roomWaitPanel = new RoomWaitPanel(frm, self);
				cp.removeAll();
				cp.add(roomWaitPanel);
				cp.repaint();
			}
		};
		
		joinRoomAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateRoom.setVisible(false);
				JoinRoom.setVisible(false);
				ReturnStart.setVisible(false);
				ipInsertframe.setVisible(true);
				cp.repaint();
			}
		};
		
		connectAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomWaitPanel roomWaitPanel = new RoomWaitPanel(frm, self);
				ipInsertframe.setVisible(false);
				//if(connection.start success)
				cp.removeAll();
				cp.add(roomWaitPanel);
				cp.repaint();
				//else ipInserFrame.setVisible(true);
			}
		};
		
		cancleConnectAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ipInsertframe.setVisible(false);
				CreateRoom.setVisible(true);
				JoinRoom.setVisible(true);
				ReturnStart.setVisible(true);
				cp.repaint();
			}
		};
		
		returnStartAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.removeAll();
				cp.add(previousPanel);
				cp.repaint();
			}
		};
	}
}
