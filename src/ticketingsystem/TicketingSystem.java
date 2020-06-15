/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


public class TicketingSystem {

    public static Queue <Integer>shopQueue = new LinkedList<>();
    public static int ticketNum = 1;
    
    public static void main(String[] args) {
     
 
        
        
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000); //run code in the SalesAssistantTask run() method every 5 seconds
        timer.schedule(new CustomerArrivedTask(), 0, 3000);
        

    }
    public static class SalesAssisstantTask extends TimerTask { //inner class
       
        public void run() {
                
            System.out.println("\nSales Assistant is ready to see the next customer."); 
            
            if (!shopQueue.isEmpty()){
                System.out.println("The customer with ticket number " + shopQueue.remove() + " will be seen");
                System.out.println("The customers with the following tickets are in the queue: " + shopQueue + "\n");
            } else {
                System.out.println("\nThere are no customers to see.\n");
            }
            
        }
    }
    
    
    public static class CustomerArrivedTask extends TimerTask {
        
        public void run() {
            
            //New Customer arrives!
            shopQueue.add(ticketNum);
            System.out.println("Customer with ticket " + ticketNum + " is added to the queue.");
            ticketNum++;          
            
        }
    }
   
    
}
    

