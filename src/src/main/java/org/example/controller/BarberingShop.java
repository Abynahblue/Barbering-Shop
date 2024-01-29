package org.example.controller;

import org.example.entity.Chair;
import org.example.entity.Client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BarberingShop {
    Chair mainChair;
    List<Chair> waitingChairs;
    Queue<Client> queue;
    public BarberingShop(){
        mainChair = new Chair();
        waitingChairs = new ArrayList<>();
        for(int i = 0; i <= 5;i++){
            waitingChairs.add(new Chair());
        }
        queue = new LinkedList<>();
    }
    public void displayState(){
        System.out.println("Main Chair: " + (mainChair.isOccupied() ? mainChair.client : "Empty"));
        System.out.println("Waiting Chairs: ");
        for (Chair chair : waitingChairs){
            System.out.print(chair.isOccupied() ? chair.client : "Empty");
        }
    }
}
