import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество элементов в массиве: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Массив пуст. Количество различных элементов: 0");
            scanner.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Элементы массива:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                count++;
            }
        }

        System.out.println("Количество различных элементов: " + count);

        scanner.close();
    }
}
