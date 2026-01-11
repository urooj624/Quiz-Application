package project;

import java.util.Scanner;

// Class to store each question
class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer; // 1-based index
    }

    public void display() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}

// Quiz class
class Quiz {
    Question[] questions;
    int score = 0;

    public Quiz(Question[] questions) {
        this.questions = questions;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- QUIZ START -----");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions[i].display();
            System.out.print("Your answer (1-4): ");
            int userAnswer = sc.nextInt();

            if (questions[i].checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n----- QUIZ COMPLETED -----");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }


// MAIN CLASS
 
    public static void main(String[] args) {

        // Create questions
        Question q1 = new Question(
                "What is the capital of Pakistan?",
                new String[]{"Islamabad", "Karachi", "Lahore", "Quetta"},
                1
        );

        Question q2 = new Question(
                "Which is the largest planet in our solar system?",
                new String[]{"Earth", "Mars", "Jupiter", "Saturn"},
                3
        );

        Question q3 = new Question(
                "Who is known as the Father of Computers?",
                new String[]{"Charles Babbage", "Newton", "Einstein", "Edison"},
                1
        );

        // Add questions in array
        Question[] questions = {q1, q2, q3};

        // Create quiz
        Quiz quiz = new Quiz(questions);

        // Start quiz
        quiz.start();
    }
}
