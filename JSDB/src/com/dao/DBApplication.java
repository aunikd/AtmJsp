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
public class DBApplication {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
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
	
	//SAVE DATA--------------------
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
			System.out.println("dbsave2");
			while(itr.hasNext())
			{
				System.out.println("dbsave3");
				a=itr.next();
				ps=con.prepareStatement("insert into Registration values(?,?,?,?)");
				ps.setInt(1,a.getRno());
				ps.setString(2,a.getFname());
				ps.setString(3,a.getPass());
				ps.setDouble(4,a.getBal());
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
	
	//GET ALL DATA-------------
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
				lst.add(a);
				System.out.println("cnt");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	
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
					ps=con.prepareStatement("update Registration set bal=? where rno=?");
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
