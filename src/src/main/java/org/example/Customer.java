package org.example;

import org.example.controller.BarberShop;

import java.util.Random;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        BarberShop shop = new BarberShop();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Executive Barbering Shop!");
        System.out.println("Press space to trigger an event, any other key to quit.");

        System.out.println("    X         events                  State of the Shop");
        System.out.println("+--------+--------------+-------------------------------------------+");
        while (true) {
            String input = scanner.nextLine();
            if (!input.equals(" ")) {
                break;
            }
            int event = random.nextInt(4);
            shop.startShop(event);
        }

        System.out.println("Application has ended.");
    }
}