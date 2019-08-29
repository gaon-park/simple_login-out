package com.hansung.CMS;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
	
	public void update(Member m) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member_tb set id=?,pw=?,name=?,nick_name=?,"
				+ "sex=?,email=?,homepage=?,address=?,hobby_string=? where id=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPw());
			ps.setString(3,m.getName());
			ps.setString(4, m.getNick());
			ps.setString(5, m.getSex());
			ps.setString(6, m.getEmail());
			ps.setString(7, m.getHomepage());
			ps.setString(8, m.getAddress());
			ps.setString(9, m.getHobbyString());
			ps.setString(10, m.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}
	
	public ArrayList<Member> search() throws SQLException{
		ArrayList<Member> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member_tb";
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setNick(rs.getString("nick_name"));
				m.setSex(rs.getString("sex"));
				m.setEmail(rs.getString("email"));
				m.sethomepage(rs.getString("homepage"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby_string"));
				list.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
		}

		
		return list;
	}

	public void delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from member_tb where id=?";
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}
	
	public void add(Member m) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member_tb values(?,?,?,?,?,?,?,?,?)";

		try {
			System.out.println(m.getName() + "이름이야");
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPw());
			ps.setString(3, m.getName());
			ps.setString(4, m.getNick());
			ps.setString(5, m.getSex());
			ps.setString(6, m.getEmail());
			ps.setString(7, m.getHomepage());
			ps.setString(8, m.getAddress());
			ps.setString(9, m.getHobbyString());

			ps.executeUpdate();
			System.out.println("ps성공~");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}

	public Member search(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member_tb where id = ?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {

				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setNick(rs.getString("nick_name"));
				m.setSex(rs.getString("sex"));
				m.setEmail(rs.getString("email"));
				m.sethomepage(rs.getString("homepage"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby_string"));
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
			DBUtil.close(rs);
		}
		return null;
	}

	public boolean loginCheck(String id, String pw) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member_tb where id = ? and pw = ?";

		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);

			rs = ps.executeQuery();
			if (rs.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			DBUtil.close(ps);
			DBUtil.close(conn);
			DBUtil.close(rs);
		}
	}
}
