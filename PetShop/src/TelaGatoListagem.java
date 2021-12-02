import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class TelaGatoListagem extends JFrame {

	private JPanel contentPane;
	private GatoRepositorio gatoRepo;
	private JTable tblGatos;
	private JButton btnExcluir;
	private JButton btnTelaEdicao;

	public TelaGatoListagem(GatoRepositorio gatoRepo) {
		this.gatoRepo = gatoRepo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTelaCadastro = new JButton("Cadastrar gato");
		btnTelaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGatoCadastro telaGatoCadastro = new TelaGatoCadastro(gatoRepo);
				telaGatoCadastro.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						listarGatos();
					}
				});
				telaGatoCadastro.setVisible(true);
			}
		});
		btnTelaCadastro.setBounds(559, 11, 157, 44);
		contentPane.add(btnTelaCadastro);
		
		JScrollPane scrGatos = new JScrollPane();
		scrGatos.setBounds(10, 11, 539, 382);
		contentPane.add(scrGatos);
		
		tblGatos = new JTable();
		tblGatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblGatos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Raça", "Cor"
			}
		));
		tblGatos.removeColumn(tblGatos.getColumnModel().getColumn(0));
		scrGatos.setViewportView(tblGatos);
		
		btnExcluir = new JButton("Excluir gato");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblGatos.getSelectedRow() != -1) {
					int id = (int) tblGatos.getModel().getValueAt(tblGatos.getSelectedRow(), 0);
					Object[] options = {"Sim", "Não"};
					int resposta = JOptionPane.showOptionDialog(scrGatos, "Você deseja realmente excluir o gato?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
					if(resposta == 0) {
						gatoRepo.excluir(id);
						listarGatos();
					}
				} else {
					JOptionPane.showMessageDialog(scrGatos, "Você não selecionou um gato!");
				}
			}
		});
		btnExcluir.setBounds(559, 121, 157, 44);
		contentPane.add(btnExcluir);

		btnTelaEdicao = new JButton("Editar gato");
		btnTelaEdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblGatos.getSelectedRow() != -1) {
					int id = (int) tblGatos.getModel().getValueAt(tblGatos.getSelectedRow(), 0);
					TelaGatoEdicao telaGatoEdicao = new TelaGatoEdicao(gatoRepo, id);
					telaGatoEdicao.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							listarGatos();
						}
					});
					telaGatoEdicao.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(scrGatos, "Você não selecionou um gato!");
				}
			}
		});
		btnTelaEdicao.setBounds(559, 66, 157, 44);
		contentPane.add(btnTelaEdicao);
		
		this.listarGatos();
	}
	
	public void listarGatos() {
		ArrayList<Gato> gatos = this.gatoRepo.listar();
		DefaultTableModel model = (DefaultTableModel) tblGatos.getModel();
		model.setRowCount(0);
		for(Gato gato: gatos) {
			model.addRow(new Object[] {
				gato.getId(),
				gato.getNome(),
				gato.getRaca(),
				gato.getCor()
			});
		}
	}
}
