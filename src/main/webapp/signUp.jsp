<%@ page import="com.example.spidstellare.config.DatabaseConnection" %>
<%@ page import="java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: thoma
  Date: 19/04/2024
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <link href="css/signUp.css" rel="stylesheet">
  <title>Spid stellare</title>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registrati</h3>
            <form action="signUpServlet" method="post">
              <div class="row">
                <div class="col-md-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                    <input type="text" name="nome" id="nome" class="form-control form-control-lg" />
                    <label class="form-label" for="nome">Nome</label>
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div data-mdb-input-init class="form-outline">
                    <input type="text" name="cognome" id="cognome" class="form-control form-control-lg" />
                    <label class="form-label" for="cognome">Cognome</label>
                  </div>

                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 d-flex align-items-center">

                  <div data-mdb-input-init class="form-outline datepicker w-100">
                    <input type="date" name="dt_nascita" class="form-control form-control-lg" id="dt_nascita" />
                    <label for="dt_nascita" class="form-label">Data di nascita</label>
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">Genere: </h6>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="genere" id="femmina"
                           value="F" checked />
                    <label class="form-check-label" for="femmina">Femmina</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="genere" id="maschio"
                           value="M" />
                    <label class="form-check-label" for="maschio">Maschio</label>
                  </div>

                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                  <div data-mdb-input-init class="form-outline">
                    <input type="email" name="email" id="email" class="form-control form-control-lg" />
                    <label class="form-label" for="email">Email</label>
                  </div>

                </div>
                <div class="col-md-6 mb-4 pb-2">

                  <div data-mdb-input-init class="form-outline">
                    <input type="password" name="psw" id="psw" class="form-control form-control-lg" />
                    <label class="form-label" for="psw">Password</label>
                  </div>

                </div>
              </div>
              <div class="row">
                <%
                  try (Connection connect = DatabaseConnection.initializeDatabase())
                  {
                    String sql = "SELECT id,nome FROM pianeti";
                    assert connect != null;
                    PreparedStatement stmt = connect.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();
                    out.println("<div class=\"col-6\">\n" +
                            "                  <label>\n" +
                            "                    <select name=\"id_pianeta\" class=\"select form-control-lg\">");
                    while (rs.next())
                    {
                      out.println("<option value=\" " + rs.getInt("id") + " \"> "+ rs.getString("nome") + "</option>");
                    }
                    out.println("</select>\n" +
                            "                  </label>\n" +
                            "                </div>");
                  }
                  catch (SQLException ignored)
                  {

                  }
                %>
                <%
                  try (Connection connect = DatabaseConnection.initializeDatabase())
                  {
                    String sql = "SELECT id,nome FROM razze";
                    assert connect != null;
                    PreparedStatement stmt = connect.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();
                    out.println("<div class=\"col-6\">\n" +
                            "                  <label>\n" +
                            "                    <select name=\"id_razza\" class=\"select form-control-lg\">");
                    while (rs.next())
                    {
                      out.println("<option value=\" " + rs.getInt("id") + " \"> "+ rs.getString("nome") + "</option>");
                    }
                    out.println("</select>\n" +
                            "                  </label>\n" +
                            "                </div>");
                  }
                  catch (SQLException ignored)
                  {

                  }
                %>
              </div>
              <div class="mt-4 pt-2">
                <input data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-danger" type="submit" value="Submit" />
              </div>
              <div class="d-flex align-items-center justify-content-center pb-4">
                <p class="mb-0 me-2">Already have an account?</p>
                <a href="index.jsp" type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-danger">Login</a>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
