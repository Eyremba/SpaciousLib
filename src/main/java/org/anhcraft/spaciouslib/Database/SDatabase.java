package org.anhcraft.spaciouslib.Database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * The type Database.
 */
public abstract class SDatabase {
    /**
     * The Connection.
     */
    protected Connection connection;

    /**
     * Instantiates a new Database.
     */
    protected SDatabase() {
		this.connection = null;
	}

    /**
     * Connect.
     *
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public abstract void connect() throws SQLException, ClassNotFoundException;

    /**
     * Check connection boolean.
     *
     * @return the boolean
     *
     * @throws SQLException the sql exception
     */
    public boolean checkConnection() throws SQLException {
		return (connection != null && !connection.isClosed());
	}
}
