package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.BenhNhan;

public class BenhNhanDAO {
	private Connection conn;

	public BenhNhanDAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-40OFFHMU\\SQLEXPRESS:1433;"
					+ "user=sa;password=123;databaseName=BenhAn;encrypt=false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<BenhNhan> selectQuery() {
		
		ArrayList<BenhNhan> list = new ArrayList<>();
		String sql = "SELECT*FROM BenhNhan";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BenhNhan b = new BenhNhan();
				b.setMaBenhNhan(rs.getInt("MABENHNHAN"));
				b.setSoPhieu(rs.getString("SOPHIEU"));
				b.setHoTen(rs.getString("HOTEN"));
				b.setIdBenhAn(rs.getString("ID_BENHAN"));
				b.setNamSinh(rs.getInt("NAMSINH"));
				b.setDiaChi(rs.getString("DIACHI"));
				b.setKhoaDieuTri(rs.getString("KHOADIEUTRI"));
				b.setNgayVaoDieuTri(rs.getDate("NGAYVAODIEUTRI"));
				b.setNgayRaVien(rs.getDate("NGAYRAVIEN"));
				b.setKetQuaDieuTri(rs.getString("KETQUADIEUTRI"));
				b.setChanDoanBenh(rs.getString("CHANDOANBENH"));
				b.setBienChungBenh(rs.getString("BIENCHUNGBENH"));
				
				list.add(b);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
public BenhNhan getBenhNhanByMBN(int mbn) {
		
		ArrayList<BenhNhan> list = new ArrayList<>();
		String sql = "SELECT*FROM BenhNhan WHERE MABENHNHAN=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mbn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BenhNhan b = new BenhNhan();
				b.setMaBenhNhan(rs.getInt("MABENHNHAN"));
				b.setSoPhieu(rs.getString("SOPHIEU"));
				b.setHoTen(rs.getString("HOTEN"));
				b.setIdBenhAn(rs.getString("ID_BENHAN"));
				b.setNamSinh(rs.getInt("NAMSINH"));
				b.setDiaChi(rs.getString("DIACHI"));
				b.setKhoaDieuTri(rs.getString("KHOADIEUTRI"));
				b.setNgayVaoDieuTri(rs.getDate("NGAYVAODIEUTRI"));
				b.setNgayRaVien(rs.getDate("NGAYRAVIEN"));
				b.setKetQuaDieuTri(rs.getString("KETQUADIEUTRI"));
				b.setChanDoanBenh(rs.getString("CHANDOANBENH"));
				b.setBienChungBenh(rs.getString("BIENCHUNGBENH"));
				
				return b;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean themBenhAn(BenhNhan b) {

		String sql = "INSERT INTO BenhNhan(MABENHNHAN, SOPHIEU, HOTEN, ID_BENHAN, NAMSINH, DIACHI, KHOADIEUTRI,"
				+ "NGAYVAODIEUTRI, NGAYRAVIEN, KETQUADIEUTRI, CHANDOANBENH, BIENCHUNGBENH) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getMaBenhNhan());
			ps.setString(2, b.getSoPhieu());
			ps.setString(3, b.getHoTen());
			ps.setString(4, b.getIdBenhAn());
			ps.setInt(5, b.getNamSinh());
			ps.setString(6, b.getDiaChi());
			ps.setString(7, b.getKhoaDieuTri());
			ps.setDate(8, new Date(b.getNgayVaoDieuTri().getTime()));
			ps.setDate(9, new Date(b.getNgayRaVien().getTime()));
			ps.setString(10, b.getKetQuaDieuTri());
			ps.setString(11, b.getChanDoanBenh());
			ps.setString(12, b.getBienChungBenh());
			
			return ps.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public void suaBenhAn(BenhNhan b) {

		String sql = "update BenhNhan set SOPHIEU=?, HOTEN=?, ID_BENHAN=?, NAMSINH=?, DIACHI=?, KHOADIEUTRI=?,"
				+ " NGAYVAODIEUTRI=?, NGAYRAVIEN=?, KETQUADIEUTRI=?, CHANDOANBENH=?, BIENCHUNGBENH=? "
				+ "WHERE MABENHNHAN=?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, b.getSoPhieu());
			ps.setString(2, b.getHoTen());
			ps.setString(3, b.getIdBenhAn());
			ps.setInt(4, b.getNamSinh());
			ps.setString(5, b.getDiaChi());
			ps.setString(6, b.getKhoaDieuTri());
			ps.setDate(7, new Date(b.getNgayVaoDieuTri().getTime()));
			ps.setDate(8, new Date(b.getNgayRaVien().getTime()));
			ps.setString(9, b.getKetQuaDieuTri());
			ps.setString(10, b.getChanDoanBenh());
			ps.setString(11, b.getBienChungBenh());
			ps.setInt(12, b.getMaBenhNhan());
			
			ps.executeUpdate();
			
			try {
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void xoaBenhAn(int mbn) {
		
		try {
			String sql = "delete from BenhNhan where MABENHNHAN=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mbn);
			int rs = ps.executeUpdate();
	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void xoaTatCa() {
		try {
			String sql = "delete from BenhNhan";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			int rs = ps.executeUpdate();
	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
