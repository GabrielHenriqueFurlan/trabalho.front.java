import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
            @SuppressWarnings("unused")
            Connection conexao = MySQLConnector.conectar();
    }
}
