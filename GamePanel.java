import java.awt.*;
import javax.swing.JPanel;
public class GamePanel extends JPanel{
	private Grid grid;
	public GamePanel(Grid grid){
		this.grid = grid;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(grid.getPlayer().getImage(), grid.getPlayer().getCoordinate().getX() + grid.getPlayer().getXVelocity(), grid.getPlayer().getCoordinate().getY() + grid.getPlayer().getYVelocity(), grid.getPlayer().getWidth(), grid.getPlayer().getHeight(), null);
	}
	
	public void updatePanel(){
		repaint();
	}
}
