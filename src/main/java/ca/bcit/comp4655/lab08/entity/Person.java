package ca.bcit.comp4655.lab08.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries( {
	@NamedQuery( name= "Person.getPeople" , query="select p from Person p" ),
	@NamedQuery( name= "Person.findById", query= "select p from Person p where p.id= :id" ),
	@NamedQuery( name= "Person.updateById", query= "update Person p set p.firstName= :firstName, p.lastName= :lastName where p.id= :id")
	} )
@Table
public class Person
{
	@Id
	@NotNull
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
	
	
}
