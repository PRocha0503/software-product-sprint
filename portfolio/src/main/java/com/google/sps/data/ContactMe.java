package com.google.sps.data;

/** Class containing the object of the contact me form */
public final class ContactMe {

  private final String name;
  private final String email;
  private final String reason;
  private final boolean recruiter;
  private final boolean active;
  private final long timestamp;
  private final long id;
  
  public ContactMe(long id,String name, String email, String reason, Boolean recruiter,boolean active, long timestamp) {
    this.name = name;
    this.email = email;
    this.reason = reason;
    this.recruiter = recruiter;
    this.active = active;
    this.timestamp = timestamp;
    this.id = id;
  }
}
