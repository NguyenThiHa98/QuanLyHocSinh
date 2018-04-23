package qlhsUpdate;

public class Course {
	public String tenKhoaHoc;
	public String tenKyHoc;
	public int soLop;
	public Class[] classsL;
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(String tenKhoaHoc, String tenKyHoc, int soLop, Class[] classs) {
		super();
		this.tenKhoaHoc = tenKhoaHoc;
		this.tenKyHoc = tenKyHoc;
		this.soLop = soLop;
		this.classsL = classs;
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
	public String getTenKyHoc() {
		return tenKyHoc;
	}
	public void setTenKyHoc(String tenKyHoc) {
		this.tenKyHoc = tenKyHoc;
	}
	public int getSoLop() {
		return soLop;
	}
	public void setSoLop(int soLop) {
		this.soLop = soLop;
	}
	public Class[] getClasssL() {
		return classsL;
	}
	public void setClasssL(Class[] classs) {
		this.classsL = classs;
	}
}
