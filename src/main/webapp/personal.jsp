<%--
  Created by IntelliJ IDEA.
  User: thoma
  Date: 20/04/2024
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="it">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Pagina personale</title>
</head>
<body>
<%
  if (session != null && !session.isNew() && session.getAttribute("logged") != null)
  {
      out.println("Ciao : "+session.getAttribute("email"));
  }
  else
  {
    response.sendRedirect("index.jsp");
  }

%>

</body>
</html>
