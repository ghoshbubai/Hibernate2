package com.sony.HibernateHQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {

	@Id
	private int sid;
	private double marks;
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", marks=" + marks + ", sname=" + sname + "]";
	}
	
	
}
