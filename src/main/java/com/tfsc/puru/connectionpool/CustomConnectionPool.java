
package com.tfsc.puru.connectionpool;

import java.sql.Connection;
import java.util.List;

public interface CustomConnectionPool extends ConnectionPool {
	
	public Connection getSpecificConnection();
	
	public List<Connection> getAllConnectionPool();
	
	
	public boolean isConnectionAlive(String connectionName);
	
	
	public void removeAllConnection(int poolIndex);

}
