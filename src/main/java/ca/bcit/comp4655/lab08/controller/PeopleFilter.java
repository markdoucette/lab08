package ca.bcit.comp4655.lab08.controller;

import ca.bcit.comp4655.lab08.entity.Person;
import ca.bcit.comp4655.lab08.services.PersonServices;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter( filterName="PeopleFilter", urlPatterns="/*")
public class PeopleFilter implements Filter 
{
	//TODO Inject PersonServices EJB
    @EJB(mappedName = "java:app/lab08/PersonServicesImpl")
    PersonServices personServices;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		//TODO Add list of people to servlet context: Call getPeople method of PersonServices EJB
        List<Person> people = personServices.getPeople();
        filterConfig.getServletContext().setAttribute("people", people);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy()
	{
	}

	
}
