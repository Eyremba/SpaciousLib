package org.anhcraft.spaciouslib.Database;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Ice my sql.
 */
public abstract class SMySQL extends SDatabase {
	/*
	 * --- Ice API ---
	 * 
	 * [+] Create by Anh Craft
	 * 
	 */
	
	private String user = null;
	private String dtbs = null;
	private String pass = null;
	private String port = null;
	private String host = null;

    /**
     * Create new MySQL instance
     *
     * @param host host name
     * @param port port number
     * @param dtbs database name
     * @param user username
     * @param pass password
     */
    public SMySQL(String host, int port, String dtbs, String user, String pass) {
		this.host = host;
		this.port = Integer.toString(port);
		this.dtbs = dtbs;
		this.user = user;
		this.pass = pass;
	}
	
	/**
	 * Connect to a database (must close the connection)
	 *
	 * @return Connection
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	
	public void connect(DatabaseRunnable d) throws ClassNotFoundException, SQLException {
		if (!checkConnection()) {
			String u = "jdbc:mysql://" + this.host + ":" + this.port;
			if (dtbs != null) {
				u = u + "/" + this.dtbs;
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(u, this.user, this.pass);
			d.run(connection, connection.createStatement());
		}
	}

    /**
     * Connect to a database (auto close the connection)
     *
     * @return Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     *
     */

    public void connectAutoClose(DatabaseRunnable d) throws ClassNotFoundException, SQLException {
        if (!checkConnection()) {
            String u = "jdbc:mysql://" + this.host + ":" + this.port;
            if (dtbs != null) {
                u = u + "/" + this.dtbs;
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(u, this.user, this.pass);
            d.run(connection, connection.createStatement());
            connection.close();
        }
    }
}
