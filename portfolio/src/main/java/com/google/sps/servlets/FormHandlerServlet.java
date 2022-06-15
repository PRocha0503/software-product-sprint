package com.google.sps.servlets;

import com.google.sps.data.ContactMe;
import com.google.gson.Gson;
 
import java.io.FileWriter;
import org.json.simple.JSONArray;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String reason = request.getParameter("reason");
    String recruiter = request.getParameter("recruiter");
    long timestamp = System.currentTimeMillis();

    //Check for nullity in rec
    if(recruiter == null) {
      recruiter = "null";
    }

    // Convert the server stats to JSON
    ContactMe contactMe = new ContactMe(name, email, reason, recruiter,true,timestamp);
    String jsonContactMe = convertToJson(contactMe);
    System.out.println(jsonContactMe);

    //Read previous forms
    JSONArray contactList = readFile();

    //Add new contact to list
    System.out.println(jsonContactMe);
    contactList.add(jsonContactMe);

    //Write JSON file
    try (FileWriter file = new FileWriter("src/main/java/com/google/sps/db/contactMe.json")) {
      //We can write any JSONArray or JSONObject instance to the file
      file.write(contactList.toJSONString()); 
      file.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //Print all the contactList
    System.out.println(contactList);

     // Send the JSON as the response
     response.setContentType("application/json;");
     response.getWriter().println(jsonContactMe);

     
    //Redirect to main page
    response.sendRedirect("/");
  }

  /**
   * Converts the form info into a Json
   */
  private String convertToJson(ContactMe contactMe) {
    Gson gson = new Gson();
    String json = gson.toJson(contactMe);
    return json;
  }


  /**
   * Reads the file and returns the list
   */
  public static JSONArray readFile() 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("src/main/java/com/google/sps/db/contactMe.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray contactList = (JSONArray) obj;
            System.out.println(contactList);
            return contactList;
            //Iterate over employee array
            // employeeList.forEach( con -> parseEmployeeObject( (JSONObject) emp ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray list = new JSONArray();
        return list;
    }

}