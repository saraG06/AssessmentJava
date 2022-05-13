package com.example.assessmentjava.DAL.Repository;

import com.example.assessmentjava.DAL.Entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {

    //@Query(value = "SELECT * FROM Academy a WHERE")
}
