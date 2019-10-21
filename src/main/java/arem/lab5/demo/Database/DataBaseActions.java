package arem.lab5.demo.Database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import arem.lab5.demo.POJOS.Usuario;
import arem.lab5.demo.Repository.UserR;




@Component
public class DataBaseActions implements UserR {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public List<Usuario> findAll() throws SQLException {
		String query = "SELECT * FROM first_Table;";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getString("id"));
				usuario.setName(rs.getString("firstname"));
				usuario.setLastName(rs.getString("lastname"));
				usuarios.add(usuario);				
			}
			connection.close();
			return usuarios;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	
	}

	@Override
	public Boolean añadirUsuario(String name,String lastName) throws SQLException {
		String query = "SELECT COUNT(firstname) as cantidad From first_Table WHERE firstname='"+name+"' AND lastname='"+lastName+"';";
		int Cantidad=0;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) { 
				 Cantidad= rs.getInt(1);
			}		
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
		if(Cantidad==0){
			query = "INSERT INTO first_Table (firstname, lastname) VALUES ('"+name+"', '"+lastName+"');";
			try {
				connection = dataSource.getConnection();
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(query);			
				connection.close();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}
		}else{
			return false;
		}
		
	}
}