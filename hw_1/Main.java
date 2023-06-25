package hw_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] arrOne = { -5, 4, 2, 6 };
        int[] arrTwo = { -2, 1, 2, 2 };
        int a = 0;
        Scanner scan = new Scanner(System.in);
        // Method1(a);
        // Method2(scan);
        // Method3(arrOne, a);
        // int[] arrThree = Method4(arrOne, arrTwo);
        double[] arrThree = Method5(arrOne, arrTwo);
        
        PrintArr(arrThree);

    }

    static void Method1(int b) {
        int a = 5 / b; // для вызова ArithmeticException
    }

    static void Method2(Scanner scan) {
        int a = scan.nextInt(); // для вызова InputMismatchException ввести символ
    }

    static void Method3(int[] arr, int b) {
        arr[b - 1] = 4; // для вызова ArrayIndexOutOfBoundsException
    }

    static int[] Method4(int[] arrOne, int[] arrTwo) {
        int[] arrResult;
        if (arrOne.length == arrTwo.length && arrOne.length != 0) {
            arrResult = new int[arrTwo.length];
            for (int i = 0; i < arrResult.length; i++) {
                arrResult[i] = arrOne[i] - arrTwo[i];
            }
            System.out.println();
            return arrResult;

        } else if (arrOne.length == 0) {
            System.out.println("Массивов имеед нулевую длину");
            arrResult = null;
            return arrResult;
        } else {
            System.out.println("Длина массивов не равны");
            arrResult = null;
            return arrResult;
        }
    }

    static double[] Method5(int[] arrOne, int[] arrTwo){
        double[] arrResult;
        if (arrOne.length == arrTwo.length && arrOne.length != 0) {
            arrResult = new double[arrTwo.length];
            for (int i = 0; i < arrResult.length; i++) {
                if (arrTwo[i] == 0) {
                    throw new RuntimeException("Деление на ноль");
                } else {
                    arrResult[i] = arrOne[i] / arrTwo[i];
                }
            }
            System.out.println();
            return arrResult;

        } else if (arrOne.length == 0) {
            throw new RuntimeException("Массивов имеед нулевую длину");
        } else {
            throw new RuntimeException("Длина массивов не равны");
        }
    }

    static void PrintArr(double[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%f \t", arr[i]);
            }
        }
    }

}