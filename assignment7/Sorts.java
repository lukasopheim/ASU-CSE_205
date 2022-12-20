// Assignment #: ASU Fall 2022 #7
//         Name: Lukas Opheim 
//    StudentID: 1224151695
//      Lecture: Tuesday, Thursday, 10:30
//Description: Sorts a list of Company objects based on different criterias.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Sorts {
	
	public static void sort(ArrayList<Company> companyList, Comparator<Company> xComparator) {
		if (companyList.size() == 1)
			return;
		for (int i = 0; i < companyList.size()-1; i++) {
			for (int j = i+1; j < companyList.size(); j++) {
				if (xComparator.compare(companyList.get(i),companyList.get(j)) > 0) {
					Collections.swap(companyList, i, j);
			}
			}
		}
	}
}