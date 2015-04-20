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
	private boolean up, down, left, right, space;
	public GameFrame(GamePanel panel){
		up = false;
		down = false;
		left = false;
		right = false;
		space = false;
		
		this.gamePanel = panel;
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		gamePanel.addKeyListener(new GameKeyListener());
		gamePanel.setFocusable(true);
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

		setSize(900, 850);
		setVisible(true);
	}
	
	public void updateLabels(){
		scoreLabel.setText(Integer.toString(game.getScore()));
		livesLabel.setText(Integer.toString(game.getLives()));
		rollsLabel.setText(Integer.toString(game.getRolls()));
	}
	private class GameKeyListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				left = true;
//				System.out.println("left");
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				right = true;
//				System.out.println("right");
			} else if (e.getKeyCode() == KeyEvent.VK_UP){
				up = true;
//				System.out.println("up");
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				down = true;
//				System.out.println("down");
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE){
				space = true;
			}
		}
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				left = false;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				right = false;
			} else if (e.getKeyCode() == KeyEvent.VK_UP){
				up = false;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN){
				down = false;
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				space = false;
			}
		}
		public void keyTyped(KeyEvent arg0) {}
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
