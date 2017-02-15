package GUI.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.JTextFieldBuscar;
import Servicios.Articulo;
import Servicios.Categoria;
import Servicios.Conexion;
import Servicios.Localidad;
import Servicios.SubCategoria;
import Servicios.Usuario;

public class AddCategoria extends JFrame implements ActionListener{
	private JTextFieldBuscar txtNombre;
	
	WallapopFrameAdmin wallapopAdmin;
	
	private JTextArea txtrDescripcion;

	
	public AddCategoria(){
		this.setTitle("Añadir Categoria");
		this.setBounds(100, 100, 512, 512);
		
		addElementos();
	}

	
	public void addElementos(){
		
		
		txtNombre = new JTextFieldBuscar();
		txtNombre.setPlaceholder("Nombre");
		txtNombre.setText("");
		txtNombre.setColumns(10);
		
		JLabel lblAadirArticulo = new JLabel("A\u00F1adir Categoria");
		

		
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setText("Descripcion");
		

		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(177)
					.addComponent(lblAadirArticulo)
					.addContainerGap(171, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
					.addComponent(btnEnviar)
					.addGap(45))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(328, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAadirArticulo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnviar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtrDescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
		);
		this.getContentPane().setLayout(groupLayout);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Categoria a=new Categoria();
		int max = 0;
		Query query = s.createQuery("SELECT p FROM Categoria p order by p.id desc");
		 List<Categoria> listDatos = query.list();
		 for (Categoria datos : listDatos) {
			 max=datos.getId();
			 break;
		 }
		
			Conexion con1=new Conexion();
			Session s1=con1.getSession();
			
			
			try {
				//Coge el texto de los JTextField y los añade al objeto
				
				 a.setId(max+1);
				 a.setNombre(txtNombre.getText());
				 a.setDescripcion(txtrDescripcion.getText());
				 
				 s1.save(a);
				 s1.getTransaction().commit();
				 this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getParent(), "Atributos erroneos");
			}
			
			
			

	}
	
	
	
}
