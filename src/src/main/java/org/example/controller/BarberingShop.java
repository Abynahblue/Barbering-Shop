package org.example.controller;

import org.example.entity.Chair;
import org.example.entity.Client;

import java.util.*;

public class BarberingShop {
    Chair mainChair;
    LinkedList<Chair> waitingChairs;
    Queue<Client> queue;
    public BarberingShop(){
        mainChair = new Chair();
        waitingChairs = new LinkedList<>();
        for(int i = 0; i < 5;i++){
            waitingChairs.add(new Chair());
        }
        queue = new LinkedList<>();
    }
    public void displayState(int eventNumber){
        System.out.print(eventNumber + " ---> ");
        System.out.print("Main Chair: " + (mainChair.isOccupied() ? mainChair.client : "_____"));
        System.out.print("Waiting Chairs: ");
        for (Chair chair : waitingChairs){
            System.out.print(chair.isOccupied() ? chair.client : "_____");
            System.out.print(" ");
        }
        System.out.println();
    }

    public void processEvent(int eventNumber){
        Random rand = new Random();
        int x = rand.nextInt(4);
        String event = "";
        switch (x){
            case 0:
                event = "-- clientName";
                if(mainChair.isOccupied()){
                    mainChair.releaseChair();
                }
                break;
            case 1:
                event = "++ VIP" + (queue.size() + 1);
                if(!mainChair.isOccupied()){
                    mainChair.assignClient(new Client("VIP", queue.size() + 1));
                } else {
                    event = "+- VIP" + (queue.size() + 1);
                }
                break;
            case 2:
            case 3:
                event = "++ ORD" + (queue.size() + 1);
                if (!mainChair.isOccupied()){
                    mainChair.assignClient(new Client("ORD",queue.size() + 1));
                } else if (x == 2 || x == 3){
                    event = "+- ORD" + (queue.size() + 1);
                }
                break;
        }
        displayState(eventNumber);
        System.out.println(x + "---> (" + event + " )");
    }
}
