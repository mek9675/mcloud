package com.mek.mcloud.service;


import java.util.List;

import com.mek.mcloud.model.Person;

public interface PersonService {
    
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
}
