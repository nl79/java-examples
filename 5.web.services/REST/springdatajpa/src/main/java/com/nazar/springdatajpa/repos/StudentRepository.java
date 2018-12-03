package com.nazar.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
