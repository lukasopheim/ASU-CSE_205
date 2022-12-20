// Assignment #: ASU CSE205 Fall #8
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: T/Th 10:30 
//  Description: this program reads in a sequence of numbers from standard
//  input until 0 is read and stores the numbers in an array, it then
//  compute the maximum number, the total sum of even numbers (includes both 
//  postive and negative),
//  and compute the sum of numbers at odd indexes
//  (i.e. 1, 3, 5, ...), using recursion.
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Assignment8
{
    //Creat scanner 
	static Scanner scan = new Scanner(System.in);
	//Initaile variables
	private static int num;
	private static int index;
	static int[] numList;
	
/******************************************************************************
  ***Complete the main() method. See program description for details.
******************************************************************************/
  public static void main (String[] args) throws IOException
  {
    numList = new int[100];
	  index = 0;
	  do{
		  num = scan.nextInt();
		  if (num == 0)
			  break;
		  numList[index] = num;
		  index++;
	  }
	  while (num != 0);
      System.out.print("The minimum number is " + findMin(numList, 0,index) + "\n");
	  System.out.print("The total sum of all even integers is " + computeEvenSum(numList,0,index) + "\n");
	  System.out.print("The sum of numbers at odd indexes is " + computeSumAtOddIndexes(numList, 0) + "\n");

  }
/***********************************************************************************
**
***(1)Complete the method. The method finds the minimum number in the partial array
***range from startIndex to endIndex
***********************************************************************************
**/
public static int findMin(int[ ] numbers, int startIndex, int endIndex)
{
	// check if array length is 1
	if (startIndex == endIndex) {
		return numbers[startIndex];
	}
	else {
		if (Math.min(numbers[startIndex],numbers[endIndex]) == numbers[startIndex]) {
			return findMin(numbers, startIndex, endIndex-1);
		}
		else {
			return findMin(numbers, startIndex+1,endIndex);
		}
	}
}
/***********************************************************************************
***
***(2)Complete the method. The method counts the sum of all even integers in the
// partial array range from startIndex to endIndex
***********************************************************************************
**/
public static int computeEvenSum(int[ ] numbers, int startIndex, int endIndex)
{
	if (startIndex == endIndex) {
		if (numbers[startIndex]%2 == 0) {
			return numbers[startIndex];
		}else {
		return 0;
		}	
	}
	else 
	//recursively call computeEvenSum with a higher start index
	{
		if (numbers[startIndex]%2 == 0) {
			return numbers[startIndex] + computeEvenSum(numbers,startIndex+1,endIndex);
		}else {

			 return computeEvenSum(numbers, startIndex+1,endIndex);
		}
	}

}
/***********************************************************************************
***
***(3)Complete the method. The method computes the sum of numbers at index 1, 3, 5,
...
***  inside a partial array with "count" numbers, index ranges from 0 to count-1
***********************************************************************************
****/
public static int computeSumAtOddIndexes(int[ ] numbers, int count)
{
	if (numbers.length == 0) {
		return 0;
	}
	if (count == 0) {
		return computeSumAtOddIndexes(Arrays.copyOfRange(numbers,1,numbers.length), 1);
	}
	else {
		return numbers[0] + computeSumAtOddIndexes(Arrays.copyOfRange(numbers,1,numbers.length), 0);
	}
}
}// end of class Assignment8