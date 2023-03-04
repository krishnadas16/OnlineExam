import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Exam {
    // Sample login credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    private static Scanner scanner = new Scanner(System.in);
    private static Timer timer = new Timer();

    private static String username;
    private static String password;

    public static void main(String[] args) {
        // Login screen
        System.out.println("Welcome to the online exam system.");
        System.out.print("Please enter your username: ");
        username = scanner.nextLine();
        System.out.print("Please enter your password: ");
        password = scanner.nextLine();
        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            System.out.println("Invalid login credentials. Exiting program.");
            return;
        }


        // Exam screen

        System.out.println("Welcome, " + username + "!");
        System.out.println("You have 10 minutes to complete the exam.");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                submitExam();
            }
        }, 60 * 100000); // 10 minutes in milliseconds

        // Exam questions

            // Define the question and answer
        String[] questions = {"What is the capital of France?",
                "What is the tallest mountain in the world?",
                "Who wrote the novel 'Pride and Prejudice?",
                "which year of ww1 Germany declared war on France?",
                "ICAO stands for?",
                "When is International Mother Language Day celebrated?",
                "Name the Father of the Indian Constitution?",
                "Who was the first Prime Minister of India?",
                "Name the deepest ocean in the world?", "How many States and Union Territories are there in India?"};
        String[] answer = {"Paris",
                "Mount Everest",
                "Jane Austen" ,
                "1914",
                "International Civil Aviation Organization",
                "21 February",
                "Dr. B. R. Ambedkar",
                "Jawaharlal Nehru",
                "Pacific Ocean","28 States and 8 Union Territories"};

        // Loop through each question and ask the user for an answer
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();

            // Check if the user's answer is correct
            if (userAnswer.equalsIgnoreCase(answer[i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + answer);
            }
        }

        // Submit exam
        submitExam();
    }

    private static void submitExam() {
        timer.cancel();
        System.out.println("Submitting exam...");
        // Code to save exam results and display score
        System.out.println("Thank you for taking the exam!");
    }
}


