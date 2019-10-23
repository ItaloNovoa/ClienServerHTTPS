package arem.lab5.demo.Repository;

import java.sql.SQLException;
import java.util.*;

import arem.lab5.demo.POJOS.Usuario;


public interface UserR {
    public List<Usuario> findAll() throws SQLException ;
    public Boolean añadirUsuario(String name,String lastName)  throws SQLException ;
    public Boolean logear(String name,String lastName) throws SQLException ;
}