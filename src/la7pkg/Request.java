package la7pkg;

public class Request<T> implements Comparable<T> {

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Constructor
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_Array) {
		
	}
	
	
	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	public int yearsFromGraduation(String level) {
		return 0;
		
	}

	// Calculate the GPA for a particular student.
	private double GPA_Cal(double[][] GPA_Array) {
		return 0;
		
	}

	// Getters for a student’s name and department, and the department and number of a course
}
