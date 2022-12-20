// Assignment #: Arizona State University CSE205 #5
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: MWF 10:30am
//  Description: The Order class represent an order info.
//  this includes product name, quantity, price and total cost.
import java.text.DecimalFormat;
public class Order
{
private String productName;
private String sellerName;
private int quantity;
private double unitPrice,
totalCost;
//Constructor. It initializes all instance variables to their default values.
public Order()
{
productName = new String("?");
sellerName = new String("?");
quantity = 0;
unitPrice = 0;
totalCost = 0.0;
}
//Overloaded constructor, used to initialize all instance varibles
public Order(String name, String sName, int qty, double price)
{
productName = name;
sellerName = sName;
quantity = qty;
this.unitPrice = price;
totalCost = quantity * unitPrice;
}
//Accessor method of the instance variable productName
public String getProductName()
{
return productName;
}
//Accessor method of the instance variable sellerName
public String getSellerName()
{
return sellerName;
}
//Accessor method of the instance variable quantity
public int getQuantity()
{
return quantity;
}
//Accessor method of the instance variable unitPrice
public double getUnitPrice()
{
return unitPrice;
}
//Accessor method of the instance variable totalCost
public double getTotalCost()
{
return totalCost;
}
//Mutator method of the instance variable productName
public void setProductName(String name)
{
productName = name;
}
//Mutator method of the instance variable productName
public void setSellerName(String name)
{
sellerName = name;
}
//Mutator method of the instance variable quantity
public void setModel(int qty)
{
quantity = qty;
}
//Mutator method of the instance variable unitPrice
public void setUnitPrice(double price)
{
unitPrice = price;
}
//Mutator method of the instance variable totalCost
//Note: totalCost will be computed and set by quantity*unitPrice
public void setTotalCost()
{
totalCost = getQuantity() * getUnitPrice();
}
//toString method creates a string containing values of
//instance variables using the specified format and returns it
public String toString()
{
DecimalFormat fmt1 = new DecimalFormat("$0.00");
String result = "Name:\t\t" + productName +
"\nSeller Name:\t\t" + sellerName +
"\nQuantity:\t\t" + quantity +
"\nPrice:\t\t" + fmt1.format(unitPrice) +
"\nTotal Cost:\t" + fmt1.format(totalCost) + "\n\n";
return result;
}
} //end of the Order class