package la7pkg;

public class Course<E> implements ICourse {

	String dept;
	int courseNum;
	int cap;
	int stuInCourse;
	String stuName;
	
	//LinkedList<E> stu1040 = new LinkedList<E>();
	//LinkedList<E> stu1060 = new LinkedList<E>();
	
	@Override
	public boolean isFull() {

		if(stuInCourse < cap) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void addStudent(String name) {
		
		
	}

	@Override
	public void printClassList() {
		
		
	}

}
