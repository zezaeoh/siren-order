package com.sirenPOS.database;

public class DatabaseManager {
	private static DatabaseManager instance;

	private DatabaseManager() {
		// for singleton design pattern
	}
	
	public static synchronized DatabaseManager getInstance() {
		return (instance == null) ? new DatabaseManager(): instance;
	}
	
	public void insert(Object obj) {
		// insert to database
	}
	public void update(Object obj) {
		// update to database
	}
	public void delete(Object obj) {
		// delete from database
	}
	public Object get(int id) {
		// select from database
		return null;
	}
}
