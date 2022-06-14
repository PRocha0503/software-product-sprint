package com.google.sps.servlets;

import com.google.sps.data.ContactMe;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing tasks. */
@WebServlet("/getContacts")
public class GetContact extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Connect to datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    //Order contacts by date
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Contact").setOrderBy(OrderBy.desc("timestamp")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<ContactMe> contacts = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();
      String name = entity.getString("name");
      String email = entity.getString("email");
      String reason = entity.getString("reason");
      Boolean recruiter = entity.getBoolean("recruiter");
      ContactMe contact = new ContactMe(name, email, reason, recruiter);
      contacts.add(contact);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(contacts));
  }
}
