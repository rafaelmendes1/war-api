package com.rafaelmendes1.warapi;

import com.rafaelmendes1.warapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
