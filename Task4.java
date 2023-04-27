import java.util.*;

public class Task4 {


		private String user_name;
		private String pass_word;
		private boolean is_LoggedIn;
		private int time_Remaining;
		private int question_Count;
		private int[] user_Answers;
		private int[] correct_Answers;

		public Task4(String username, String password) {
			this.user_name = username;
			this.pass_word = password;
			System.out.println("Sucessfully You are registered!  :)");
			this.is_LoggedIn = false;
			this.time_Remaining = 10; // in minutes
			this.question_Count = 10;
			this.user_Answers = new int[question_Count];
			this.correct_Answers = new int[question_Count];
			// initialize correct answers with random values (0 or 1)
			for (int i = 0; i < question_Count; i++) {
				correct_Answers[i] = (int) Math.round(Math.random());
			}
		}

		public void logout() {
			is_LoggedIn = false;
			System.out.println("Logout successful.");
		}
         
		

		
         
		public void submitExam() {
			if (!is_LoggedIn) {
				System.out.println("Please login first.");
				return;
			}
			int score = 0;
			for (int i = 0; i < question_Count; i++) {
				if (user_Answers[i] == correct_Answers[i]) {
					score++;
				}
			}
			System.out.println("Your score is " + score + " out of " + question_Count + ".");
			System.out.println("Best of luck :)");
			logout();
		}
		
		public void login() {
			System.out.println("Log in to give the Exam ");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Username: ");
			String inputUsername = scanner.nextLine();
			System.out.print("Password: ");
			String inputPassword = scanner.nextLine();
			if (inputUsername.equals(user_name) && inputPassword.equals(pass_word)) {
				is_LoggedIn = true;
				System.out.println("Login successful Best of Luck Dear");
			} else {
				System.out.println("Login failed. Please try again.");
			}
		}
		public void startExam() {
			if (!is_LoggedIn) {
				System.out.println("Please login first.");
				return;
			}
			Scanner scanner = new Scanner(System.in);
			System.out.println("You have " + time_Remaining + " minutes to complete the exam.");
			for (int i = 0; i < question_Count; i++) {
				System.out.println("Question " + (i + 1) + ":");
				System.out.println("1. Option 1");
				System.out.println("2. Option 2");
				System.out.print("Your answer (1 or 2): ");
				int answer = scanner.nextInt();
				user_Answers[i] = answer;
			}

			System.out.println("Would you like to submit? \n1:Yes \n2:NO ");
			int n = scanner.nextInt();
			if (n == 1) {
				submitExam();
			} else {
				// auto-submit exam when time is up
				try {
					Thread.sleep(time_Remaining * 10 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					submitExam();
				}

			}

		}

		

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your username and password");
			String userName = sc.nextLine();
			String passWord = sc.nextLine();
			Task4 exam_System = new Task4(userName, passWord);
			exam_System.login();
			exam_System.startExam();
		}
	}

