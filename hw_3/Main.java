package hw_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        System.out.println("Введите данные: фамилия, имя, отчество и номер телефона");
        System.out.println("ФИО - строки, номертелефона - целое беззнаковое число без форматирования");
        System.out.println("Ввод всех элементов через пробел");
        String input_str;
        int keyExc;
        // parserStr("ав1пр апрапр апр3апр 898339j23329");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                input_str = reader.readLine();
                keyExc = codeException(input_str);

                if (keyExc == -1) {
                    throw new RuntimeException("Введена пустая строка");
                } else if (keyExc == -2) {
                    throw new RuntimeException("Введены не все данные");
                } else if (keyExc == -3) {
                    throw new RuntimeException("Введены избыточные данные");
                } else {
                    parserStr(input_str);
                }
            }

        } catch (ClassCastException e) {
            System.out.println("Неверный ввод1: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод2: " + e);
        } catch (MissingFormatArgumentException e) {
            System.out.println("Неверный вывод3: " + e);
        } catch (RuntimeException e) {
            System.out.println("Неверный ввод3: " + e);
        } catch (Exception e) {
            System.out.println("Неверный ввод4: " + e);
        }

    }

    private static void parserStr(String input_str) {
        // ArrayList<People> peopleArr = new ArrayList<>();
        // People peopleArr = new People();

        boolean allLetters;
        String[] words = input_str.split(" ");
        BigInteger phone = new BigInteger(words[3]);
        for (int index = 0; index < 3; index++) {
            allLetters = words[index].chars().allMatch(Character::isLetter);
            if (allLetters) {

            } else {
                throw new ClassCastException("Использованы цифры или спец. символы при вводе ФИО");
            }
        }
        People peopleArr = new People(words[0], words[1], words[2], phone);

        System.out.println(peopleArr.toString());


    }

    static int codeException(String input_str) {
        Pattern pattern = Pattern.compile(" ");
        Matcher matcher = pattern.matcher(input_str);
        int spaceCount = 0;
        while (matcher.find()) {
            spaceCount++;
        }
        System.out.println(spaceCount);
        if (input_str == null || input_str.isEmpty()) {
            return -1;
        } else if (spaceCount < 3) {
            return -2;
        } else if (spaceCount > 3) {
            return -3;
        }
        // assertThat(spaceCount).isEqualTo(EXPECTED_COUNT);

        return 0;

    }

}
