// Assignment #: 3
//         Name: Lukas Opheim
//    StudentID: 
//      Lecture: 10:30, tuesday thursday 
import java.util.Scanner;  
public class Movie {
    public String name;
    public int Year;
    public String nameOfDirector;
    public Summary mySummary;
    public Movie(){
        this.name="?";
        this.nameOfDirector="?";
        this.mySummary = new Summary();
    } 
    public String getMovieName(){
        return name;
    } 
    public int getYear(){
        return Year;
    } 
    public String getNameOfDirector(){
        return nameOfDirector;
    } 
    public Summary getSummary(){
        return mySummary;
    }
    public void setMovieName(String someName){
        this.name=someName;
    } 
    public void setYear(int someYear){
        this.Year=someYear;
    }
    public void setNameOfDirector(String someDirector){
    this.nameOfDirector=someDirector;
    } 
    public void setSummary(String lead, String genre, int rating){
        mySummary.setLead(lead);
        mySummary.setGenre(genre);
        mySummary.setRating(rating);
    }
    public String toString(){
    return "\nMovie Name" + ":\t\t" + this.name +"\nYear:\t\t"+this.Year+"\nDirected By:\t\t"+this.nameOfDirector+"\nSummary:\t\t"+mySummary.toString()+"\n\n";
    }
    
}
