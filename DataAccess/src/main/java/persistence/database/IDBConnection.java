package persistence.database;

import exceptions.DataConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IDBConnection {
    Connection getConnection() throws DataConnectionException;

    void closeConnection();

    PreparedStatement executePreparedQuery(String preparedSql) throws DataConnectionException;

    PreparedStatement createPreparedStatement(String preparedSql) throws DataConnectionException;

    void executeUpdate(PreparedStatement preparedStatement) throws SQLException;

    String getSchemaName();

    String getUserTable();

    String getShiftTable();
}
