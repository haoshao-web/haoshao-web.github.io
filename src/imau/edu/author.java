package imau.edu;
//满足了JavaBean规范的类
public class author {
	private int id;
	private String Username;//姓名
	private String Gender;//性别
	private String Phone;//电话
	private String Bookname;//书名
	private String Sales_volume;//销量
	private String Booknum;//数量
	public author() {}
	public author(int id,String Username,String Gender,String Phone,String Bookname,String Sales_volume,String Booknum) {
		this.id = id;
		this.Username = Username;
		this.Gender = Gender;
		this.Phone = Phone;
		this.Bookname = Bookname;
		this.Sales_volume = Sales_volume;
		this.Booknum = Booknum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public String getSales_volume() {
		return Sales_volume;
	}
	public void setSales_volume(String sales_volume) {
		Sales_volume = sales_volume;
	}
	public String getBooknum() {
		return Booknum;
	}
	public void setBooknum(String booknum) {
		Booknum = booknum;
	}

	
}
