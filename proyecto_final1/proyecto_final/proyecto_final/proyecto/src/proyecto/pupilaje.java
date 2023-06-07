package proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class pupilaje
 */
@WebServlet("/pupilaje")
public class pupilaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pupilaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Connection conn=null;
  	String user="root";
  	String driver="com.mysql.cj.jdbc.Driver";
  	String pwd="";
  	String url="jdbc:mysql://localhost:3306/caballos?serverTimezone=UTC";
  	
      public void init(ServletConfig config) throws ServletException{
  		try {
  		    Class.forName(driver);
  			conn=DriverManager.getConnection(url,user,pwd);
  			JOptionPane.showMessageDialog(null,"hemos conectado");
  		} 
  		catch (ClassNotFoundException e1) {
  		            //Error si no puedo leer el driver de Oracle 
  			JOptionPane.showMessageDialog(null, "ERROR:No encuentro el driver de la BD: "+
  					e1.getMessage());
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      }
      protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      String nombre;
      String nacimiento=null;
      String herrado=null;
      String veterinario=null;
      String desparasitado=null;
      String pienso=null;
      String nacimiento2=null;
      String herrado2=null;
      String veterinario2=null;
      String desparasitado2=null;
      String pienso2=null;
      PreparedStatement actualizar;
      PreparedStatement obtain;
      PreparedStatement obtains;
      ResultSet obtener;
      ResultSet obten;
      PrintWriter out;
		out=response.getWriter();
		datos_pupilaje d=(datos_pupilaje) new datos_pupilaje();
   	 ArrayList<datos_pupilaje>listas=new ArrayList<datos_pupilaje>();
   	 ArrayList<datos_pupilaje>listas1=new ArrayList<datos_pupilaje>();
   	 ArrayList<datos_pupilaje>listas2=new ArrayList<datos_pupilaje>();
   	 ArrayList<datos_pupilaje>listas3=new ArrayList<datos_pupilaje>();

		nombre=request.getParameter("1");
		JOptionPane.showMessageDialog(null, nombre);
		nacimiento=request.getParameter("nacimiento");
		JOptionPane.showMessageDialog(null, nacimiento);
		herrado=request.getParameter("herrado");
		veterinario=request.getParameter("veterinario");
		desparasitado=request.getParameter("desparasitado");
		pienso=request.getParameter("pienso");
      	try {
      		out.println("<html>");
      		out.println("<head><title>service</title></head>");
      		out.println("<body>");
      	 if( nacimiento.length()==0 && herrado.length()==0 && veterinario.length()==0 && desparasitado.length()==0 && pienso.length()==0) {
				JOptionPane.showMessageDialog(null, "ha entrado aqui");
				obtains=conn.prepareStatement(
	  					"select fecha_nacimiento,fecha_herrado,fecha_veterinario,fecha_desparasitado,fecha_pienso from `datos_pupilaje` where id=?;");
	  			obtains.setString(1, nombre);
	  			obtener=obtains.executeQuery();
	  			while(obtener.next()) {
	  				nacimiento2=obtener.getString("fecha_nacimiento");
	  				herrado2=obtener.getString("fecha_herrado");
	  				veterinario2=obtener.getString("fecha_veterinario");
		  			desparasitado2=obtener.getString("fecha_desparasitado");
		  			pienso2=obtener.getString("fecha_pienso");
	  			}
	  			if(nombre.length()!=0 && nombre.equals("relampago")) {
		  			d.setFecha_nacimiento(nacimiento2);
		  			d.setFecha_herrado(herrado2);
			  		d.setFecha_veterinario(veterinario2);
			  		d.setFecha_desparasitado(desparasitado2);
			  		d.setFecha_pienso(pienso2);
			  		listas.add(d);
					request.getSession().setAttribute("lista", listas);
				response.sendRedirect("relampago.jsp");
			  		}else if(nombre.length()!=0 && nombre.equals("capricho")) {
			  			d.setFecha_nacimiento(nacimiento2);
			  			d.setFecha_herrado(herrado2);
				  		d.setFecha_veterinario(veterinario2);
				  		d.setFecha_desparasitado(desparasitado2);
				  		d.setFecha_pienso(pienso2);
				  		listas1.add(d);
						request.getSession().setAttribute("lista1", listas1);
						response.sendRedirect("capricho.jsp");
		  			}else if(nombre.length()!=0 && nombre.equals("pellizco")) {
		  				d.setFecha_nacimiento(nacimiento2);
		  	  			d.setFecha_herrado(herrado2);
		  		  		d.setFecha_veterinario(veterinario2);
		  		  		d.setFecha_desparasitado(desparasitado2);
		  		  		d.setFecha_pienso(pienso2);
		  		  		listas2.add(d);
						request.getSession().setAttribute("lista2", listas2);
						response.sendRedirect("pellizco.jsp");
		  			}else if(nombre.length()!=0 && nombre.equals("marengo")) {
		  				d.setFecha_nacimiento(nacimiento2);
		  	  			d.setFecha_herrado(herrado2);
		  		  		d.setFecha_veterinario(veterinario2);
		  		  		d.setFecha_desparasitado(desparasitado2);
		  		  		d.setFecha_pienso(pienso2);
		  		  		listas3.add(d);
						request.getSession().setAttribute("lista3", listas3);
						response.sendRedirect("marengo.jsp");
		  			}
      	}else if(nombre.length()!=0 && nacimiento.length()!=0  && herrado.length()!=0  && veterinario.length()!=0  && desparasitado.length()!=0  && pienso.length()!=0 ) {
  			actualizar=conn.prepareStatement(
  					"update `datos_pupilaje` set fecha_nacimiento='"+nacimiento+"',fecha_herrado='"+herrado+"',fecha_veterinario='"+veterinario+"',fecha_desparasitado='"+desparasitado+"',fecha_pienso='"+pienso+"'where id='"+nombre+"';"
  					);
  			actualizar.executeUpdate();
  			JOptionPane.showMessageDialog(null, "se ha actualizado");
  			obtain=conn.prepareStatement(
  					"select fecha_nacimiento,fecha_herrado,fecha_veterinario,fecha_desparasitado,fecha_pienso from `datos_pupilaje` where id=?;");

  			obtain.setString(1, nombre);
  			obtener=obtain.executeQuery();
  			while(obtener.next()) {
  				nacimiento2=obtener.getString("fecha_nacimiento");
  				herrado2=obtener.getString("fecha_herrado");
	  			veterinario2=obtener.getString("fecha_veterinario");
	  			desparasitado2=obtener.getString("fecha_desparasitado");
	  			pienso2=obtener.getString("fecha_pienso");
  			}
  			 if(nombre.length()!=0 && nombre.equals("relampago")) {
	  			d.setFecha_nacimiento(nacimiento2);
	  			d.setFecha_herrado(herrado2);
		  		d.setFecha_veterinario(veterinario2);
		  		d.setFecha_desparasitado(desparasitado2);
		  		d.setFecha_pienso(pienso2);
		  		listas.add(d);
				request.getSession().setAttribute("lista", listas);
			response.sendRedirect("relampago.jsp");
		  		}else if(nombre.length()!=0 && nombre.equals("capricho")) {
		  			d.setFecha_nacimiento(nacimiento2);
		  			d.setFecha_herrado(herrado2);
			  		d.setFecha_veterinario(veterinario2);
			  		d.setFecha_desparasitado(desparasitado2);
			  		d.setFecha_pienso(pienso2);
			  		listas1.add(d);
					request.getSession().setAttribute("lista1", listas1);
					response.sendRedirect("capricho.jsp");
	  			}else if(nombre.length()!=0 && nombre.equals("pellizco")) {
	  				d.setFecha_nacimiento(nacimiento2);
	  	  			d.setFecha_herrado(herrado2);
	  		  		d.setFecha_veterinario(veterinario2);
	  		  		d.setFecha_desparasitado(desparasitado2);
	  		  		d.setFecha_pienso(pienso2);
	  		  		listas2.add(d);
					request.getSession().setAttribute("lista2", listas2);
					response.sendRedirect("pellizco.jsp");
	  			}else if(nombre.length()!=0 && nombre.equals("marengo")) {
	  				d.setFecha_nacimiento(nacimiento2);
	  	  			d.setFecha_herrado(herrado2);
	  		  		d.setFecha_veterinario(veterinario2);
	  		  		d.setFecha_desparasitado(desparasitado2);
	  		  		d.setFecha_pienso(pienso2);
	  		  		listas3.add(d);
					request.getSession().setAttribute("lista3", listas3);
					response.sendRedirect("marengo.jsp");
	  			}
      	}else {
      		StringBuilder sqlBuilder= new StringBuilder("update `datos_pupilaje` set ");
          	if(!nacimiento.isEmpty()) {
          		sqlBuilder.append("fecha_nacimiento = ?, ");
          	}
         	if(!herrado.isEmpty()) {
          		sqlBuilder.append("fecha_herrado = ?, ");
          	}
         	if(!veterinario.isEmpty()) {
          		sqlBuilder.append("fecha_veterinario = ?, ");
          	}
         	if(!desparasitado.isEmpty()) {
          		sqlBuilder.append("fecha_desparasitado = ?, ");
          	}
         	if(!pienso.isEmpty()) {
          		sqlBuilder.append("fecha_pienso = ?, ");
          	}
         	sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length()); 
          		
         	sqlBuilder.append("WHERE id='"+nombre+"';");

         	String sql = sqlBuilder.toString();	
         	PreparedStatement statement = conn.prepareStatement(sql);

         	int index = 1;

         	if (!nacimiento.isEmpty()) {
         	    statement.setString(index++, nacimiento);
         	}

         	if (!herrado.isEmpty()) {
         	    statement.setString(index++, herrado);
         	}
        	if (!veterinario.isEmpty()) {
         	    statement.setString(index++, veterinario);
         	}
         	if (!desparasitado.isEmpty()) {
         	    statement.setString(index++, desparasitado);
         	}

         	if (!pienso.isEmpty()) {
         	    statement.setString(index++, pienso);
         	}

         	// Ejecuta la actualizaci�n
         	statement.executeUpdate();
         	obtain=conn.prepareStatement(
    					"select fecha_nacimiento,fecha_herrado,fecha_veterinario,fecha_desparasitado,fecha_pienso from `datos_pupilaje` where id=?;");

    			obtain.setString(1, nombre);
    			obten=obtain.executeQuery();
        	while(obten.next()) {
    			nacimiento2=obten.getString("fecha_nacimiento");
    			herrado2=obten.getString("fecha_herrado");
      			veterinario2=obten.getString("fecha_veterinario");
      			desparasitado2=obten.getString("fecha_desparasitado");
      			pienso2=obten.getString("fecha_pienso");
    			}
    			 if(nombre.length()!=0 && nombre.equals("relampago")) {
      			d.setFecha_nacimiento(nacimiento2);
      			d.setFecha_herrado(herrado2);
    	  		d.setFecha_veterinario(veterinario2);
    	  		d.setFecha_desparasitado(desparasitado2);
    	  		d.setFecha_pienso(pienso2);
    	  		listas.add(d);
    			request.getSession().setAttribute("lista", listas);
    		response.sendRedirect("relampago.jsp");
    	  		}else if(nombre.length()!=0 && nombre.equals("capricho")) {
    	  			d.setFecha_nacimiento(nacimiento2);
    	  			d.setFecha_herrado(herrado2);
    		  		d.setFecha_veterinario(veterinario2);
    		  		d.setFecha_desparasitado(desparasitado2);
    		  		d.setFecha_pienso(pienso2);
    		  		listas1.add(d);
    				request.getSession().setAttribute("lista1", listas1);
    				response.sendRedirect("capricho.jsp");
      			}else if(nombre.length()!=0 && nombre.equals("pellizco")) {
      				d.setFecha_nacimiento(nacimiento2);
      	  			d.setFecha_herrado(herrado2);
      		  		d.setFecha_veterinario(veterinario2);
      		  		d.setFecha_desparasitado(desparasitado2);
      		  		d.setFecha_pienso(pienso2);
      		  		listas2.add(d);
    				request.getSession().setAttribute("lista2", listas2);
    				response.sendRedirect("pellizco.jsp");
      			}else if(nombre.length()!=0 && nombre.equals("marengo")) {
      				d.setFecha_nacimiento(nacimiento2);
      	  			d.setFecha_herrado(herrado2);
      		  		d.setFecha_veterinario(veterinario2);
      		  		d.setFecha_desparasitado(desparasitado2);
      		  		d.setFecha_pienso(pienso2);
      		  		listas3.add(d);
    				request.getSession().setAttribute("lista3", listas3);
    				response.sendRedirect("marengo.jsp");
      			}
      	}
      		}catch (Exception e) {
      			JOptionPane.showMessageDialog(null, "no se ha actualizado, solo se aceptan datos en formato de fecha");
    			response.sendRedirect("acceso_pupilaje.jsp");
      			System.out.println(e);
      		}
      }
}
      