import java.util.Scanner;

public class task_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество строк M: ");
        int m = scanner.nextInt();

        System.out.print("Количество столбцов N: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        for (int j = 0; j < n; j++) {
            int value = 5 * (j + 1); 
            for (int i = 0; i < m; i++) {
                matrix[i][j] = value;
            }
        }

        System.out.println("Матрица " + m + "x" + n + ":");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }

        scanner.close();
    }
}
