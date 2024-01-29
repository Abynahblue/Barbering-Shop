package org.example;

import org.example.controller.BarberingShop;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        BarberingShop shop = new BarberingShop();
        System.out.println("Press Space to simulate an event. Type anything else to exit");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            System.out.println("Input detected: " + input);
            if(input.isEmpty()){
                shop.processEvent();
            } else{
                break;
            }

        }
    }
}