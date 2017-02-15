package Componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.accessibility.AccessibleIcon;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import GUI.Frame.*;
import Servicios.Conexion;
import Servicios.Usuario;


public class ControlerLogin implements ActionListener{
	private WallapopFrameLogin frame;
	
	public ControlerLogin(WallapopFrameLogin frame){
		this.frame=frame;
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()) {
		case "btn_login":
			Conexion con=new Conexion();
			Session s=con.getSession();
			String mail=frame.getMail().getText();
			String pass=frame.getPass().getText();
			
			
			Query query = s.createQuery("SELECT p FROM Usuario p WHERE p.mail='"+mail+"' and p.pass='"+pass+"'");
			
			 List<Usuario> listDatos = query.list();
			 System.out.println(listDatos.size());
			if(listDatos.size()>0){
				 for (Usuario datos : listDatos) {
				     if(datos.isAdmin()){
				    	 WallapopFrameAdmin frame = new WallapopFrameAdmin();
				    	 frame.setVisible(true);
				    	 this.frame.setVisible(false);
				     }else{
							WallapopFrame frame = new WallapopFrame();
							frame.setVisible(true);
							this.frame.setVisible(false);
				     }
				 }
				System.out.println("Usuario correcto");
			}else{
				System.out.println("Usuario incorrecto");
				
				JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrecto.","Login", JOptionPane.INFORMATION_MESSAGE);
			}

			
			break;

		default:
			
			break;
		}
		
	}

}
