package com.example.RetriviengForTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PersonRetriever implements PersonData {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonFromID(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

    @Override
    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
