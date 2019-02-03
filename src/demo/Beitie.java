package demo;
import java.io.Serializable;

public class Beitie implements Serializable{
	   /**
		 * 
		 */
	  private static final long serialVersionUID = 1L;
	   private int rno;
	   public String rname;
	   private int cno;
	   private String rtype;
	   private String authority;
	   private String rpath;
	   public String showpath;
	   
	   public Beitie() { }
	public Beitie(int rno,String rname,int cno,String rtype,
			String authority,String rpath,String showpath) {
	  this.rno = rno;
	  this.rname = rname;
	  this.cno = cno;
	  this.rtype = rtype;
	  this.authority = authority;
	  this.rpath = rpath;
	  this.showpath =showpath;
	}

	public int getRno() {
		      return rno;
	}
	public void setRno(int rno) {
		      this.rno = rno;
	}
	
	public String getRname() {
		      return rname;
	}
	public void setRname(String rname) {
		      this.rname = rname;
	}
	
	public int getCno() {
		      return cno;
	}
	public void setCno(int cno) {
		      this.cno = cno;
	}
	
	public String getAuthority() {
		      return authority;
	}
	public void setAuthority(String authority) {
		      this.authority = authority;
	}
	
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	
	public String getRpath() {
		return rpath;
	}
	public void setRpath(String rpath) {
		this.rpath = rpath;
	}
	
	public String getShowpath() {
		return showpath;
	}
	public void setShowpath(String showpath) {
		this.showpath = showpath;
	}
}
