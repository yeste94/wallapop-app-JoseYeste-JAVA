package GUI.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.JTextFieldBuscar;
import GUI.Frame.*;
import Servicios.*;
import Servicios.Conexion;
import Servicios.Localidad;
import Servicios.SubCategoria;
import Servicios.Usuario;
/**
 * 
 * @author Jose Yeste
 * Clase encargada de Añadir articulo segun los datos introducidos.
 */
public class AddArticulo extends JFrame implements ActionListener{
	private JTextFieldBuscar txtNombre;
	private JTextFieldBuscar txtPrecio;
	
	WallapopFrameAdmin wallapopAdmin;
	
	private JCheckBox chckbxEnvio;
	private JCheckBox chckbxIntercambio;
	private JCheckBox chckbxNegociable;
	private JTextArea txtrDescripcion;
	private JComboBox comboBoxLocalidad;
	private JComboBox comboBoxSubCategoria;

	private String querySubCategoria="SELECT p FROM SubCategoria p";
	private String querySubLocalidad="SELECT c FROM Localidad c";
	
	public AddArticulo(){
		this.setTitle("Añadir Articulo");
		this.setBounds(100, 100, 512, 512);
		
		addElementos();
	}

	
	public void addElementos(){
		
		
		txtNombre = new JTextFieldBuscar();
		txtNombre.setPlaceholder("Nombre");
		txtNombre.setText("");
		txtNombre.setColumns(10);
		
		JLabel lblAadirArticulo = new JLabel("A\u00F1adir Articulo");
		
		txtPrecio = new JTextFieldBuscar();
		txtPrecio.setPlaceholder("Precio");
		txtPrecio.setText("");
		txtPrecio.setColumns(10);
		
		chckbxEnvio = new JCheckBox("Envio");
		
		chckbxIntercambio = new JCheckBox("Intercambio");
		
		chckbxNegociable = new JCheckBox("Negociable");
		
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setText("Descripcion");
		
		comboBoxLocalidad = new JComboBox();
		comboBoxLocalidad.setModel(new DefaultComboBoxModel(new String[] {"--Localidad--"}));
		
		
		 Query query = s.createQuery(this.querySubLocalidad);
		 List<Localidad> listDatos = query.list();
		 
		 for (Localidad datos : listDatos) {
			 comboBoxLocalidad.addItem(datos.getNombre());
		 }
			
		
		
		comboBoxSubCategoria = new JComboBox();
		comboBoxSubCategoria.setModel(new DefaultComboBoxModel(new String[] {"--Subcategoria--"}));
		

		
		
		 Query query1=s.createQuery(this.querySubCategoria);
			List<SubCategoria> listDatos1 = query1.list();
			System.out.println(listDatos1.size());
			 for (SubCategoria datos : listDatos1) {
				 comboBoxSubCategoria.addItem(datos.getId());
			 
			 }
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addComponent(lblAadirArticulo))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtrDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxEnvio)
								.addComponent(chckbxIntercambio)
								.addComponent(chckbxNegociable))
							.addGap(60)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEnviar)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(comboBoxLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxSubCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAadirArticulo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxEnvio)
						.addComponent(comboBoxLocalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxSubCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxIntercambio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxNegociable)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtrDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnEnviar)))
					.addGap(70))
		);
		this.getContentPane().setLayout(groupLayout);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Articulo a=new Articulo();
		int max = 0;
		Query query = s.createQuery("SELECT p FROM Articulo p order by p.id desc");
		 List<Articulo> listDatos = query.list();
		 for (Articulo datos : listDatos) {
			 max=datos.getId();
			 break;
		 }
		
			Conexion con1=new Conexion();
			Session s1=con1.getSession();
			
			Localidad localidad=(Localidad)s1.get(Localidad.class, (Serializable) comboBoxLocalidad.getSelectedItem());
			
			try {
				SubCategoria subCat=(SubCategoria)s1.get(SubCategoria.class, (Serializable) comboBoxSubCategoria.getSelectedItem());
				//Coge el texto de los JTextField y los añade al objeto
				 a.setId(max+1);
				 a.setNombre(txtNombre.getText());
				 a.setDescripcion(txtrDescripcion.getText());
				 a.setPrecio(new BigDecimal(txtPrecio.getText()));
				 a.setEnvio(chckbxEnvio.isSelected());
				 a.setIntercambio(chckbxIntercambio.isSelected());
				 a.setNegociable(chckbxNegociable.isSelected());
				 a.setLocalidad(localidad);
				 a.setUsuario(new Usuario("admin"));
				 a.setSubCategoria(subCat);
				 a.setVenta(Timestamp.valueOf("2017-02-14 00:04:12"));
				 
				 s1.save(a);
				 s1.getTransaction().commit();
				 this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getParent(), "Atributos erroneos");
			}
			
			wallapopAdmin.actualizarPantalla();
			

	}
}
