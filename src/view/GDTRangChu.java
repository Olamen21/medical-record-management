package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GDTRangChu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lblTieuDe;
	private JButton btnThemHS;
	private JButton btnXemHS;

	public GDTRangChu() {
		this.init();
		btnThemHS.addActionListener(this);
		btnXemHS.addActionListener(this);
		this.setLocationRelativeTo(null);
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTieuDe = new JLabel("HỒ SƠ BỆNH ÁN");
		lblTieuDe.setForeground(Color.WHITE);
		lblTieuDe.setBackground(Color.DARK_GRAY);
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTieuDe.setBounds(115, 0, 244, 66);
		contentPane.add(lblTieuDe);
		
		btnThemHS = new JButton("Thêm hồ sơ ");
		btnThemHS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemHS.setBounds(136, 76, 151, 38);
		btnThemHS.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GDTRangChu.class.getResource("icon-add.png"))));
		contentPane.add(btnThemHS);
		
		btnXemHS = new JButton("Xem hồ sơ ");
		btnXemHS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXemHS.setBounds(136, 151, 151, 38);
		btnXemHS.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GDTRangChu.class.getResource("icon-see.png"))));
		contentPane.add(btnXemHS);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnThemHS)) {
			btnThemHoSoClick();
		} else {
			btnXemHSClick();
		}
	}
	
	public void btnThemHoSoClick() {
		new GDThemBenhAn().setVisible(true);
		this.dispose();
	}
	
	public void btnXemHSClick() {
		new GDXem().setVisible(true);
		this.dispose();
	}
}
