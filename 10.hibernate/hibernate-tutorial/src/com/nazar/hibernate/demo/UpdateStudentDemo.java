package com.nazar.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nazar.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();

			Student myStudent = session.get(Student.class, studentId);

			myStudent.setFirstName("Scooby");

			session.getTransaction().commit();

			session = factory.getCurrentSession();

			session.beginTransaction();

			// update email for all students

			session.createQuery("update Student set email='test@awesome.com'")
					.executeUpdate();
			session.getTransaction().commit();

			// commit the transaction

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
