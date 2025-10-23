import java.util.Scanner;

// -------------------- Question 1 --------------------
class WordThread implements Runnable {
    String[] words;

    WordThread(String text) {
        words = text.split(" ");
    }

    public void run() {
        try {
            for (String word : words) {
                System.out.println("Word: " + word);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class VowelThread implements Runnable {
    String text;

    VowelThread(String text) {
        this.text = text;
    }

    public void run() {
        try {
            for (char ch : text.toCharArray()) {
                if ("AEIOUaeiou".indexOf(ch) != -1) {
                    System.out.println("Vowel: " + ch);
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

// -------------------- Question 2 --------------------
class EvenThread extends Thread {
    int[] numbers;

    EvenThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        try {
            for (int num : numbers) {
                if (num % 2 == 0) {
                    System.out.println("Even: " + num);
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class OddThread extends Thread {
    int[] numbers;

    OddThread(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        try {
            for (int num : numbers) {
                if (num % 2 != 0) {
                    System.out.println("Odd: " + num);
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

// -------------------- Question 3 --------------------
class TableThread extends Thread {
    int number;

    TableThread(int number) {
        this.number = number;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class DivisorThread implements Runnable {
    int number;

    DivisorThread(int number) {
        this.number = number;
    }

    public void run() {
        try {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.println("Divisor: " + i);
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

// -------------------- Main Program --------------------
public class AllQuestionsThreading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a question to execute:");
        System.out.println("1. Display words and vowels from a paragraph");
        System.out.println("2. Display even and odd numbers from an array");
        System.out.println("3. Display multiplication table and divisors");
        System.out.print("Enter choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter a paragraph: ");
                String paragraph = sc.nextLine();
                Thread wordThread = new Thread(new WordThread(paragraph));
                Thread vowelThread = new Thread(new VowelThread(paragraph));
                wordThread.start();
                vowelThread.start();
                break;

            case 2:
                int[] arr = new int[10];
                System.out.println("Enter 10 numbers:");
                for (int i = 0; i < 10; i++) {
                    arr[i] = sc.nextInt();
                }
                EvenThread even = new EvenThread(arr);
                OddThread odd = new OddThread(arr);
                even.start();
                odd.start();
                break;

            case 3:
                System.out.print("Enter a number: ");
                int num = sc.nextInt();
                TableThread table = new TableThread(num);
                Thread divisor = new Thread(new DivisorThread(num));
                table.start();
                divisor.start();
                break;

            default:
                System.out.println("Invalid choice!");
        }
        sc.close();
    }
}
