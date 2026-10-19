import java.util.Scanner;

public class task_3 {
    public static int[] createMaxArray(int[] a, int[] b) {
        int n = a.length;
        int[] c = new int[n];

        for (int k = 0; k < n; k++) {
            c[k] = Math.max(a[k], b[k]);
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Размер массивов A и B: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.println("Элементы массива A:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = new int[n];
        System.out.println("Элементы массива B:");
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int[] c = createMaxArray(a, b);

        System.out.println("Массив C (C[k] = max(A[k], B[k])):");
        for (int i = 0; i < n; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
