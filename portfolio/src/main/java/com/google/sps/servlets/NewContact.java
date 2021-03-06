package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
// import org.jsoup.Jsoup;
// import org.jsoup.safety.Whitelist;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

/** Servlet responsible for creating new tasks. */
@WebServlet("/newContact")
public class NewContact extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the value entered in the form.
    String name = Jsoup.clean(request.getParameter("name"), Safelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Safelist.none());
    String reason = Jsoup.clean(request.getParameter("reason"), Safelist.none());
    String recruiter = request.getParameter("recruiter");
    Boolean isRec;
    //Check for nullity in rec
    if(recruiter == null) {
      isRec = false;
    }else{
      isRec =true;
    }
    long timestamp = System.currentTimeMillis();

    //  Connect to datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    //crate new entity
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name",name)
            .set("email", email)
            .set("reason", reason)
            .set("recruiter", isRec)
            .set("active",true)
            .set("timestamp", timestamp)
            .build();
    // Pubish
    datastore.put(contactEntity);
    response.sendRedirect("/");
  }
}
