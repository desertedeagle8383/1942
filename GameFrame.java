import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class GameFrame extends JFrame{
	private GamePanel gamePanel;
	private JLabel scoreLabel, livesLabel, rollsLabel;
	private JPanel contentPane, labels;
	private boolean up, down, left, right, alt, shift;
	private JLabel projectiles, enemies, powerups;
	
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final String MOVE_UP = "move up";
	private static final String RELEASE_UP = "release up";
	private static final String MOVE_RIGHT = "move right";
	private static final String RELEASE_RIGHT = "release right";
	private static final String MOVE_DOWN = "move down";
	private static final String RELEASE_DOWN = "release down";
	private static final String MOVE_LEFT = "move left";
	private static final String RELEASE_LEFT = "release left";
	private static final String SHOOT = "shoot";
	private static final String RELEASE_SHOOT = "release alt";
	private static final String ROLL = "shoot";
	private static final String RELEASE_ROLL = "release shift";
	
	public GameFrame(GamePanel panel){
		up = false;
		down = false;
		left = false;
		right = false;
		alt = false;
		shift = false;
		this.gamePanel = panel;
		contentPane = new JPanel();
		setContentPane(contentPane);
		labels = new JPanel();
		gamePanel.setPreferredSize(new Dimension(800, 750));
		labels.setPreferredSize(new Dimension (800, 50));
		contentPane.add(labels);
		contentPane.add(gamePanel);
		scoreLabel = new JLabel();
		livesLabel = new JLabel();
		rollsLabel = new JLabel();
		labels.add(scoreLabel);
		labels.add(livesLabel);
		labels.add(rollsLabel);
		
		projectiles = new JLabel();
		enemies = new JLabel();
		powerups = new JLabel();
		labels.add(projectiles);
		labels.add(enemies);
		labels.add(powerups);
		
		createKeyBindings();
		setSize(900, 850);
		setVisible(true);
	}
	public void createKeyBindings(){
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt UP"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift UP"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift UP"), MOVE_UP);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released UP"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released UP"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released UP"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released UP"), RELEASE_UP);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt RIGHT"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift RIGHT"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift RIGHT"), MOVE_RIGHT);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released RIGHT"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released RIGHT"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released RIGHT"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released RIGHT"), RELEASE_RIGHT);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt DOWN"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift DOWN"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift DOWN"), MOVE_DOWN);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released DOWN"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released DOWN"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released DOWN"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released DOWN"), RELEASE_DOWN);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt LEFT"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift LEFT"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift LEFT"), MOVE_LEFT);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released LEFT"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released LEFT"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released LEFT"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift released LEFT"), RELEASE_LEFT);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt pressed ALT"), SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift pressed ALT"), SHOOT);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released ALT"), RELEASE_SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift released ALT"), RELEASE_SHOOT);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("shift pressed SHIFT"), ROLL);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt shift pressed SHIFT"), ROLL);
		
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released SHIFT"), RELEASE_ROLL);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("alt released SHIFT"), RELEASE_ROLL);

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
		gamePanel.getActionMap().put(ROLL, new Action(5));
		gamePanel.getActionMap().put(RELEASE_ROLL, new ReleaseAction(5));
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
				System.out.println("SHOOT");
				alt = true;
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
				alt = false;
				System.out.println("STOP");
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
	public boolean getAlt() {
		return alt;
	}
	public boolean getShift() {
		return shift;
	}
	public void updateFrame(Grid g, int score, int lives, int rolls, int projectile, int enemy, int powerup) {
		gamePanel.updatePanel(g);
		scoreLabel.setText("Score: " + score);
		rollsLabel.setText("Rolls: " + rolls);
		livesLabel.setText("Lives: " + lives);
		projectiles.setText("Projectiles: " + projectile);
		enemies.setText("Enemies: " + enemy);
		powerups.setText("Powerups: " + powerup);
	}
}
