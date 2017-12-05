package lab6;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Simpsons/CharacterCatalog")
public class CharacterCatalog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init (ServletConfig config) throws ServletException{
    	super.init(config);
    	ArrayList<SimpsonCharacter> characters = new ArrayList<SimpsonCharacter>();
    	characters.add(new SimpsonCharacter("Homer Simpson",	2246));
    	characters.add(new SimpsonCharacter("Ned Flanders",	1454));
    	characters.add(new SimpsonCharacter("Moe Szyslak",	1452));
    	characters.add(new SimpsonCharacter("Lisa Simpson",	1354));
    	characters.add(new SimpsonCharacter("Bart Simpson",	1342));
    	characters.add(new SimpsonCharacter("Marge Simpson",	1291));
    	characters.add(new SimpsonCharacter("Krusty The Clown",	1206));
    	characters.add(new SimpsonCharacter("Principal Skinner",	1194));
    	characters.add(new SimpsonCharacter("Charles Montgomery Burns",	1193));
    	characters.add(new SimpsonCharacter("Milhouse Van Houten",	1079));
    	characters.add(new SimpsonCharacter("Chief Wiggum",	986));
    	characters.add(new SimpsonCharacter("Abraham Grampa Simpson",	913));
    	characters.add(new SimpsonCharacter("Sideshow Bob",	877));
    	characters.add(new SimpsonCharacter("Apu Nahasapeemapetilon",	623));
    	characters.add(new SimpsonCharacter("Kent Brockman",	498));
    	characters.add(new SimpsonCharacter("Comic Book Guy",	469));
    	characters.add(new SimpsonCharacter("Edna Krabappel",	457));
    	characters.add(new SimpsonCharacter("Nelson Muntz",	358));
    	characters.add(new SimpsonCharacter("Lenny Leonard",	310));
    	characters.add(new SimpsonCharacter("Mayor Quimby",	246));
    	characters.add(new SimpsonCharacter("Waylon Smithers",	181));
    	characters.add(new SimpsonCharacter("Maggie Simpson",	128));
    	characters.add(new SimpsonCharacter("Groundskeeper Willie",	121));
    	characters.add(new SimpsonCharacter("Barney Gumble",	106));
    	characters.add(new SimpsonCharacter("Selma Bouvier",	103));
    	characters.add(new SimpsonCharacter("Carl Carlson",	98));
    	characters.add(new SimpsonCharacter("Ralph Wiggum",	89));
    	characters.add(new SimpsonCharacter("Patty Bouvier",	72));
    	characters.add(new SimpsonCharacter("Martin Prince",	71));
    	characters.add(new SimpsonCharacter("Professor John Frink",	65));
    	characters.add(new SimpsonCharacter("Snake Jailbird",	55));
    	characters.add(new SimpsonCharacter("Cletus Spuckler",	47));
    	characters.add(new SimpsonCharacter("Rainier Wolfcastle",	45));
    	characters.add(new SimpsonCharacter("Agnes Skinner",	42));
    	characters.add(new SimpsonCharacter("Sideshow Mel",	40));
    	characters.add(new SimpsonCharacter("Otto Mann",	32));
    	characters.add(new SimpsonCharacter("Fat Tony",	27));
    	characters.add(new SimpsonCharacter("Gil",	27));
    	characters.add(new SimpsonCharacter("Miss Hoover",	17));
    	characters.add(new SimpsonCharacter("Disco Stu",	8));
    	characters.add(new SimpsonCharacter("Troy Mcclure",	8));
    	characters.add(new SimpsonCharacter("Lionel Hutz",	3));
    	characters.add(new SimpsonCharacter("Jimbo Jones",	0));
    	characters.add(new SimpsonCharacter("Bumblebee Man",	0));
    	characters.add(new SimpsonCharacter("Hans Moleman",	0));
    	characters.add(new SimpsonCharacter("Helen Lovejoy",	0));
    	characters.add(new SimpsonCharacter("Jasper Beardly",	0));
    	getServletContext().setAttribute( "characters", characters );
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lab6/CharacterCatalogView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
