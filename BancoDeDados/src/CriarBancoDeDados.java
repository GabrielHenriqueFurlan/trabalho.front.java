import java.sql.*;

public class CriarBancoDeDados {
    public static void main (String[] args) throws SQLException {
        try{
        Connection conexao = MySQLConnector.conectar();
        String strSqlCriarBancoDeDados = "create database `db_teste`";
        Statement stmSqlCriarBancoDeDados = conexao.createStatement();
        stmSqlCriarBancoDeDados.addBatch(strSqlCriarBancoDeDados);
        stmSqlCriarBancoDeDados.executeBatch();
        stmSqlCriarBancoDeDados.close();
        System.out.println("Banco de dados criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Ops! Ocorreu um erro: " + e);
        }
    }
}
