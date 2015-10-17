package edu.ncu.csie.seudb.UI;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfigTemplate;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	private int frameWidth = 1280;
	private int frameHeight = 700;
	private Container cp;
	private int screenWidth, screenHeight;
	private StartPanel startPanel;
	
	public MainFrame(){
		super("UDB");
		screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		initFrame();
		cp = this.getContentPane();
		cp.setLayout(null);
		startPanel = new StartPanel(this);
		cp.add(startPanel);
		this.setVisible(true);
	}
	
	private void initFrame(){
		//this.setUndecorated(true);
		this.setSize(frameWidth, frameHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation((screenWidth/2)-(frameWidth/2),(screenHeight/2)-(frameHeight/2));
	}
}
