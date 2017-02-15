package GUI.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Query;
import org.hibernate.Session;

import Componentes.JTextFieldBuscar;
import Servicios.Categoria;
import Servicios.Conexion;
import Servicios.Provincia;

public class AddProvincia extends JFrame implements ActionListener{
	private JTextFieldBuscar txtNombre;
	
	WallapopFrameAdmin wallapopAdmin;
	
	
	public AddProvincia(){
		this.setTitle("Añadir Provincia");
		this.setBounds(100, 100, 512, 512);
		
		addElementos();
	}

	
	public void addElementos(){
		
		
		txtNombre = new JTextFieldBuscar();
		txtNombre.setPlaceholder("Nombre");
		txtNombre.setText("");
		txtNombre.setColumns(10);
		
		JLabel lblAadirArticulo = new JLabel("A\u00F1adir Provincia");
		

		
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		

		
		
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
					.addGap(157))
		);
		this.getContentPane().setLayout(groupLayout);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Provincia a=new Provincia();

			
			
			try {
				//Coge el texto de los JTextField y los añade al objeto
				 a.setNombre(txtNombre.getText());
				 
				 s.save(a);
				 s.getTransaction().commit();
				 this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getParent(), "Atributos erroneos");
			}	
	}
	
}
