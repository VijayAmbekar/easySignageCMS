/**
 * 
 */
package com.easysignage.cms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easysignage.cms.bean.LoginBean;
import com.easysignage.cms.dao.Connect;

/**
 * @author Owner
 * 
 */

public class AuthenticatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName = req.getParameter("user_name");
		String password = req.getParameter("password");
		System.out.print("UserName: " + userName + "  Password: " + password);

		if (userName != null && password != null) {
			if (Connect.checkLogin(new LoginBean(userName, password))) {
				HttpSession session = req.getSession(true);
				session.setAttribute("USERID", userName);
				resp.sendRedirect("index.jsp");
				return;
//				RequestDispatcher rd = getServletContext()
//						.getRequestDispatcher("/index.jsp");
//				rd.forward(req, resp);
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/login.jsp");
		rd.forward(req, resp);
	}

}
