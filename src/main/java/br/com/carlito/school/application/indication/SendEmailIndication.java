package br.com.carlito.school.application.indication;

import br.com.carlito.school.domain.student.Student;

public interface SendEmailIndication {

    void sendTo(Student indicate);

}
