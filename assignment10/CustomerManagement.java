// Assignment #10 : ASU CSE205 Fall 2022 #10
// Name: Lukas Opheim 
// StudentID: 1224151695
// Lecture: T/TH 10:30 
// Description: This program manages customer queues, assigns customer to loan officer,
//              process and release them, etc.
//              //---- is where you should add your own code

import java.util.LinkedList;

public class CustomerManagement
{
   private LinkedList<Customer> LEQueue;
   private LinkedList<Customer> MEQueue;
   private LinkedList<Customer> SEQueue;

   private LinkedList<Customer> checkoutQueue;

   private LoanOfficer[] officerList;

   //**********************************************
   //Constructor
   public CustomerManagement(int numOfLoanOfficers)
   {
      LEQueue = new LinkedList<Customer>();
      MEQueue = new LinkedList<Customer>();
      SEQueue = new LinkedList<Customer>();
      checkoutQueue = new LinkedList<Customer>();

      //creating LoanOfficer objects
      officerList = new LoanOfficer[numOfLoanOfficers];
      for (int i=0; i< officerList.length; i++)
      {
         officerList[i] = new LoanOfficer(i);
      }
   }

   //*******************************************************************
   //add a customer to the corresponding queue based on its category
   //return true if added to a queue successfully; otherwise return false
   boolean addCustomer(int id, String category)
   {
      Customer cust=new Customer(id, category);
      if(category.equals("LE")) {
      LEQueue.add(cust);
      return true;
      }
      else if(category.equals("ME")) {
      MEQueue.add(cust);
      return true;
      }
      else if(category.equals("SE")) {
      SEQueue.add(cust);
      return true;
      }
      return false;
   }
      
      

   //*******************************************************************
   //assign a customer to a loan officer with large enterprise (LE) queues
   //going first; return null if there are no customers in the queues or if
   //there are no loan officer are available
   Customer assignCustomerToLoanOfficer()
   {
      if(checkOfficer()==-1 || (LEQueue.size()==-0 && MEQueue.size()==0 && SEQueue.size()==0)) { //Checks if all of the queues are empty or if there is no officer than can take on a new customeer.
      return null;
      }
      LoanOfficer officer=officerList[checkOfficer()];
      Customer cust;
      if(LEQueue.size()!=0) {
      cust=LEQueue.poll();
      officer.assignCustomer(cust);
      return cust;
      }
      else if(MEQueue.size()!=0) {
      cust=MEQueue.poll();
      officer.assignCustomer(cust);
      return cust;
      }
      else if(SEQueue.size()!=0) {
      cust=SEQueue.poll();
      officer.assignCustomer(cust);
      return cust;
      }
      else { 
      return null;
      }
   }
   // helper method checks if any of lists do not have an assigned customer 
   int checkOfficer() {
      for(int i=0; i<officerList.length;i++) {
      if(officerList[i].hasCustomer()==false) {
      return i;
      }
      }
      return -1;
   }

   //***************************************************************
   //check if officer with the officerID has a customer, and release
   //that customer if they do. Then add that customer to checkout queue
   //and return the Customer object; otherwise return null
   Customer releaseCustomerFromOfficer(int officerID)
   {
      int index=-1;
      Customer cust;
      for(int i=0;i<officerList.length;i++) { 
      if(officerList[i].getID()==officerID) {
      index=i;
      }
      }
      if(index==-1) {
      return null;
      }
      if(officerList[index].hasCustomer()) { 
      //Release the customer and return the customer object.
      cust=officerList[index].handleCustomer();
      checkoutQueue.add(cust);
      return cust;
      }
      return null;
      }

   //**************************************************************
   //remove the first Customer from the checkoutQueue and return it;
   //otherwise the method return null.
   public Customer checkoutCustomer()
   {
      if(checkoutQueue.size()!=0) {
      return checkoutQueue.poll();
      }
      return null;
   }

   //************************************************
   //The printQueue prints out the content
   //of the queues and the array of loan officers
   public void printQueues()
   {
      System.out.print("\nLarge Enterprise Queue:\n" + LEQueue.toString() + "\n");
      System.out.print("\nMedium Enterprise Queue:\n" + MEQueue.toString() + "\n");
      System.out.print("\nSmall Enterprise Queue:\n" + SEQueue.toString() + "\n\n");
      for (int i = 0; i < officerList.length; i++)
      {
         System.out.print(officerList[i].toString());
      }
      System.out.print("\nCheckout Customer Queue:\n" + checkoutQueue.toString() + "\n\n");
   }
}