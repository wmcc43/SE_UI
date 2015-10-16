import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class RoomPanel extends JPanel {
	public RoomPanel(JFrame frm){
		super();
		this.setBounds(0, 0, frm.getWidth()-20, frm.getHeight()-50);
		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Room:10.0.0.1");
		this.setBorder(border);
	}
}
