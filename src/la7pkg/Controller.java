package la7pkg;

import java.io.BufferedReader;
import java.io.IOException;

public class Controller implements IController {

	PriorityQueue<Request> requestQueue0;
	LinkedList<Course> courses0;;
	BufferedReader fileIn0;
	BufferedReader fileIn10;
	LinkedList<Request> reqs = new LinkedList<>(); 
	LinkedList<Request> orderReqs = new LinkedList<>();

	
	// constructor
	public Controller(PriorityQueue<Request> requestQueue, LinkedList<Course> courses,
			BufferedReader fileIn, BufferedReader fileIn1) {
		requestQueue0 = requestQueue;
		courses0 = courses;
		fileIn0 = fileIn;
		fileIn10 = fileIn1;
		
		
	}
	
	/**
	 * Reads from the course text file by line, then splits the line by comma
	 * and creates a new course object.
	 */
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

	/**
	 * reads from the request text file by line, then splits and assigns values to
	 * a double grade array, a double credits array, and course number. Then creates
	 * new request object given the values from the file.
	 */
	@Override
	public void readRequestFile() {
		try {
			// reads the file to strings and converts
			LinkedList<String> requests = new LinkedList<>();
			String line = "";
			while((line =fileIn10.readLine()) != null) {
				requests.add(line);
			}
						
			// builds linkedList of request objects
			for(int i = 0; i < requests.size(); i++) {
				String reqLine = requests.get(i);
				String[] lineArr = reqLine.split(",");
				
				double[] gradeArr = {Double.parseDouble(lineArr[5]), Double.parseDouble(lineArr[7]),
						Double.parseDouble(lineArr[9]), Double.parseDouble(lineArr[11]) };
				double[] credArr = {Double.parseDouble(lineArr[6]), Double.parseDouble(lineArr[8]),
						Double.parseDouble(lineArr[10]), Double.parseDouble(lineArr[12]) };
	
				double grades[][] = {gradeArr, credArr};
				//double grades[][] = {{3.0, 3},{2.0, 2}};
				int crsNum = Integer.parseInt(lineArr[4]);
				
				Request nuReq = new Request(lineArr[0], lineArr[2], lineArr[1],
				 lineArr[3], crsNum, grades);
				reqs.add(nuReq);
				

			}
			
			fileIn10.close();

		}
		catch(IOException e) {
			System.out.println("IO Exception Caught: " + e.getMessage());
		}
		
	}

	/**
	 * Stores the request object in the requests priority queue.
	 * 
	 * @param req   request object
	 */
	@Override
	public void addRequest(Request req) {
		
			requestQueue0.enqueue(req);
		
	}

	// Process all the requests as follows: if request can be granted, update the relevant classlist, 
	// update the class/course capacity, print out a message that the student who made that 
	// request has been successfully registered for that course. Else, print out a message that 
	// student could not be registered.
	
	/**
	 * Based on the requests from the priority queue, add students to the course if there
	 * open spots.
	 */
	@Override
	public void processRequests() {
		
		// will have to change this for priority
		for(int i = 0; i < reqs.size(); i++) {
			
			addRequest(reqs.get(i));
			
		}
				
		System.out.println("<<<<<<<<<<<< Beginning of Queue Contents >>>>>>>>>>>>>>>>>");
		requestQueue0.Qprint();
		System.out.println("<<<<<<<<<<<< End of Queue Contents >>>>>>>>>>>>>>>>>\n");

		for(int j = 0; !requestQueue0.isEmpty(); j++) {
			Request reqRef = requestQueue0.dequeue();
			
			if(!getCourse(reqRef.getCrsDept(), reqRef.getNum()).isFull()) {
				getCourse(reqRef.getCrsDept(), reqRef.getNum()).addStudent(reqRef.getName());
				getCourse(reqRef.getCrsDept(), reqRef.getNum()).stuInCourse += 1;
				System.out.println(reqRef + " processed.");
				System.out.println(reqRef.getName() + " sucessfully registered " 
						+ reqRef.getCrsDept()+ " " + reqRef.getNum());
			}
			else {
				getCourse(reqRef.getCrsDept(), reqRef.getNum()).addStudent(reqRef.getName());
				System.out.println(reqRef + " processed.");
				System.out.println(reqRef.getName() + " cannot register for " 
						+ reqRef.getCrsDept()+ " " + reqRef.getNum());
			}
		}	
	}

	/**
	 * searches for and returns a course, given the department and course number.
	 * 
	 * @param courseDept   course department
	 * @param courseNumber   course number
	 * @return match    matched course
	 */
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

	/**
	 * Prints class lists for all courses.
	 */
	@Override
	public void printClassList() {
		for(int i = 0; i < courses0.size(); i++) {
			System.out.println("\nClass List for " + courses0.get(i).dept + " " + courses0.get(i).courseNum + ":");
			courses0.get(i).printClassList();
		}
		
	}

}
