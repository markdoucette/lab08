package ca.bcit.comp4655.lab08.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import ca.bcit.comp4655.jpa.data.PersonFacade;
import ca.bcit.comp4655.lab08.entity.Person;

@Stateless(mappedName="PersonServicesImpl")
public class PersonServicesImpl implements PersonServices
{	
	@EJB
	PersonFacade personFacade;
	
	@Override
	public Person findPersonById( String id )
	{
		return personFacade.findPersonById(id);
	}
	
	@Override
	public List<Person> getPeople()
	{
		return personFacade.getPeople();
	}
	
	@Override
	public int updatePersonById(Person person)
	{
		return personFacade.updatePersonById(person);
	}

}
