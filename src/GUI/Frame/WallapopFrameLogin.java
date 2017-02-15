package GUI.Frame;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Servicios.Usuario;

import javax.swing.GroupLayout.Alignment;

import Componentes.*;

public class WallapopFrameLogin extends JFrame{
	private JTextField mail;
	private JTextField pass;
	
	public JTextField getMail() {
		return mail;
	}
	public void setMail(JTextField mail) {
		this.mail = mail;
	}
	public JTextField getPass() {
		return pass;
	}
	public void setPass(JTextField pass) {
		this.pass = pass;
	}

	public WallapopFrameLogin(){
		this.setTitle("Wallapop Jose");
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		mail = new JTextField();
		mail.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblConstrasea = new JLabel("Constrase\u00F1a");
		//
		Usuario user=new Usuario(mail.getText(),
		pass.getText());
		
		System.out.println(user.getMail());
		
		ControlerLogin c=new ControlerLogin(this);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(c);
		btnEnter.setActionCommand("btn_login");
		
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(34))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblConstrasea)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnEnter)
							.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(147))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsuario)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblLogin)
							.addGap(40)
							.addComponent(mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConstrasea))
					.addGap(18)
					.addComponent(btnEnter)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
		
	}
}
