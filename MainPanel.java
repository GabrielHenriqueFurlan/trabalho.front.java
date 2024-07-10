import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {

    private DrawingPanel panel1, panel2, panel3;
    private Color color = Color.LIGHT_GRAY;

    public MainPanel() {
        setTitle("Exemplo de JPanel com PaintComponent");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cria os painéis de desenho
        panel1 = new DrawingPanel(1);
        panel2 = new DrawingPanel(2);
        panel3 = new DrawingPanel(3);

        // Adiciona os painéis ao JFrame
        add(panel1, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);
        add(panel3, BorderLayout.EAST);

        // Cria o botão para alterar as cores
        JButton button = new JButton("Alterar Cores");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(MainPanel.this, "Escolha uma cor", color);

                // Define as novas cores nos painéis
                panel1.setColor(color);
                panel2.setColor(color);
                panel3.setColor(color);
            }
        });

        // Adiciona o botão ao JFrame
        add(button, BorderLayout.SOUTH);

        // Configura o tamanho do JFrame e exibe-o
        setSize(600, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPanel();
            }
        });
    }
}
