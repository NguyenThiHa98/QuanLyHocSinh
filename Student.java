package qlhsUpdate;

public class Student {
	public String hoten;
	public int tuoi;
	public int namsinh;
	public String quequan;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String hoten, int tuoi, int namsinh, String quequan) {
		super();
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.namsinh = namsinh;
		this.quequan = quequan;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
}
