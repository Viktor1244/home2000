import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberListProcessor {

    private List<Integer> numbers;

    public NumberListProcessor() {
        this.numbers = new ArrayList<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void addNumbersFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers (type 'done' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                addNumber(number);
            } else {
                String input = scanner.next();
                if ("done".equalsIgnoreCase(input)) {
                    break;
                } else {
                    System.out.println("Invalid input, please enter a number or 'done' to finish.");
                }
            }
        }
    }

    public int sumOfEvenNumbers() {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> multiplyEachByTwo() {
        return numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    public OptionalInt findMaxNumber() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    public String getOddNumbersAsString() {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public OptionalDouble calculateAverage() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static void main(String[] args) {
        NumberListProcessor processor = new NumberListProcessor();
        processor.addNumbersFromInput();

        System.out.println("Sum of even numbers: " + processor.sumOfEvenNumbers());
        System.out.println("Numbers multiplied by 2: " + processor.multiplyEachByTwo());
        System.out.println("Maximum number: " + processor.findMaxNumber().orElse(Integer.MIN_VALUE));
        System.out.println("Odd numbers: " + processor.getOddNumbersAsString());
        System.out.println("Average of numbers: " + processor.calculateAverage().orElse(Double.NaN));
    }
}

