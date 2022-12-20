// Assignment #10 : ASU CSE205 Fall 2022 #10
// Name: Lukas Opheim 
// StudentID: 1224151695
// Lecture: T/TH 10:30 
// Description: LoanOfficer class represents a bank loan officer
//              that accept/handle and release customers.
//              //---- is where you should add your own code

public class LoanOfficer
{
   private int officerID;
   private Customer currentCustomer;

   //**************************************************
   //Constructor to initialize member variables
   //Initially no patient is assigned
   public LoanOfficer(int id)
   {
      this.officerID = id;
      currentCustomer = null;
   }

   //******************************************
   //an accessor method for the officer's ID
   public int getID()
   {
      return officerID;
   }

   //****************************************************************
   //method to determine if a loanOfficer currently has a customer by
   //checking the currentCustomer variable
   public boolean hasCustomer()
   {
      if(currentCustomer==null) {
         return false;
         }
         return true;
   }

   //************************************************************************
   //assign customer1 to currentCustomer if the officer does not have customer
   public boolean assignCustomer(Customer customer1)
   {
      if(hasCustomer()==false) {
      currentCustomer=customer1;
      return true;
      }
      else {
      return false;
      }
   }
      
      

   //*********************************************
   // This is simulating an officer handling a customer
   public Customer handleCustomer()
   {
      Customer c;
      if(hasCustomer()==false) {
      return null;
      }
      else {
      c=currentCustomer;
      currentCustomer=null;
      return c;
      }
   }

   //********************************************
   //toString method returns a string containing
   //the information of a loanOfficer
   public String toString()
   {
      String result = "\nOfficer ID: " + officerID;

      if (currentCustomer == null)
         result += " does not have any cutomers\n";
      else
         result += " is serving customer with id " + currentCustomer.getCustID() + "\n";

      return result;
   }
}