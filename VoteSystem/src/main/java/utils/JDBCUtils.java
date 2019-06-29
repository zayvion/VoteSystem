package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;

/**
 * 数据库连接工具类
 */
public class JDBCUtils {

	static String url = null;
	static String user = null;
	static String password = null;
	static String className = null;
	
	//读取配置文件里面的数据
	static{
		try {
			//1.创建属性配置对象
			Properties properties = new Properties();
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//导入输入流
			properties.load(is);
			//读取属性
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			className = properties.getProperty("jdbc.driverName");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			//1.注册驱动
			Class.forName(className);
			//2.建立连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/***
	 * 关闭连接
	 * @param conn 数据库连接对象
	 * @param state statement对象
	 * @param result 数据集
	 */
	public static void release(Connection conn,Statement state){
		closeConnection(conn);
		closeStatement(state);
	}
	
	public static void release(Connection conn,Statement state,ResultSet result){
		closeConnection(conn);
		closeResultSet(result);
		closeStatement(state);
	}
	
	private static void closeConnection(Connection conn){
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	private static void closeStatement(Statement state){
		try {
			if (state != null) {
				state.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void closeResultSet(ResultSet result){
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
