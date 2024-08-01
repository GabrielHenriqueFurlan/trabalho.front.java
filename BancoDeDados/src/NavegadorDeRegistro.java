import java.sql.*;

public class NavegadorDeRegistro {
    public static String[] firstRegistro(String db, String tbl) throws Exception {
        Connection connection = MySQLConnector.conectar();
        String strSqlFirstRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc limit 1;";
        Statement stmFirstRegister = connection.createStatement();
        ResultSet rstSqlFirstRegiter = stmFirstRegister.executeQuery(strSqlFirstRegister);
        rstSqlFirstRegiter.next();
        String[] result = {
            rstSqlFirstRegiter.getString("id"),
            rstSqlFirstRegiter.getString("nome"),
            rstSqlFirstRegiter.getString("email"),
            rstSqlFirstRegiter.getString("senha")
        };
        stmFirstRegister.close();
        return result;
    }

    public static String[] nextRegistro(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson + 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` asc;";
                Statement stmNextRegister = connection.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("nome");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;
                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }
    public static String deleteRegistro(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) throws Exception {
        String retorno = "...";
        try {
        Connection connection = MySQLConnector.conectar();
                String strSqlDeleteRegister = "delete from `" + db + "`.`" + tbl + "` where`" + campo1 + "`= ? and`" + campo2 + "`= ? and`" + campo3 + "`= ?;";
                PreparedStatement rstDeletarRegistro = connection.prepareStatement(strSqlDeleteRegister);
                rstDeletarRegistro.setString(1 , nome);
                rstDeletarRegistro.setString(2 , email);
                rstDeletarRegistro.setString(3 , senha);
                int linhasRegistro = rstDeletarRegistro.executeUpdate();
                rstDeletarRegistro.close();
                connection.close();
                if (linhasRegistro > 0) {
                    retorno = "registro excluído";

                }else {
                    retorno = "nenhum registro";
                }
            } catch(Exception e) {
                retorno = "ocorreu um erro: " + e;
                System.out.println(retorno);
            } 
            return retorno;
    }

                
    public static String[] previousRegistro(String db, String tbl, String id) throws Exception {
        Connection connection = MySQLConnector.conectar();
        int idPerson = Integer.parseInt(id);
        int nextID = idPerson - 1;
        if (nextID >= 1) {
                String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc;";
                Statement stmNextRegister = connection.createStatement();
                ResultSet rstSqlNextRegister = stmNextRegister.executeQuery(strSqlLastRegister);
                String[] result = {"", "", "", ""};

                while (rstSqlNextRegister.next()) {
                    if (id.equals(rstSqlNextRegister.getString("id"))) {
                        rstSqlNextRegister.next();
                        result[0] = rstSqlNextRegister.getString("id");
                        result[1] = rstSqlNextRegister.getString("nome");
                        result[2] = rstSqlNextRegister.getString("email");
                        result[3] = rstSqlNextRegister.getString("senha");
                        break;

                    }
                }
                rstSqlNextRegister.close();
                if (result[0] == "") {
                    return null;
                } else {
                    return result;
                }
        } else {
            return null;
        }
    }
    public static String cadastrar(String db, String tbl, String campo1, String campo2, String campo3, String nome, String email, String senha) {
        String retorno = "Nada aconteceu ainda...";
        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlInsereRegistro = "INSERT INTO `" + db + "`.`" + tbl + "` (`" + campo1 + "`, `" + campo2 + "`, `" + campo3 + "`)  VALUES ('" + nome + "', '" + email + "', '" + senha + "');";
            Statement stmSqlInsereRegistro = conexao.createStatement(); 

            stmSqlInsereRegistro.addBatch(strSqlInsereRegistro);
            stmSqlInsereRegistro.executeBatch();
            stmSqlInsereRegistro.close();

            retorno = "Resgistro inserido com sucesso";
            System.out.println(retorno);
            
        } catch (Exception e) {
            retorno = "Opsss!! Ocorreu um erro"+ e;
            System.out.println(retorno);
        }
        return retorno;
    }

    public static String[] lastRegistro(String db, String tbl) throws Exception {
        Connection connection = MySQLConnector.conectar();
        try {
            String strSqlLastRegister = "select * from `" + db + "`.`" + tbl + "` order by `id` desc limit 1;";
            Statement stmLastRegister = connection.createStatement();
            ResultSet rstSqlLastRegiter = stmLastRegister.executeQuery(strSqlLastRegister);
            rstSqlLastRegiter.next();
            String[] result = {
                rstSqlLastRegiter.getString("id"),
                rstSqlLastRegiter.getString("nome"),
                rstSqlLastRegiter.getString("email"),
                rstSqlLastRegiter.getString("senha")
            };
            rstSqlLastRegiter.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}