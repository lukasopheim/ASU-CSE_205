// Assignment #: ASU Fall 2022 #7
//         Name: Lukas Opheim 
//    StudentID: 1224151695
//      Lecture: Tuesday, Thursday, 10:30
//Description: Returns an integer based on if one of the two Company objects has a name that come before it in alphabetical order.

import java.util.Comparator; 

public class CompanyNameComparator implements Comparator<Company> {

	public int compare(Company first, Company second) {
		return first.getCompanyName().compareTo(second.getCompanyName());
	}
}