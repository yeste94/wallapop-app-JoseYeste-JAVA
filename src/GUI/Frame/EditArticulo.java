package GUI.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Session;

import Servicios.Articulo;
import Servicios.Conexion;

public class EditArticulo extends JFrame implements ActionListener{
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private Articulo user;
	
	private JTextArea txtrDescripcion;
	private JCheckBox chckbxNegociable;
	private JCheckBox chckbxIntercambio;
	private JCheckBox chckbxEnvio;

	Conexion con=new Conexion();
	Session s=con.getSession();
	public EditArticulo(int id){
		
		this.setTitle("Editar Articulo");
		this.setBounds(100, 100, 512, 512);
		
		
		
		user=(Articulo)s.get(Articulo.class, id);
		
		
		txtNombre = new JTextField();
		txtNombre.setText(user.getNombre());
		txtNombre.setColumns(10);
		
		JLabel lblAadirArticulo = new JLabel("Editar Articulo");
		
		txtPrecio = new JTextField();
		txtPrecio.setText(user.getPrecio()+"");
		txtPrecio.setColumns(10);
		
		chckbxEnvio = new JCheckBox("Envio");
		chckbxEnvio.setSelected(user.isEnvio());
		
		chckbxIntercambio = new JCheckBox("Intercambio");
		chckbxIntercambio.setSelected(user.isIntercambio());
		
		chckbxNegociable = new JCheckBox("Negociable");
		chckbxNegociable.setSelected(user.isNegociable());
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setText(" "+user.getDescripcion());
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Localidad"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Subcategoria"}));
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setActionCommand("");
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
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
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
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		user.setNombre(txtNombre.getText());
		user.setPrecio(new BigDecimal(txtPrecio.getText()));
		user.setEnvio(chckbxEnvio.isSelected());
		user.setIntercambio(chckbxIntercambio.isSelected());
		user.setNegociable(chckbxNegociable.isSelected());
		user.setDescripcion(txtrDescripcion.getText());
		System.out.println(user.getDescripcion());
		s.update(user);
		s.getTransaction().commit();
		this.setVisible(false);
	}


}
