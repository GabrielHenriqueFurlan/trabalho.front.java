
import java.sql.*;

public class PesquisarRegistro {
    public static String pesquisar(String db, String tbl) {
        String retorno = "nada aconteceu ainda";
        try{
        Connection conexao = MySQLConnector.conectar();
        String strSqlPesquisarRegistro = "select * from `db_teste`.`tbl_teste`;";
        Statement stmSqlPesquisarRegistro = conexao.createStatement();
        ResultSet resultado = stmSqlPesquisarRegistro.executeQuery(strSqlPesquisarRegistro);
        while (resultado.next()) {
            System.out.println(resultado.getString("nome"));
            System.out.println(resultado.getString("email"));
            System.out.println(resultado.getString("senha"));
        }

        System.out.println("Pesquisa realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu um erro: " + e);
        }
        return retorno;
    }
}


