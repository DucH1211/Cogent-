

import java.sql.*;
import java.util.Scanner;

public class testJDBCFUN {

	public static void main(String[] args)throws ClassNotFoundException {
		// TODO Auto-generated method stub
//		Class c = Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println(c);
		// you don't need this because referenced libraries are loaded during extension loader
		
		String url = "jdbc:mysql://localhost/javademo";
		String user = "root";
		String password = "TommyTmy!12016ZXC";
		
		Connection con = null;
		//connect
		try {
			con = 	DriverManager.getConnection(url,user,password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println(con); //confirm connection
		
		//Create new Table
		String query = "create table if not exists funTable"
				+ "("
				+ "fun_id int primary key,"
				+ "fun_content varchar(100),"
				+ "fun_int int"
				+ ")";
		PreparedStatement stmt =  null;
		try {
			//run statement create table;
			stmt = 	con.prepareStatement(query);
			stmt.executeUpdate();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		//change to insert values query
		query = "insert into funtable values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do
		{
			try {
				//set var
				System.out.println("Enter 9 to stop the loop or a number to continue");
				choice = sc.nextInt();sc.nextLine();
				if(choice == 9)
				{
					break;
				}else {
				stmt = con.prepareStatement(query);
				System.out.println("Enter ID");
				int id = sc.nextInt(); sc.nextLine();
				stmt.setInt(1, id);
				System.out.println("Enter fun_content");
				String fun_content =  sc.nextLine();
				stmt.setString(2, fun_content);
				System.out.println("Enter fun_int");
				int fun_int = sc.nextInt();sc.nextLine();
				stmt.setInt(3, fun_int);
				//execute
				stmt.executeUpdate();
				//Attempt to stop loop
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				sc = new Scanner(System.in);
			}
			
		}while(choice != 9);
		
		//create another table with foreign key
		query = "create table if not exists funforeignTable"
				+ "("
				+ "foreign_id int primary key,"
				+ "fun_id int,"
				+ "status varchar(20),"
				+ "extra_note varchar(100),"
				+ "constraint fk_id foreign key (fun_id) references funtable(fun_id)"
				+ ")";
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query = "select * from funTable";
		try {
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(); 
			//Scrollable ResultSet (similar to List Iterator(legacy))
			
			while(rs.next()) //similar to Iterator hasNext()
			{
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getInt(3)+ "\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query = "select * from funforeignTable";
		try {
			stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(); 
			//Scrollable ResultSet (similar to List Iterator(legacy))
			//ResultSetMetaData - 
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Total column count:" + rsmd.getColumnCount());
			System.out.println("Size column Name:" + rsmd.getColumnDisplaySize(3));
			while(rs.next()) //similar to Iterator hasNext()
			{
				for(int i = 1; i <= rsmd.getColumnCount(); i++)
				{
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//trying callable statement
		
		query = "call get_funtable()";
		try {
			CallableStatement Cstmt = con.prepareCall(query);
			ResultSet rs = null;
			boolean b = Cstmt.execute();
			//execute return boolean type to check if return type is ResultSet
			if(b){
				rs = stmt.getResultSet();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
