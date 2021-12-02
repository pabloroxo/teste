import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaGatoEdicao extends JFrame {

	private JPanel contentPane;
	private GatoRepositorio gatoRepo;
	private JTextField txtNome;
	private JTextField txtRaca;
	private JTextField txtCor;
	private int id;
	private Gato gato;

	public TelaGatoEdicao(GatoRepositorio gatoRepo, int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.gatoRepo = gatoRepo;
		this.id = id;
		setBounds(200, 200, 250, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Edi\u00E7\u00E3o de Gato");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 11, 214, 26);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 51, 39, 14);
		contentPane.add(lblNome);
		
		JLabel lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setBounds(10, 84, 39, 14);
		contentPane.add(lblRaca);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(10, 115, 39, 14);
		contentPane.add(lblCor);
		
		txtNome = new JTextField();
		txtNome.setBounds(59, 48, 165, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtRaca = new JTextField();
		txtRaca.setBounds(59, 81, 165, 20);
		contentPane.add(txtRaca);
		txtRaca.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(59, 112, 165, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gato.setNome(txtNome.getText());
				gato.setRaca(txtRaca.getText());
				gato.setCor(txtCor.getText());
				gatoRepo.editar(gato);
				JOptionPane.showMessageDialog(btnEditar, "Gato editado com sucesso!");
				dispose();
			}
		});
		btnEditar.setBounds(10, 143, 100, 23);
		contentPane.add(btnEditar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtRaca.setText("");
				txtCor.setText("");
			}
		});
		btnLimpar.setBounds(124, 143, 100, 23);
		contentPane.add(btnLimpar);
		
		this.gato = this.gatoRepo.obter(this.id);
		txtNome.setText(this.gato.getNome());
		txtRaca.setText(this.gato.getRaca());
		txtCor.setText(this.gato.getCor());
	}
}
