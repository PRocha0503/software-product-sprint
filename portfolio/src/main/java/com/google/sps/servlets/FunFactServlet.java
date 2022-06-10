package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Random;

@WebServlet("/funFact")
public class FunFactServlet extends HttpServlet {

  //Returns a random fun fact
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String[] funFacts = {"Avocados are a fruit, not a vegetable.",
		"The Eiffel Tower can be 15 cm taller during the summer",
		"The heart of a shrimp is located in its head.",
		"Baby rabbits are called kits",
		"The Easter Island heads have bodies.",
		"Ketchup was once sold as medicine."};
    // Generate a random number and acces it to the array
	  Random generator = new Random();
    int randomIndex = generator.nextInt(funFacts.length);
    String selectedFact = funFacts[randomIndex];
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(selectedFact);
  }
}
