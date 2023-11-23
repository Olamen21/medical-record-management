package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BenhNhanDAO;
import model.BenhNhan;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;

public class GDXem extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable table;
	private ArrayList<BenhNhan> list;
	private DefaultTableModel model;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnRefresh;
	private JButton btnCancel;
	private JButton btnClear;

	
	public GDXem() {
		this.init();
		this.setLocationRelativeTo(null);
		list = new BenhNhanDAO().selectQuery();
		
		model = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		model = (DefaultTableModel)this.table.getModel();
		this.model.setColumnIdentifiers(new Object[] {"Ma benh nhan","So phieu", "Ho ten", "ID benh an", "Nam sinh", "Dia chi",
				"Khoa dieu tri","Ngay vao dieu tri", "Ngay ra vien", "Ket qua dieu tri","Chan doan benh", "Bien chung benh"});
		this.showTable();
		btnEdit.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnClear.addActionListener(this);
	}

	private void showTable() {
		for (BenhNhan s : list) {
            model.addRow(new Object[]{ s.getMaBenhNhan(), s.getSoPhieu(), s.getHoTen(), s.getIdBenhAn(), 
                    		s.getNamSinh(), s.getDiaChi(), s.getKhoaDieuTri(), s.getNgayVaoDieuTri(), s.getNgayRaVien(), s.getKetQuaDieuTri(),
                    		s.getChanDoanBenh(), s.getBienChungBenh()});
		}
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 498);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("XEM HỒ SƠ BỆNH ÁN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GDXem.class.getResource("icon-update.png"))));
		panel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnDelete);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnRefresh);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GDXem.class.getResource("icon-cancel.png"))));
		panel.add(btnCancel);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnClear);
		
		table = new JTable();
		table.setBounds(310, 168, 1, 1);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(table);
		this.table.setModel(new DefaultTableModel(new Object[0][], new String[0]));
		contentPane.add(jScrollPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnEdit)) {
			btnEditClick();
		} else if(e.getSource().equals(btnDelete)) {
			btnDeleteClick();
		} else if(e.getSource().equals(btnCancel)) {
			btnCancelClick();
		} else if(e.getSource().equals(btnRefresh)) {
			btnRefreshClick();
		} else if (e.getSource().equals(btnClear)) {
			btnClearClick();
		}
	}

	private void btnClearClick() {
		new BenhNhanDAO().xoaTatCa();
	}

	private void btnRefreshClick() {
		model.setRowCount(0);
		list = new BenhNhanDAO().selectQuery();
		showTable();
		
	}

	private void btnCancelClick() {
		new GDTRangChu().setVisible(true);
		this.dispose();
	}

	private void btnDeleteClick() {
		try {
			int row = table.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(GDXem.this, "Vui lòng chọn bệnh án!","Lỗi!", JOptionPane.ERROR_MESSAGE, null);
			} else {
				int confirm = JOptionPane.showConfirmDialog(GDXem.this, "Bạn có chắc chắn muốn xóa không?");
				
				if(confirm == JOptionPane.YES_OPTION) {
					int mbn = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
					new BenhNhanDAO().xoaBenhAn(mbn);
					
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private void btnEditClick() {
		int row = table.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(GDXem.this, "Vui lòng chọn bệnh án!","Lỗi!", JOptionPane.ERROR_MESSAGE, null);
		} else {
			
				int mbn = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
				
				new GDChinhSuaHS(mbn).setVisible(true);
				this.dispose();
			}
		
	}

}
