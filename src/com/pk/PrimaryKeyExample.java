package com.pk;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class PrimaryKeyExample {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("first", "Wall", "first@luv2code.com");
			Student tempStudent2 = new Student("second", "Wall", "second@luv2code.com");
			Student tempStudent3 = new Student("third", "Wall", "third@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving 3 students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
