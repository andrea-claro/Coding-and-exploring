package com.example.RetriviengForTable;

import java.util.List;

public interface PersonData {

    public Person getPersonFromID(Long id);
    public List<Person> getPeople();

    public void savePerson(Person person);
    public void deletePerson(Long id);
}
