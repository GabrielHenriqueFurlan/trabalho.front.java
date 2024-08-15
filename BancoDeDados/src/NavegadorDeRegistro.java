import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] firstRegistro(String db, String tbl) throws Exception {
        try (Connection connection = MySQLConnector.conectar();
             Statement stmFirstRegister = connection.createStatement()) {
            String strSqlFirstRegister = "SELECT * FROM `" + db + "`.`" + tbl + "` ORDER BY `id` ASC LIMIT 1;";
            ResultSet rstSqlFirstRegister = stmFirstRegister.executeQuery(strSqlFirstRegister);
            if (rstSqlFirstRegister.next()) {
                return new String[]{
                    rstSqlFirstRegister.getString("id"),
                    rstSqlFirstRegister.getString("nome"),
                    rstSqlFirstRegister.getString("email"),
                    rstSqlFirstRegister.getString("senha")
                };
            }
        }
        return null;
    }

    public static String[] nextRegistro(String db, String tbl, String id) throws Exception {
        try (Connection connection = MySQLConnector.conectar();
             Statement stmNextRegister = connection.createStatement()) {
            String strSqlNextRegister = "SELECT * FROM `" + db + "`.`" + tbl + "` ORDER BY `id` ASC;";
            ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlNextRegister);
            while (rstSqlNextRegister.next()) {
                if (id.equals(rstSqlNextRegister.getString("id"))) {
                    if (rstSqlNextRegister.next()) {
                        return new String[]{
                            rstSqlNextRegister.getString("id"),
                            rstSqlNextRegister.getString("nome"),
                            rstSqlNextRegister.getString("email"),
                            rstSqlNextRegister.getString("senha")
                        };
                    }
                }
            }
        }
        return null;
    }

    public static String deleteRegistro(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) throws Exception {
        try (Connection connection = MySQLConnector.conectar();
             PreparedStatement pstDeleteRegistro = connection.prepareStatement(
                     "DELETE FROM `" + db + "`.`" + tbl + "` WHERE `" + campo1 + "` = ? AND `" + campo2 + "` = ? AND `" + campo3 + "` = ?")) {
            pstDeleteRegistro.setString(1, nome);
            pstDeleteRegistro.setString(2, email);
            pstDeleteRegistro.setString(3, senha);
            int linhasRegistro = pstDeleteRegistro.executeUpdate();
            return linhasRegistro > 0 ? "Registro excluído" : "Nenhum registro excluído";
        }
    }

    public static String updateRegistro(String db, String tbl, String nome, String email, String senha, String id) {
        try (Connection conexao = MySQLConnector.conectar();
             Statement stmSqlUpdateRegistro = conexao.createStatement()) {
            String strSqlUpdateRegistro = "UPDATE `" + db + "`.`" + tbl + "` SET `nome` = ?, `email` = ?, `senha` = ? WHERE `id` = ?";
            try (PreparedStatement pstUpdateRegistro = conexao.prepareStatement(strSqlUpdateRegistro)) {
                pstUpdateRegistro.setString(1, nome);
                pstUpdateRegistro.setString(2, email);
                pstUpdateRegistro.setString(3, senha);
                pstUpdateRegistro.setString(4, id);
                pstUpdateRegistro.executeUpdate();
            }
            return "Registro atualizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao atualizar o registro: " + e;
        }
    }

    public static String[] previousRegistro(String db, String tbl, String id) throws Exception {
        try (Connection connection = MySQLConnector.conectar();
             Statement stmPreviousRegister = connection.createStatement()) {
            String strSqlPreviousRegister = "SELECT * FROM `" + db + "`.`" + tbl + "` ORDER BY `id` DESC;";
            ResultSet rstSqlPreviousRegister = stmPreviousRegister.executeQuery(strSqlPreviousRegister);
            while (rstSqlPreviousRegister.next()) {
                if (id.equals(rstSqlPreviousRegister.getString("id"))) {
                    if (rstSqlPreviousRegister.next()) {
                        return new String[]{
                            rstSqlPreviousRegister.getString("id"),
                            rstSqlPreviousRegister.getString("nome"),
                            rstSqlPreviousRegister.getString("email"),
                            rstSqlPreviousRegister.getString("senha")
                        };
                    }
                }
            }
        }
        return null;
    }

    public static String cadastrar(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) {
        try (Connection conexao = MySQLConnector.conectar();
             PreparedStatement pstInsertRegistro = conexao.prepareStatement(
                     "INSERT INTO `" + db + "`.`" + tbl + "` (`" + campo1 + "`, `" + campo2 + "`, `" + campo3 + "`) VALUES (?, ?, ?)")) {
            pstInsertRegistro.setString(1, nome);
            pstInsertRegistro.setString(2, email);
            pstInsertRegistro.setString(3, senha);
            pstInsertRegistro.executeUpdate();
            return "Registro inserido com sucesso";
        } catch (Exception e) {
            return "Erro ao inserir registro: " + e;
        }
    }

    public static String[] lastRegistro(String db, String tbl) throws Exception {
        try (Connection connection = MySQLConnector.conectar();
             Statement stmLastRegister = connection.createStatement()) {
            String strSqlLastRegister = "SELECT * FROM `" + db + "`.`" + tbl + "` ORDER BY `id` DESC LIMIT 1;";
            ResultSet rstSqlLastRegister = stmLastRegister.executeQuery(strSqlLastRegister);
            if (rstSqlLastRegister.next()) {
                return new String[]{
                    rstSqlLastRegister.getString("id"),
                    rstSqlLastRegister.getString("nome"),
                    rstSqlLastRegister.getString("email"),
                    rstSqlLastRegister.getString("senha")
                };
            }
        }
        return null;
    }

    // Este método deve ser removido ou corrigido conforme o que realmente precisa fazer
    public static String[] limparRegistro(String db, String tbl) throws Exception {
        // Se deseja realmente limpar todos os registros, considere um DELETE ao invés de SELECT
        // Este método está errado pois faz um SELECT onde id=0, e pode não ser o comportamento desejado
        return null;
    }
}
