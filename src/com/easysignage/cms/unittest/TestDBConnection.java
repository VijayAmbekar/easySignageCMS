/**
 * 
 */
package com.easysignage.cms.unittest;

import java.sql.Connection;

import com.easysignage.cms.dao.Connect;

/**
 * @author Owner
 * 
 */
public class TestDBConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.print("Creating MySQL DB Connection");
			Connection con = Connect.getConnection();
			if (con != null) {
				System.out.print("Connection created...");
				con.close();
			}
		} catch (Exception e) {
			System.out.print("Connection failed: ");
			e.printStackTrace();
		}

	}

}
