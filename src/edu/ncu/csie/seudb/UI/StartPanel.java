package edu.ncu.csie.seudb.UI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	
	private MainFrame frm;
	private JButton start, exit;
	private StartPanel self;
	private Container cp;
	private int startWidth = 300, startHeight = 70;
	private int exitWidth = 300, exitHeight = 70;
	private ActionListener startAction, exitAction;
	private RoomEntryPanel roomEntryPanel;
	public StartPanel(MainFrame frm){
		super();
		this.frm = frm;
		cp = frm.getContentPane();
		this.setBounds(0, 0, frm.getWidth(), frm.getHeight());
		this.setLayout(null);
		self = this;
		constructActionListener();
		roomEntryPanel = new RoomEntryPanel(frm, self);
		
		start = new JButton("Start");
		start.addActionListener(startAction);
		start.setBounds(frm.getWidth()-350, frm.getHeight()-210, startWidth, startHeight);
		this.add(start);
		
		exit = new JButton("Exit");
		exit.addActionListener(exitAction);
		exit.setBounds(frm.getWidth()-350, frm.getHeight()-120, exitWidth, exitHeight);
		this.add(exit);
	}
	private void constructActionListener() {
		startAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.removeAll();
				cp.add(roomEntryPanel);
				cp.repaint();
			}
		};
		
		exitAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.dispose();
			}
		};
	}
}
