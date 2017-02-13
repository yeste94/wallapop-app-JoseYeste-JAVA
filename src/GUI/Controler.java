package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import Servicios.Conexion;

public class Controler implements ActionListener{
	private WallapopFrame frame;
	
	public Controler(WallapopFrame frame){
		this.frame=frame;
	}
	public Controler(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()) {
		case "boton_delante":
			frame.setPaginaAMostrar(frame.getPaginaAMostrar()+1);
			frame.actualizarPantalla();
			break;
		case "boton_atras":
			frame.setPaginaAMostrar(frame.getPaginaAMostrar()-1);
			frame.actualizarPantalla();
			break;
		case "buscar":
			System.out.println("Buscar");
			frame.setQueryArticulo("SELECT p FROM Articulo p WHERE p.nombre like '"+frame.getTxtBuscar().getText()+"%'");
			System.out.println(frame.getQueryArticulo());
			frame.actualizarPantalla();
			break;
		case "salir":
			WallapopFrameLogin f = new WallapopFrameLogin();
			f.setVisible(true);
			this.frame.setVisible(false);
		default:
			int pag=Integer.parseInt(arg0.getActionCommand());
			frame.actualizarPantalla(pag);
			break;
		}
	}

}
