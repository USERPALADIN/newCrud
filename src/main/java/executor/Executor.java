package executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Executor {
    private final Connection connection;


    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpdate(String update) throws SQLException {
        connection.setAutoCommit(false);
        Statement stmt = connection.createStatement();

        stmt.executeUpdate(update);
        connection.commit();
        stmt.close();
    }

    public <T> List<T> execQuery(String query, executor.ResultHandler<T> handler) throws SQLException {

            Statement stmt = connection.createStatement();
            stmt.execute(query);
            ResultSet result = stmt.getResultSet();
            List<T> value = handler.handle(result);
            result.close();
            stmt.close();
            return  value;
    }
}
