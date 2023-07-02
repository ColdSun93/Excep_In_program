package hw_3;

import java.math.BigInteger;

public class People {

    private String name;
    private String surname;
    private String patronymic;
    private BigInteger phone;

    protected People(String surname, String name, String patronymic, BigInteger phone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
    }

    public People() {
    }

    @Override
    public String toString() {
        return String.format("<" + surname + "><" + name + "><" + patronymic + "><" + phone + ">");
    }

    public String getSurname() {
        return surname;
    }

    public String toStringPrint() {
        return String.format("%-15s %-15s %-15s %-12d" , surname, name, patronymic, phone);
        //String.format("<" + surname + "><" + name + "><" + patronymic + "><" + phone + ">");
    }

}
