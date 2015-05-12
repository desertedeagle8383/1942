import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class GameFrame extends JFrame{
	private GamePanel gamePanel;
	private JLabel scoreLabel, livesLabel, shieldsLabel, enemies;
	private JPanel contentPane, labels;
	private MainMenu mainMenu;
	private boolean up, down, left, right, space, shift;
	private boolean waiting = true;
	private boolean begin = false;
	private Image liveImg, shieldImg, enemyImg, resizedLive, resizedShield, resizedEnemy;
	private ImageIcon liveIcon, shieldIcon, enemyIcon;
	private String livePath = "src/Player.png";
	private String shieldPath = "src/Shield.png";
	private String enemyPath = "src/Enemy.png";
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final String MOVE_UP = "move up";
	private static final String RELEASE_UP = "release up";
	private static final String MOVE_RIGHT = "move right";
	private static final String RELEASE_RIGHT = "release right";
	private static final String MOVE_DOWN = "move down";
	private static final String RELEASE_DOWN = "release down";
	private static final String MOVE_LEFT = "move left";
	private static final String RELEASE_LEFT = "release left";
	private static final String SHOOT = "space";
	private static final String RELEASE_SHOOT = "release space";
	private static final String SHIELD = "shift";
	private static final String RELEASE_SHIELD = "release shift";
	public GameFrame(GamePanel panel){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		up = false;
		down = false;
		left = false;
		right = false;
		space = false;
		shift = false;
		
		gamePanel = panel;
		gamePanel.setPreferredSize(new Dimension(800, 750));
		
		mainMenu = new MainMenu();
		mainMenu.setPreferredSize(new Dimension(800, 750));
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		labels = new JPanel();
		labels.setPreferredSize(new Dimension (800, 50));
		
		contentPane.add(labels);
		contentPane.add(mainMenu);
		
		createKeyBindings();
		
		setSize(900, 850);
		setVisible(true);
		
		while(waiting){
			if (mainMenu.begin()){
				waiting = false;
				waiting = false;
				remove(mainMenu);
				createLabels();
				add(gamePanel);
				begin = true;
				repaint();
			}				
		}
	}
	public void createLabels(){
		scoreLabel = new JLabel();
		scoreLabel.setPreferredSize(new Dimension(300, 20));
		livesLabel = new JLabel();
		livesLabel.setPreferredSize(new Dimension(300, 20));
		shieldsLabel = new JLabel();
		shieldsLabel.setPreferredSize(new Dimension(300, 20));
		enemies = new JLabel();
		enemies.setPreferredSize(new Dimension(300, 20));
		
		liveImg = setImage(livePath);
		shieldImg = setImage(shieldPath);
		enemyImg = setImage(enemyPath);
		resizedLive = liveImg.getScaledInstance(20, 20, 1);
		resizedShield = shieldImg.getScaledInstance(20, 20, 1);
		resizedEnemy = enemyImg.getScaledInstance(20, 20, 1);
		liveIcon = new ImageIcon(resizedLive);
		shieldIcon = new ImageIcon(resizedShield);
		enemyIcon = new ImageIcon(resizedEnemy);
		livesLabel.setIcon(liveIcon);
		shieldsLabel.setIcon(shieldIcon);
		enemies.setIcon(enemyIcon);

		
		labels.add(scoreLabel);
		labels.add(livesLabel);
		labels.add(shieldsLabel);
		labels.add(enemies);
	}
	public boolean getBegin(){
		return begin;
	}
	public void createKeyBindings(){
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt W"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift W"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift W"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released W"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released W"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released W"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released W"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt D"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift D"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift D"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released D"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released D"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released D"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released D"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt S"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift S"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift S"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released S"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released S"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released S"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released S"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt A"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift A"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift A"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released A"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released A"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released A"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released A"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt SPACE"), SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift SPACE"), SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift SPACE"), SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released SPACE"), RELEASE_SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released SPACE"), RELEASE_SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released SPACE"), RELEASE_SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released SPACE"), RELEASE_SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("SHIFT"), SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt SHIFT"), SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift SHIFT"), SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift SHIFT"), SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released SHIFT"), RELEASE_SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released SHIFT"), RELEASE_SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released SHIFT"), RELEASE_SHIELD);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released SHIFT"), RELEASE_SHIELD);
		gamePanel.getActionMap().put(MOVE_UP, new Action(0));
		gamePanel.getActionMap().put(RELEASE_UP, new ReleaseAction(0));
		gamePanel.getActionMap().put(MOVE_RIGHT, new Action(1));
		gamePanel.getActionMap().put(RELEASE_RIGHT, new ReleaseAction(1));
		gamePanel.getActionMap().put(MOVE_DOWN, new Action(2));
		gamePanel.getActionMap().put(RELEASE_DOWN, new ReleaseAction(2));
		gamePanel.getActionMap().put(MOVE_LEFT, new Action(3));
		gamePanel.getActionMap().put(RELEASE_LEFT, new ReleaseAction(3));
		gamePanel.getActionMap().put(SHOOT, new Action(4));
		gamePanel.getActionMap().put(RELEASE_SHOOT, new ReleaseAction(4));
		gamePanel.getActionMap().put(SHIELD, new Action(5));
		gamePanel.getActionMap().put(RELEASE_SHIELD, new ReleaseAction(5));
	}
	private class Action extends AbstractAction{
		int actionNumber;
		public Action(int actionNumber){
			this.actionNumber = actionNumber;
		}
		public void actionPerformed(ActionEvent e) {
			if(actionNumber == 0){
				up = true;
			}
			if(actionNumber == 1){
				right = true;
			}
			if(actionNumber == 2){
				down = true;
			}
			if(actionNumber == 3){
				left = true;
			}
			if(actionNumber == 4){
				// System.out.println("SHOOT");
				space= true;
			}
			if(actionNumber == 5){
				shift = true;
			}
		}
	}
	private class ReleaseAction extends AbstractAction{
		int direction;
		public ReleaseAction(int direction){
			this.direction = direction;
		}
		public void actionPerformed(ActionEvent arg0) {
			if (direction == 0)
				up = false;
			if (direction == 1)
				right = false;
			if (direction == 2)
				down = false;
			if (direction == 3)
				left = false;
			if (direction == 4) {
				space = false;
				// System.out.println("STOP");
			}
			if (direction == 5)
				shift = false;
		}
	}
	public boolean getLeft() {
		return left;
	}
	public boolean getRight() {
		return right;
	}
	public boolean getUp() {
		return up;
	}
	public boolean getDown() {
		return down;
	}
	public boolean getShift() {
		return shift;
	}
	public boolean getSpace() {
		return space;
	}
	public Image setImage(String filePath){
		Image image = null;
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
		}
		return image;
	}
	public void updateFrame(Grid g, int score, int lives, int shields, int projectile, int enemy, int powerup) {
		gamePanel.updatePanel(g);
		scoreLabel.setText("Score: " + score);
		shieldsLabel.setText("Shields: " + shields);
		livesLabel.setText("Lives: " + lives);
		enemies.setText("Enemies: " + enemy);
	}
}
