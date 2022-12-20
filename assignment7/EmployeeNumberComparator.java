// Assignment #: ASU Fall 2022 #7
//         Name: Lukas Opheim 
//    StudentID: 1224151695
//      Lecture: Tuesday, Thursday, 10:30
//Description: Returns an integer based on if one of the two Company objects has an employee count that is smaller than the other. 

import java.util.Comparator;

public class EmployeeNumberComparator implements Comparator<Company> {

	public int compare(Company first, Company second) {
		return (first.getNumOfEmployees() - second.getNumOfEmployees());
	}

}