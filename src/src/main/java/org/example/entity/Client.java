package org.example.entity;

public class Client {
    public String type;
    int number;

    public Client(String type, int number) {
        this.type = type;
        this.number = number;
    }
    public String toString(){
        return type + number;
    }
}
