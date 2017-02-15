package GUI.Frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.*;
import Servicios.Articulo;
import Servicios.Categoria;
import Servicios.Conexion;
import Servicios.SubCategoria;
/**
 * 
 * @author Jose Yeste
 *	panel principal para usuarios admins
 */
public class WallapopFrameAdmin extends JFrame{
	private JTextFieldBuscar txtBuscar;
	
	private int tamanyoPagina = 2;
	private int paginaAMostrar = 0;
	 
	private JPanel panelPrincipal;
	private JPanel panelInferior;
	
	private ControlerAdmin c=new ControlerAdmin(this);
	private JComboBox categorias;
	private JComboBox SubCategorias;
	
	ArrayList<Integer> art = new ArrayList<Integer>();
	
	private String queryCategoria="SELECT p FROM Categoria p";
	private String queryArticulo="SELECT p FROM Articulo p";
	private String querySubCategoria="SELECT p FROM SubCategoria p";
	
	private JButton btnBuscar;
	private JButton btnExit;
	private JPanel panel_admin;
	private JButton btnAddArticulo;
	private JButton btnAtras;
	private JButton btnDelante;
	private JMenuBar menuBuscar;
	
	/**
	 * Constructor del Frame
	 */
	public WallapopFrameAdmin(){
		this.setTitle("Wallapop Jose----Administrador-----");
		this.setBounds(100, 100, 900, 512);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBuscar();
			
		//Botones de administrador
		panel_admin = new JPanel();
		this.getContentPane().add(panel_admin, BorderLayout.NORTH);
		panel_admin.setLayout(new BoxLayout(panel_admin, BoxLayout.X_AXIS));
		
		btnAddArticulo = new JButton("A\u00F1adir Articulo");
		btnAddArticulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddArticulo.setActionCommand("addArticulo");
		btnAddArticulo.addActionListener(c);
		panel_admin.add(btnAddArticulo);
		
		
		btnAddArticulo = new JButton("A\u00F1adir Categoria");
		btnAddArticulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddArticulo.setActionCommand("addCategoria");
		btnAddArticulo.addActionListener(c);
		panel_admin.add(btnAddArticulo);
		
		btnAddArticulo = new JButton("A\u00F1adir Localidad");
		btnAddArticulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddArticulo.setActionCommand("addLocalidad");
		btnAddArticulo.addActionListener(c);
		panel_admin.add(btnAddArticulo);
		
		btnAddArticulo = new JButton("A\u00F1adir Provincia");
		btnAddArticulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddArticulo.setActionCommand("addProvincia");
		btnAddArticulo.addActionListener(c);
		panel_admin.add(btnAddArticulo);
		
		btnAddArticulo = new JButton("A\u00F1adir SubCategoria");
		btnAddArticulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddArticulo.setActionCommand("addsubCategoria");
		btnAddArticulo.addActionListener(c);
		panel_admin.add(btnAddArticulo);
		
		btnAddArticulo = new JButton("A\u00F1adir Usuario");
		btnAddArticulo.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddArticulo.setActionCommand("addUsuario");
		btnAddArticulo.addActionListener(c);
		panel_admin.add(btnAddArticulo);
		
		panelPrincipal = new JPanel();
		this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelPrincipal.setLayout(gbl_panel);
		
		addArticulo();
		
		paginated();
			
	}
	
	
	public void menuBuscar(){
		//Conexion a hibernate
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		menuBuscar = new JMenuBar();
		
		this.setJMenuBar(menuBuscar);
		categorias = new JComboBox();
		categorias.addItem("----Categorias----");
		categorias.setActionCommand("categorias");
		categorias.addActionListener(c);
		
		
		
		SubCategorias = new JComboBox();
		SubCategorias.addItem("----SubCategorias----");
		//SubCategorias.setEnabled(false);
		SubCategorias.setActionCommand("subCategorias");
		SubCategorias.addActionListener(c);
		
		Query query = s.createQuery(this.queryCategoria);
		
		//Listado de categorias		
		List<Categoria> listDatos = query.list();
		System.out.println(listDatos.size());
		 for (Categoria datos : listDatos) {
			 categorias.addItem(datos.getNombre());
		 
		 }
		
		 Query query1=s.createQuery(this.querySubCategoria);
			List<SubCategoria> listDatos1 = query1.list();
			System.out.println(listDatos1.size());
			 for (SubCategoria datos : listDatos1) {
				 SubCategorias.addItem(datos.getNombre());
			 
			 }
		
		menuBuscar.add(categorias);
		menuBuscar.add(SubCategorias);
		
		txtBuscar = new JTextFieldBuscar();
		txtBuscar.setLocation(40, 40);
		txtBuscar.setPlaceholder("Buscar");
		menuBuscar.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("buscar");
		btnBuscar.addActionListener(c);
		menuBuscar.add(btnBuscar);
		this.getContentPane().setLayout(new BorderLayout(0,0));
		
		btnExit = new JButton("Exit");
		btnExit.setActionCommand("salir");
		btnExit.addActionListener(c);
		menuBuscar.add(btnExit);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
	}
	
	
	
	
	public void paginated(){
		//Añade el panel para los botones del paginado
		panelInferior = new JPanel();
		this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Query query1 = s.createQuery(this.queryArticulo);
		
		 List<Articulo> listDatos = query1.list();
		
		 if(paginaAMostrar==0){
				btnAtras = new JButton("<");
				btnAtras.setActionCommand("boton_atras");
				panelInferior.add(btnAtras);
				btnAtras.setEnabled(false);
		 }else{
			 	btnAtras = new JButton("<");
			 	btnAtras.setActionCommand("boton_atras");
			 	btnAtras.addActionListener(c);
				panelInferior.add(btnAtras);
				btnAtras.setEnabled(true);
		 }


		
		int numPag=(int) Math.ceil( ( ( (double)listDatos.size())/2 ) );
		for(int i=0;i<numPag;i++){
			JButton button_1 = new JButton((i+1)+"");
			button_1.setActionCommand((i)+"");
			button_1.addActionListener(c);
			panelInferior.add(button_1);
		}
		
		
		if(paginaAMostrar>=numPag-1){
			btnDelante = new JButton(">");
			btnDelante.setActionCommand("boton_delante");
			panelInferior.add(btnDelante);
			btnDelante.setEnabled(false);
		}else{
			btnDelante = new JButton(">");
			btnDelante.setActionCommand("boton_delante");
			btnDelante.addActionListener(c);
			panelInferior.add(btnDelante);
			btnDelante.setEnabled(true);
		}
	}
	
	public void actualizarPantalla(){
		art.clear();
		System.out.println(paginaAMostrar);
		
		panelPrincipal.removeAll();
		panelPrincipal.updateUI();
		
		addArticulo();
		
		this.validate();
		//
		panelInferior.removeAll();
		panelInferior.updateUI();
		paginated();
		
		this.validate();
		
		menuBuscar.removeAll();
		menuBuscar.updateUI();
		
		menuBuscar();
		
		this.validate();
		
	}
	public void actualizarPantalla(int pag){
		art.clear();
		System.out.println(paginaAMostrar);
		paginaAMostrar=pag;
		panelPrincipal.removeAll();
		panelPrincipal.updateUI();
		panelPrincipal.repaint();
		addArticulo();
		this.validate();
		//
		panelInferior.removeAll();
		panelInferior.updateUI();
		panelInferior.repaint();
		paginated();
		this.validate();
		

	}

	/**
	 * Añade los articulos al GridBagLayout
	 */
	public void addArticulo(){
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		
		 Query query = s.createQuery(this.queryArticulo);
		 query.setMaxResults(tamanyoPagina);
		 query.setFirstResult(paginaAMostrar * tamanyoPagina);
		 List<Articulo> articulos = query.list();
			int contNombre=2,cont=1;
			int contImagen=1;
				
		for (Articulo datos : articulos) {    
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\troya\\Desktop\\icon.png"));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = contImagen;
			gbc_label.gridy = 0;
			panelPrincipal.add(label, gbc_label);
			
			JButton lblNewLabel_3 = new JButton("");
			lblNewLabel_3.setActionCommand("delete"+cont);
			lblNewLabel_3.addActionListener(c);
			lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\troya\\Desktop\\delete.png"));
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_3.gridx = contImagen+1;
			gbc_lblNewLabel_3.gridy = 0;
			panelPrincipal.add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			JButton label_1 = new JButton("");
			label_1.setActionCommand("edit"+cont);
			
			label_1.addActionListener(c);
			label_1.setIcon(new ImageIcon("C:\\Users\\troya\\Desktop\\edit.png"));
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.NORTH;
			gbc_label_1.insets = new Insets(0, 0, 0, 5);
			gbc_label_1.gridx = contNombre+1;
			gbc_label_1.gridy = 0;
			panelPrincipal.add(label_1, gbc_label_1);
			
			//Label con los datos de los articulos.
			JLabel lblNewLabel = new JLabel("<html>"+datos.getNombre()+"<br>"+"Precio:"+datos.getPrecio()+"</html>");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = contNombre;
			gbc_lblNewLabel.gridy = 0;
			panelPrincipal.add(lblNewLabel, gbc_lblNewLabel);
			
			art.add(datos.getId());
			
			
			contNombre=6;
			contImagen=5;
			cont++;
			
			//Añade componente para que haya espacio entre articulo y articulo
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			GridBagConstraints gbc_rigidArea = new GridBagConstraints();
			gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
			gbc_rigidArea.gridx = 3;
			gbc_rigidArea.gridy = 0;
			panelPrincipal.add(rigidArea, gbc_rigidArea);
			
			Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
			GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
			gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
			gbc_rigidArea_1.gridx = 4;
			gbc_rigidArea_1.gridy = 0;
			panelPrincipal.add(rigidArea_1, gbc_rigidArea_1);
		}
	}
	
	
	public JTextField getTxtBuscar() {
		return txtBuscar;
	}
	public void setTxtBuscar(JTextFieldBuscar txtBuscar) {
		this.txtBuscar = txtBuscar;
	}
	public int getTamanyoPagina() {
		return tamanyoPagina;
	}
	public void setTamanyoPagina(int tamanyoPagina) {
		this.tamanyoPagina = tamanyoPagina;
	}
	public int getPaginaAMostrar() {
		return paginaAMostrar;
	}
	public void setPaginaAMostrar(int paginaAMostrar) {
		this.paginaAMostrar = paginaAMostrar;
	}

	public String getQueryCategoria() {
		return queryCategoria;
	}
	public void setQueryCategoria(String queryCategoria) {
		this.queryCategoria = queryCategoria;
	}
	public String getQueryArticulo() {
		return queryArticulo;
	}
	public void setQueryArticulo(String queryArticulo) {
		this.queryArticulo = queryArticulo;
	}
	public JComboBox getCategorias() {
		return categorias;
	}
	public void setCategorias(JComboBox categorias) {
		this.categorias = categorias;
	}
	public ArrayList<Integer> getArt() {
		return art;
	}
	public void setArt(ArrayList<Integer> art) {
		this.art = art;
	}
	public JComboBox getSubCategorias() {
		return SubCategorias;
	}
	public void setSubCategorias(JComboBox subCategorias) {
		SubCategorias = subCategorias;
	}
	public String getQuerySubCategoria() {
		return querySubCategoria;
	}
	public void setQuerySubCategoria(String querySubCategoria) {
		this.querySubCategoria = querySubCategoria;
	}
	
}
