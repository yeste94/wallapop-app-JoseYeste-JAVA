package GUI.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.JTextFieldBuscar;
import Servicios.Conexion;
import Servicios.Localidad;
import Servicios.Provincia;

public class AddLocalidad extends JFrame implements ActionListener{
	private JTextFieldBuscar txtNombre;
	
	WallapopFrameAdmin wallapopAdmin;

	private JButton btnEnviar;

	private JComboBox comboBox;
	
	
	public AddLocalidad(){
		this.setTitle("Añadir Localidad");
		this.setBounds(100, 100, 512, 512);
		
		addElementos();
	}

	
	public void addElementos(){
		
		
		txtNombre = new JTextFieldBuscar();
		txtNombre.setPlaceholder("Nombre");
		txtNombre.setText("");
		txtNombre.setColumns(10);
		
		JLabel lblAadirArticulo = new JLabel("A\u00F1adir Localidad");
		

		
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		

		btnEnviar = new JButton("Enviar");
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Provincia"}));
		
		Query query = s.createQuery("SELECT p FROM Provincia p");
		List<Provincia> listDatos = query.list();
		 
		 for (Provincia datos : listDatos) {
			 comboBox.addItem(datos.getNombre());
		 }
		
		btnEnviar.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnEnviar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAadirArticulo))))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAadirArticulo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnEnviar)
					.addGap(145))
		);
		this.getContentPane().setLayout(groupLayout);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Localidad a=new Localidad();

			
			
			try {
				//Coge el texto de los JTextField y los añade al objeto
				 a.setNombre(txtNombre.getText());
				 a.setProvincia(new Provincia(comboBox.getSelectedItem().toString()));
				 
				 s.save(a);
				 s.getTransaction().commit();
				 this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getParent(), "Atributos erroneos");
			}	
	}
}
