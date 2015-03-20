package ca.bcit.comp4655.lab08.controller;

import ca.bcit.comp4655.lab08.entity.Person;
import ca.bcit.comp4655.lab08.services.PersonServices;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet is called when "find person by id" is requested.
 */
@WebServlet ( name="PeopleServlet", urlPatterns="/people")
public class PeopleServlet extends HttpServlet 
{
	
	//TODO Inject PersonServices EJB
    @EJB(mappedName = "java:app/lab08/PersonServicesImpl")
    PersonServices personServices;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		if ( null != req.getParameter( "id" ) ) {
            //TODO call to PersonServices EJB findPersonById method. Add the return "person" object as attribute to the request.
            try {
                Person person = personServices.findPersonById(req.getParameter("id"));
                req.setAttribute("person", person);
            } catch (Exception e) {
                req.setAttribute("error", e);
            }

        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		doGet(req, resp);
	}
}
