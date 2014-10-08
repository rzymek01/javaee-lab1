package eu.rzymek.java.lab1b.view.tags;

import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class CurrencyConverter {

  public static String convert(String from, String to, float amount) {
    float result = 0;

    ResourceBundle exRates = ResourceBundle.getBundle("exchange_rates");
    try {
      float rate = Float.parseFloat(exRates.getString(from.toUpperCase() + to.toUpperCase()));
      result = rate * amount;
    } catch (NumberFormatException e) {
      result = 0;
    } catch (NullPointerException e) {
      result = 0;
    }

    DecimalFormat format = new DecimalFormat("#0.##");
    String formattedResult = format.format(result);

    return formattedResult;
  }
}
