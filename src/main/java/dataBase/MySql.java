package main.java.dataBase;

public class MySql {
	public static String ip;
	public static String port;
	public static String userName;
	public static String url;
	public static String password;
	public static String dataBase;
	public static String table;
	
	/**
	 * @author Isabella Oren
	 * @author Arbel Nathan
	 * @category builder for MySql
	 * @param ip
	 * @param port
	 * @param userName
	 * @param password
	 * @param database
	 */
	public MySql(String ip,String port,String userName,String password,String database) {
		this.ip=ip;
		this.dataBase=database;
		this.password=password;
		this.port=port;
		this.userName=userName;
		this.url="jdbc:mysql://" +ip+":"+port+"/"+database;
	}
	
	public static String getIp() {
		return ip;
	}
	public static void setIp(String ip) {
		MySql.ip = ip;
	}
	public static String getPort() {
		return port;
	}
	public static void setPort(String port) {
		MySql.port = port;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		MySql.userName = userName;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		MySql.url = url;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		MySql.password = password;
	}
	public static String getDataBase() {
		return dataBase;
	}
	public static void setDataBase(String dataBase) {
		MySql.dataBase = dataBase;
	}
	public static String getTable() {
		return table;
	}
	public static void setTable(String table) {
		MySql.table = table;
	}
	
	
	
}
