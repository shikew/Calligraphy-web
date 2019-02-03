package com.entity;

public class Word {
	private int wno;
	private String wname;
	private String wpell;
	private int cno;
	private String rtype;
	private int rno;
	private String wpath;
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWpell() {
		return wpell;
	}
	public void setWpell(String wpell) {
		this.wpell = wpell;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getWpath() {
		return wpath;
	}
	public void setWpath(String wpath) {
		this.wpath = wpath;
	}
	@Override
	public String toString() {
		return "Word [wno=" + wno + ", wname=" + wname + ", wpell=" + wpell + ", cno=" + cno + ", rtype=" + rtype
				+ ", rno=" + rno + ", wpath=" + wpath + "]";
	}
	
	public Word(int wno, String wname, String wpell, int cno, String rtype, int rno, String wpath) {
		super();
		this.wno = wno;
		this.wname = wname;
		this.wpell = wpell;
		this.cno = cno;
		this.rtype = rtype;
		this.rno = rno;
		this.wpath = wpath;
	}
	
	public Word() {
		super();
	}
	
}
