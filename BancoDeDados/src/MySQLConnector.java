import java.sql.*;

public class MySQLConnector {
    @SuppressWarnings("deprecation")
    public static Connection conectar() {
        String status = "Nada aconteceu ainda...";
        String mysqlHost = "localhost";
        String mysqlDb = "db_mysql_connector";
        String mysqlUser = "root";
        String mysqlPassword = "senac@02";
        String mysqlPort = "3306";
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com Sucesso!!";
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            status = "Ops, Ocorreu um erro! Mensagem do servidor: " + e;
        }

        System.out.println(status);
        return conn;
    }
}