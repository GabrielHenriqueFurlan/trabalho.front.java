import javax.swing.JFrame;

public class showtela 
{

   public static void main(String[] args)
   {

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      tela fontJPanel = new tela();
      frame.add(fontJPanel); 
      frame.setSize(420, 150);
      frame.setVisible(true);
   } 
} 