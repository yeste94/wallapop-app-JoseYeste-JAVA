package Componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.*;
import GUI.Frame.*;
import Servicios.Conexion;
/**
 * 
 * @author Jose Yeste
 * Controlador de Eventos del Frame Principal "WallapopFrame"
 */
public class Controler implements ActionListener{
	
	private WallapopFrame frame;
	private WallapopFrameAdmin adminFrame;
	public Controler(WallapopFrame frame){
		this.frame=frame;
	}
	public Controler(){
		
	}
	/**
	 * 
	 * @param wallapopFrameAdmin
	 * Constructor en la que se le introduce el frame.
	 */
	public Controler(WallapopFrameAdmin wallapopFrameAdmin) {
		this.adminFrame=wallapopFrameAdmin;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()) {
		case "boton_delante"://En caso de pulsar el boton hacia delante muestra la siguiente pagina
			frame.setPaginaAMostrar(frame.getPaginaAMostrar()+1);
			frame.actualizarPantalla();
			break;
			
		case "boton_atras"://En caso de pulsar el boton hacia atras muentra la pagina anterior
			frame.setPaginaAMostrar(frame.getPaginaAMostrar()-1);
			frame.actualizarPantalla();
			break;
		//Al dar al boton de buscar, muestra los articulo con el nombre que hemos introducido en le TextField buscar. 
		case "buscar":
			System.out.println("Buscar");
			frame.setQueryArticulo("SELECT p FROM Articulo p WHERE p.nombre like '"+frame.getTxtBuscar().getText()+"%'");//Cambia la quey a ejecutar
			frame.actualizarPantalla();
			break;
		//Al dar al boton salir vuelve a la pagina para logearse.
		case "salir":
			WallapopFrameLogin f = new WallapopFrameLogin();
			f.setVisible(true);
			this.frame.setVisible(false);
			break;
			//Al pulsar sobre una categoria muestra las subcategorias relacionadas a la categoria.
		case "categorias":
			String categoria=frame.getCategorias().getSelectedItem().toString();
			if(!categoria.equals("----Categorias----")){
				//frame.setQueryArticulo("SELECT ");
			}
			break;
		case "addArticulo":
			System.out.println("Añadir Articulo");
			AddArticulo addArticulo = new AddArticulo();
			addArticulo.setVisible(true);
			break;
			
		case "eliminarArticulo":
			System.out.println("Eliminar Articulo");
			break;
		default:
			int pag=Integer.parseInt(arg0.getActionCommand());
			frame.actualizarPantalla(pag);
			break;
		}
	}

}
