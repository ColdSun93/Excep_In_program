package hw_3;

import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class ListPeople {

    public static ArrayList<People> listPeople = new ArrayList<>();

    private int size() {
        return listPeople.size();
    }

    public void addPerson(String surname, String name, String patronymic, BigInteger phone) {
        ListPeople.listPeople.add(new People(surname, name, patronymic, phone));
    }

    void addPerson(People person) {
        ListPeople.listPeople.add(person);
    }

    void showListPeople() {
        int index = 0;
        System.out.printf("%-3s %-15s %-15s %-15s %-12s %n" , "N", "surname", "name", "patronymic", "phone");
        for (People person : listPeople) {
            System.out.printf("%-3d) ", index);
            System.out.println(person.toStringPrint());
            index++;
        }
    }

    public static void storeListPeople(String path) throws Exception{
        String pathFile;

        for (People person : listPeople) {
            pathFile = path + person.getSurname() + ".txt";
        try (FileWriter  wrFile  = new FileWriter (pathFile, true)) {
            wrFile.write(person.toString());
            wrFile.flush();
            wrFile.append('\n');
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    }
}
