package oasisproject2;
import java.util.Scanner;
public class ExamSystem {
		private String[] questions = {"Question 1: What is 2+2?", "Question 2: What is the capital of France?", "Question 3: Who invented the telephone?"};
	    private String[] choices = {"a. 1\tb. 2\tc. 3\td. 4", "a. Rome\tb. Paris\tc. Berlin\td. Madrid", "a. Thomas Edison\tb. Alexander Graham Bell\tc. Isaac Newton\td. Benjamin Franklin"};
	    private char[] answers = {'d', 'b', 'b'};
	    private int score = 0;
	    private String username;
	    private String password;
	    private int timeLimit = 60; 
	    public void run() {
	        Scanner sc= new Scanner(System.in);
	        boolean quit = false;
	        System.out.print("Username: ");
	        username = sc.next();
	        System.out.print("Password: ");
	        password = sc.next();
	        while (!quit) {
	            System.out.println("1. Update Profile and Password");
	            System.out.println("2. Take Exam");
	            System.out.println("3. Quit");
	            System.out.print("Choose an option: ");
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    updateProfile();
	                    break;
	                case 2:
	                    takeExam();
	                    break;
	                case 3:
	                    quit = true;
	                    break;
	                default:
	                    System.out.println("Invalid option.");
	                    break;
	            }
	        }

	        System.out.println("Thank you for using this examination system!");
	    }
	    private void updateProfile() {
	        Scanner sc= new Scanner(System.in);
	        System.out.print("New username: ");
	        username = sc.next();
	        System.out.print("New password: ");
	        password = sc.next();
	        System.out.println("Profile and password updated successfully!");
	    }
	    private void takeExam() {
	        Scanner sc= new Scanner(System.in);
	        score = 0;
	        long startTime = System.currentTimeMillis();
	        long endTime = startTime + (timeLimit * 1000);
	        for (int i = 0; i < questions.length; i++) {
	            System.out.println(questions[i]);
	            System.out.println(choices[i]);
	            System.out.print("Enter your answer: ");
	            char answer = sc.next().charAt(0);
	            if (answer == answers[i]) {
	                System.out.println("Correct!");
	                score++;
	            } else {
	                System.out.println("Incorrect.");
	            }
	            long currentTime = System.currentTimeMillis();
	            if (currentTime > endTime) {
	                System.out.println("Time's up!");
	                break;
	            }
	        }
	        System.out.println("Your score is " + score + " out of " + questions.length);
	        System.out.println("Closing session...");
	        username = null;
	        password = null;
	    }
	    public static void main(String[] args) {
	    	ExamSystem examsys=new ExamSystem();
	    	examsys.run();
	    	examsys.updateProfile();
	    	examsys.takeExam();
	}

}
