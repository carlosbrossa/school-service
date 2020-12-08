package br.com.carlito.school.domain.indication;


import br.com.carlito.school.domain.student.Student;

import java.time.LocalDateTime;

public class Indication {

    private final Student indicated;
    private final Student indicator;
    private final LocalDateTime date;

    public Indication(Student indicated, Student indicator, LocalDateTime date) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.date = date;
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
