package la7pkg;

public class Request implements Comparable<Request> {

	String stuName;
	String stuDept;
	String stuLevel;
	String crsDept;
	int crsNum;
	double[][] GPA;
	double calcGPA;
	int yearsFromGrad;
	
	/**
	 * Compares the current request object to the student department and the course
	 *  department, the students level with how many years from graduation, and
	 *  finally the GPA. Returns '1' if the request object has priority and a '-1'
	 *  if it does not.
	 * 
	 * @param o   Request object
	 */
	@Override
	public int compareTo(Request o) {
		int comp = 0;
		if((this.crsDept.equals(this.stuDept)) && (!o.crsDept.equals(o.stuDept))) {
			return 1;
		} else if((!this.crsDept.equals(this.stuDept)) && (o.crsDept.equals(o.stuDept))) {
			return -1;
		} else if ((this.yearsFromGraduation(this.stuLevel)) < (o.yearsFromGraduation(o.stuLevel))){
			return 1;
		} else if ((this.yearsFromGraduation(this.stuLevel)) >= (o.yearsFromGraduation(o.stuLevel))){
			return -1;
		} else if ((this.calcGPA) > (o.calcGPA)) {
			return 1;
		} else if ((this.calcGPA) <= (o.calcGPA)) {
			return -1;
		} else {
			return 0;
		}
		
	}

	
	/**
	 * Constructor for Request object
	 * 
	 * @param studentName   name
	 * @param studentDept   student department
	 * @param studentLevel   student level
	 * @param courseDept    course department
	 * @param courseNumber   course number
	 * @param GPA_Array   array of one students GPAs
	 */
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber, double[][] GPA_Array) {
		
		 stuName = studentName;
		 stuDept = studentDept;
		 stuLevel = studentLevel;
		 crsDept = courseDept;
		 crsNum = courseNumber;
		 GPA = GPA_Array;
		 calcGPA = GPA_Cal(GPA_Array);
		
	}
	
	
	/**
	 * Compares the given string 'level' to each of the four rankings,
	 * then assigns an integer (ie. '0' is closest to graduation)
	 * 
	 * @param level   rank in school
	 * @return yearsFromGrad  int 0-3
	 */
	public int yearsFromGraduation(String level) {
		
		if(level.equals("Senior") || level.equals(" Senior")) {
			yearsFromGrad = 0;
		}
		else if(level.equals("Junior") || level.equals(" Junior")) {
			yearsFromGrad = 1;
		}
		else if(level.equals("Sophomore") || level.equals(" Sophomore")) {
			yearsFromGrad = 2;
		}
		else //(level.equals("Freshman") || level.equals(" Freshman")) 
		{
			yearsFromGrad = 3;
		}
		
		return yearsFromGrad;
		
	}

	/**
	 * Given is a 2d array for a single student, with the following 
	 * information: {GPA in course, number of credits} we use nested
	 * for loops to sum up the GPAs and the number of credits to
	 * calculate the average.
	 * 
	 * @param GPA_Array   one students array of GPAs
	 * @return gpa   average of one students GPAs    
	 */
	private double GPA_Cal(double[][] GPA_Array) {
		double gpa = 0;
		double sum = 0;
		double credits = 0;
		double value = 0;
		int row = GPA_Array.length;
		int col = GPA_Array[0].length;
		double[] gpaArr = new double[col];
		double[] creditsArr = new double[col];
	
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				
				gpaArr[j] = GPA_Array[0][j];
				creditsArr[j] = GPA_Array[1][j];
				
				sum += gpaArr[j];
				credits += creditsArr[j];
			}
		}
		for(int k = 0; k<col;k++) {
			value += (gpaArr[k] * creditsArr[k]);
		}
		sum= sum/2;credits= credits/2;
		gpa = (value)/credits;
		
		return gpa;
	}

	// Getters for a students name and department, and the department and number of a course
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
