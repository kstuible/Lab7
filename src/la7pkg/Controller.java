package la7pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controller implements IController {

	PriorityQueue<Request> requestQueue0;
	LinkedList<Course> courses0;;
	BufferedReader fileIn0;
	BufferedReader fileIn10;
	
	// constructor
	public Controller(PriorityQueue<Request> requestQueue, LinkedList<Course> courses,
			BufferedReader fileIn, BufferedReader fileIn1) {
		requestQueue0 = requestQueue;
		courses0 = courses;
		fileIn0 = fileIn;
		fileIn10 = fileIn1;
		
		
	}
	
	// Read courses from input file and add each course to a LinkedList of courses. Close file.
	// use try/catch
	@Override
	public void readCourseFile() {
		try {
			LinkedList<String> crsString = new LinkedList<>();
			String line = "";
			while((line =fileIn0.readLine()) != null) {
				crsString.add(line);
			}
			
			//LinkedList<Course> courses = new LinkedList<>();
			
			for(int i = 0; i < crsString.size(); i++) {
				String crsLine = crsString.get(i);
				String[] crsArr = crsLine.split(",");
				Course nuCourse = new Course(crsArr[0], Integer.parseInt(crsArr[1]), Integer.parseInt(crsArr[2]));
				
				courses0.add(nuCourse);
				
				// testing object contents
				// System.out.println(courses.get(i).courseNum);
			}

			
			fileIn0.close();
		}
		catch(IOException e) {
			System.out.println("IO Exception Caught: " + e.getMessage());
		}
		
	}

	// Read each request from the request input file and use it to create a Request object.
	// use try/catch
	@Override
	public void readRequestFile() {
		try {
			// reads the file to strings and converts
			LinkedList<String> requests = new LinkedList<>();
			String line = "";
			while((line =fileIn10.readLine()) != null) {
				requests.add(line);
			}
			
			 LinkedList<Request> reqs = new LinkedList<>(); 
			
			// builds linkedList of request objects
			for(int i = 0; i < requests.size(); i++) {
				String reqLine = requests.get(i);
				String[] lineArr = reqLine.split(",");
				double grades[][] = {{3.0, 3},{2.0, 2}};
				int crsNum = Integer.parseInt(lineArr[4]);
				
				Request nuReq = new Request(lineArr[0], lineArr[1], lineArr[2],
				 lineArr[3], crsNum, grades);
				reqs.add(nuReq);
				
				// test contents
				// System.out.print(reqs.get(i).stuName + " ");
				// System.out.println(reqs.get(i).crsDept);

			}
			
			fileIn10.close();

		}
		catch(IOException e) {
			System.out.println("IO Exception Caught: " + e.getMessage());
		}
		
	}

	// Store the request object in the requests priority queue.
	@Override
	public void addRequest(Request req) {

		
	}

	// Process all the requests as follows: if request can be granted, update the relevant classlist, 
	// update the class/course capacity, print out a message that the student who made that 
	// request has been successfully registered for that course. Else, print out a message that 
	// student could not be registered.
	@Override
	public void processRequests() {

		
	}

	// Return the course object with data values that match the parameters received.
	@Override
	public Course getCourse(String courseDept, int courseNumber) {
		Course match = null;
		for(int i = 0; i < courses0.size(); i++) {
			if(courses0.get(i).dept.equals(courseDept) && courses0.get(i).courseNum == courseNumber) {
				match = courses0.get(i);
			}
		}
		
		return match;
	}

	// Print class lists for all courses.
	@Override
	public void printClassList() {

		
	}

}
