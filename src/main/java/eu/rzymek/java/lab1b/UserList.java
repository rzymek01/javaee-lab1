package eu.rzymek.java.lab1b;

import eu.rzymek.java.lab1b.entity.User;

import java.io.Serializable;
import java.util.*;

public class UserList implements Serializable {
  public static final String NAME = "userList";
  private final SortedMap<String, User> users;

  public UserList() {
    users = new TreeMap<>();
  }

  /**
   * Add user to list (by login).
   * @param login
   */
  public void add(String login) {
    System.out.println("UserList: adding user " + login);
    User user = new User(login, new Date());
    users.put(login, user);
  }

  /**
   * Remove user from list (by login).
   * @param login
   * @returns true if successfully removed, false otherwise
   */
  public boolean remove(String login) {
    if (null == login) {
      return false;
    }

    System.out.println("UserList: removing user " + login);
    return (users.remove(login) != null);
  }

  /**
   * @return number of users
   */
  public int getCount() {
    return users.size();
  }

  /**
   * @returns user list in ascending order
   */
  public ArrayList<User> getList() {
    return getList("asc");
  }

  /**
   * @param order asc or desc
   * @return user list in "order" order
   */
  public ArrayList<User> getList(String order) {
    ArrayList<User> list = new ArrayList<>(users.values());

    // SortedMap collection is sorted ascending by key (login), by default
    // so we have to reverse list if and only if "order" equals "desc"
    if (order.equals("desc")) {
      Collections.reverse(list);
    }

    return list;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserList userList = (UserList) o;

    if (!users.equals(userList.users)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return users.hashCode();
  }

  @Override
  public String toString() {
    return "UserList{" +
        "users=" + users +
        '}';
  }
}
