package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;



public class Student_Test {
	private static ArrayList<Course> CourseList = new ArrayList<Course>();
	private static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	private static ArrayList<Section> SectionList = new ArrayList<Section>();
	private static ArrayList<Student> StudentList = new ArrayList<Student>();
	
	@BeforeClass
	public static void setup() {
		Course course1 = new Course(UUID.randomUUID(), "CHEM", 90, eMajor.CHEM);
		Course course2 = new Course(UUID.randomUUID(), "PHYS", 80, eMajor.PHYSICS);
		Course course3 = new Course(UUID.randomUUID(), "NURS", 100, eMajor.NURSING);
		
		CourseList.add(course1);
		CourseList.add(course2);
		CourseList.add(course3);
		
		Semester fall = new Semester(UUID.randomUUID(), new Date(1976, 9, 1), new Date(1977, 2, 1));
		Semester spring = new Semester(UUID.randomUUID(), new Date(1977, 2, 1), new Date(1977, 7, 1));
		
		SemesterList.add(fall);
		SemesterList.add(spring);
		
		Student student1 = new Student("Lisa", "Lisa", "Lisa", new Date(1999, 9, 25), eMajor.CHEM,
				"152 Courtney Street, Newark, DE, 19717", "(302)-111-1212", "Lisa@udel.edu");
		Student student2 = new Student("Steve", "Steve", "Steve", new Date(1999, 10, 25), eMajor.BUSINESS,
				"152 Courtney Street, Newark, DE, 19717", "(302)-2222-1213", "Steve@udel.edu");
		Student student3 = new Student("John", "John", "John", new Date(1999, 11, 25), eMajor.COMPSI,
				"152 Courtney Street, Newark, DE, 19717", "(302)-3333-1214", "John@udel.edu");
		Student student4 = new Student("Lee", "Lee", "Lee", new Date(1999, 12, 25), eMajor.NURSING,
				"152 Courtney Street, Newark, DE, 19717", "(302)-3333-1215", "Lee@udel.edu");
		Student student5 = new Student("Amy", "Amy", "Amy", new Date(1999, 8, 25), eMajor.PHYSICS,
				"152 Courtney Street, Newark, DE, 19717", "(302)-4444-1216", "Amy@udel.edu");
		Student student6 = new Student("Tom", "Tom", "Tom", new Date(1999, 7, 25), eMajor.BUSINESS,
				"152 Courtney Street, Newark, DE, 19717", "(302)-5555-1217", "Tom@udel.edu");
		Student student7 = new Student("Alex", "Alex", "Alex", new Date(1999, 6, 25), eMajor.CHEM,
				"152 Courtney Street, Newark, DE, 19717", "(302)-6666-1218", "Alex@udel.edu");
		Student student8 = new Student("Lucy", "Lucy", "Lucy", new Date(1999, 5, 25), eMajor.COMPSI,
				"152 Courtney Street, Newark, DE, 19717", "(302)-7777-1219", "Lucy@udel.edu");
		Student student9 = new Student("Jason", "Jason", "Jason", new Date(1999, 4, 25), eMajor.NURSING,
				"152 Courtney Street, Newark, DE, 19717", "(302)-8888-1220", "Jason@udel.edu");
		Student student10 = new Student("Lex", "Lex", "Lex", new Date(1999, 3, 25), eMajor.PHYSICS,
				"152 Courtney Street, Newark, DE, 19717", "(302)-9999-1221", "Lex@udel.edu");
		
		StudentList.add(student1);
		StudentList.add(student2);
		StudentList.add(student3);
		StudentList.add(student4);
		StudentList.add(student5);
		StudentList.add(student6);
		StudentList.add(student7);
		StudentList.add(student8);
		StudentList.add(student9);
		StudentList.add(student10);
	}

	@Test
	public void test() {
		ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
		for(Student student : StudentList) 
		{
			for(Section section : SectionList) 
			{
				EnrollmentList.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}
		for(Enrollment enrollment : EnrollmentList) 
		{
			enrollment.setGrade(3.0);
		}
		
		for(Student s: StudentList)
		{
			double totalGrades = 0;
			int creditHours = 0;
			for(Enrollment enrollment: EnrollmentList)
			{
				if(s.getStudentID().equals(enrollment.getStudentID()))
				{
					for(Section section : SectionList)
					{
						if(section.getSectionID().equals(enrollment.getSectionID()))
						{
							for(Course course : CourseList)
							{
								if(course.getCourseID().equals(section.getCourseID()))
								{
									creditHours += course.getGradePoints();
									totalGrades += (enrollment.getGrade() * course.getGradePoints());
								}
							}
						}
					}
				}
			}
			assertEquals(totalGrades/creditHours,3.0,0.1);
		}
		
		for(Section section : SectionList)
		{
			double enrolledCourses = 0.0;
			double totalGrade = 0.0;
			for(Enrollment enrollment: EnrollmentList)
			{
				if(section.getSectionID().equals(enrollment.getSectionID()))
				{
					enrolledCourses += 1;
					totalGrade += enrollment.getGrade();
				}
			}
			assertEquals((totalGrade / enrolledCourses), 80.0, 0.01);
		}
		
		}
}
