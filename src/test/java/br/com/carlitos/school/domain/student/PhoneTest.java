package br.com.carlitos.school.domain.student;

import br.com.carlito.school.domain.student.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    public void testInvalidPhone(){
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("", ""));
        assertThrows(IllegalArgumentException.class,
                () -> new Phone("samva", "samba"));
        assertThrows(IllegalArgumentException.class,
                () -> new Phone(null, null));
    }

    @Test
    public void testOk(){
        assertEquals("(11)", new Phone("(11)", "97017-8966").getDdd());
        assertEquals("97017-8966", new Phone("(11)", "97017-8966").getNumber());

    }

}