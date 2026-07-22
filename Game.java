package Game;

import java.util.*;

public class Game {

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private ArrayList<Score> scores = new ArrayList<>();

    public void start() {

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        Player player = new Player(name);

        int round = 1;
        boolean playAgain = true;

        while (playAgain) {

            int maxNumber = 100;
            int maxAttempts = 7;

            System.out.println("\n===== Difficulty =====");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            System.out.print("Choose: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

            int number = random.nextInt(maxNumber) + 1;

            int attempts = 0;

            boolean guessed = false;

            while (attempts < maxAttempts) {

                System.out.print("Guess Number (1-" + maxNumber + "): ");

                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {

                    System.out.println("Correct!");

                    guessed = true;

                    scores.add(new Score(round, attempts));

                    break;

                } else if (guess > number) {

                    System.out.println("Too High!");

                } else {

                    System.out.println("Too Low!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessed) {

                System.out.println("You Lost!");

                System.out.println("Correct Number: " + number);
            }

            System.out.print("Play Again? (yes/no): ");

            sc.nextLine();

            String ans = sc.nextLine();

            playAgain = ans.equalsIgnoreCase("yes");

            round++;
        }

        System.out.println("\n===== Score Summary =====");

        for (Score s : scores) {

            System.out.println(s);
        }

        System.out.println("Thank You " + player.getName());
    }
}