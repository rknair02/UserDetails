package com.abn.db.springdatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abn.db.entity.Person;

@Repository
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
