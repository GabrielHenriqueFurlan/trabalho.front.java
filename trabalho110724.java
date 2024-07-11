import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class trabalho110724 extends JPanel 
{
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      g.setFont(new Font("Serif", Font.ITALIC, 12));
      g.setColor(Color.BLACK);
      g.drawString("red line", 3, 20);
      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);

      g.setColor(Color.BLACK);
      g.drawString("blue rect", 30, 40);
      g.drawString("blue fill", 129, 40);
      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.fillRect(100, 40, 90, 55);

      g.setColor(Color.BLACK);
      g.drawString("black fill round", 204, 40);
      g.drawString("black rect round", 295, 40);
      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.drawRoundRect(290, 40, 90, 55, 20, 20);

      g.setColor(Color.BLACK);
      g.drawString("green rect 3d", 18, 165);
      g.drawString("green fill 3d", 117, 165);
      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.fill3DRect(100, 100, 90, 55, false);

      g.setColor(Color.BLACK);
      g.drawString("magenta oval", 208, 165);
      g.drawString("magenta fill oval", 297, 165);
      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.fillOval(290, 100, 90, 55);
   } 
}