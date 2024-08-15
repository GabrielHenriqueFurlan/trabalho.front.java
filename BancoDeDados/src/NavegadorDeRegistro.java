import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] firstRegistro(String db, String tbl) throws Exception {
        Connection connection = MySQLConnector.conectar();
        String strSqlFirstRegister = "SELECT * FROM " + db + "." + tbl + " ORDER BY id ASC LIMIT 1;";
        Statement stmFirstRegister = connection.createStatement();
        ResultSet rstSqlFirstRegister = stmFirstRegister.executeQuery(strSqlFirstRegister);
        rstSqlFirstRegister.next();
        String[] result = {
            rstSqlFirstRegister.getString("id"),
            rstSqlFirstRegister.getString("nome"),
            rstSqlFirstRegister.getString("email"),
            rstSqlFirstRegister.getString("senha")
        };
        stmFirstRegister.close();
        return result;
    }

    public static String[] nextRegistro(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson + 1;
        if (nextID >= 1) {
            String strSqlNextRegister = "SELECT * FROM " + db + "." + tbl + " ORDER BY id ASC;";
            Statement stmNextRegister = connection.createStatement();
            ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlNextRegister);
            String[] result = {"", "", "", ""};

            while (rstSqlNextRegister.next()) {
                if (id.equals(rstSqlNextRegister.getString("id"))) {
                    if (rstSqlNextRegister.next()) {
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("nome");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;
                    }
                }
            }
            rstSqlNextRegister.close();
            return result[0].isEmpty() ? null : result;
        } else {
            return null;
        }
    }

    public static String[] previousRegistro(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int previousID = idPerson - 1;
        if (previousID >= 1) {
            String strSqlPreviousRegister = "SELECT * FROM " + db + "." + tbl + " ORDER BY id DESC;";
            Statement stmPreviousRegister = connection.createStatement();
            ResultSet rstSqlPreviousRegister = stmPreviousRegister.executeQuery(strSqlPreviousRegister);
            String[] result = {"", "", "", ""};

            while (rstSqlPreviousRegister.next()) {
                if (id.equals(rstSqlPreviousRegister.getString("id"))) {
                    if (rstSqlPreviousRegister.next()) {
                        result[0] = rstSqlPreviousRegister.getString("id");
                        result[1] = rstSqlPreviousRegister.getString("nome");
                        result[2] = rstSqlPreviousRegister.getString("email");
                        result[3] = rstSqlPreviousRegister.getString("senha");
                        break;
                    }
                }
            }
            rstSqlPreviousRegister.close();
            return result[0].isEmpty() ? null : result;
        } else {
            return null;
        }
    }

    public static String deleteRegistro(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) throws Exception {
        Connection connection = MySQLConnector.conectar();
        String strSqlDeleteRegister = "DELETE FROM " + db + "." + tbl + " WHERE " + campo1 + "= ? AND " + campo2 + "= ? AND " + campo3 + "= ?;";
        PreparedStatement stmDeleteRegister = connection.prepareStatement(strSqlDeleteRegister);
        stmDeleteRegister.setString(1, nome);
        stmDeleteRegister.setString(2, email);
        stmDeleteRegister.setString(3, senha);
        int linhasRegistro = stmDeleteRegister.executeUpdate();
        stmDeleteRegister.close();
        connection.close();
        return linhasRegistro > 0 ? "Registro excluído" : "Nenhum registro encontrado";
    }

    public static String updateRegistro(String db, String tbl, String nome, String email, String senha, String id) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlUpdateRegistro = "UPDATE " + db + "." + tbl + " SET nome = ?, email = ?, senha = ? WHERE id = ?;";
            PreparedStatement stmUpdateRegistro = conexao.prepareStatement(strSqlUpdateRegistro);
            stmUpdateRegistro.setString(1, nome);
            stmUpdateRegistro.setString(2, email);
            stmUpdateRegistro.setString(3, senha);
            stmUpdateRegistro.setString(4, id);
            stmUpdateRegistro.executeUpdate();
            stmUpdateRegistro.close();
            conexao.close();
            return "Registro atualizado com sucesso!";
        } catch (Exception e) {
            return "Ops! Ocorreu um erro: " + e;
        }
    }

    public static String cadastrar(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) {
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlInsereRegistro = "INSERT INTO " + db + "." + tbl + " (" + campo1 + ", " + campo2 + ", " + campo3 + ") VALUES (?, ?, ?);";
            PreparedStatement stmInsereRegistro = conexao.prepareStatement(strSqlInsereRegistro);
            stmInsereRegistro.setString(1, nome);
            stmInsereRegistro.setString(2, email);
            stmInsereRegistro.setString(3, senha);
            stmInsereRegistro.executeUpdate();
            stmInsereRegistro.close();
            conexao.close();
            return "Registro inserido com sucesso";
        } catch (Exception e) {
            return "Opsss! Ocorreu um erro: " + e;
        }
    }

    public static String[] lastRegistro(String db, String tbl) throws Exception {
        Connection connection = MySQLConnector.conectar();
        String strSqlLastRegister = "SELECT * FROM " + db + "." + tbl + " ORDER BY id DESC LIMIT 1;";
        Statement stmLastRegister = connection.createStatement();
        ResultSet rstSqlLastRegister = stmLastRegister.executeQuery(strSqlLastRegister);
        rstSqlLastRegister.next();
        String[] result = {
            rstSqlLastRegister.getString("id"),
            rstSqlLastRegister.getString("nome"),
            rstSqlLastRegister.getString("email"),
            rstSqlLastRegister.getString("senha")
        };
        rstSqlLastRegister.close();
        return result;
    }

    public static String[] LimparRegistro() {

        return new String[]{"", "", "", ""};
    }
}
