/**
 * 
 */
package com.easysignage.cms.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.easysignage.cms.bean.LayoutTemplate;
import com.easysignage.cms.bean.LoginBean;
import com.easysignage.cms.bean.MediaBean;

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

	public static boolean addMedia(String libPath, MediaBean media) {
		// Find the uploaded file and get its size
		// insert record in the database
		// rename file to the inserted mediaId
		// media_type, media_name, fileName, media_size, duration
		String sql = "select max(media_id) from media;";
		String insertSQL = "insert into media values(?,?, ?,?, ?, ?)";
		int newMediaID = 1;
		Connection con = null;
		try {

			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				newMediaID = rs.getInt(1) + 1;
				System.out.print("New Media ID : " + newMediaID);
			}

			System.out.println("File Name : " + media.getFileName());

			File file = new File(libPath + media.getFileName());
			if (file.exists()) {
				media.setMediaSize(file.length());
			} else {
				media.setMediaSize(0);
			}
			String newFileName = newMediaID + "."
					+ media.getFileName().split("\\.")[1];

			PreparedStatement pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, newMediaID);
			pstmt.setString(2, media.getMediaType());
			pstmt.setString(3, media.getMediaName());
			pstmt.setString(4, newFileName);
			pstmt.setLong(5, media.getMediaSize());
			pstmt.setInt(6, media.getMediaDuration());

			if (pstmt.executeUpdate() == 1) {
				file.renameTo(new File(libPath + newFileName));
				con.commit();
				System.out.println("add media success @@@@@");
				return true;
			} else {
				System.out.println("Unable to add media....");
				con.rollback();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<MediaBean> getImageList() {
		String sql = "select * from media where media_type='image'";
		Connection con = null;
		ArrayList<MediaBean> mediaList = null;
		// media_type, media_name, fileName, media_size, duration
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				if (mediaList == null) {
					mediaList = new ArrayList<MediaBean>();
				}
				mediaList.add(new MediaBean(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getInt(5), rs
						.getInt(6)));
			}

			return mediaList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
