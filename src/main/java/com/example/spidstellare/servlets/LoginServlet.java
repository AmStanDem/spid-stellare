package com.example.spidstellare.servlets;

import com.example.spidstellare.Entities.User;
import com.example.spidstellare.queries.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginServlet extends HttpServlet
{
    @Override
    public void init()
    {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try
        {
            String [] data = getUserData(req);
            if (Query.userExistence(data[0]))
            {
                System.out.println(Query.getHashedPassword(data[0]));
                if (BCrypt.checkpw(data[1],Query.getHashedPassword(data[0])))
                {
                    resp.getWriter().println("Loggato");
                    HttpSession session = req.getSession();
                    session.setAttribute("email",data[0]);
                    session.setAttribute("logged",true);
                    resp.sendRedirect("personal.jsp");
                }
            }


        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }

    private String[] getUserData (HttpServletRequest req) throws ParseException {

        String email = req.getParameter("email");
        String psw = req.getParameter("psw");

        return new String[]{email,psw};
    }
}
