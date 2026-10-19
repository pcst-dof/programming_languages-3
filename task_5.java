import java.util.Scanner;

public class task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("ГЛАВНОЕ МЕНЮ");
            System.out.println("1. Выполнить расчёт");
            System.out.println("2. Информация о программе");
            System.out.println("3. Информация о разработчике");
            System.out.println("4. Выход");
            System.out.print("Выберите действие (1-4): ");
            
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    runCalculation(scanner);
                    break;
                case "2":
                    printProgramInfo();
                    break;
                case "3":
                    printDeveloperInfo();
                    break;
                case "4":
                    System.out.println("Пока!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ошибка: неверный выбор. Введите число от 1 до 4.");
            }
        }
        scanner.close();
    }


    private static void printProgramInfo() {
        System.out.println("Информация о программе");
        System.out.println("Программа вычисляет площадь треугольника по формуле Герона.");
        System.out.println("Формула: S = (p * (p - a) * (p - b) * (p - c))**0.5, где p = (a + b + c) / 2");
        System.out.println("Параметры передаются между методами через массивы.");
    }

    private static void printDeveloperInfo() {
        System.out.println("Информация о разработчике");
        System.out.println("Разработчик: Студентка группы РИ-250912");
        System.out.println("Год: 2026");
    }

    private static void runCalculation(Scanner scanner) {
        System.out.println("Вычисление площади треугольника по формуле Герона");
        System.out.println("(Подсказка: введите 'exit' вместо числа, чтобы вернуться в меню)");

        double[] sides = inputSides(scanner);
        if (sides == null) {
            System.out.println("Возврат в главное меню.");
            return;
        }

        String error = checkTriangle(sides);
        if (error != null) {
            System.out.println("Ошибка: " + error);
            System.out.println("Попробуйте запустить расчёт заново.");
            return;
        }

        double[] results = calculateArea(sides);

        printResult(sides, results);
    }

    private static double[] inputSides(Scanner scanner) {
        double[] sides = new double[3];
        String[] names = {"a", "b", "c"};

        for (int i = 0; i < 3; i++) {
            sides[i] = getValidSide(scanner, names[i]);
            if (Double.isNaN(sides[i])) {
                return null; 
            }
        }
        return sides;
    }

    private static String checkTriangle(double[] sides) {
        double a = sides[0], b = sides[1], c = sides[2];

        if (a <= 0 || b <= 0 || c <= 0) {
            return "Все стороны треугольника должны быть положительными числами!";
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Треугольник с такими сторонами не существует! Сумма любых двух сторон должна быть больше третьей.";
        }

        return null;
    }

    private static double[] calculateArea(double[] sides) {
        double a = sides[0], b = sides[1], c = sides[2];
        double[] results = new double[2];

        results[0] = (a + b + c) / 2; // полупериметр p
        results[1] = Math.sqrt(results[0] * (results[0] - a) * (results[0] - b) * (results[0] - c)); // площадь S

        return results;
    }

    private static void printResult(double[] sides, double[] results) {
        System.out.println();
        System.out.println("Стороны треугольника: a = " + sides[0] + ", b = " + sides[1] + ", c = " + sides[2]);
        System.out.println("Площадь треугольника S = " + results[1]);
        System.out.println();
    }


    private static double getValidSide(Scanner scanner, String sideName) {
        while (true) {
            System.out.print("Введите длину стороны " + sideName + ": ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                return Double.NaN;
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: это не число. Попробуйте еще раз.");
            }
        }
    }
}
