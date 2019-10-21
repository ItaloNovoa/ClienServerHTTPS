package arem.lab5.demo;
import java.sql.SQLException;
import java.util.*;


public interface UserR {
    public List<Usuario> findAll() throws SQLException ;
    public Boolean añadirUsuario(String name,String lastName)  throws SQLException ;
}