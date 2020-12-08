package br.com.carlito.school.domain.student;

public class StudentFactory {

    private Student student;

    public StudentFactory withNameCPFEmail(String cpf, String name, String email){
        this.student = new Student(new Cpf(cpf), name, new Email(email));
        return this;
    }

    public StudentFactory withPhone(String ddd, String number){
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create(){
        return this.student;
    }

}
