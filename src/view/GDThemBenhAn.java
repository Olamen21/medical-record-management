package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.BenhNhanDAO;
import model.BenhNhan;

public class GDThemBenhAn extends JFrame implements ActionListener{

	private BenhNhan benhNhan;
	private JPanel contentPane;
	private JLabel jlabelHoSoBenhAn;
	private JPanel panel;
	private JLabel jlblThongTinChung;
	private JLabel lblMaBenhNhan;
	private JTextField textFieldMabenhNhan;
	private JTextField textFieldSoPhieu;
	private JTextField textField_HoTen;
	private JTextField textField_IDBenhAn;
	private JTextField textField_NamSinh;
	private JTextArea textArea_DiaChi;
	private JTextField textField_KhoaDieuTri;
	private JTextField textField_NgayVaoDieuTri;
	private JTextField textField_NgayRaVien;
	private JTextArea textArea_KetQuaDieuTri;
	private JTextArea textArea_ChanDoanBenh;
	private JTextArea textArea_BienChungBenh;
	private JScrollPane jScrollPane1;
	private JTable jtable;
	private JScrollPane jScrollPane;
	private JButton btnAdd;
	private JButton btnReset;
	private JButton btnCancel;
	DefaultTableModel model;
	private int i = 1;
	private ArrayList<BenhNhan> list;

	
	public GDThemBenhAn() {
		this.init();
		btnAdd.addActionListener(this);
		btnReset.addActionListener(this);
		btnCancel.addActionListener(this);
		list = new BenhNhanDAO().selectQuery();
	}

	public void init() {
		this.setTitle("Thêm hồ sơ bệnh án");
		this.setSize(864, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	
		jlabelHoSoBenhAn = new JLabel("HỒ SƠ BỆNH ÁN");
		jlabelHoSoBenhAn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jlabelHoSoBenhAn.setForeground(Color.WHITE);
		contentPane.add(jlabelHoSoBenhAn);
	
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		jScrollPane = new JScrollPane(panel);
		contentPane.add(jScrollPane);
	
		jlblThongTinChung = new JLabel("Thông tin chung");
		jlblThongTinChung.setForeground(new Color(0, 0, 160));
		jlblThongTinChung.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(jlblThongTinChung);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel.add(label_2);
		
		lblMaBenhNhan = new JLabel("Mã bệnh nhân");
		lblMaBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblMaBenhNhan);
		
		textFieldMabenhNhan = new JTextField();
		textFieldMabenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textFieldMabenhNhan);
		textFieldMabenhNhan.setColumns(10);
		
		JLabel lblSoPhieu = new JLabel("Số phiếu");
		lblSoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblSoPhieu);
		
		textFieldSoPhieu = new JTextField();
		textFieldSoPhieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textFieldSoPhieu);
		textFieldSoPhieu.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên\r\n");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblHoTen);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_HoTen);
		textField_HoTen.setColumns(10);
		
		JLabel lblIDBenhAn = new JLabel("ID Bệnh án");
		lblIDBenhAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblIDBenhAn);
		
		textField_IDBenhAn = new JTextField();
		textField_IDBenhAn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_IDBenhAn);
		textField_IDBenhAn.setColumns(10);
		
		JLabel lblNamSinh = new JLabel("Năm sinh");
		lblNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNamSinh);
		
		textField_NamSinh = new JTextField();
		textField_NamSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_NamSinh);
		textField_NamSinh.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDiaChi);
		
		textArea_DiaChi = new JTextArea();
		textArea_DiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textArea_DiaChi);
		
		JLabel lblKhoaDieuTri = new JLabel("Khoa điều trị");
		lblKhoaDieuTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblKhoaDieuTri);
		
		textField_KhoaDieuTri = new JTextField();
		textField_KhoaDieuTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_KhoaDieuTri);
		textField_KhoaDieuTri.setColumns(10);
		
		JLabel lblNgayVaoDieuTri = new JLabel("Ngày vào điều trị");
		lblNgayVaoDieuTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNgayVaoDieuTri);
		
		textField_NgayVaoDieuTri = new JTextField();
		textField_NgayVaoDieuTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_NgayVaoDieuTri);
		textField_NgayVaoDieuTri.setColumns(10);
		
		JLabel lblThongTinRaVien = new JLabel("Thông tin ra viện");
		lblThongTinRaVien.setForeground(new Color(0, 0, 160));
		lblThongTinRaVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblThongTinRaVien);
		
		JLabel label_3 = new JLabel("");
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		
		JLabel lblNgayRaVien = new JLabel("Ngày ra viện");
		lblNgayRaVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNgayRaVien);
		
		textField_NgayRaVien = new JTextField();
		textField_NgayRaVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textField_NgayRaVien);
		textField_NgayRaVien.setColumns(10);
		
		JLabel lblKetQuaDieuTri = new JLabel("Kết quả điều trị");
		lblKetQuaDieuTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblKetQuaDieuTri);
		
		textArea_KetQuaDieuTri = new JTextArea();
		textArea_KetQuaDieuTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textArea_KetQuaDieuTri);
		
		JLabel lblChanDoanBenh = new JLabel("Chẩn đoán bệnh");
		lblChanDoanBenh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblChanDoanBenh);
		
		textArea_ChanDoanBenh = new JTextArea();
		textArea_ChanDoanBenh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textArea_ChanDoanBenh);
		
		JLabel lblBienChungBenh = new JLabel("Biến chứng bệnh");
		lblBienChungBenh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblBienChungBenh);
		
		textArea_BienChungBenh = new JTextArea();
		textArea_BienChungBenh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(textArea_BienChungBenh);
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GDThemBenhAn.class.getResource("icon-add.png"))));
		panel.add(btnAdd);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnReset);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GDThemBenhAn.class.getResource("icon-cancel.png"))));
		panel.add(btnCancel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)) {
			addClick();
		} else if(e.getSource().equals(btnReset)) {
			resetClick();
		}else if(e.getSource().equals(btnCancel)){
			cancelClick();
		}
	}
	
	public void addClick() {
		benhNhan = new BenhNhan();
		try {
				try {
					benhNhan.setMaBenhNhan(Integer.parseInt(textFieldMabenhNhan.getText()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(rootPane, "Mã bệnh nhân phải là số và không chứa kí tự khác!");
				}
					benhNhan.setSoPhieu(textFieldSoPhieu.getText());
					benhNhan.setHoTen(textField_HoTen.getText());
					benhNhan.setIdBenhAn(textField_IDBenhAn.getText());
			try {
				benhNhan.setNamSinh(Integer.parseInt(textField_NamSinh.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(rootPane, "Năm sinh phải là số và không chứa kí tự khác!");
			}
			benhNhan.setDiaChi(textArea_DiaChi.getText());
			benhNhan.setKhoaDieuTri(textField_KhoaDieuTri.getText());
			try {
				 benhNhan.setNgayVaoDieuTri((new SimpleDateFormat("dd/MM/yyyy")).parse(textField_NgayVaoDieuTri.getText()));
				 benhNhan.setNgayRaVien(new SimpleDateFormat("dd/MM/yyyy").parse(textField_NgayRaVien.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(rootPane, "Nhập sai ngày tháng năm!(Ngày/tháng/năm)");
			}
				benhNhan.setKetQuaDieuTri(textArea_KetQuaDieuTri.getText());
				benhNhan.setChanDoanBenh(textArea_ChanDoanBenh.getText());
				benhNhan.setBienChungBenh(textArea_BienChungBenh.getText());
			
			if(new BenhNhanDAO().themBenhAn(benhNhan)) {
				JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
			} else JOptionPane.showMessageDialog(rootPane, "Thêm thất bại!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


	public void resetClick() {
		this.textFieldMabenhNhan.setText("");
		this.textFieldSoPhieu.setText("");
		this.textField_HoTen.setText("");
		this.textField_IDBenhAn.setText("");
		this.textField_NamSinh.setText("");
		this.textArea_DiaChi.setText("");
		this.textField_KhoaDieuTri.setText("");
		this.textField_NgayVaoDieuTri.setText("");
		this.textField_NgayRaVien.setText("");
		this.textArea_KetQuaDieuTri.setText("");
		this.textArea_ChanDoanBenh.setText("");
		this.textArea_BienChungBenh.setText("");
	}
	
	public void cancelClick() {
		new GDTRangChu().setVisible(true);
		this.dispose();
	}
}
