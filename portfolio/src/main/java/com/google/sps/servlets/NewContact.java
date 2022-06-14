package com.google.sps.servlets;

import com.google.sps.data.ContactMe;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import org.jsoup.Jsoup;
// import org.jsoup.safety.Whitelist;

/** Servlet responsible for creating new tasks. */
@WebServlet("/newContact")
public class NewContact extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the value entered in the form.
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String reason = request.getParameter("reason");
    String recruiter = request.getParameter("recruiter");

    //Check for nullity in rec
    if(recruiter == null) {
      recruiter = "null";
    }

    // Convert the server stats to JSON
    ContactMe contactMe = new ContactMe(name, email, reason, recruiter);
    long timestamp = System.currentTimeMillis();

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name",name)
            .set("email", email)
            .set("reason", reason)
            .set("recruiter", recruiter)
            .set("active",false)
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactEntity);

    response.sendRedirect("/");
  }
}
