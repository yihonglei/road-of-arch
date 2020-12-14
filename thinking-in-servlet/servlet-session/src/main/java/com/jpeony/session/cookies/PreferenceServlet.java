package com.jpeony.session.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试Cookie
 *
 * @author yihonglei
 */
@WebServlet(name = "PreferenceServlet", urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet {
    private static final long serialVersionUID = -6382997793554034892L;

    public static final String MENU =
            "<div style='background:#e8e8e8;"
                    + "padding:15px'>"
                    + "<a href='cookieClass'>Cookie Class</a>&nbsp;&nbsp;"
                    + "<a href='cookieInfo'>Cookie Info</a>&nbsp;&nbsp;"
                    + "<a href='preference'>Preference</a>" + "</div>";

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head>" + "<title>Preference</title>"
                + "<style>table {" + "font-size:small;"
                + "background:NavajoWhite }</style>"
                + "</head><body>"
                + MENU
                + "Please select the values below:"
                + "<form method='post'>"
                + "<table>"
                + "<tr><td>Title Font Size: </td>"
                + "<td><select name='titleFontSize'>"
                + "<option>large</option>"
                + "<option>x-large</option>"
                + "<option>xx-large</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>Title Style & Weight: </td>"
                + "<td><select name='titleStyleAndWeight' multiple>"
                + "<option>italic</option>"
                + "<option>bold</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td>Max. Records in Table: </td>"
                + "<td><select name='maxRecords'>"
                + "<option>5</option>"
                + "<option>10</option>"
                + "</select></td>"
                + "</tr>"
                + "<tr><td rowspan='2'>"
                + "<input type='submit' value='Set'/></td>"
                + "</tr>"
                + "</table>" + "</form>" + "</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String maxRecords = request.getParameter("maxRecords");
        String[] titleStyleAndWeight = request.getParameterValues("titleStyleAndWeight");
        String titleFontSize = request.getParameter("titleFontSize");
        response.addCookie(new Cookie("maxRecords", maxRecords));
        response.addCookie(new Cookie("titleFontSize", titleFontSize));
        // delete titleFontWeight and titleFontStyle cookies first
        // Delete cookie by adding a cookie with the maxAge = 0;
        Cookie cookie = new Cookie("titleFontWeight", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        cookie = new Cookie("titleFontStyle", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        if (titleStyleAndWeight != null) {
            for (String style : titleStyleAndWeight) {
                if (style.equals("bold")) {
                    response.addCookie(new Cookie("titleFontWeight", "bold"));
                } else if (style.equals("italic")) {
                    response.addCookie(new Cookie("titleFontStyle", "italic"));
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head>" + "<title>Preference</title>"
                + "</head><body>" + MENU
                + "Your preference has been set."
                + "<br/><br/>Max. Records in Table: " + maxRecords
                + "<br/>Title Font Size: " + titleFontSize
                + "<br/>Title Font Style & Weight: ");
        // titleStyleAndWeight will be null if none of the options
        // was selected
        if (titleStyleAndWeight != null) {
            writer.println("<ul>");
            for (String style : titleStyleAndWeight) {
                writer.print("<li>" + style + "</li>");
            }
            writer.println("</ul>");
        }
        writer.println("</body></html>");
    }

}
