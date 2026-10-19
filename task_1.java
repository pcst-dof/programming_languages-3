import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество элементов в массиве: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<Integer> oddPositions = new ArrayList<>();
        ArrayList<Integer> evenPositions = new ArrayList<>();

        for (int i = 0; i < n; i += 2) {
            oddPositions.add(arr[i]);
        }

        for (int i = 1; i < n; i += 2) {
            evenPositions.add(arr[i]);
        }

        Collections.sort(oddPositions);
        Collections.sort(evenPositions);

        System.out.println("Результат:");
        
        for (int val : oddPositions) {
            System.out.print(val + " ");
        }

        for (int i = evenPositions.size() - 1; i >= 0; i--) {
            System.out.print(evenPositions.get(i) + " ");
        }
        
        System.out.println();
        scanner.close();
    }
}