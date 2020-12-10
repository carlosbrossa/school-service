package br.com.carlito.school.infra.student;

import br.com.carlito.school.domain.student.EncryptPass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassMD5 implements EncryptPass {


    @Override
    public String encrypt(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean validPassEncrypt(String cryptPass, String pass) {
        return cryptPass.equals(encrypt(pass));
    }
}
