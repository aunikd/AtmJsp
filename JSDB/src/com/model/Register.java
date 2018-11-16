package com.model;

/**	Pojo class for Register instantiation
 * @author aunik
 *
 */
public class Register {
	private int rno;
	private String fname;
	private String pass;
	private double bal;
	private String acctype;

	/**Setters and getters for Register members
	 * 
	 * @return 
	 */
	
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	
	

}
