package lab6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Simpsons/CharacterProfile")
public class CharacterProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SimpsonCharacter getCharacter(int id, ArrayList<SimpsonCharacter> list){
		for(SimpsonCharacter item : list){
			if(id == item.getId()){
				return new SimpsonCharacter(item.getCharacterName(), item.getNumberOfPictures());
			}
		}
		return null;
		
	}
	
	String getRandomNumber(int picNum){
		Random rand = new Random();
		int randomNumber = rand.nextInt(picNum);
		String out;
		if(randomNumber < 10){
			out = "000" + randomNumber;
		} 
		else if(randomNumber>9 && randomNumber<100){
			out = "00" + randomNumber;
		}
		else if(randomNumber>99 && randomNumber<999){
			out = "0" + randomNumber;
		} else {
			out = randomNumber + "";
		}
		return out;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		ArrayList<SimpsonCharacter> characters = (ArrayList<SimpsonCharacter>) context.getAttribute("characters");
		SimpsonCharacter character = getCharacter(Integer.parseInt(request.getParameter("id")), characters);
		context.setAttribute("character", character);
		if(character.numberOfPictures > 0){
			String pic = getRandomNumber(character.numberOfPictures);
			context.setAttribute("pic", pic);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lab6/CharacterProfileView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
