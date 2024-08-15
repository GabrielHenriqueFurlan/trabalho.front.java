import java.awt.*;
import javax.swing.*;

public class EditarCadastro extends JFrame {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nomeJTextField = new JTextField();
    private final JTextField emailJTextField = new JTextField();
    private final JPasswordField senhaJPasswordField = new JPasswordField();
    private final JButton updateJButton = new JButton("^");
    private final JButton nextJButton = new JButton(">");
    private final JButton cleanJButton = new JButton("Limpar área");
    private final JButton previousJButton = new JButton("<");
    private final JButton deleteJButton = new JButton("Deletar registro");
    private final JButton firstJButton = new JButton("<<");
    private final JButton lastJButton = new JButton(">>");
    private final JButton criarJButton = new JButton("Criar registro");
    private final JLabel idJLabel = new JLabel("Id:");
    private final JLabel nomeJLabel = new JLabel("Digite um nome:");
    private final JLabel emailJLabel = new JLabel("Digite um email:");
    private final JLabel senhaJLabel = new JLabel("Digite uma senha:");
    private final JLabel notificacaoJLabel = new JLabel("Status atual");

    public EditarCadastro() {
        super("Cadastrar");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(idJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        idJTextField.setColumns(15);
        add(idJTextField, gbc);
        idJTextField.setEditable(false);

        gbc.gridx = 3;
        gbc.gridwidth = 1;
        add(updateJButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nomeJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        nomeJTextField.setColumns(25);
        add(nomeJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(emailJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        emailJTextField.setColumns(25);
        add(emailJTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(senhaJLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        senhaJPasswordField.setColumns(25);
        add(senhaJPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(firstJButton, gbc);

        gbc.gridx = 1;
        add(previousJButton, gbc);

        gbc.gridx = 2;
        add(nextJButton, gbc);

        gbc.gridx = 3;
        add(lastJButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(criarJButton, gbc);

        gbc.gridx = 1;
        add(deleteJButton, gbc);

        gbc.gridx = 2;
        add(cleanJButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(notificacaoJLabel, gbc);

        for (int i = 0; i < 7; i++) {
            JLabel spacer = new JLabel("");
            add(spacer);
        }

        firstJButton.addActionListener(e -> firstButtonAction());
        nextJButton.addActionListener(e -> nextButtonAction());
        previousJButton.addActionListener(e -> previousButtonAction());
        deleteJButton.addActionListener(e -> deleteButtonAction());
        criarJButton.addActionListener(e -> criarButtonAction());
        updateJButton.addActionListener(e -> updateButtonAction());
        lastJButton.addActionListener(e -> lastButtonAction());
        cleanJButton.addActionListener(e -> cleanButtonAction());

        setSize(600, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void firstButtonAction() {
        try {
            String[] resultado = NavegadorDeRegistro.firstRegistro("db_teste", "tbl_teste");
            atualizarCampos(resultado);
            updateJButton.setEnabled(true);
            firstJButton.setEnabled(false);
            previousJButton.setEnabled(false);
            lastJButton.setEnabled(true);
            nextJButton.setEnabled(true);
            notificacaoJLabel.setText("Primeiro registro");
        } catch (Exception e) {
            System.out.println("Erro ao posicionar o primeiro registro: " + e);
        }
    }

    private void nextButtonAction() {
        try {
            String[] resultado = NavegadorDeRegistro.nextRegistro("db_teste", "tbl_teste", idJTextField.getText());
            if (resultado != null) {
                atualizarCampos(resultado);
                updateJButton.setEnabled(true);
                firstJButton.setEnabled(true);
                previousJButton.setEnabled(true);
                lastJButton.setEnabled(true);
                nextJButton.setEnabled(true);
                notificacaoJLabel.setText("Próximo registro");
            } else {
                notificacaoJLabel.setText("Nenhum próximo registro");
            }
        } catch (Exception e) {
            System.out.println("Erro ao posicionar o próximo registro: " + e);
        }
    }

    private void previousButtonAction() {
        try {
            String[] resultado = NavegadorDeRegistro.previousRegistro("db_teste", "tbl_teste", idJTextField.getText());
            if (resultado != null) {
                atualizarCampos(resultado);
                updateJButton.setEnabled(true);
                firstJButton.setEnabled(true);
                previousJButton.setEnabled(true);
                lastJButton.setEnabled(true);
                nextJButton.setEnabled(true);
                notificacaoJLabel.setText("Registro Anterior");
            } else {
                notificacaoJLabel.setText("Nenhum registro anterior");
            }
        } catch (Exception e) {
            System.out.println("Erro ao posicionar o registro anterior: " + e);
        }
    }

    private void deleteButtonAction() {
        try {
            NavegadorDeRegistro.deleteRegistro("db_teste", "tbl_teste", "nome", "email", "senha",
                    nomeJTextField.getText(), emailJTextField.getText(), new String(senhaJPasswordField.getPassword()));
            notificacaoJLabel.setText("Registro deletado");
        } catch (Exception e) {
            System.out.println("Erro ao deletar o registro: " + e);
        }
    }

    private void criarButtonAction() {
        try {
            InserirRegistro.cadastrar("db_teste", "tbl_teste", "nome", "email", "senha",
                    nomeJTextField.getText(), emailJTextField.getText(), new String(senhaJPasswordField.getPassword()));
            notificacaoJLabel.setText("Registro criado");
        } catch (Exception e) {
            System.out.println("Erro ao criar registro: " + e);
        }
    }

    private void updateButtonAction() {
        try {
            NavegadorDeRegistro.updateRegistro("db_teste", "tbl_teste",
                    nomeJTextField.getText(), emailJTextField.getText(), new String(senhaJPasswordField.getPassword()), idJTextField.getText());
            notificacaoJLabel.setText("Registro atualizado");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o registro: " + e);
        }
    }

    private void lastButtonAction() {
        try {
            String[] resultado = NavegadorDeRegistro.lastRegistro("db_teste", "tbl_teste");
            atualizarCampos(resultado);
            updateJButton.setEnabled(true);
            firstJButton.setEnabled(true);
            previousJButton.setEnabled(true);
            lastJButton.setEnabled(false);
            nextJButton.setEnabled(false);
            notificacaoJLabel.setText("Último registro");
        } catch (Exception e) {
            System.out.println("Erro ao posicionar o último registro: " + e);
        }
    }

    private void cleanButtonAction() {
        idJTextField.setText("");
        nomeJTextField.setText("");
        emailJTextField.setText("");
        senhaJPasswordField.setText("");
        updateJButton.setEnabled(false);
        firstJButton.setEnabled(true);
        previousJButton.setEnabled(false);
        lastJButton.setEnabled(false);
        nextJButton.setEnabled(true);
        notificacaoJLabel.setText("Área de registros limpa");
    }

    private void atualizarCampos(String[] resultado) {
        if (resultado != null) {
            idJTextField.setText(resultado[0]);
            nomeJTextField.setText(resultado[1]);
            emailJTextField.setText(resultado[2]);
            senhaJPasswordField.setText(resultado[3]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditarCadastro::new);
    }
}
