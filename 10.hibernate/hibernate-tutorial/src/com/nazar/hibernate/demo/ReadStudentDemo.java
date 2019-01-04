package com.nazar.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nazar.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// create a student object
			System.out.println("Creating a new Student object...");
			Student tempStudent = new Student("Fname", "Lname",
					"email@email.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			System.out.println(
					"Saved student. Generated id: " + tempStudent.getId());

			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on the id: primary key

			System.out
					.println("Getting student with id: " + tempStudent.getId());

			Student myStudent = session.get(Student.class, tempStudent.getId());

			System.out.println("Get Complete : " + myStudent);

			session.getTransaction().commit();

			// commit the transaction

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
