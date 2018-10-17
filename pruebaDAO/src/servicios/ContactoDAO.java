package servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Contacto;
import util.Conexion;

public class ContactoDAO {

	Contacto contacto = new Contacto();
	Conexion con = null;
	List<Contacto> contactos = new ArrayList<Contacto>();
	
	public ContactoDAO() {
		// TODO Auto-generated constructor stub
		con = Conexion.getConexion();
	}
	
	public void insertar(Contacto contacto){
		
		String sql = "INSERT INTO contacto (nombre, email, "
	    		+ "sitio, mensaje) "
	    		+ "VALUES ('"+contacto.getNombre()+"', '"+contacto.getEmail()+"', '"+contacto.getSitio()+"', "
	    		+ "'"+contacto.getMensaje()+"');";
		
		try {
			con.insert(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}
	
	public void actualizar(Contacto contacto){
		String sql = "UPDATE contacto SET nombre = '"+contacto.getNombre()+"', "
				+ "email = '"+contacto.getEmail()+"', "
	    		+ "sitio = '"+contacto.getSitio()+"', "
	    		+ "mensaje = '"+contacto.getMensaje()+"' "
	    			+ "WHERE id = " + contacto.getId() +";";
		System.out.println(sql);
		try {
			con.insert(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminar(Contacto contacto){
		String sql = "DELETE FROM contacto "
			+ "WHERE id = " + contacto.getId() +";";
		System.out.println(sql);
		try {
			con.insert(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Contacto buscar(Integer id){
		
		Contacto contacto = null;
		
		String sql = "SELECT * FROM contacto "
				+ "WHERE id = " + id +";";
			
		ResultSet res;
		try {
			res = con.query(sql);
	  	   	while(res.next()){
		        	    contacto = new Contacto();
		        	    contacto.setId(res.getInt("id"));
		        	    contacto.setNombre(res.getString("nombre"));
		        	    contacto.setEmail(res.getString("email"));
		        	    contacto.setSitio(res.getString("sitio"));
		        	    contacto.setMensaje(res.getString("mensaje"));    	    
	  	   	}
	  	   	res.close();
  	   	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		return contacto;
	}
	
	
public List<Contacto> listar(){
		
		Contacto contacto = null;
		
		String sql = "SELECT * FROM contacto ;";
			
		ResultSet res;
		try {
			res = con.query(sql);
	  	   	while(res.next()){
		        	    contacto = new Contacto();
		        	    contacto.setId(res.getInt("id"));
		        	    contacto.setNombre(res.getString("nombre"));
		        	    contacto.setEmail(res.getString("email"));
		        	    contacto.setSitio(res.getString("sitio"));
		        	    contacto.setMensaje(res.getString("mensaje"));
		        	    contactos.add(contacto);
	  	   	}
	  	   	res.close();
  	   	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		return contactos;
	}
	
	

}
