package br.com.carlito.school.domain.student;

public class Cpf {

    private String number;

    public Cpf(String number) {
        if(number == null || !number.matches("^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")){
            throw new IllegalArgumentException("Invalid cpf");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
