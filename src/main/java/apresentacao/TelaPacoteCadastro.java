package apresentacao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ControladorPrincipal;
import entidade.Pacote;

public class TelaPacoteCadastro extends JInternalFrame {
	private JTextField txtPesquisar;
	private JTextField txtNomeRem;
	private JTextField txtNomeDes;
	private JTextField txtCodigoLoc;
	private JTextField txtEndRem;
	private JTextField txtEndDes;
	private JTable table;
	private static ControladorPrincipal controladorPrincipal = ControladorPrincipal.getInstancia();
	private JTextField txtPeso;
	private JButton btnPacCreate;
	private JButton btnPacUpdate;
	private JButton btnPacDelete;
	private JButton btnPacClear;
	private JButton btnFind;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPacoteCadastro frame = new TelaPacoteCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPacoteCadastro() {
		setTitle("Pacote");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 744, 530);
		getContentPane().setLayout(null);

		JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 728, 500);
		getContentPane().add(desktop);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(188, 18, 440, 28);
		desktop.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNomeRemetente = new JLabel("Nome remetente");
		lblNomeRemetente.setForeground(Color.WHITE);
		lblNomeRemetente.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeRemetente.setBounds(32, 214, 137, 16);
		desktop.add(lblNomeRemetente);

		JLabel lblNomeDestinatario = new JLabel("Nome destinatário");
		lblNomeDestinatario.setForeground(Color.WHITE);
		lblNomeDestinatario.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeDestinatario.setBounds(32, 254, 146, 16);
		desktop.add(lblNomeDestinatario);

		JLabel lblCodigoLocalizador = new JLabel("Código localizador");
		lblCodigoLocalizador.setForeground(Color.WHITE);
		lblCodigoLocalizador.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCodigoLocalizador.setBounds(32, 328, 146, 28);
		desktop.add(lblCodigoLocalizador);

		JLabel lblEnderecoRemetente = new JLabel("Endereço remetente");
		lblEnderecoRemetente.setForeground(Color.WHITE);
		lblEnderecoRemetente.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnderecoRemetente.setBounds(32, 294, 175, 16);
		desktop.add(lblEnderecoRemetente);

		JLabel lblEnderecoDestino = new JLabel("Endereço destino");
		lblEnderecoDestino.setForeground(Color.WHITE);
		lblEnderecoDestino.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnderecoDestino.setBounds(32, 374, 146, 16);
		desktop.add(lblEnderecoDestino);

		txtNomeRem = new JTextField();
		txtNomeRem.setBounds(188, 208, 440, 28);
		desktop.add(txtNomeRem);
		txtNomeRem.setColumns(10);

		txtNomeDes = new JTextField();
		txtNomeDes.setBounds(188, 248, 442, 28);
		desktop.add(txtNomeDes);
		txtNomeDes.setColumns(10);

		txtCodigoLoc = new JTextField();
		txtCodigoLoc.setBounds(188, 288, 442, 28);
		desktop.add(txtCodigoLoc);
		txtCodigoLoc.setColumns(10);

		txtEndRem = new JTextField();
		txtEndRem.setBounds(188, 328, 442, 28);
		desktop.add(txtEndRem);
		txtEndRem.setColumns(10);

		txtEndDes = new JTextField();
		txtEndDes.setBounds(188, 368, 442, 28);
		desktop.add(txtEndDes);
		txtEndDes.setColumns(10);

		btnPacCreate = new JButton("");
		btnPacCreate.setToolTipText("Adicionar");
		btnPacCreate.setBackground(Color.LIGHT_GRAY);
		btnPacCreate.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/btnPack.png")));
		btnPacCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeRemetente = txtNomeRem.getText();
				String nomeDestino = txtNomeDes.getText();
				String codLocalizador = txtCodigoLoc.getText();
				String endRemetente = txtEndRem.getText();
				String endDestino = txtEndDes.getText();
				Double peso = Double.parseDouble(txtPeso.getText());

				controladorPrincipal.getControlePacote().cadastrarPacote(nomeRemetente, nomeDestino, codLocalizador,
						endRemetente, endDestino, peso);
				limparCampos();
			}
		});
		btnPacCreate.setBounds(217, 437, 55, 52);
		desktop.add(btnPacCreate);

		btnPacUpdate = new JButton("");
		btnPacUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCodigoLoc != null && !txtCodigoLoc.getText().isEmpty()) {
					Pacote pacote = new Pacote();
					pacote.setCodLocalizador(txtCodigoLoc.getText());
					pacote.setNomeRemetente(txtNomeRem.getText());
					pacote.setNomeDestino(txtNomeDes.getText());
					pacote.setEndDestino(txtEndDes.getText());
					pacote.setEndRemetente(txtEndRem.getText());
					pacote.setPeso(Double.parseDouble(txtPeso.getText()));
					controladorPrincipal.getControlePacote().atualizarPacote(pacote, pacote.getCodLocalizador());
					limparCampos();
				}
			}
		});
		btnPacUpdate.setToolTipText("Editar");
		btnPacUpdate.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/btnEdit.png")));
		btnPacUpdate.setBounds(307, 437, 55, 52);
		desktop.add(btnPacUpdate);

		btnPacDelete = new JButton("");
		btnPacDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCodigoLoc != null && !txtCodigoLoc.getText().isEmpty()) {
					Pacote pacote = new Pacote();
					pacote.setCodLocalizador(txtCodigoLoc.getText());
					controladorPrincipal.getControlePacote().removerPacote(pacote);
					limparCampos();
				}
			}
		});
		btnPacDelete.setToolTipText("Deletar");
		btnPacDelete.setIcon(new ImageIcon(TelaMotoristaCadastro.class.getResource("/apresentacao/icones/delete.png")));
		btnPacDelete.setBounds(397, 437, 55, 52);
		desktop.add(btnPacDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setEnabled(false);
		desktop.setLayer(scrollPane, 0);
		scrollPane.setBounds(46, 71, 637, 119);
		desktop.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setarCampos();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome remetente",
				"Nome destinat\u00E1rio", "C\u00F3digo", "Endere\u00E7o remetente", "Endere\u00E7o destino", "Peso" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(2).setPreferredWidth(53);
		table.getColumnModel().getColumn(3).setPreferredWidth(123);
		table.getColumnModel().getColumn(4).setPreferredWidth(108);
		table.getColumnModel().getColumn(4).setPreferredWidth(53);
		scrollPane.setViewportView(table);

		btnPacClear = new JButton("");
		btnPacClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnPacClear.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/btnClear.png")));
		btnPacClear.setBounds(487, 437, 55, 52);
		desktop.add(btnPacClear);

		btnFind = new JButton("");
		btnFind.setIcon(new ImageIcon(TelaPacoteCadastro.class.getResource("/apresentacao/icones/search-icon.png")));
		btnFind.setBounds(644, 22, 24, 24);
		desktop.add(btnFind);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPeso.setBounds(108, 412, 61, 16);
		desktop.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(188, 407, 442, 28);
		desktop.add(txtPeso);

	}

	private void limparCampos() {
		btnPacCreate.setEnabled(true);
		btnPacUpdate.setEnabled(true);
		btnPacDelete.setEnabled(true);
		btnPacClear.setEnabled(true);

		DefaultTableModel modeloTable = (DefaultTableModel) table.getModel();

		while (modeloTable.getRowCount() > 0) {
			modeloTable.removeRow(0);
		}

		txtPesquisar.setText(null);
		txtNomeDes.setText(null);
		txtNomeRem.setText(null);
		txtCodigoLoc.setText(null);
		txtEndRem.setText(null);
		txtEndDes.setText(null);
		txtPeso.setText(null);

	}

	public void setarCampos() {
		int setar = table.getSelectedRow();
		txtNomeRem.setText(table.getModel().getValueAt(setar, 0).toString());
		txtNomeDes.setText(table.getModel().getValueAt(setar, 1).toString());
		txtCodigoLoc.setText(table.getModel().getValueAt(setar, 2).toString());
		txtEndRem.setText(table.getModel().getValueAt(setar, 3).toString());
		txtEndDes.setText(table.getModel().getValueAt(setar, 4).toString());
		txtPeso.setText(table.getModel().getValueAt(setar, 5).toString());

		btnPacCreate.setEnabled(false);
		btnPacUpdate.setEnabled(true);
	}
}
