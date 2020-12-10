package br.com.carlito.school.infra.student;

import br.com.carlito.school.domain.student.Cpf;
import br.com.carlito.school.domain.student.RepositoryStudent;
import br.com.carlito.school.domain.student.Student;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStudentInMemory implements RepositoryStudent {

    List<Student> enrolls = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolls.add(student);
    }

    @Override
    public Student findByCPF(Cpf cpf) throws Exception {
        return this.enrolls.stream().filter(
                a -> a.getCpf().equals(cpf.getNumber()))
                .findFirst()
                .orElseThrow(() -> new Exception("cpf not found " +  cpf));
    }

    @Override
    public List<Student> listAll() {
        return this.enrolls;
    }
}
