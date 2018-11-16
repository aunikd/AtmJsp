package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.model.Login;
import com.model.Register;

/** dao package class for JDBC connectivity setup
 * 
 * @author aunik
 *
 */

public class DBApplication {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	/** Method for connection establishment 
	 * 
	 * @return Returns connection instance once excuted from try/catch block
	 */
	public Connection myConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","newuser123");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	/** Method to insert extracted values into database tabe 
	 * 
	 * @param lst Register List passed as parameter
	 * @return Returns integer value as number of 
	 */
	public int saveData(List<Register> lst)
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Register a=null;
		con=myConnection();
		try
		{
			Iterator<Register> itr=lst.iterator();
			while(itr.hasNext())
			{
				a=itr.next();
				ps=con.prepareStatement("insert into Registration values(?,?,?,?,?)");
				ps.setInt(1,a.getRno());
				ps.setString(2,a.getFname());
				ps.setString(3,a.getPass());
				ps.setDouble(4,a.getBal());
				ps.setString(5, a.getAcctype());
				i = ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	
	/** Method to extract all rows/tuples from Registration table
	 * 
	 * @return Returns Register List of all extracted tuples
	 */
	public List<Register> getAllData()
	{
		List<Register> lst=new LinkedList<Register>();
		con=myConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from Registration");
			while(rs.next())
			{
				Register a=new Register();
				a.setRno(rs.getInt(1));
				a.setFname(rs.getString(2));
				a.setPass(rs.getString(3));
				a.setBal(rs.getDouble(4));
				a.setAcctype(rs.getString(5));
				lst.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	
	
	/** Method to extract one row/tuple from Registration table based on Login parameters passed
	 * 
	 * @param l Login oject passed for db extraction
	 * @return Returns Register List of extracted tuple
	 */
	public List<Register> getData(Login l)
	{
		List<Register> lst=new LinkedList<>();
		Login ln=new Login();
		try {
			con=myConnection();
			ps=con.prepareStatement
					("select * from Registration where rno=? and pass=?");
			ps.setInt(1,l.getRno());
			ps.setString(2,l.getPass());
			ResultSet rs=ps.executeQuery();
			
			Register a=new Register();
			a.setRno(rs.getInt(1));
			a.setFname(rs.getString(2));
			a.setPass(rs.getString(3));
			a.setBal(rs.getDouble(4));
			lst.add(a);
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	
	/** Withdraw method for deducting specific amount parameter passed for User balance from db
	 * 
	 * @param a Amount to be deducted from balance
	 * @param chk Unique Rno from which balance has to be deducted
	 * @return Returns boolean value indicating successfull or unsuccessfull withdrawal
	 */
	public boolean withdraw(int a,int chk) {
		
		con=myConnection();
		List<Register> lst=getAllData();
		boolean b=false;
		for(Register r:lst)
		{
			if(r.getRno()==chk && (r.getBal()>a))
			{ 
				
				double new_bal=r.getBal()-a;
				
				r.setBal(new_bal);
				int nbal = (int)r.getBal();
				try {
					ps=con.prepareStatement("update table Registration set bal=? where rno=?");
					ps.setInt(1,nbal);
					ps.setInt(2,r.getRno());
					b=true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}		
		}
		
		return b;
		
	}
	
	/** Method to Validate user based on existence in Registration table in db
	 * 
	 * @param l Login object passed as parameter
	 * @return Return int value 0,1 and 2 indicating invalid,admin login and regular user validation
	 */
	public int validateUser(Login l)
	{
		myConnection();
		List<Register> lst=getAllData();
		
		for(Register r:lst)	{
			if(r.getRno()==l.getRno() && l.getRno()==420)	{
				return 2;
			} 
			else if(r.getRno()==l.getRno() && l.getRno()!=420)
			{
				if(r.getPass().equals(l.getPass()))	{
					return 1;
				}
			}
		
		}
		return 0;
	}
}
