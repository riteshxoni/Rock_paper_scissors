import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Rock_paper_scissors {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("########################### Rock, Paper, Scissors ###########################");
        System.out.print("Loading");
        for (int i = 0; i < 70; i++) {
            System.out.print("#");
            Thread.sleep(100);
        }
        while (true) {
            System.out.print("\n1. > Play\n2. > Exit\nChoice : ");
            Scanner sc = new Scanner(System.in);
            try {
                int ch = sc.nextInt();
                if (ch == 1) {
                    Game g = new Game();
                    g.play();
                } else {
                    System.out.println("Thankyou for playing....");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice...");
                break;
            }
        }
    }
}

class Game {
    String elements[] = { "rock", "paper", "scissors" };
    String user;
    int cScore, uScore, com;

    void getdata() {
        Scanner sc = new Scanner(System.in);

        System.out.print("> Rock\n> Paper\n> Scissors\nEnter Your Choice : ");
        user = sc.nextLine();

        if (!user.equalsIgnoreCase(elements[0]) && !user.equalsIgnoreCase(elements[1])
                && !user.equalsIgnoreCase(elements[2])) {
            System.out.println("Invalid Choice.....");
            getdata();
        }
    }

    void play() {
        for (int i = 1; i <= 4; i++) {
            if (i == 4) {
                System.out.println("Round " + i);
                System.out.println("Computer Score : " + cScore + " User Score : " + uScore);
                break;
            }

            getdata();
            Random ran = new Random();
            com = ran.nextInt(3);

            System.out.println("Computer Choice = " + elements[com]);

            if (user.equalsIgnoreCase(elements[com])) {
                System.out.println("Round " + i + " is Draw...");
                uScore++;
                cScore++;
            } else if (user.equalsIgnoreCase("scissors") && com == 0 || user.equalsIgnoreCase("rock") && com == 1
                    || user.equalsIgnoreCase("paper") && com == 2) {
                System.out.println("You loose " + i + " round");
                cScore++;
            } else {
                System.out.println("You win " + i + " round");
                uScore++;
            }
        }
        if (uScore > cScore) {
            System.out.println("You Win this game....");
        } else if (cScore == uScore) {
            System.out.println("Game is Draw...");
        } else {
            System.out.println("You loose this game...\nTry again...");
        }
    }

}