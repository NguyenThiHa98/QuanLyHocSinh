package qlhsUpdate;

import java.util.Scanner;

public class Management {
	public static void main(String[] args) {
		int chon;
		Scanner sc = new Scanner(System.in);
		int n;
		Student[] studentlist = null;
		Class[] classlist = null;
		Course[] courselist = null;
		Management mng = new Management();
		do {
			System.out.println("Chon 1: De nhap thong tin");
			System.out.println("Chon 2: De hien thi thong tin");
			System.out.println("Chon 3: De tim kiem hoc sinh theo nam sinh");
			System.out.println("Chon 4: De dem so hoc sinh sinh nam 2000 va co que o HN");
			System.out.println("Chon 0: De ket thuc");
			chon = sc.nextInt();
			switch (chon) {
			case 1:
				System.out.println("Nhap so khoa hoc:");
				n = sc.nextInt();
				courselist = new Course[n];
				mng.inputCourse(courselist);
				System.out.println("===================");
				break;
			case 2:
				mng.showCourselist(courselist);
				System.out.println("===================");
				break;
			case 3:
				Student[] temp;
				temp = mng.searchbyDOB(courselist);
				if (temp != null) {
					System.out.println("Danh sach cac hoc sinh can tim:");
					mng.showStudentList(temp);
				} else {
					System.out.println("Khong co hoc sinh nao sinh nam 2000.");
				}
				System.out.println("===================");
				break;
			case 4:
				mng.searchbyDOBandCiy(courselist);
				System.out.println("===================");
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Khong co chuc nang tuong ung");
				break;
			}
		} while (chon != 0);
	}

	private int count;

	public Student[] inputStudent(Student[] studentlist, int sizeStudent) {
		Scanner intValue = new Scanner(System.in);
		Scanner stringValue = new Scanner(System.in);

		Student student = null;
		;
		studentlist = new Student[sizeStudent];

		for (int i = 0; i < studentlist.length; i++) {
			student = new Student();
			System.out.println("Nhap thong tin hoc sinh thu " + (i + 1));
			System.out.println("Nhap ho ten:");
			student.setHoten(stringValue.nextLine());
			System.out.println("Nhap tuoi:");
			student.setTuoi(intValue.nextInt());
			System.out.println("Nhap nam sinh:");
			student.setNamsinh(intValue.nextInt());
			System.out.println("Nhap que quan:");
			student.setQuequan(stringValue.nextLine());
			studentlist[i] = student;
		}
		return studentlist;
	}

	public Class[] inputClass(Class[] classlist, int sizeClass) {
		Scanner intValue = new Scanner(System.in);
		Scanner stringValue = new Scanner(System.in);
		String tenLop;
		int soHS;
		Class cls = null;
		classlist = new Class[sizeClass];
		Student[] studentlist = null;
		Student[] stdtemp;
		for (int i = 0; i < classlist.length; i++) {
			cls = new Class();
			System.out.println("Nhap thong tin lop thu " + (i + 1));
			System.out.println("Nhap ten lop:");
			tenLop = stringValue.nextLine();
			cls.setTenLop(tenLop);
			System.out.println("Nhap so hoc sinh cua lop:");
			soHS = intValue.nextInt();
			cls.setSoHS(soHS);
			stdtemp = this.inputStudent(studentlist, soHS);
			cls.setStudents(stdtemp);
			classlist[i] = cls;
		}
		return classlist;
	}

	public Course[] inputCourse(Course[] courselist) {
		Scanner intValue = new Scanner(System.in);
		Scanner stringValue = new Scanner(System.in);
		String tenKhoaHoc;
		String tenKyHoc;
		int soLop;

		Course course = null;
		Class[] classlist = null;
		Class[] classtemp;
		for (int i = 0; i < courselist.length; i++) {
			course = new Course();
			System.out.println("Nhap thong tin khoa hoc thu " + (i + 1));
			System.out.println("Nhap ten khoa hoc:");
			tenKhoaHoc = stringValue.nextLine();
			course.setTenKhoaHoc(tenKhoaHoc);
			System.out.println("Nhap ten ky hoc:");
			tenKyHoc = stringValue.nextLine();
			course.setTenKyHoc(tenKyHoc);
			System.out.println("Nhap so lop:");
			soLop = intValue.nextInt();
			course.setSoLop(soLop);
			classtemp = this.inputClass(classlist, soLop);
			course.setClasssL(classtemp);
			courselist[i] = course;
		}
		return courselist;
	}

	public void showStudent(Student student) {
		System.out.println("\tHo ten: " + student.getHoten());
		System.out.println("\tTuoi: " + student.getTuoi());
		System.out.println("\tNam sinh: " + student.getNamsinh());
		System.out.println("\tQue quan: " + student.getQuequan());
	}

	public void showStudentList(Student[] studentlist) {
		int demP = 1;
		for (Student student : studentlist) {
			System.out.println("\tThong tin hoc sinh thu " + demP);
			this.showStudent(student);
			demP++;
			System.out.println("\t**************");
		}
	}

	public void showClassList(Class[] classlist) {
		int demC = 1;
		for (Class classs : classlist) {
			System.out.println("\tThong tin lop thu " + demC);
			System.out.println("\tTen lop: " + classs.getTenLop());
			System.out.println("\tSo hoc sinh: " + classs.getSoHS());
			System.out.println("\t**************");
			this.showStudentList(classs.getStudents());
			demC++;
		}
	}

	public void showCourselist(Course[] courselist) {
		int demCo = 1;
		for (Course course : courselist) {
			System.out.println("Thong tin khoa hoc thu " + demCo);
			System.out.println("\tTen khoa hoc: " + course.getTenKhoaHoc());
			System.out.println("\tTen ky hoc: " + course.getTenKyHoc());
			System.out.println("\t**************");
			this.showClassList(course.getClasssL());
			demCo++;
		}
	}

	public Student[] searchbyDOB(Course[] courselist) {
		int ns, i = 0, count = 0;
		Scanner sc = new Scanner(System.in);
		Student[] studentlist = null;
		Student[] resultstudents = null;
		Class[] classlist;
		System.out.println("Nhap nam sinh: ");
		ns = sc.nextInt();
		for (Course course : courselist) {
			classlist = course.getClasssL();
			if (classlist != null) {
				for (Class classs : classlist) {
					studentlist = classs.getStudents();
					if (studentlist != null) {
						for (Student student : studentlist) {
							if (ns == student.getNamsinh()) {
								count++;
							}
						}
					}
				}
			}
		}
		resultstudents = new Student[count];
		count = 0;
		for (Course course : courselist) {
			classlist = course.getClasssL();
			if (classlist != null) {
				for (Class classs : classlist) {
					studentlist = classs.getStudents();
					for (Student student : studentlist) {
						if (ns == student.getNamsinh()) {
							resultstudents[i] = student;
							i++;
						}
					}
				}
			}

		}
		return resultstudents;
	}

	public void searchbyDOBandCiy(Course[] courselist) {

		int count = 0;
		Scanner sc = new Scanner(System.in);
		Student[] studentlist = null;
		Student[] resultstudents = null;
		Class[] classlist;

		for (Course course : courselist) {
			classlist = course.getClasssL();
			if (classlist != null) {
				for (Class classs : classlist) {
					studentlist = classs.getStudents();
					if (studentlist != null) {
						for (Student student : studentlist) {
							if (student.getNamsinh() == 2000 && student.getQuequan().equalsIgnoreCase("Ha Noi")) {
									count++;
							}
						}
					}
				}
			}
		}
		System.out.println("Co "+count+" hoc sinh sinh nam 2000 va co que o Ha Noi");
	}
}