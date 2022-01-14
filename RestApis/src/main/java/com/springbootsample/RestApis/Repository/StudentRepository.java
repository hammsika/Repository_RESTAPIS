package com.springbootsample.RestApis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsample.RestApis.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
