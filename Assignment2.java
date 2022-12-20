// Assignment #: 2
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: 10:30, tuesday thursday 
import java.util.Scanner;  
public class Assignment2 {
  public static void main (String[] args) {
    //Create scanner for user input of integers 
    Scanner scanny = new Scanner(System.in);
    //Initializing variables to be used for calculations and print statements
    int x;
    int min=0;
    int max=0;
    int div5=0;
    int maxO=0;
    int div3=0;
    
    // do while loop that uses if statements to decide if the input is a key value 
    do{
        x=scanny.nextInt();
        
        if (x<min)
        {
            min=x;
        }
        if (x%2!=0&&x>maxO)
        {
            maxO=x;
        }
        if (x%5==0)
        {
            div5++;
        }
        if (x%3==0)
        {
            div3+=x;
        }
        if (x>=max)
        {
            max=x;
        } 
    }
    while(x!=0);
   
    
// print statements with concatenation of variables 
    System.out.println("The smallest integer is "+min);
    System.out.println("The number of integers divisible by 5 in the sequence is "+div5);
    System.out.println("The largest odd integer is "+maxO);
    System.out.println("The sum of numbers divisible by 3 is "+div3);
    System.out.println("The sum of smallest and largest integer is "+(min+max));
    scanny.close();

    }
    
}


