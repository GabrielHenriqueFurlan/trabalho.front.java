
 import java.sql.*;

public class InserirRegistro {
    public static void main (String[] args) throws SQLException {
        try{
        Connection conexao = MySQLConnector.conectar();
        String strSqlInserirRegistro = "insert into `db_teste`.`tbl_teste` (`nome`, `email`, `senha`) values ('Gabriel', 'gabriel.henrique.furlan.85@gmail.com', 'senha');";
        Statement stmSqlInserirRegistro = conexao.createStatement();

        stmSqlInserirRegistro.addBatch(strSqlInserirRegistro);
        stmSqlInserirRegistro.executeBatch();

        stmSqlInserirRegistro.close();
        System.out.println("Registro inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu um erro: " + e);
        }
    }
}

