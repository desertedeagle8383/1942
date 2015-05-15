import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends JPanel implements KeyListener{
	JPanel buttonPanel, movePanel, powerUpPanel, shootPanel;
	JButton returnTo; 
	JLabel spaceLabel, nameLabel, start, howToPlay, move, powerUps, enemies, movePic, powerUpPic, enemyPic, spacePic, space;
	Image name, arrow, resizedArrow, wasd, powerUpsImg, spaceImg;
	ImageIcon nameIcon, arrowIcon, moveIcon, powerUpIcon, spaceIcon;
	String namePath = "1942.png";
	String arrowPath = "Arrow.png";
	String movePath = "wasd.png";
	String powerUpPath = "PowerUps.png";
	String spacePath = "Space.png";
	int arrowPlace = 0;
	boolean begin = false;

	public MainMenu(){
		setOpaque(true);
		setBackground(Color.black);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setFocusable(true);
		addKeyListener(this);

		create();
	}
	public boolean begin(){return begin;}
	public void create(){
		add(Box.createRigidArea(new Dimension(800, 150)));

		nameLabel = new JLabel();
		nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nameLabel.setPreferredSize(new Dimension(800, 300));
		name = setImage(namePath);
		nameIcon = new ImageIcon(name);
		nameLabel.setIcon(nameIcon);
		add(nameLabel);

		add(Box.createRigidArea(new Dimension(800, 10)));

		start = new JLabel("START");
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setHorizontalAlignment(SwingConstants.CENTER);
		start.setForeground(Color.ORANGE);
		start.setFont(new Font(start.getName(), Font.PLAIN, 30));
		start.setPreferredSize(new Dimension(800, 100));

		arrow = setImage(arrowPath);
		resizedArrow = arrow.getScaledInstance(30, 30, 1);
		arrowIcon = new ImageIcon(resizedArrow);
		start.setIcon(arrowIcon);

		add(start, BorderLayout.PAGE_END);

		add(Box.createRigidArea(new Dimension(800, 50)));

		howToPlay = new JLabel("HOW TO PLAY");
		howToPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		howToPlay.setForeground(Color.ORANGE);
		howToPlay.setFont(new Font(howToPlay.getName(), Font.PLAIN, 30));
		howToPlay.setPreferredSize(new Dimension(800, 100));
		add(howToPlay);

		add(Box.createRigidArea(new Dimension(800, 90)));

	}
	public void howToPlay(){
		removeAll();
		
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setPreferredSize(new Dimension(800, 250));
		
		returnTo = new JButton("Return");
		returnTo.setPreferredSize(new Dimension(100, 30));
		returnTo.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	removeAll();
            	create();
            	revalidate();
            	repaint();
            }
        });      
		buttonPanel.add(returnTo);
		
		movePanel = new JPanel();
		movePanel.setPreferredSize(new Dimension(800, 250));
		
		movePic = new JLabel();
		movePic.setPreferredSize(new Dimension (300, 250));
		wasd = setImage(movePath);
		moveIcon = new ImageIcon(wasd);
		movePic.setIcon(moveIcon);
		
		move = new JLabel("<html> W - UP <br> A - LEFT <br> S - DOWN <br> D - RIGHT </html>", SwingConstants.CENTER);
		move.setPreferredSize(new Dimension(300, 250));
		move.setFont(new Font("Serif", Font.PLAIN, 40));
		
		movePanel.add(movePic);
		movePanel.add(move);
		
		powerUpPanel = new JPanel();
		powerUpPanel.setPreferredSize(new Dimension(800, 250));
		
		powerUpPic = new JLabel();
		powerUpPic.setPreferredSize(new Dimension(300, 250));
		powerUpsImg = setImage(powerUpPath);
		powerUpIcon = new ImageIcon(powerUpsImg);
		powerUpPic.setIcon(powerUpIcon);
		
		powerUps = new JLabel("<html> POWER <br> UPS </html>", SwingConstants.CENTER);
		powerUps.setPreferredSize(new Dimension(300, 250));
		powerUps.setFont(new Font("Serif", Font.PLAIN, 40));
		
		powerUpPanel.add(powerUpPic);
		powerUpPanel.add(powerUps);

		shootPanel = new JPanel();
		shootPanel.setPreferredSize(new Dimension(800, 250));
		
		spacePic = new JLabel();
		spacePic.setPreferredSize(new Dimension(300, 250));
		spaceImg = setImage(spacePath);
		spaceIcon = new ImageIcon(spaceImg);
		spacePic.setIcon(spaceIcon);
		
		space = new JLabel("SHOOT", SwingConstants.CENTER);
		space.setPreferredSize(new Dimension(300, 250));
		space.setFont(new Font("Serif", Font.PLAIN, 40));
		
		shootPanel.add(spacePic);
		shootPanel.add(space);
		
		add(buttonPanel);
		add(movePanel);
		add(powerUpPanel);
		add(shootPanel);
		
		revalidate();
		repaint();
	}
	public Image setImage(String filePath){
		Image image = null;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
		}
		return image;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP){
			if (arrowPlace > 0)
				arrowPlace--;
		} else 
			if (e.getKeyCode() == KeyEvent.VK_DOWN){
				if (arrowPlace < 1)
					arrowPlace++;
			} else {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					if (arrowPlace == 0)
						begin = true;
					if (arrowPlace == 1)
						howToPlay();
				}

			}
	}
	public void keyReleased(KeyEvent arg0) {
		start.setIcon(null);
		howToPlay.setIcon(null);

		if (arrowPlace == 0)
			start.setIcon(arrowIcon);
		else 
			if (arrowPlace == 1)
				howToPlay.setIcon(arrowIcon);

	}
	public void keyTyped(KeyEvent arg0) {

	}

}
