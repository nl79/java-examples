package com.nazar.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nazar.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student")
					.getResultList();

			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}

			// query students: lastName = "Doe"

			theStudents = (List<Student>) session
					.createQuery("from Student s where s.lastName='Doe'")
					.getResultList();

			// query students: lastName='Doe' OR firstName = 'Daffy'
			theStudents = session.createQuery(
					"from Student s where s.lastName='Doe' OR s.firstName='Daffy'")
					.getResultList();

			// query students where email LIKE %email.com
			theStudents = session
					.createQuery(
							"from Student s where s.email LIKE '%email.com'")
					.getResultList();

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
