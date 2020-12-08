package br.com.carlitos.school.domain.student;

import br.com.carlito.school.domain.student.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    public void notCreateInvalidCpf(){
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf("samba"));
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Cpf(null));
    }

    @Test
    public void createOk(){
        assertEquals("322.663.444-12", new Cpf("322.663.444-12").getNumber());
    }


}