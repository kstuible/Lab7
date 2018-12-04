package la7pkg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
		LinkedList<Course> courses = new LinkedList<Course>();
		BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
		BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
		IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
		control.readCourseFile();
		control.readRequestFile();
		control.processRequests();
		control.printClassList();

		// testing -- delete later
		//courses.get(0).addStudent("Buck");
		//courses.get(0).printClassList();
		//System.out.println(control.getCourse("CS", 1060).courseNum);
		//System.out.print(courses.get(0).courseNum);
	}

}

