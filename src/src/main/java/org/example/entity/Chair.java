package org.example.entity;

public class Chair {
    public Client client;

    public Chair(){
        this.client = null;
    }
    public boolean isOccupied(){
        return client != null;
    }
    public void assignClient(Client client){
        this.client = client;
    }
    public void releaseChair(){
        this.client =  null;
    }
}
