package br.com.carlito.school.domain.student;

public class Phone {

    private String ddd;
    private String number;

    public Phone(String ddd, String number) {
        if(ddd == null || !ddd.matches("^\\((\\d{2})\\)")
        || number == null || !number.matches("(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")){
            throw new IllegalArgumentException("phone is invalid");
        }
        this.ddd = ddd;
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
