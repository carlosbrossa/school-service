package br.com.carlitos.school.domain.student;

import br.com.carlito.school.domain.student.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    public void notCreateInvalidEmail(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email("samba"));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));
    }

    @Test
    public void createOk(){
        assertEquals("sandero@samba.com.br", new Email("sandero@samba.com.br").getAddress());
    }

}