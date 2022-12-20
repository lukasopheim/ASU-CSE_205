// Assignment #: Arizona State University CSE205 #5
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: MWF 10:30am
//  Description: InputPane generates a pane where a user can enter
//  a new order information and create a list of available Orders.
//  //---- is where you need to add your own codes
import java.util.ArrayList;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import all other necessary javafx classes here
//----
public class InputPane extends HBox
{
//components
ArrayList<Order> orderList;
//The relationship between InputPane and HandlePane is Aggregation
private HandlePane handlePane;
//declare other necessary GUI components and variables here
//----
//constructor
public InputPane(ArrayList<Order> list, HandlePane pane)
{
this.orderList = list;
this.handlePane = pane;
//initialize each instance variable (textfields, labels, textarea, button, etc.)
//and set up the layout
//----
//register source object with event handler
//----
} //end of constructor
//Step 2: Create a ButtonHandler class
//ButtonHandler listen to see if the button "Place an order" is pushed or not,
//When the event occurs, it get an order's product name, seller name, quantiy, unit price
//from the relevant text fields, then create a new Order object and add it inside
//the orderList. Meanwhile it will display the order's total cost and other info. inside the text area.
//It also does error checking in case any of the textfields are empty
private class ButtonHandler implements EventHandler<ActionEvent>
{
//Override the abstact method handle()
public void handle(ActionEvent e)
{
//declare any necessary local variables here
//---
//when one text field is empty and the button is pushed
//display msg "Please fill all fields"
if ( //----  )
{
//handle the case here
}
else
{
//when a non-numeric value was entered for quantity or price
//and the button is pushed
//you will need to use try & catch block to catch
//the NumberFormatException
//----
//When a duplicated order was attempted to be added, do not
//add it to the list. Instead displaying msg "Order not added - duplicate"
//----
}
} //end of handle() method
} //end of ButtonHandler class
}
