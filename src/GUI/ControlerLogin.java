package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.accessibility.AccessibleIcon;

import org.hibernate.Query;
import org.hibernate.Session;

import Servicios.Conexion;
import Servicios.Usuario;


public class ControlerLogin implements ActionListener{
	private WallapopFrameLogin frame;
	
	public ControlerLogin(WallapopFrameLogin frame){
		this.frame=frame;
	}
	public ControlerLogin(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		switch (arg0.getActionCommand()) {
		case "btn_login":
			System.out.println("Mandar a otra pagina");
			Conexion con=new Conexion();
			Session s=con.getSession();
			String mail=frame.getMail().getText();
			String pass=frame.getPass().getText();
			
			
			Query query = s.createQuery("SELECT p FROM Usuario p WHERE p.mail='"+mail+"' and p.pass='"+pass+"'");
			
			 List<Usuario> listDatos = query.list();
			 System.out.println(listDatos.size());
			if(listDatos.size()>0){
				WallapopFrame frame = new WallapopFrame();
				frame.setVisible(true);
				this.frame.setVisible(false);
				System.out.println("Usuario correcto");
			}else{
				System.out.println("Usuario incorrecto");
			}

			
			break;

		default:
			
			break;
		}
		
	}

}
