package ca.bcit.comp4655.jpa.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ca.bcit.comp4655.lab08.entity.Person;

@Stateless
public class PersonFacade {

	@PersistenceContext
	EntityManager entityManager;

	public List<Person> getPeople()
	{
		TypedQuery<Person > query = entityManager.createNamedQuery( "Person.getPeople", Person.class );
		return query.getResultList();
		
	}
	
	
	public Person findPersonById( String id )
	{
		int personId = Integer.parseInt(id);
		return entityManager.createNamedQuery( "Person.findById", Person.class ).setParameter("id", personId ).getSingleResult();
	}
	
	public int updatePersonById ( Person person )
	{
		Query query = entityManager.createNamedQuery("Person.updateById");
		query.setParameter("id", person.getId() );
		query.setParameter("firstName", person.getFirstName() );
		query.setParameter("lastName", person.getLastName() );
		int rowsAffected = query.executeUpdate();
		return rowsAffected;
	}
	
	public void closeEntityManager()
	{
		if ( entityManager.isOpen() )
		{
			entityManager.close();
		}
	}

}
