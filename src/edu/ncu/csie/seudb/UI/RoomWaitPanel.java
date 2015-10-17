package edu.ncu.csie.seudb.UI;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class RoomWaitPanel extends JPanel {
	
	private MainFrame frm;
	private Container cp;
	
	public RoomWaitPanel(MainFrame frm, RoomEntryPanel previous){
		super();
		this.frm = frm;
		cp = frm.getContentPane();
		this.setBounds(0, 0, frm.getWidth()-20, frm.getHeight()-50);
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Room:10.0.0.1");
		this.setBorder(border);
		cp.add(this);
	}
}
