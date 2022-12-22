package imau.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
//单例模式，创建Connection
public class ConnectionManager {
//	public static void main(String[] args) {
//		ConnectionManager.getConnection();
//		if(conn != null) {
//			System.out.print("无错");
//		}
//		else {
//			System.out.print("有错");
//		}
//	}
		static Connection conn =null;
		public static Connection getConnection(){
			if(conn != null) {
				return conn;
			}
			else {
				try {
				//1，注册启动（导入jar包）JDBC=Java Database Connector
				Class.forName("com.mysql.jdbc.Driver");
				
				//2，创建连接对象
				String url = "jdbc:mysql://svip.xmjar.cn:3306/ospfbf?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
				String user = "efspes";
				String password = "xiaocao";
				conn = DriverManager.getConnection(url,user,password);
				}catch(ClassNotFoundException e){
					//e.printStackTrace();
					System.out.append("q");
				}catch(SQLException e) {
					//e.printStackTrace();
					System.out.print("hh");
				}
			}
			
			return conn;
		}
		//删除数据
		public int delete(int id) {
			try {
				//3,准备查询
				String sql = "delete from author where id = ?";
				PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setInt(1, id);
				//执行sql
				int rs = stmt.executeUpdate();
				return rs;
			}catch(SQLException e) {
				e.printStackTrace();
			}
				return 0;
			}
	}


