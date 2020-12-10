package br.com.carlito.school.domain.student;

public class StudenNotFound extends Throwable {
    public StudenNotFound(Cpf cpf) {
        super("Student not found with CPF: " + cpf.getNumber());
    }
}



