package org.example.controller;

import org.example.entity.Chair;
import org.example.entity.Client;

import java.util.*;

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
            System.out.print(" ");
        }
        System.out.println();
    }

    public void processEvent(){
        Scanner scanner = new Scanner(System.in);
        char input = scanner.nextLine().charAt(0);
        Random rand = new Random();
        int x = rand.nextInt(5);
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
            case 4:
                event = "++ ORD" + (queue.size() + 1);
                if (!mainChair.isOccupied()){
                    mainChair.assignClient(new Client("ORD",queue.size() + 1));
                } else if (x == 2 || x == 3){
                    event = "+- ORD" + (queue.size() + 1);
                }
                break;
        }
        displayState();
        System.out.println(x + "---> (" + event + " )");
    }
}
