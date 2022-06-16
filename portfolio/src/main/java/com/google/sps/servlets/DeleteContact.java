// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

/** Servlet responsible for deleting tasks. */
@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet {

  @Override
  public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //Get email to delete
    String email = request.getParameter("email");
    response.setContentType("text/plain;");
    response.getWriter().println(email);

    // // Initialize datastore
    // Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    // // KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
    // // Key taskEntityKey = keyFactory.newKey(id);
    // // datastore.delete(taskEntityKey);
    // String entityName = "Contacts";
    // String gql = "SELECT * FROM "+entityName +" WHERE email= "+email+"";


    // Query<Entity> query = Query.newGqlQueryBuilder(Query.ResultType.ENTITY, gql)
    //         .setAllowLiteral(true).build();
    // try{
    //     QueryResults<Entity> results = datastore.run(query);           
    //     if (results.hasNext()) {
    //         Entity rs = results.next();             
    //         datastore.delete(rs.getKey());
    //         return ;
    //     }
    //     return ;
    // }catch(Exception e){
    //     System.out.println(e);
    //     return ;
    // }
  }
}
