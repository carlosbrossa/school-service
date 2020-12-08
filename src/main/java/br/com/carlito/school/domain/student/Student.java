package br.com.carlito.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private Cpf cpf;
    private String name;
    private Email email;

    public Student(Cpf cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    private List<Phone> phones = new ArrayList<>();

    public void addPhone(String ddd, String number){
        this.phones.add(new Phone(ddd, number));
    }
}
