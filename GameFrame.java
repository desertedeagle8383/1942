import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GameFrame extends JFrame{
	private Game game;
	private GamePanel gamePanel;
	private JLabel scoreLabel, livesLabel, rollsLabel;
	private JPanel contentPane, labels;
	public GameFrame(Game game){
		this.game = game;
				
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		gamePanel = new GamePanel(game.getGrid());
		gamePanel.addKeyListener(new GameKeyListener());
		gamePanel.setFocusable(true);
		labels = new JPanel();
		
		gamePanel.setPreferredSize(new Dimension(800, 750));
		labels.setPreferredSize(new Dimension (800, 50));
		
		contentPane.add(labels);
		contentPane.add(gamePanel);
		
		scoreLabel = new JLabel(Integer.toString(game.getScore()));
		livesLabel = new JLabel(Integer.toString(game.getLives()));
		rollsLabel = new JLabel(Integer.toString(game.getRolls()));
		labels.add(scoreLabel);
		labels.add(livesLabel);
		labels.add(rollsLabel);

		setSize(800, 800);
		setVisible(true);
		
	}
	public void initializeGUI(){
		
	}
	public void updateLabels(){
		scoreLabel.setText(Integer.toString(game.getScore()));
		livesLabel.setText(Integer.toString(game.getLives()));
		rollsLabel.setText(Integer.toString(game.getRolls()));
	}
	private class GameKeyListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				game.setLeft(true);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				game.setRight(true);
			} else if (e.getKeyCode() == KeyEvent.VK_UP){
				game.setUp(true);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				game.setDown(true);
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE){
				game.shoot();
			}
		}
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				game.setLeft(false);
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				game.setRight(false);
			} else if (e.getKeyCode() == KeyEvent.VK_UP){
				game.setUp(false);
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				game.setDown(false);
			}
		}
		public void keyTyped(KeyEvent arg0) {}
	}

	public static void main(String args[]){
		Grid grid = new Grid(800, 750);
		Game game = new Game(grid);
		GameFrame frame = new GameFrame(game);
	
	}
}
