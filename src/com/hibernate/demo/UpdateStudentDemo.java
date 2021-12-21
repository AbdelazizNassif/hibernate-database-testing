package com.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {			
			// start a transaction
			session.beginTransaction();

			// query all students
			System.out.println("Print students with email begins with ahmed");
			int studentId = 1;
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Name_updated");
			// commit transaction
			session.getTransaction().commit();
//
//			System.out.println("Print student with id =1");
//			System.out.println(myStudent);
//			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student tmpStudent : students)
		{
			System.out.println("Student: " + tmpStudent);
		}
	}

}
