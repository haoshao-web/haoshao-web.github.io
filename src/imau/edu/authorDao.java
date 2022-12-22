package imau.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import imau.edu.ConnectionManager;
import imau.edu.author;


public class authorDao {
//	public static void main(String[] args) {
//		ArrayList list = Ordinary_userDao.getAll();
//		System.out.print(list);
//		
//	}
	 private static Connection conn = ConnectionManager.getConnection();
		//��ѯ����
		public static ArrayList<author> getAll(){
			ArrayList<author>  list = new ArrayList<author>(); 
			try {
			//3,׼����ѯ
			Statement stmt = conn.createStatement();
			String sql = "select * from author";
			//ִ��sql
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				author c = new author(
						rs.getInt("ID"),
						rs.getString("Username"),
						rs.getString("Gender"),
						rs.getString("Phone"),
						rs.getString("Bookname"),
						rs.getString("Sales_volume"),
						rs.getString("Booknum"));
					list.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			return list;
		}
		//ɾ������
		public int delete(int id) {
			try {
				//3,׼����ѯ
				String sql = "delete from author where id = ?";
				PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setInt(1, id);
				//ִ��sql
				int rs = stmt.executeUpdate();
				return rs;
			}catch(SQLException e) {
				e.printStackTrace();
			}
				return 0;
			}
		//�������
		public int add(author student) {
			try {
				//3,׼����ѯ
				String sql = "insert into author(Username,Gender,Phone,Bookname,Sales_volume,Booknum) values(?,?,?,?,?,?)";
				PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setString(1, student.getUsername());
				stmt.setString(2, student.getGender());
				stmt.setString(3, student.getPhone());
				stmt.setString(4, student.getBookname());
				stmt.setString(5, student.getSales_volume());
				stmt.setString(6, student.getBooknum());
				//ִ��sql
				int rs = stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				return 0;
			}
}
