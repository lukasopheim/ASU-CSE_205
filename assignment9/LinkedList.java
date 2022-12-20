// Assignment #: ASU CSE205 Fall 2022 #9
//         Name: Your name
//    StudentID: Your id
//      Lecture:
//  Description: The LinkedList defines a linked list using its node class
//  object and also defines a iterator class to traverse the linked list.
//***********************************************************************

import java.util.NoSuchElementException;

public class LinkedList {

  //only instance variable that points to the first node
  private Node first;

  //nested class to represent a node
  private class Node {

    public Object data;
    public Node next;
  }

  // Constructs an empty linked list.
  public LinkedList() {
    first = null;
  }

  //Returns the first element in the linked list.
  public Object getFirst() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }

  //Removes the first element in the linked list.
  public Object removeFirst() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    Object element = first.data;
    first = first.next;
    return element;
  }

  //Adds an element to the front of the linked list.
  public void addFirst(Object element) {
    Node newNode = new Node();
    newNode.data = element;
    newNode.next = first;
    first = newNode;
  }

  //toString() method prints the elements out from front to tail
  public String toString() {

    ListIterator iterator = listIterator();
    String result = "{ ";
    while (iterator.hasNext()) {
      result += iterator.next() + " ";
    }
    result += "}\n";

    return result;
  }

  //size() method returns the number of nodes inside this LinkedList
  public int size() {
    ListIterator iterator = listIterator();
    int count = 0;
    while (iterator.hasNext()) {
      count++;
      iterator.next();
    }
    return count;
  }

  //*****************************************************************************
  // Below is where you should add the new methods, several of them are already given as examples.
  // ****************************************************************************

  //***********************************************************************************
  //searchElement() method returns the index of the first occurrence of the
  //parameter object in the linked list if it exists. It returns -1 if it does not exit.
  //***********************************************************************************
  public int searchElement(Object element) {
    int index = 0;
    for (Node node = this.first; node != null; node = node.next, index++) {
      if (element.toString().equals(node.data.toString())) {
        return index;
      }
    }
    return -1;
  }

  //*****************************************************************
  // getElement() method returns the element at the parameter index
  // If the index is out of bounds, throw an IndexOutOfBoundException.
  //*****************************************************************
  public Object getElement(int index) {
    // list index starts from 0. If the
    // index given is less than 0, throw
    // indexOutOfBoundsException
    if (index < 0) {
    throw new IndexOutOfBoundsException();
    }
    // create new LinkedListIterator object 
    ListIterator listIterator = listIterator();
    // iterate through the linkedlist
    while (listIterator.hasNext()) {
      Object element = listIterator.next();
if (index == 0)
return element;
index--;
}
// if not found, throw indexOutOfBoundsException
throw new IndexOutOfBoundsException();
}

  //****************************************************************************
  //setElement() method sets the parameter object at the parameter index in the
  //linked list. If the index is out of bounds, throws an IndexOutOfBoundException
  //****************************************************************************
  public void setElement(int index, Object element) {
    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    ListIterator li = listIterator();
    while (li.hasNext()) {
      li.next();
      if (index == 0) {
        li.set(element);
        return;
      }
      index--;
    }
    throw new IndexOutOfBoundsException();
  }

  //***********************************************************************************
  //insertElement() method inserts the parameter object at the parameter index.
  //If the index is out of bounds, throws an IndexOutOfBoundException
  //Note: the element can be inserted at the end, i.e. inserted at size() index/position
  //************************************************************************************
  public void insertElement(int index, Object element) {
    if (index < 0) {
      throw new IndexOutOfBoundsException();
    }
    ListIterator iterator = listIterator();
    while (true) {
      if (index == 0) {
        iterator.add(element);
      }
      if (iterator.hasNext()) {
        iterator.next();
      } else {
        break;
      }
      index--;
    }
  }

  //*******************************************************************
  //removeElement()method removes and returns element at parameter index
  //and throw an IndexOutOfBoundException if the index is out of bounds
  //*******************************************************************
  public Object removeElement(int index) {
    // if given index is less than 0 or greater than size of the list, throw exception
    if (index < 0 || index > this.size())
    throw new IndexOutOfBoundsException();
    // create instance of LinkedListIterator
    LinkedListIterator iterator = new LinkedListIterator();
    // iterate through the list and reach to the specified index
    for (int i = 0; i < index; i++) {
    iterator.next();
    }
    // store the value of the object into an object
    Object objectAtSpecifiedIndex = iterator.next();
    // remove the object from the list
    iterator.remove();
    // return the removed object.
    return objectAtSpecifiedIndex;
    }

  //*****************************************************************
  //countHowMany(Object) method returns the number of occurences of
  //the parameter object in the LinkedList
  //*****************************************************************
  public int countHowMany(Object searchedObject) {
    int count = 0;
    int index = 0;
    // for loop to iterate through linkedList
    for (Node node = this.first; node != null; node = node.next, index++) {
    // if the object match is found, increment the value of count
    if (searchedObject.toString().equals(node.data.toString()))
    count++;
    }
    // at the end, return count.
    return count;
    }

  //*****************************************************************
  //removeDuplicate() method removes all occurences of the parameter
  //objects from the LinkedList
  //*****************************************************************
  public void removeDuplicate(Object removedObject) {
    ListIterator iterator = listIterator();
    while (iterator.hasNext()) {
      if (removedObject.equals(iterator.next())) {
        iterator.remove();
      }
    }
  }

  //*******************************************************************************
  //appendAtEnd(Object, int) method appends the parameter object number of
  //times at the end of the linked list. For example, a call of appendAtEnd("A", 3)
  //will append string "A" three times at the end of the linked list.
  //*******************************************************************************
  public void appendAtEnd(Object element, int howManyTimes) {
    //get the size of the list
    int sizeOfList = size();
    if (howManyTimes > 0) {
    //insert element at the end of the list
    for (int i = 0; i < howManyTimes; i++) {
    insertElement(sizeOfList, element);
    sizeOfList++;
    }
    }
    }

  //********************************************************************************
  //appendAfter(Object element1, Object element2) method appends the second parameter
  //object, i.e. element2 right after the first occurence of first parameter object,
  //i.e. element1. If element1 is not inside the linked list, then append element2
  //at the front/head of the linked list.
  //********************************************************************************
  public void appendAfter(Object element1, Object element2) {
    // Create instance of LinkedListIterator
    LinkedListIterator iterator = new LinkedListIterator();
    int index = 0;
    // iterate through the list
    while (iterator.hasNext()) {// check if the first oject exists in the list
    index = this.searchElement(element1);
    // if index return is not equal to -1 i.e the object exists i the list
    if (index != -1) {
    // add element2 after the existing element1
    this.insertElement(index + 1, element2);
    break;
    }
    iterator.next();
    }
    // if element1 is not found in the list, add element2 at the end of the list.
    if (index == -1) {
    this.insertElement(0, element2);
    }
  
    }

  //**************************************************************************************
  //reverseFistFew(int howMany) reverse the first parameter number of elements inside the
  //linked list. For example, if the original linked list is { A B C D E }, a call of
  //reverseFirstFew(3) will change the linked list to { C B A D E }. Note: (1)you need to
  //consider the boundary value, i.e.cases where howMany <= 0 or howMany > size()
  //(2)list.reverseFirstFew(list.size()) should reverse the whole linked list
  //**************************************************************************************
  public void reverseFirstFew(int howMany) {
    LinkedListIterator it = new LinkedListIterator();
    //if howMany value is invalid
     if(howMany<=0 || howMany > size())
     {
     throw new IndexOutOfBoundsException();
     }else
     {
     //set top of the linkedlist to be howMany-1
     int top = howMany-1;
     //start from zero index
     int bot = 0;
     it.next();
     do
     {
     //make an instance of LinkedListIterator
     LinkedListIterator ti = new LinkedListIterator();
     //get elements
     Object one= getElement(bot);
     Object two= getElement(top);
     //set the vlalue of second in first position
     it.set(two);
     //iterate next
     it.next();
     for(int i = 0; i<top+1; i++)
     ti.next();
     ti.set(one);
     bot++;
     top--;
     }while(top>(size()/2)-1);
     }
    }

  //***************************************************************
  //Method creates an iterator on the current LinkedList
  //***************************************************************
  public ListIterator listIterator() {
    return new LinkedListIterator();
  }

  //***************************************************************
  //nested class to define its iterator
  //***************************************************************
  private class LinkedListIterator implements ListIterator {

    private Node position;
    private Node previous;

    // Constructs an iterator that points to the front
    // of the linked list.   of the linked list.
    public LinkedListIterator() {
      position = null;
      previous = null;
    }

    // Moves the iterator past the next element, and returns
    // the traversed element's data.
    public Object next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      previous = position; // Remember for remove

      if (position == null) {
        position = first;
      } else {
        position = position.next;
      }

      return position.data;
    }

    // Tests if there is an element after the iterator position  position
    public boolean hasNext() {
      if (position == null) {
        return first != null;
      } else {
        return position.next != null;
      }
    }

    // Adds an element after the iterator position
    // and moves the iterator to the inserted element.
    public void add(Object element) {
      if (position == null) {
        addFirst(element);
        position = first;
      } else {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = position.next;
        position.next = newNode;
        position = newNode;
      }
      previous = position;
    }

    // Removes the last traversed element. This method may
    // only be called after a call to the next() method.
    public void remove() {
      if (previous == position) {
        throw new IllegalStateException();
      }

      if (position == first) {
        removeFirst();
      } else {
        previous.next = position.next;
      }
      position = previous;
    }

    // Sets the last traversed element to a different value
    public void set(Object element) {
      if (position == null) {
        throw new NoSuchElementException();
      }
      position.data = element;
    }
  } //end of
}