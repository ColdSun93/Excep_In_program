package hw_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Method1(scan);
        Method2();
        Method3();
        Method4(scan);

    }

    static void Method1(Scanner scan) {
        double a = getNumDoubleByUser("Введите дробное число", scan);
        System.out.println(a);
    }

    public static double getNumDoubleByUser(String text, Scanner input) {

        System.out.println(text);
        double a = 0;
        boolean flag = true;

        while (flag) {
            if (input.hasNextDouble()) {
                a = input.nextDouble();
                flag = false;
            } else {
                System.out.println("Некорректный формат данных, повторите ввод ");
                input.nextLine();
            }
        }
        return a;
    }

    static void Method2() {
        int d = 2; // изменено с "0"
        int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 6 }; // объявлен массив размером 9 и c элементами типа int
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    static void Method3() throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NumberFormatException ex) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Задано значение индекса массива, не принадлежащее допустимому диапазону");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    static void Method4(Scanner scan) {
        System.out.println("Введите данные");
        String a;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = reader.readLine();

            if (a == null || a.isEmpty()) {
                throw new RuntimeException("Введена пустая строка");
            }
        } catch (Exception e) {
            System.out.println("Пустые строки вводить нельзя, Исключение: " + e);
        }

    }

}
