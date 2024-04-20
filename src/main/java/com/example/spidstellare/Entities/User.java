package com.example.spidstellare.Entities;


import java.util.Date;


public class User
{
    private String nome;
    private String cognome;
    private String email;
    private String psw;
    private int id_pianeta;
    private int id_razza;
    private boolean genere;
    private Date dt_nascita;

    public User()
    {
    }

    public User(String nome, String cognome, String email, String psw, int id_pianeta, int id_razza, boolean genere, Date dt_nascita)
    {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.psw = psw;
        this.id_pianeta = id_pianeta;
        this.id_razza = id_razza;
        this.genere = genere;
        this.dt_nascita = dt_nascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    public int getId_pianeta() {
        return id_pianeta;
    }

    public int getId_razza() {
        return id_razza;
    }

    public boolean isGenere() {
        return genere;
    }

    public Date getDt_nascita() {
        return dt_nascita;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", psw='" + psw + '\'' +
                ", id_pianeta=" + id_pianeta +
                ", id_razza=" + id_razza +
                ", genere=" + genere +
                ", dt_nascita=" + dt_nascita +
                '}';
    }
}
