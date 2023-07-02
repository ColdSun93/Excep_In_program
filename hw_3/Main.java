package hw_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        ListPeople listPeople = new ListPeople();
        System.out.println("Введите данные: фамилия, имя, отчество и номер телефона");
        System.out.println("ФИО - строки, номертелефона - целое беззнаковое число без форматирования");
        System.out.println("Ввод всех элементов через пробел");
        String input_str;
        String path = "/Users/ColdSun/Documents/Exceptions_In_programming/hw_3/";
        int keyExc;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                input_str = reader.readLine();
                keyExc = codeException(input_str);

                if (keyExc == -1) {
                    throw new IllegalArgumentException(String.format("Код ошибки: " + keyExc + " введена пустая строка"));
                } else if (keyExc == -2) {
                    throw new IllegalArgumentException(
                            String.format("Код ошибки: " + keyExc + " введены не все исходные данные"));
                } else if (keyExc == -3) {
                    throw new IllegalArgumentException(
                            String.format("Код ошибки: " + keyExc + " избыточное количество введенной информации"));
                } else {
                    listPeople.addPerson(parserStr(input_str));
                }
                int keyMenu = menuUser(reader);
                if (keyMenu==2) {
                    listPeople.showListPeople();
                    break;
                } else if (keyMenu==3) {
                    listPeople.storeListPeople(path);
                    break;
                } else if (keyMenu==4) {
                    break;
                }
                System.out.println("Введите данные: фамилия, имя, отчество и номер телефона");
            }


        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (MissingFormatArgumentException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (RuntimeException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка сохранения: " + e);
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e);
        } catch (Throwable e) {
            System.out.println("Что-то пошло не так... " + e);
        }

    }

    private static People parserStr(String input_str) {
        boolean allLetters;
        String[] words = input_str.split(" ");

        try {
            BigInteger phone = new BigInteger(words[3]);

            for (int index = 0; index < 4; index++) {
                if ((words[index] == null || words[index].isEmpty()) && index == 0) {
                    throw new ArrayIndexOutOfBoundsException("Не введена фамилия");
                } else if ((words[index] == null || words[index].isEmpty()) && index == 1) {
                    throw new ArrayIndexOutOfBoundsException("Не введено имя");
                } else if ((words[index] == null || words[index].isEmpty()) && index == 2) {
                    throw new ArrayIndexOutOfBoundsException("Не введено отчество");
                } else if ((words[index] == null || words[index].isEmpty()) && index == 3) {
                    throw new ArrayIndexOutOfBoundsException("Не введен номер телефона");
                }

                allLetters = words[index].chars().allMatch(Character::isLetter);
                if (!allLetters && index < 3) {
                    throw new ClassCastException("Использованы цифры, спец. символы или кириллица при вводе ФИО");

                }

            }
            People peopleArr = new People(words[0], words[1], words[2], phone);
            return peopleArr;
        }

        catch (NumberFormatException e) {
            throw new NumberFormatException("Неверно указан телефон");
        }

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


        return 0;

    }

    private static int menuUser(BufferedReader reader) {
        System.out.println("Продолжить ввод - 1");
        System.out.println("Завешить и показать пользователей на экране  - 2");
        System.out.println("Записать в файлы - 3");
        System.out.println("Выход - 4");
        String key;

        try {
            key = reader.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Введен неверный ключ выбора");
        }

        switch (key) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            default:
                throw new ClassCastException("Введен неверный ключ");
        }

    }

    



}
