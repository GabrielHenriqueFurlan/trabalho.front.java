import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class ColorJPanel extends JPanel 
{
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.RED);
      g.setColor(new Color(0, 0, 255));
      g.fillRect(15, 50, 100, 20);
      g.drawString("Senac", 130, 65);

       g.setColor(new Color(255, 255, 255));
      g.fillRect(15, 75, 100, 20);
      g.drawString("Curso de java", 130, 90);
   }    
}

