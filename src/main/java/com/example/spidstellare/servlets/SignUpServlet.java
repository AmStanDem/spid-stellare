package com.example.spidstellare.servlets;

import com.example.spidstellare.Entities.*;
import com.example.spidstellare.queries.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignUpServlet extends HttpServlet
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
        User newUser = null;
        try
        {
            newUser = getUserData(req);
            if (!Query.userExistence(newUser.getEmail()))
            {
                Query.insertUser(newUser);
                resp.setStatus(resp.SC_ACCEPTED);
                resp.setHeader("Location","index.jsp");
                resp.sendRedirect("index.jsp");
            }


        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }

    private User getUserData (HttpServletRequest req) throws ParseException {

        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String email = req.getParameter("email");
        String psw = req.getParameter("psw");
        int id_razza = Integer.parseInt(req.getParameter("id_razza").trim());
        int id_pianeta = Integer.parseInt(req.getParameter("id_pianeta").trim());
        boolean genere = req.getParameter("genere").equals("M");
        Date dt_nascita = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dt_nascita"));


        return new User(nome,cognome,email,
                        psw,id_pianeta,id_razza,
                        genere, dt_nascita);
    }

}
