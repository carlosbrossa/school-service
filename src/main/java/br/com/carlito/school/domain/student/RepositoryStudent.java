package br.com.carlito.school.domain.student;

import java.util.List;

public interface RepositoryStudent {

    void enroll(Student student);

    Student findByCPF(Cpf cpf) throws StudenNotFound;

    List<Student> listAll();


}
