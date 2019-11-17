package com.tfsc.puru.connectionpool;

import java.sql.Connection;

public interface ConnectionPool {
	
	public Connection getConnectionPool() throws Exception;
	
	public void removeConnectionFromPool(int poolIndex);

}
