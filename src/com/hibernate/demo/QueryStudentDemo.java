package com.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class QueryStudentDemo {

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
			System.out.println("Print all students in the DB");
			List<Student> allStudents = session.createQuery("from Student").list();
			displayStudents(allStudents);

//			// use java property name not column name
			System.out.println("Print students with last name Wall!");
			List<Student> allStudentsWithLastNameWall = session.createQuery("from Student s where s.lastName='Wall'").list();
			displayStudents(allStudentsWithLastNameWall);


			// use java property name not column name
			System.out.println("Print students with last name duck or first name ahmed!");
			List<Student> studentsWithConditions = session.createQuery("from Student s where s.lastName='Duck'"
					+ "or s.firstName='ahmed'").list();
			displayStudents(studentsWithConditions);
			
			System.out.println("Print students with email begins with ahmed");
			List<Student> studentsWithEmailConditions = session.createQuery("from Student s "
					+ "where s.email like 'ahmed%'").list();
			displayStudents(studentsWithEmailConditions);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
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
