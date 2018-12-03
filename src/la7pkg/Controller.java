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
			LinkedList<String> courses = new LinkedList<>();
			String line = "";
			while((line =fileIn0.readLine()) != null) {
				courses.add(line);
			}
			
			// testing input and contents
			System.out.println(courses.get(0));
			System.out.println(courses.get(1));
			
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

		
		return null;
	}

	// Print class lists for all courses.
	@Override
	public void printClassList() {

		
	}

}
