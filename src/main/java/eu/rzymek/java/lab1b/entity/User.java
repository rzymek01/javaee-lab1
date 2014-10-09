package eu.rzymek.java.lab1b.entity;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
  private String login;
  private Date loginDate;

  public User() {
  }

  public User(String login, Date loginDate) {
    this.login = login;
    this.loginDate = loginDate;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Date getLoginDate() {
    return loginDate;
  }

  public void setLoginDate(Date loginDate) {
    this.loginDate = loginDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (!login.equals(user.login)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return login.hashCode();
  }

  @Override
  public String toString() {
    return "User{" +
        "login='" + login + '\'' +
        ", loginDate=" + loginDate +
        '}';
  }
}
