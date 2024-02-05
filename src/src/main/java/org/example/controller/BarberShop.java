package org.example.controller;

import java.text.MessageFormat;
import java.util.LinkedList;

public class BarberShop {
    private static final String MAIN_CHAIR = "Chair 0";
    private static final int WAIT_CHAIRS = 5;
    private static final String ORD_PREFIX = "ORD";
    private static final String VIP_PREFIX = "VIP";

    private final LinkedList<String> queue;
    private String currentCustomer;
    private int ordCount;
    private int vipCount;

    public BarberShop() {
        queue = new LinkedList<>();
        currentCustomer = null;
        ordCount = 0;
        vipCount = 0;
    }

    public void startShop(int event) {
        String message;
        switch (event) {
            case 0:
                message = "-- " + currentCustomer;
                currentCustomer = null;
                serveNextCustomer();
                break;
            case 1: // VIP arrives
                String vipName = VIP_PREFIX + ++vipCount;
                if (isQueueFull()) {
                    message = "+- " + vipName;
                } else {
                    message = "++ " + vipName;
                    if(queue.isEmpty() && currentCustomer == null){
                        addToQueue(vipName, true);
                        serveNextCustomer();
                    }else {
                        addToQueue(vipName, true);
                    }
                }
                break;
            case 2:
            case 3:
                String ordName = ORD_PREFIX + ++ordCount;
                if (isQueueFull()) {
                    message = "+- " + ordName;
                } else {
                    message = "++ " + ordName;
                    if(queue.isEmpty() && currentCustomer == null){
                        addToQueue(ordName, false);
                        serveNextCustomer();
                    }else {
                        addToQueue(ordName, false);
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid event code: " + event);
        }
        printState(message, event);
    }

    private void addToQueue(String name, boolean isVip) {
        if(isQueueFull()) return;
        if (isVip) {
            if (queue.isEmpty()) {
                queue.addFirst(name);
            } else {
                int vipIndex = -1;
                for (int i = 0; i < queue.size(); i++) {
                    if (queue.get(i).startsWith("ORD")) {
                        if(i < 1){
                            vipIndex = 0;
                            break;
                        }
                        vipIndex = i - 1;
                        break;
                    }
                }
                if (vipIndex > -1) {
                    queue.add(vipIndex, name);
                } else {
                    queue.addLast(name);
                }
            }
        } else {
            queue.addLast(name);
        }
    }

    private void serveNextCustomer() {
        if (!queue.isEmpty()) {
            currentCustomer = queue.removeFirst();
        }
    }

    private boolean isQueueFull() {
        return queue.size() == WAIT_CHAIRS;
    }

    private void printState(String message, int eventNumber) {
        StringBuilder sb = new StringBuilder(" ");
        sb.append(eventNumber);
        sb.append(" ----> ");
        sb.append("  ");
        sb.append("( ");
        sb.append(message);
        sb.append(" )");
        sb.append("   ");

        sb.append(" [");
        if(currentCustomer != null) {
            sb.append(currentCustomer);
            sb.append(": ");
        }

        int queueLength = queue.size();

        if (!queue.isEmpty()) {
            sb.append(String.join(" : ", queue));
        }
        int freeSpaceLeft = 5-queueLength;
        for(int i=0; i<= freeSpaceLeft; i++){
            sb.append(" : ---- ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}