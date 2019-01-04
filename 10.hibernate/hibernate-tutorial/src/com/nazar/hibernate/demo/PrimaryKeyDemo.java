package com.nazar.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nazar.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object
			// start a transaction
			session.beginTransaction();
			// create a student object
			System.out.println("Creating a new Student object...");
			for (int i = 0; i <= 10; ++i) {
				Student tempStudent = new Student("Fname" + i, "Lname" + i, i + "email@email.com");

				// save the student object
				System.out.println("Saving the student...");
				session.save(tempStudent);

			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
