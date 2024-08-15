import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

    private final JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
    private final JPanel inputPanel = new JPanel();
    private final JPanel buttonPanel = new JPanel();
    private final JTextField nomeJTextField = new JTextField(20);
    private final JTextField emailJTextField = new JTextField(20);
    private final JTextField senhaJTextField = new JTextField(20);
    private final JButton cadastrarJButton = new JButton("Cadastrar");
    private final JLabel nomeJLabel = new JLabel("Nome:");
    private final JLabel emailJLabel = new JLabel("Email:");
    private final JLabel senhaJLabel = new JLabel("Senha:");

    public Frame() {
        super("Cadastro");

        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(nomeJLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(nomeJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(emailJLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(emailJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(senhaJLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(senhaJTextField, gbc);

        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        buttonPanel.add(cadastrarJButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cadastrarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String nome = nomeJTextField.getText();
                String email = emailJTextField.getText();
                String senha = senhaJTextField.getText();
                try {
                    InserirRegistro.cadastrar("db_teste", "tbl_teste", "nome", "email", "senha", nome, email, senha);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Frame.this, "Digite uma coisa válida!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame());
    }
}
