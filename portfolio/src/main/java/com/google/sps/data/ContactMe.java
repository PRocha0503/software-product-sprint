package com.google.sps.data;

/** Class containing the object of the contact me form */
public final class ContactMe {

  private final String name;
  private final String email;
  private final String reason;
  private final boolean recruiter;

  public ContactMe(String name, String email, String reason, String recruiter) {
    this.name = name;
    this.email = email;
    this.reason = reason;
    System.out.println(recruiter);
    if (recruiter.equals("on")) {
        this.recruiter = true;
      }else {
        this.recruiter = false;   
      }
  }
  public ContactMe(String name, String email, String reason, Boolean recruiter) {
    this.name = name;
    this.email = email;
    this.reason = reason;
    this.recruiter = recruiter;
  }
}
