package Componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import GUI.Frame.AddArticulo;
import GUI.Frame.AddCategoria;
import GUI.Frame.AddLocalidad;
import GUI.Frame.AddProvincia;
import GUI.Frame.AddSubcategoria;
import GUI.Frame.EditArticulo;
import GUI.Frame.WallapopFrameAdmin;
import GUI.Frame.WallapopFrameLogin;
import Servicios.Articulo;
import Servicios.Conexion;
import Servicios.SubCategoria;
/**
 * 
 * @author Jose Yeste
 * Clase encargada de controlar los eventos del Frame "WallapopFrameAdmin".
 */
public class ControlerAdmin implements ActionListener{
	
	private WallapopFrameAdmin frame;
	private Integer id;
	private int op;
	private Articulo a;
	private String categoriaSelec;
	
	
	
	public ControlerAdmin(WallapopFrameAdmin frame){
		this.frame=frame;
	}
	public ControlerAdmin(){
		
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
			
			break;

			
		case "categorias":
			categoriaSelec=frame.getCategorias().getSelectedItem().toString();
			if(!categoriaSelec.equals("----Categorias----")){
				frame.getSubCategorias().setEnabled(true);
				
				frame.setQuerySubCategoria("SELECT c FROM SubCategoria c WHERE c.categoria.nombre='"+categoriaSelec+"'");
				frame.actualizarPantalla();
				
				//System.out.println(frame.getQuerySubCategoria());
			}else{
				frame.setQuerySubCategoria("SELECT p FROM SubCategoria p");
				}
				frame.actualizarPantalla();
				
			break;
			
			
		case "subCategorias":
			String subCatego= frame.getSubCategorias().getSelectedItem().toString();
			if(!subCatego.equals("----SubCategorias----")){
				frame.setQueryArticulo("SELECT c FROM Articulo c WHERE c.subCategoria.nombre='"+subCatego+"'");
				System.out.println(frame.getQueryArticulo());
				
				frame.actualizarPantalla();
			}else{
				
			}	
			break;
		case "addsubCategoria":
			AddSubcategoria addSubCategoria= new AddSubcategoria();
			addSubCategoria.setVisible(true);
			break;			
		case "addCategoria":
			AddCategoria addCategoria= new AddCategoria();
			addCategoria.setVisible(true);
			break;
			
		case "addProvincia":
			AddProvincia addProvincia=new AddProvincia();
			addProvincia.setVisible(true);
			break;
			
		case "addArticulo":
			System.out.println("Añadir Articulo");
			AddArticulo addArticulo = new AddArticulo();
			addArticulo.setVisible(true);
			break;
			
		case "addLocalidad":
			AddLocalidad addLocalidad=new AddLocalidad();
			addLocalidad.setVisible(true);
			break;
			
		case "delete1":
			op = JOptionPane.showConfirmDialog(frame, "Seguro que quieres eliminar el articulo");
			id=frame.getArt().get(0);
			a=new Articulo();
			a.setId(id);
			if(op == JOptionPane.YES_OPTION){
				Conexion con=new Conexion();
				Session s=con.getSession();
				
				s.delete(a);
				s.getTransaction().commit();
				frame.actualizarPantalla();
			}
			
			break;
		case "delete2":
			op = JOptionPane.showConfirmDialog(frame, "Seguro que quieres eliminar el articulo");
			id=frame.getArt().get(1);
			 a=new Articulo();
			a.setId(id);
			if(op == JOptionPane.YES_OPTION){
				Conexion con=new Conexion();
				Session s=con.getSession();
				
				s.delete(a);
				s.getTransaction().commit();
				frame.actualizarPantalla();
			}
			
			break;
		case "edit1":
			id=frame.getArt().get(0);
			EditArticulo ea=new EditArticulo(id);
			ea.setVisible(true);
			
			System.out.println("Hay que editar");
			break;
		case "edit2":
			id=frame.getArt().get(1);
			System.out.println(id);
			EditArticulo ea2=new EditArticulo(id);
			ea2.setVisible(true);
			
			System.out.println("Hay que editar");
			break;
			
			
			
		default:
			int pag=Integer.parseInt(arg0.getActionCommand());
			frame.actualizarPantalla(pag);
			break;
		}
	}

}
