package arem.lab5.demo;

import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {

    public List<Usuario> list() throws SQLException;
	
}
