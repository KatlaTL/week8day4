<%-- 
    Document   : index
    Created on : Oct 13, 2016, 11:26:53 AM
    Author     : Asger
--%>

<%@page import="databasepopulation.domain.Building"%>
<%@page import="java.util.List"%>
<%@page import="domain.domainfacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            List<Building> buildings = domainfacade.buildings();
            if(buildings.isEmpty()) {
                %><p>There are no buildings in the table</p><%
            } else {
                out.println( "<table>" );
                out.println( "<tr><th>Address</th><th>Zip</th><th>City</th><th>Contact</th><th>Phone</th></tr>" );
                for ( Building b : buildings ) {
                    String addr = "<a href=\"editbuilding.jsp?buildingid=" + b.getId() + "\">" + b.getAddress() + "</a>";
                    String zip = String.valueOf( b.getZip() );
                    String city = b.getCity();
                    String contact = b.getContactPerson();
                    String phone = b.getContactPhone();
                    String htmlTemplate = "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";
                    out.println( String.format( htmlTemplate, addr, zip, city, contact, phone ) );
                }
                out.println( "</table>" );
            }
        %>
    </body>
</html>
