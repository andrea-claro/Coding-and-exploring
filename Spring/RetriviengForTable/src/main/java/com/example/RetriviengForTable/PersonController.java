package com.example.RetriviengForTable;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Resource
    private PersonData personData;

    @GetMapping
    public List<Person> getPeople(){
        return personData.getPeople();
    }

    @GetMapping("/get/{id}")
    public Person getPerson(@PathVariable Long id){
        return personData.getPersonFromID(id);
    }

    @PostMapping("/person")
    public String savePerson(final @RequestBody Person person){
        personData.savePerson(person);
        return "saved";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personData.deletePerson(id);
        return "deleted";
    }
}
