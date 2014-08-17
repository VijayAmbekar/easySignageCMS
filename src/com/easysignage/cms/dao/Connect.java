/**
 * 
 */
package com.easysignage.cms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.easysignage.cms.bean.LayoutTemplate;
import com.easysignage.cms.bean.LoginBean;

/**
 * @author Vijay created 13 August, 2014 last modified 13 August, 2014
 */
public class Connect {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// OracleDriver driver = new OracleDriver();
			// DriverManager.registerDriver(driver);

			// Driver driver = new Driver();
			// DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost/jcms?user=cmsuser&password=1234";
			Connection conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);
			System.out.println("Connection successful!!!");
			return conn;
		} catch (Exception e) {
			System.out.println("Connection failed!!!");
			e.printStackTrace();
			return null;
		}
	}

	public static boolean checkLogin(LoginBean loginBean) {
		String sql = "select password from auth_user where username=?";

		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginBean.getUsername());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// there are some rows
				String ps = rs.getString(1);
				if (ps.equals(loginBean.getPassword())) {
					// valid user
					System.out.println("successful");
					return true;
				} else
					System.out.println("Wrong password!!!!");
				return false;
			} else {
				// no rows-- Wrong user
				System.out.println("Wrong User");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static ArrayList<LayoutTemplate> getLayoutTemplateList() {
		String sql = "select * from layout_templates";
		Connection con = null;
		ArrayList<LayoutTemplate> templateList = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (templateList == null) {
					templateList = new ArrayList<LayoutTemplate>();
				}
				templateList.add(new LayoutTemplate(rs.getInt(1), rs
						.getString(2), rs.getString(3)));
			}

			return templateList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static LayoutTemplate getLayoutTemplate(int temp_id) {
		String sql = "select * from layout_templates where template_id=?";

		Connection con = null;
		LayoutTemplate template = null;
		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, temp_id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// there are some rows
				return new LayoutTemplate(rs.getInt(1), rs.getString(2),
						rs.getString(3));
			} else {
				// no rows-- Wrong user
				System.out.println("Wrong User");
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
