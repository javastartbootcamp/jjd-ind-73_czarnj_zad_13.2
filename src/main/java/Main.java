import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        boolean isNumberNegative = false;
        while (!isNumberNegative) {
            try {
                System.out.println("Wprowadź liczbę:");
                int number = scanner.nextInt();
                if (number < 0) {
                    isNumberNegative = true;
                } else {
                    numbers.add(number);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Musisz wprowadzić liczbę całkowitą");
                break;
            }
        }
        if (numbers.size() > 0) {
            showRevertedSequence(numbers);
            showSum(numbers);
            showMaxAndMinValue(numbers);
        } else {
            System.out.println("Lista jest pusta");
        }

    }

    public void showRevertedSequence(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            builder.append(numbers.get(i));
            if (i > 0) {
                builder.append(", ");
            }
        }
        System.out.println(builder);
    }

    public void showSum(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
            builder.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                builder.append(" + ");
            }
        }
        builder.append(" = ").append(sum);
        System.out.println(builder);
    }

    public void showMaxAndMinValue(List<Integer> numbers) {
        int min = numbers.get(0);
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            } else if (number > max) {
                max = number;
            }
        }
        System.out.printf("Najmniejsza liczba w liście to %d%n", min);
        System.out.printf("Największa liczba w liście to %d%n", max);
    }
}
