package com.example.spidstellare.queries;



import com.example.spidstellare.Entities.User;
import com.example.spidstellare.config.DatabaseConnection;
import org.mindrot.jbcrypt.*;

import java.sql.*;

public class Query
{
    public static boolean userExistence (String email)
    {
        try (Connection connect = DatabaseConnection.initializeDatabase())
        {
            assert connect != null;
            String sql = "SELECT 1 FROM utenti WHERE email = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next())
            {
                i++;
            }
            return i != 0;
        }
        catch (SQLException ignored)
        {

        }
        return true;
    }
    public static String getHashedPassword(String email)
    {
        try (Connection connect = DatabaseConnection.initializeDatabase())
        {
            assert connect != null;
            String sql = "SELECT psw FROM utenti WHERE email = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            String psw = "";
            while (rs.next())
            {
                psw = rs.getString("psw");
            }
            return psw;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static void insertUser (User newUser)
    {
        try (Connection connect = DatabaseConnection.initializeDatabase())
        {
            String sql = "INSERT INTO utenti (nome,cognome,email,psw,id_pianeta,id_razza,genere,dt_nascita) VALUES (?,?,?,?,?,?,?,?)";
            assert connect != null;
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1,newUser.getNome());
            stmt.setString(2,newUser.getCognome());
            stmt.setString(3,newUser.getEmail());
            String password = BCrypt.hashpw(newUser.getPsw(),BCrypt.gensalt(12));
            stmt.setString(4,password);
            stmt.setInt(5,newUser.getId_pianeta());
            stmt.setInt(6,newUser.getId_razza());
            stmt.setBoolean(7, newUser.isGenere());
            Date dt_nascita = new Date(newUser.getDt_nascita().getTime());
            stmt.setDate(8, dt_nascita);
            stmt.execute();
            stmt.close();
        }
        catch (SQLException ignored)
        {
        }
    }
}
