package ca.bcit.comp4655.lab08.services;

import java.util.List;

import javax.ejb.Local;

import ca.bcit.comp4655.lab08.entity.Person;


@Local
public interface PersonServices
{
	Person findPersonById(String id );
	List<Person> getPeople();
	int updatePersonById(Person person);
}
