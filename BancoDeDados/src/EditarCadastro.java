import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditarCadastro extends JFrame {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JTextField senhaJPasswordField = new JTextField();
    private final JButton updateJButton = new JButton("^");
    private final JButton nextJButton = new JButton(">");
    private final JButton previousJButton = new JButton("<");
    private final JButton deleteJButton = new JButton("delete register");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JButton criarJButton = new JButton("criar registro");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JLabel notificacaoJLabel = new JLabel("Status atual");
    private final JLabel espacadorLabel = new JLabel("");
    private final JLabel espacador2Label = new JLabel("");
    private final JLabel espacador3Label = new JLabel("");
    private final JLabel espacador4Label = new JLabel("");
    private final JLabel espacador5Label = new JLabel("");
    private final JLabel espacador6Label = new JLabel("");
    private final JLabel espacador7Label = new JLabel("");
    
    public EditarCadastro()
    {
        super("Cadastrar");
        setLayout(new GridLayout(6, 4, 10, 10));

        firstJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.firstRegistro("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Primeiro registro");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(false);
                        firstJButton.setEnabled(false);
                        previousJButton.setEnabled(false);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);

                        notificacaoJLabel.setText("Primeiro registro");
                    } catch (Exception e) {
                        System.out.println("Ops! Ocorreu um erro ao posicionar o primeiro registro. Erro: "+ e);
                    }
                }
            }
        );

        nextJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.nextRegistro("db_teste", "tbl_teste", idJTextField.getText());
                        notificacaoJLabel.setText("Próximo registro");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(false);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);

                    } catch (Exception e) {
                        System.out.println("Ops! Ocorreu um erro ao posicionar o próximo registro. Erro: "+ e);
                    }
                }
            }
        );

        previousJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.previousRegistro("db_teste", "tbl_teste", idJTextField.getText());
                        notificacaoJLabel.setText("Registro Anterior");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(false);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(true);
                        nextJButton.setEnabled(true);

                    } catch (Exception e) {
                        System.out.println("Ops! Ocorreu um erro ao posicionar o registro anterior. Erro: "+ e);
                    }
                }
            }
        );
        deleteJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String nome;
                    String email;
                    String senha;
                    try {
                        nome = nomeJTextField.getText();
                        email = emailJTextField.getText();
                        senha = senhaJPasswordField.getText();
                        NavegadorDeRegistro.deleteRegistro("db_teste", "tbl_teste", "nome", "email", "senha", nome, email, senha);

                    } catch (Exception e) {
                        System.out.println("Ops! Ocorreu um erro ao deletar o registro. Erro: "+ e);
                    }
                }
            }
        );
        criarJButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String nome = nomeJTextField.getText();
                String email = emailJTextField.getText();
                String senha = senhaJPasswordField.getText();
                try {
                    InserirRegistro.cadastrar("db_teste", "tbl_teste", "nome", "email", "senha", nome, email, senha);
                } catch (NumberFormatException ex) {
                }
            }
        });

        lastJButton.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    String[] resultado;
                    try {
                        resultado = NavegadorDeRegistro.lastRegistro("db_teste", "tbl_teste");
                        notificacaoJLabel.setText("Último registro");
                        idJTextField.setText(resultado[0]);
                        nomeJTextField.setText(resultado[1]);
                        emailJTextField.setText(resultado[2]);
                        senhaJPasswordField.setText(resultado[3]);
                        updateJButton.setEnabled(false);
                        firstJButton.setEnabled(true);
                        previousJButton.setEnabled(true);
                        lastJButton.setEnabled(false);
                        nextJButton.setEnabled(false);
                    } catch (Exception e) {
                        System.out.println("Ops! Ocorreu um erro ao posicionar o último registro. Erro: "+ e);
                    }
                }
            }
        );
        
        add(idJLabel);
        add(idJTextField);
        add(updateJButton);
        idJTextField.setEditable(false);
        add(espacadorLabel);
        
        add(nomeJLabel);
        add(nomeJTextField);
        add(espacador2Label);
        add(espacador3Label);
            
        add(emailJLabel);
        add(emailJTextField);
        add(espacador4Label);
        add(espacador5Label);
            
        add(senhaJLabel);
        add(senhaJPasswordField);
        add(espacador6Label);
        add(espacador7Label);

        add(firstJButton);
        add(previousJButton);
        add(nextJButton);
        add(lastJButton);
        add(criarJButton);
        add(deleteJButton);

        add(notificacaoJLabel);
        
        setSize(600, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        EditarCadastro application = new EditarCadastro();
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}