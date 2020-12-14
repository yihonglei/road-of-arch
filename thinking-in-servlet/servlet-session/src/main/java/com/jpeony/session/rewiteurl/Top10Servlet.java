package com.jpeony.session.rewiteurl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * URL重写
 *
 * @author yihonglei
 */
@WebServlet(name = "Top10Servlet", urlPatterns = {"/top10"})
public class Top10Servlet extends HttpServlet {
    private static final long serialVersionUID = 987654321L;

    private List<String> londonAttractions;
    private List<String> parisAttractions;

    /**
     * 重写HttpServlet中的init方法。
     * 第一次访问Servlet时调用init，初始化两个类级别的List
     */
    @Override
    public void init() throws ServletException {
        londonAttractions = new ArrayList<>(10);
        londonAttractions.add("Buckingham Palace");
        londonAttractions.add("London Eye");
        londonAttractions.add("British Museum");
        londonAttractions.add("National Gallery");
        londonAttractions.add("Big Ben");
        londonAttractions.add("Tower of London");
        londonAttractions.add("Natural History Museum");
        londonAttractions.add("Canary Wharf");
        londonAttractions.add("2012 Olympic Park");
        londonAttractions.add("St Paul's Cathedral");

        parisAttractions = new ArrayList<>(10);
        parisAttractions.add("Eiffel Tower");
        parisAttractions.add("Notre Dame");
        parisAttractions.add("The Louvre");
        parisAttractions.add("Champs Elysees");
        parisAttractions.add("Arc de Triomphe");
        parisAttractions.add("Sainte Chapelle Church");
        parisAttractions.add("Les Invalides");
        parisAttractions.add("Musee d'Orsay");
        parisAttractions.add("Montmarte");
        parisAttractions.add("Sacre Couer Basilica");
    }

    /**
     * 接受Get请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String city = request.getParameter("city");
        if (city != null && (city.equals("london") || city.equals("paris"))) {
            // show attractions
            showAttractions(request, response, city);
        } else {
            // show main page
            showMainPage(request, response);
        }
    }

    private void showMainPage(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<html><head>" +
                "<title>Top 10 Tourist Attractions</title>" +
                "</head><body>" +
                "Please select a city:" +
                "<br/><a href='?city=london'>London</a>" +
                "<br/><a href='?city=paris'>Paris</a>" +
                "</body></html>");
    }

    private void showAttractions(HttpServletRequest request,
                                 HttpServletResponse response, String city) throws ServletException, IOException {
        int page = 1;
        String pageParameter = request.getParameter("page");
        if (pageParameter != null) {
            try {
                page = Integer.parseInt(pageParameter);
            } catch (NumberFormatException e) {
                // do nothing and retain default value for page
            }
            if (page > 2) {
                page = 1;
            }
        }
        List<String> attractions = null;
        if (city.equals("london")) {
            attractions = londonAttractions;
        } else if (city.equals("paris")) {
            attractions = parisAttractions;
        }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head>" +
                "<title>Top 10 Tourist Attractions</title>" +
                "</head><body>");
        writer.println("<a href='top10'>Select City</a> ");
        writer.println("<hr/>Page " + page + "<hr/>");
        int start = page * 5 - 5;
        for (int i = start; i < start + 5; i++) {
            writer.println(attractions.get(i) + "<br/>");
        }
        writer.print("<hr style='color:blue'/>" +
                "<a href='?city=" + city +
                "&page=1'>Page 1</a>");
        writer.println("&nbsp; <a href='?city=" + city +
                "&page=2'>Page 2</a>");
        writer.println("</body></html>");
    }

}
