package com.registration.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.registration.bean.Register;
import com.registration.dao.RegisterDAO;

public class JdbcRegisterDAO implements RegisterDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Register register) {
		String sql = "INSERT INTO registration "
				+ "(registration_firstname, registration_lastname, registration_password,registration_email) VALUES (?, ?, ?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, register.getFirstName());
			ps.setString(2, register.getLastName());
			ps.setString(3, register.getEmailId());
			ps.setString(4, register.getPwd());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public Register findByCustomerId(int registrationId) {
		String sql = "SELECT * FROM registration WHERE registration_id = ?";
		 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, registrationId);
			Register member = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				member = new Register();
				member.setFirstName(rs.getString("registration_firstname") );
			}
			rs.close();
			ps.close();
			return member;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public int findCustomer(String username, String password) {
		String sql = "SELECT * FROM registration WHERE registration_email = ? and registration_password = ?";
		Connection conn = null;
		int result = 0;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				 result = 1;
			}
			rs.close();
			ps.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
