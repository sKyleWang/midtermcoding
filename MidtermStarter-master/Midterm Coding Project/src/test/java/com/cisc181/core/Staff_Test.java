package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	private static ArrayList<Staff> StaffList = new ArrayList<Staff>();	

	@BeforeClass
	public static void setup() {
		Staff staff1 = new Staff("Joseph","Jo","Joster", new Date(1920,9,27), "152 Courtney Street, Newark, DE, 19717", "(302)-123-1234" 
				,"jo2@udel.edu", "3-5", 8, 20000.00, new Date(1987,3,14), eTitle.MR);
		Staff staff2 = new Staff("Jonathan","Jo","Joster", new Date(1920,8,27), "152 Courtney Street, Newark, DE, 19717", "(302)-124-1233" 
				,"jo1@udel.edu", "1-3", 9, 21000.00, new Date(1987,3,12), eTitle.MR);
		Staff staff3 = new Staff("George","Jo","Joster", new Date(1918,10,25), "152 Courtney Street, Newark, DE, 19717", "(302)-125-1235" 
				,"jo0@udel.edu", "12-2", 10, 22000.00, new Date(1987,3,15), eTitle.MR);
		Staff staff4 = new Staff("Jotaro","Jo","Kujo", new Date(1970,10,25), "152 Courtney Street, Newark, DE, 19717", "(302)-126-1236" 
				,"jo3@udel.edu", "10-11", 11, 23000.00, new Date(1987,3,16), eTitle.MR);
		Staff staff5 = new Staff("Josuke","Jo","Joster", new Date(1983,7,01), "152 Courtney Street, Newark, DE, 19717", "(302)-127-1237" 
				,"jo4@udel.edu", "10-11", 12, 24000.00, new Date(1999,3,16), eTitle.MR);
		StaffList.add(staff1);
		StaffList.add(staff2);
		StaffList.add(staff3);
		StaffList.add(staff4);
		StaffList.add(staff5);
	}
	
	@Test
	public void test() {
		double totalSalary = 0.0;
		for (int count = 0; count < StaffList.size(); count++) 
		{
			totalSalary += (StaffList.get(count).getSalary());
		}
		double avgSalary = totalSalary/StaffList.size();
		assertEquals(avgSalary, 22000,0.01);
		
		boolean thrown1 = false;
		try
		{
			Staff wrongNumber = new Staff("Joseph","Jo","Joster", new Date(1920,9,27), "152 Courtney Street, Newark, DE, 19717", "(302)-998-2222" 
					,"jo2@udel.edu", "3-5", 8, 20000.00, new Date(1987,3,14), eTitle.MR);
		}
		catch(Exception e)
		{
			thrown1 = true;
		}
		boolean thrown2 = false;
		try
		{
			Staff wrongDOB = new Staff("Joseph","Jo","Joster", new Date(1990,7,25), "152 Courtney Street, Newark, DE, 19717", "(302)-123-1234" 
					,"jo2@udel.edu", "3-5", 8, 20000.00, new Date(1987,3,14), eTitle.MR);
		}
		catch(Exception e)
		{
			thrown2 = true;
		}
		
		assertTrue(thrown1);
		assertTrue(thrown2);
	}	

}
