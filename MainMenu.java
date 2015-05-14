import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenu extends JPanel implements KeyListener{
	JPanel movePanel;
	JLabel spaceLabel, nameLabel, start, howToPlay, move, powerUps, enemies, movePic, powerUpPic, enemyPic, blankLabel;
	Image name, arrow, resizedArrow, wasd;
	ImageIcon nameIcon, arrowIcon, moveIcon;
	String namePath = "1942.png";
	String arrowPath = "Arrow.png";
	String movePath = "wasd.png";
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
