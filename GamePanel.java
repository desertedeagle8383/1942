import java.awt.*;
import javax.swing.JPanel;
public class GamePanel extends JPanel{
	private Grid grid;
	
	public GamePanel(){
		setOpaque(true);
		setBackground(Color.blue);
		grid = new Grid(800, 750);
		grid.createPlayer();
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
//		System.out.println(grid.getPlayer().getHeight());
		
		g2.drawImage(grid.getPlayer().getImage(),
		grid.getPlayer().getCoordinate().getX(), 
		grid.getHeight() - grid.getPlayer().getCoordinate().getY(), 
		grid.getPlayer().getWidth(), 
		grid.getPlayer().getHeight(), 
		null);
		// need images for these
		for (int i = 0; i < grid.getEnemies().size(); i++)
			g2.drawImage(grid.getEnemies().get(i).getImage(),
			grid.getEnemies().get(i).getCoordinate().getX(), 
			grid.getHeight() - grid.getEnemies().get(i).getCoordinate().getY(), 
			grid.getEnemies().get(i).getWidth(), 
			grid.getEnemies().get(i).getHeight(), 
			null);
		
		for (int i = 0; i < grid.getProjectiles().size(); i++)
			g2.drawImage(grid.getProjectiles().get(i).getImage(),
			grid.getProjectiles().get(i).getCoordinate().getX(), 
			grid.getHeight() - grid.getProjectiles().get(i).getCoordinate().getY(), 
			grid.getProjectiles().get(i).getWidth(), 
			grid.getProjectiles().get(i).getHeight(), 
			null);
		
		for (int i = 0; i < grid.getPowerups().size(); i++)
			g2.drawImage(grid.getPowerups().get(i).getImage(),
			grid.getPowerups().get(i).getCoordinate().getX(), 
			grid.getHeight() - grid.getPowerups().get(i).getCoordinate().getY(), 
			grid.getPowerups().get(i).getWidth(), 
			grid.getPowerups().get(i).getHeight(), 
			null);
		
		
		
	}
	
	public void updatePanel(Grid grid){
		this.grid = grid;
		repaint();
	}
	
	public GamePanel getGamePanel(){return this;}
	
}
