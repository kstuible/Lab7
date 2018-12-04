package la7pkg;

public class Request<T> implements Comparable<T> {

	String stuName;
	String stuDept;
	String stuLevel;
	String crsDept;
	int crsNum;
	double[][] GPA;

	
	@Override
	public int compareTo(T o) {
	
		return compareTo(o);
	}

	
	// Constructor
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_Array) {
		
		 stuName = studentName;
		 stuDept = studentDept;
		 stuLevel = studentLevel;
		 crsDept = courseDept;
		 crsNum = courseNumber;
		 GPA = GPA_Array;
		
	}
	
	
	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	public int yearsFromGraduation(String level) {
		int yearsFromGrad = 0;
		
		if(level.equals("Senior")) {
			yearsFromGrad = 0;
		}
		if(level.equals("Junior")) {
			yearsFromGrad = 1;
		}
		if(level.equals("Sophomore")) {
			yearsFromGrad = 2;
		}
		if(level.equals("Freshman")) {
			yearsFromGrad = 3;
		}
		
		return yearsFromGrad;
		
	}

	// Calculate the GPA for a particular student.
	private double GPA_Cal(double[][] GPA_Array) {
		double gpa = 0;
		double sum = 0;
		double credits = 0;
		int length = GPA_Array.length;
		for(int i=0; i<length; i++) {
			for(int j=0; j<2; j++) {
				if(j==0) {
					sum += GPA_Array[i][j];
				}
				else {
					credits += GPA_Array[i][j];
				}
			}
		}
		gpa = (sum * credits)/credits;
		return gpa;
	}

	// Getters for a student’s name and department, and the department and number of a course
	public String getName() {
		return stuName;
	}
	
	public String getStuDept() {
		return stuDept;
	}
	
	public String getCrsDept() {
		return crsDept;
	}
	
	public int getNum() {
		return crsNum;
	}
}
