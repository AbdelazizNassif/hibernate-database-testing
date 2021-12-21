package com.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class UpdateStudentDemo2 {

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
			System.out.println("update students email");
			session.createQuery("update Student "
					+ "set email='updatingEmail@vo.com' where id = 1").executeUpdate();
			
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
