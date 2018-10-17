package prueba;

import entidades.Contacto;
import servicios.ContactoDAO;

public class pruebaDao {

	public pruebaDao() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto contacto = new Contacto();
		
		contacto.setEmail("yyy@xxx.com");
		contacto.setMensaje("Mensaje de prueba 2");
		contacto.setSitio("www.xxxyyy.xom");
		contacto.setNombre("xxxx yyy");
		contacto.setId(1);
		
		ContactoDAO contactoDAO = new ContactoDAO();
		
		contactoDAO.insertar(contacto);
		
		contacto = contactoDAO.buscar(2);
		
		System.out.println(contacto.getNombre());
		
		System.out.println(contactoDAO.listar().size());
		
	}

}
