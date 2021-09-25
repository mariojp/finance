package br.ucsal.pooa.finance.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.ucsal.pooa.finance.controller.Controller;

public class JanelaDestop extends JFrame {

	private Controller controller;
	private boolean iniciar = false;
	public JanelaDestop(Controller controller) {
		super("Finance");
		setLayout(null);
		this.controller = controller;
		this.setSize(800, 600);
		menuInit();
		
		JButton cadastro = new JButton("Clique aqui");
		cadastro.setBounds(100, 100, 200, 150);


		
		cadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(JanelaDestop.this,"Cotacao" );
				
			}
		});
		
		
		this.add(cadastro);
		
		
		
		
		this.add(new Button("1"),BorderLayout.NORTH);
		this.add(new Button("1.1"),BorderLayout.NORTH);

		this.add(new Button("2"),BorderLayout.SOUTH);
		this.add(new Button("3"), BorderLayout.WEST);
		this.add(new Button("4"), BorderLayout.EAST);
		this.add(new Button("5"), BorderLayout.CENTER);

		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void menuInit() {
		this.setJMenuBar(new JMenuBar());
		JMenu sistema = new JMenu("Sistema");
		JMenuItem cadastar = new JMenuItem("Cadastrar");
		cadastar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciar = true;
			}
		});
		JMenuItem listar = new JMenuItem("Listar");
		listar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciar = false;
			}
		});
		
		JMenuItem sair = new JMenuItem("Sair");
		sistema.add(cadastar);
		sistema.add(listar);
		sistema.add(sair);
		getJMenuBar().add(sistema);
	}
	
	
	
}
