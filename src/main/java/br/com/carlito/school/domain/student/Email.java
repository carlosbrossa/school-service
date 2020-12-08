package br.com.carlito.school.domain.student;

public class Email {

    private String address;

    public Email(String address) {
        if(address == null || !address.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")){
            throw new IllegalArgumentException("Invalid email");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
