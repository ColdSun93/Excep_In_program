package hw_3;

import java.math.BigInteger;

public class People {

    private String name;
    private String surname;
    private String patronymic;
    private BigInteger phone;
    

    protected People(String name, String surname, String patronymic, BigInteger phone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
    }


    public People() {
    }


    @Override
    public String toString() {
        return String.format("People [name=" + name + ", surname=" + surname + ", patronymic=" + patronymic + ", phone=  " + phone
                + "]");
    }


}
