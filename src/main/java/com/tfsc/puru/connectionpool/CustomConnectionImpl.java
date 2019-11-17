package com.tfsc.puru.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CustomConnectionImpl implements CustomConnectionPool {

	private String driver;
	String userName;
	String password;
	String url;
	private List<Connection> connList;

	public CustomConnectionImpl(String driver, String url, String userName, String password, int numberOfConnection) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.connList = Collections.synchronizedList(new LinkedList<Connection>());

		for (int i = 0; i < numberOfConnection; i++) {
			synchronized (this) {
				connList.add(makeConnection());
			}

		}

	}

	public Connection getConnectionPool() throws Exception {
		
		if(connList.isEmpty()) {
			//log error
			try {
				throw new Exception("bosrike connection obj nhi hai");
			} catch (Exception e) {
				throw new Exception();
			}
			
			
		}
		
		Connection connection = connList.get(0);
		removeConnectionFromPool(0);
		return connection;
	}

	public void removeConnectionFromPool(int poolIndex) {
		synchronized (connList) {
			connList.remove(poolIndex);
		}
	}

	public Connection getSpecificConnection() {
		return null;
	}

	public List<Connection> getAllConnectionPool() {
		return connList;
	}

	public boolean isConnectionAlive(String connectionName) {
		for (Connection connection : connList) {
			
		}
		return false;
	}

	public void removeAllConnection() {
		// TODO Auto-generated method stub

	}

	private Connection makeConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;

	}

	public void removeAllConnection(int poolIndex) {
		// TODO Auto-generated method stub
		
	}


}
