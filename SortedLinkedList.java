
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * This class contains functions used to sort integer arrays into linked lists.
 *
 * @author Joshua Gabel
 * @version 1.0.0
 * @since 9/23/2022
 */
public class SortedLinkedList {

    /**
     * Main function
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] numbers = {2, 45, 37, 21, 31, 50, 29, 22, 67, 88, 56};
        System.out.println("Example 1 (hard-coded):");
        System.out.println(Arrays.toString(numbers) + " sorted into linked list:");
        LinkedList<Integer> sorted = sortedLinkedList(numbers);
        System.out.println(sorted);
        System.out.println();

        int[] numbersTwo = {5, 4, 3, 2, 1};
        System.out.println("Example 2 (hard-coded):");
        System.out.println(Arrays.toString(numbersTwo) + " sorted into linked list:");
        LinkedList<Integer> sortedTwo = sortedLinkedList(numbersTwo);
        System.out.println(sortedTwo);
        System.out.println();

        System.out.println("Example 3 (user input):");
        int[] numbersThree = getUserInputArray();
        System.out.println(Arrays.toString(numbersThree) + " sorted into linked list:");
        LinkedList<Integer> sortedThree = sortedLinkedList(numbersThree);
        System.out.println(sortedThree);

    }

    /**
     * This method prompts user for and returns an array of integers.
     *
     * @return, an array of integers
     */
    public static int[] getUserInputArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of integers: ");
        // prompt for length of array
        int numberOfInts = in.nextInt();
        int[] numbers = new int[numberOfInts];

        // prompt for each integer and store in array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter integer: ");
            int add = in.nextInt();
            numbers[i] = add;
        }
        return numbers;
    }

    /**
     * This method receives an integer array as input and iterates through the
     * array adding each element to a linked list in ascending order and
     * returning the result.
     *
     * @param numbers, an array of integers.
     * @return, a sorted LinkedList consisting of integers from numbers
     */
    public static LinkedList<Integer> sortedLinkedList(int[] numbers) {
        LinkedList<Integer> solution = new LinkedList<>();
        // iterate input array
        for (int i = 0; i < numbers.length; i++) {
            // if this is the first number, simply add it to the linked list.
            if (i == 0) {
                solution.add(numbers[i]);
            } else {
                ListIterator<Integer> it = solution.listIterator();
                // iterate linked list
                while (it.hasNext()) {
                    int check = it.next();
                    // if next number is larger than number being inserted
                    if (check > numbers[i]) {
                        // insert after the previous number
                        it.previous();
                        it.add(numbers[i]);
                        break;
                    }
                }
                // if a larger number has not been found, add current number to the end of LL
                if (!it.hasNext()) {
                    solution.add(numbers[i]);
                }

            }
        }
        return solution;
    }

}
