package eu.rzymek.java.lab1b.entity;

import java.io.Serializable;

public class CurrencyConvertion implements Serializable {
  private Float amount;
  private String from;
  private String to;

  public CurrencyConvertion() {
    from = "";
    to = "";
    amount = new Float(0);
  }

  public CurrencyConvertion(Float amount, String from, String to) {
    this.amount = amount;
    this.from = from;
    this.to = to;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CurrencyConvertion that = (CurrencyConvertion) o;

    if (!amount.equals(that.amount)) return false;
    if (!from.equals(that.from)) return false;
    if (!to.equals(that.to)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = amount.hashCode();
    result = 31 * result + from.hashCode();
    result = 31 * result + to.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "CurrencyConvertion{" +
        "amount=" + amount +
        ", from='" + from + '\'' +
        ", to='" + to + '\'' +
        '}';
  }
}
