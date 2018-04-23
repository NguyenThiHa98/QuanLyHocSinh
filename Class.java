package qlhsUpdate;

public class Class {
	public String tenLop;
	public int soHS;
	public Student[] students;
	public Class() {
		// TODO Auto-generated constructor stub
	}
	public Class(String tenLop, int soHS, Student[] students) {
		super();
		this.tenLop = tenLop;
		this.soHS = soHS;
		this.students = students;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public int getSoHS() {
		return soHS;
	}
	public void setSoHS(int soHS) {
		this.soHS = soHS;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
}
