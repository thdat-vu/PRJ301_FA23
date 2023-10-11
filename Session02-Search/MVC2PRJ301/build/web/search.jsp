<%-- 
    Document   : search
    Created on : Oct 4, 2023, 4:05:02 PM
    Author     : LENOVO
--%>

<%@page import="datvt.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Search Page</h1>
        <form action="DispatchServlet">
            Search Value 1 <input type="text" name="txtSearchValue" value="<%=request.getParameter("txtSearchValue")%>" />
            <input type="submit" value="Search" name="btAction" />
        </form>
        <%
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                List<RegistrationDTO> result
                        = (List<RegistrationDTO>) request.getAttribute("txtSearchValue");
                if (result != null) {//end one or more records 
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Full Name</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (RegistrationDTO dto : result) {
                %>
                <tr>
                    <td><%=++count%></td>
                    <td><%=dto.getFullname()%></td>
                    <td><%=dto.getPassword()%></td>
                    <td><%=dto.getFullname()%></td>
                    <td><%=dto.isRole()%></td>
                </tr>
            </tbody>   
        </table>

        <%
                    }
                }%>
                <h2>No Records found</h2>
        <%
            }
        %>
    </body>
</html>
