package GUI.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Session;

import Componentes.JTextFieldBuscar;
import Servicios.Conexion;
import Servicios.Provincia;
import Servicios.Usuario;

public class AddUsuario extends JFrame implements ActionListener{
	private JTextFieldBuscar txtMail;
	
	WallapopFrameAdmin wallapopAdmin;

	private JTextFieldBuscar txtPass;

	private JTextFieldBuscar txtNick;
	
	
	public AddUsuario(){
		this.setTitle("Añadir Provincia");
		this.setBounds(100, 100, 512, 512);
		
		addElementos();
	}

	
	public void addElementos(){
		
		
		txtMail = new JTextFieldBuscar();
		txtMail.setPlaceholder("Nombre");
		txtMail.setText("");
		txtMail.setColumns(10);
		
		JLabel lblAadirArticulo = new JLabel("A\u00F1adir Provincia");
		

		
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		
		txtPass = new JTextFieldBuscar();
		txtPass.setText("");
		txtPass.setPlaceholder("Contraseña");
		txtPass.setColumns(10);
		
		txtNick = new JTextFieldBuscar();
		txtNick.setPlaceholder("Nick");
		txtNick.setText("");
		txtNick.setColumns(10);
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(382, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(81)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnEnviar)
								.addComponent(lblAadirArticulo))
							.addContainerGap(139, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAadirArticulo)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(btnEnviar)))
					.addGap(116))
		);
		this.getContentPane().setLayout(groupLayout);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Conexion con=new Conexion();
		Session s=con.getSession();
		
		Usuario a=new Usuario();

			
			
			try {
				//Coge el texto de los JTextField y los añade al objeto
				 a.setMail(txtMail.getText());
				 a.setNick(txtNick.getText());
				 a.setPass(txtPass.getText());
				 s.save(a);
				 s.getTransaction().commit();
				 this.setVisible(false);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getParent(), "Atributos erroneos");
			}	
	}
}
