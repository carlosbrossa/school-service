package br.com.carlito.school.infra.indication;

import br.com.carlito.school.application.indication.SendEmailIndication;
import br.com.carlito.school.domain.student.Student;

public class SendEmailIndicationWithJavaMail implements SendEmailIndication {
    @Override
    public void sendTo(Student indicate) {

    }
}
