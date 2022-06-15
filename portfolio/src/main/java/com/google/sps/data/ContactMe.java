package com.google.sps.data;

/** Class containing the object of the contact me form */
public final class ContactMe {

  private final String name;
  private final String email;
  private final String reason;
  private final boolean recruiter;
  private final boolean active;
  private final long timestamp;


  public ContactMe(String name, String email, String reason, String recruiter,boolean active, long timestamp) {
    this.name = name;
    this.email = email;
    this.reason = reason;
    if (recruiter.equals("on")) {
        this.recruiter = true;
      }else {
        this.recruiter = false;   
      }
    this.active = active;
    this.timestamp = timestamp;
  }
  public ContactMe(String name, String email, String reason, Boolean recruiter,boolean active, long timestamp) {
    this.name = name;
    this.email = email;
    this.reason = reason;
    this.recruiter = recruiter;
    this.active = active;
    this.timestamp = timestamp;
  }
}
