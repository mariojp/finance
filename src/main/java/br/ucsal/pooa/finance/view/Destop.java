package br.ucsal.pooa.finance.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import java.awt.GridLayout;

import javax.print.attribute.standard.ColorSupported;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.ucsal.pooa.finance.controller.Controller;
import br.ucsal.pooa.finance.model.Lancamento;
import br.ucsal.pooa.finance.model.Validador;

public class Destop extends JFrame {

	private Controller controller;
	private boolean iniciar = false;
	
	private JTextField tipo = new JTextField();
	private JTextField descricao = new JTextField();
	private JTextField valor = new JTextField();
	private JTable grid;
	private Tabela tabela;
	public Destop(Controller controller) {
		//Define o titulo da janela
		super("Finance");
		this.controller = controller;
		// definir o tamanho
		this.setSize(800, 600);
		
		//inicialiaza o menu
		menuInit();
		
		//Componente container 
		JPanel cadastroPanel = new JPanel();
		//cadastroPanel.setLayout();
	
		//cadastroPanel.setBackground(Color.BLUE);
		
		
		JPanel camposPanel = new JPanel(new GridLayout(3,2));

		camposPanel.add(new JLabel("Descrição"));
		camposPanel.add(descricao);
		camposPanel.add(new JLabel("Valor"));
		camposPanel.add(valor);
		camposPanel.add(new JLabel("Tipo"));
		camposPanel.add(tipo);
		
		cadastroPanel.add(camposPanel);
		
		JButton salvar = new JButton("Salvar");
		cadastroPanel.add(salvar);
		
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tipo = Destop.this.tipo.getText();
				String descricao = Destop.this.descricao.getText();
				BigDecimal valor = new BigDecimal(Destop.this.valor.getText());
				Lancamento lancamento = new Lancamento(tipo, valor, descricao);
				
				Validador validador = new Validador(lancamento);
				List<String> erros = validador.validar();
				if(erros.isEmpty()) {
					controller.add(lancamento);
					tabela.setData(controller.lista());
				}else {
					String message = "";
					for (String string : erros) {
						message += (string +"\n");
					}
					JOptionPane.showConfirmDialog(null, message);
				}
			}
			
		});
		

		//Adcionar painel na janela no topo
		this.add(cadastroPanel, BorderLayout.NORTH);
		
		System.out.println(controller.lista().size());

		tabela = new Tabela(controller.lista());

		grid = new JTable(tabela);
		grid.setDragEnabled(false);
		//this.add(grid, BorderLayout.CENTER);
		
		//Create the scroll pane and add the table to it.	
		JScrollPane scrollPane = new JScrollPane(grid);
		//scrollPane.setOpaque(true);
		//Add the scroll pane to this panel.
		add(scrollPane,BorderLayout.CENTER);
		
		
	

		
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
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		sistema.add(cadastar);
		sistema.add(listar);
		sistema.add(sair);
		getJMenuBar().add(sistema);
	}
	
	
	
}
