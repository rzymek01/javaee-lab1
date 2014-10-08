package eu.rzymek.java.lab1b.view.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Paragraph extends SimpleTagSupport {

  private String header;
  private String headerAlign;
  private String textColor;

  /**
   * Called by the container to invoke this tag. The implementation of this
   * method is provided by the tag library developer, and handles all tag
   * processing, body iteration, etc.
   *
   * @throws javax.servlet.jsp.JspException
   */
  @Override
  public void doTag() throws JspException {
    JspWriter out = getJspContext().getOut();

    try {
      String align = (null != headerAlign ? headerAlign : "left");
      String color = (null != textColor ? textColor : "#000");

      out.println("<p align=\"center\"><div style=\"text-align:" + align + ";font-weight:bold;\">");
      out.println(header);
      out.println("</div>");
      out.println("<div style=\"color:" + color + "\">");

      JspFragment f = getJspBody();
      if (f != null) {
        f.invoke(out);
      }

      out.println("</div></p>");

    } catch (java.io.IOException ex) {
      throw new JspException(ex.getMessage());
    }
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public void setHeaderAlign(String headerAlign) {
    this.headerAlign = headerAlign;
  }

  public void setTextColor(String textColor) {
    this.textColor = textColor;
  }
}
