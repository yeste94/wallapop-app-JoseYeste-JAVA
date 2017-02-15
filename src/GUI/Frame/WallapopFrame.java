package GUI.Frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.*;
import Servicios.Articulo;
import Servicios.Categoria;
import Servicios.Conexion;
import Servicios.*;
/**
 * 
 * @author Jose Yeste
 *	Panel principal para los usuarios que no sean admin. 
 */
public class WallapopFrame extends JFrame{

	private JTextFieldBuscar txtBuscar;
	private int tamanyoPagina = 2;
	private int paginaAMostrar = 0;
	 
	private JPanel panel;
	private JPanel panel_1;
	private Controler c=new Controler(this);
	private JComboBox categorias;
	
	
	private String queryCategoria="SELECT p FROM Categoria p";
	private String queryArticulo="SELECT p FROM Articulo p";
	
	public WallapopFrame(){
		this.setTitle("Wallapop Jose");
		this.setBounds(100, 100, 900, 512);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Conexion a hibernate
		
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		JMenuBar menuBar = new JMenuBar();
		
		this.setJMenuBar(menuBar);
		categorias = new JComboBox();
		categorias.addItem("----Categorias----");
		categorias.setActionCommand("categorias");
		categorias.addActionListener(c);
		
		Query query = s.createQuery(this.queryCategoria);
		//Listado de categorias		
		
		List<Categoria> listDatos = query.list();
		System.out.println(listDatos.size());
		 for (Categoria datos : listDatos) {
			 categorias.addItem(datos.getNombre());
		 
		 }
		
		
		menuBar.add(categorias);
		
		txtBuscar = new JTextFieldBuscar();
		txtBuscar.setLocation(40, 40);
		txtBuscar.setPlaceholder("Buscar");
		menuBar.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("buscar");
		btnBuscar.addActionListener(c);
		menuBar.add(btnBuscar);
		this.getContentPane().setLayout(new BorderLayout(0,0));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setActionCommand("salir");
		btnExit.addActionListener(c);
		menuBar.add(btnExit);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		 panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		addArticulo();
		
		
		paginated();
			
	
	}
	
	
	
	public void paginated(){
		//Añade el panel para los botones del paginado
		panel_1 = new JPanel();
		this.getContentPane().add(panel_1, BorderLayout.SOUTH);
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Query query1 = s.createQuery(this.queryArticulo);
		
		 List<Articulo> listDatos = query1.list();
		
		 if(paginaAMostrar==0){
				JButton button = new JButton("<");
				button.setActionCommand("boton_atras");
				panel_1.add(button);
				button.setEnabled(false);
		 }else{
				JButton button = new JButton("<");
				button.setActionCommand("boton_atras");
				button.addActionListener(c);
				panel_1.add(button);
				button.setEnabled(true);
		 }


		
		int numPag=(int) Math.ceil( ( ( (double)listDatos.size())/2 ) );
		for(int i=0;i<numPag;i++){
			JButton button_1 = new JButton((i+1)+"");
			button_1.setActionCommand((i)+"");
			button_1.addActionListener(c);
			panel_1.add(button_1);
		}
		
		
		if(paginaAMostrar>=numPag-1){
			JButton button_2 = new JButton(">");
			button_2.setActionCommand("boton_delante");
			panel_1.add(button_2);
			button_2.setEnabled(false);
		}else{
			JButton button_2 = new JButton(">");
			button_2.setActionCommand("boton_delante");
			button_2.addActionListener(c);
			panel_1.add(button_2);
			button_2.setEnabled(true);
		}
	}
	
	public void actualizarPantalla(){
		System.out.println(paginaAMostrar);
		panel.removeAll();
        panel.updateUI();
        panel.repaint();
		addArticulo();
		
		this.validate();
		//
		panel_1.removeAll();
		
		paginated();
		this.validate();
	}
	public void actualizarPantalla(int pag){
		System.out.println(paginaAMostrar);
		paginaAMostrar=pag;
		panel.removeAll();
        panel.updateUI();
        panel.repaint();
		addArticulo();
		this.validate();
		//
		panel_1.removeAll();
		
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
			int contNombre=2;
			int contImagen=1;
				
		for (Articulo datos : articulos) {    
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\troya\\Desktop\\icon.png"));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = contImagen;
			gbc_label.gridy = 0;
			panel.add(label, gbc_label);
			
			JLabel lblNewLabel = new JLabel("<html>"+datos.getNombre()+"<br>"+"Precio:"+datos.getPrecio()+"</html>");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = contNombre;
			gbc_lblNewLabel.gridy = 0;
			panel.add(lblNewLabel, gbc_lblNewLabel);
			
			contNombre=6;
			contImagen=5;
			
			//Añade componente para que haya espacio entre articulo y articulo
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			GridBagConstraints gbc_rigidArea = new GridBagConstraints();
			gbc_rigidArea.insets = new Insets(0, 0, 0, 5);
			gbc_rigidArea.gridx = 3;
			gbc_rigidArea.gridy = 0;
			panel.add(rigidArea, gbc_rigidArea);
			
			Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
			GridBagConstraints gbc_rigidArea_1 = new GridBagConstraints();
			gbc_rigidArea_1.insets = new Insets(0, 0, 0, 5);
			gbc_rigidArea_1.gridx = 4;
			gbc_rigidArea_1.gridy = 0;
			panel.add(rigidArea_1, gbc_rigidArea_1);
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
	
}
