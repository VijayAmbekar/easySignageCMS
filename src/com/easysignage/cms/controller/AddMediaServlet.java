package com.easysignage.cms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easysignage.cms.bean.MediaBean;
import com.easysignage.cms.dao.Connect;

/**
 * Servlet implementation class AddMedia
 */
@WebServlet(name = "addMedia.do", urlPatterns = { "/addMedia.do" })
public class AddMediaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String fileName = request.getParameter("fileName");
			String mediaName = request.getParameter("mediaName");
			int mediaDuration = Integer.parseInt(request
					.getParameter("mediaDuration"));
			System.out.print("fileName: " + fileName + "  MediaName: "
					+ mediaName + "  Duration: " + mediaDuration);

			// Find the uploaded file and get its size
			// insert record in the database
			// rename file to the inserted mediaId
			String filePath = getServletContext().getInitParameter(
					"file-upload");
			MediaBean media = new MediaBean(fileName, "image", mediaName,
					mediaDuration, 0);
			if (Connect.addMedia(filePath, media)) {

				response.getWriter().write("Success");
			} else {
				response.getWriter().write("Failure");
			}

		} catch (Exception e) {
			System.out.print("Error adding media: " + e);
			e.printStackTrace();
			response.getWriter().write("Failure");
		}

	}

}
