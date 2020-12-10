package br.com.carlito.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private Cpf cpf;
    private String name;
    private Email email;
    private String pass;

    public Student(Cpf cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    private List<Phone> phones = new ArrayList<>();

    public String getCpf() {
        return cpf.getNumber();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void addPhone(String ddd, String number){
        this.phones.add(new Phone(ddd, number));
    }
}
