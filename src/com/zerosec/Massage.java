package com.zerosec;

public class Massage {
    private String text;
    private String recipient;
    private int id;

    public Massage(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("Contact Name: "+recipient+""+
                "\nMessage: "+text+""+
                "\nID: "+id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecepient() {
        return recipient;
    }

    public void setRecepient(String recepient) {
        this.recipient = recepient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
