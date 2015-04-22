import java.awt.Dimension;
import java.awt.event.ActionEvent;
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
	private boolean up, down, left, right, space;
	
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
	private static final String RELEASE_SHOOT = "release space";
	
	public GameFrame(GamePanel panel){
		up = false;
		down = false;
		left = false;
		right = false;
		space = false;
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
		
		createKeyBindings();
		setSize(900, 850);
		setVisible(true);
	}
	public void createKeyBindings(){
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), MOVE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released UP"), RELEASE_UP);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), MOVE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released RIGHT"), RELEASE_RIGHT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), MOVE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released DOWN"), RELEASE_DOWN);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), MOVE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released LEFT"), RELEASE_LEFT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("SPACE"), SHOOT);
		gamePanel.getInputMap(IFW).put(KeyStroke.getKeyStroke("released SPACE"), RELEASE_SHOOT);

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
				space = true;
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
			if (direction == 4)
				space = false;
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
	public boolean getSpace() {
		return space;
	}
	public void updateFrame(Grid g, int score, int lives, int rolls) {
		gamePanel.updatePanel(g);
		scoreLabel.setText("Score: " + score);
		rollsLabel.setText("Rolls: " + rolls);
		livesLabel.setText("Lives: " + lives);
	}
}
