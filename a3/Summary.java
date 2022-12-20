// Assignment #: 3
//         Name: Lukas Opheim
//    StudentID: 1224151695
//      Lecture: 10:30, tuesday thursday 
import java.util.Scanner;  
public class Summary {
private String Lead;
private String Genre;
private int rating;
public Summary(){
    this.Lead="?";
    this.Genre="?";
    this.rating=0;
}
public String getLead(){
    return this.Lead;
} 
public String getGenre(){
    return this.Genre;
} 
public int getRating(){
    return this.rating;
} 
public void setLead(String someLead){
    this.Lead=someLead;
} 
public void setGenre(String someGenre){
    this.Genre=someGenre;
} 
public void setRating(int someRating){
    this.rating=someRating;
}
public String toString(){
    return this.Lead+", "+this.Genre+", "+this.rating;
}

    
}