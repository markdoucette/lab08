package ca.bcit.comp4655.lab08.controller;

import ca.bcit.comp4655.lab08.entity.Person;
import ca.bcit.comp4655.lab08.services.PersonServices;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is called when "update a person by ID" is called.
 */
@WebServlet( name="PeopleUpdateServlet", urlPatterns="/update")
public class PeopleUpdateServlet extends HttpServlet
{
	//TODO Inject PersonServices EJB
    @EJB
    PersonServices personServices;
	
	private static final long serialVersionUID = -4837579681215791571L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		if ( null != req.getParameter( "update" ) ) {

			/*TODO 1) call to PersonServices EJB findPersonById method.
			 * 2) call to PersonServices EJB updatePersonById method and update the Person entity with new first name and last name
			 * 3) Refresh the list of people in servlet context 
			*/
            if (null != req.getParameter("id")) {

                Person person = personServices.findPersonById(req.getParameter("id"));

                if (null != req.getParameter("firstName") && !req.getParameter("firstName").equals("")) {
                    person.setFirstName(req.getParameter("firstName"));
                }

                if (null != req.getParameter("lastName") && !req.getParameter("lastName").equals("")) {
                    person.setLastName(req.getParameter("lastName"));
                }
                personServices.updatePersonById(person);

                List<Person> people = personServices.getPeople();
                req.getServletContext().setAttribute("people", people);
            }

            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
	}
}
