package arem.lab5.demo.Services;

import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Service;

import arem.lab5.demo.POJOS.Usuario;

@Service
public interface UserServices {

    public List<Usuario> list() throws SQLException;
	
}
