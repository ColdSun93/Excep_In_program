package hw_2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // int[] arrOne = { -5, 4, 2, 6 };
        // int[] arrTwo = { -2, 1, 2 };
        // int a = 0;
        Scanner scan = new Scanner(System.in);
        // Method1(scan);
        Method2();

        // System.out.println();

    }

    static void Method1(Scanner scan) {
        double a = getNumDoubleByUser("Введите дробное число", scan);
        System.out.println(a);
    }

    static void Method2()  {
        int d = 2;  // изменено с "0"
        int[] intArray = {1,2,3,4,5,6,7,8,6};  // объявлен массив размером и элементами 
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Catching exception: " + e);
        } catch (NumberFormatException e){
            System.out.println("Catching exception: " + e);
        } 


    }

    // static void Method3() throws Exception {
    //     try {
    //         int a = 90;
    //         int b = 3;
    //         System.out.println(a / b);
    //         printSum(23, 234);
    //         int[] abc = { 1, 2 };
    //         abc[3] = 9;
    //     } catch (Throwable ex) {
    //         System.out.println("Что-то пошло не так...");
    //     } catch (NullPointerException ex) {
    //         System.out.println("Указатель не может указывать на null!");
    //     } catch (IndexOutOfBoundsException ex) {
    //         System.out.println("Массив выходит за пределы своего размера!");
    //     }
    // }

    // public static void printSum(Integer a, Integer b) throws FileNotFoundException {
    //     System.out.println(a + b);
    // }

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

}
