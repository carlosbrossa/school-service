package br.com.carlito.school.domain.student;

public interface EncryptPass {

    String encrypt(String pass);

    boolean validPassEncrypt(String cryptPass, String pass);

}
