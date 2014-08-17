<%@page import="com.easysignage.cms.bean.MediaBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.easysignage.cms.dao.Connect"%>
<%@ include file="header.jsp"%>
<div class="ch-container">
	<div class="row">

		<%@ include file="left_menu.jsp"%>

		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Gallery</a></li>
				</ul>
			</div>

			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-picture"></i> Gallery
							</h2>

							<div class="box-icon">
								<a href="#" class="btn btn-setting btn-round btn-default"
									style='padding-top: 0; padding-left: 0;'><img
									class="glyphicon glyphicon-chevron-up" src='img/uploadlogo.png'
									width=16dpi height=16dpi
									style='top: 0; left: 0; padding: 2 2 2 2;' /> </a> <a href="#"
									class="btn btn-minimize btn-round btn-default"><i
									class="glyphicon glyphicon-chevron-up"></i> </a> <a href="#"
									class="btn btn-close btn-round btn-default"><i
									class="glyphicon glyphicon-remove"></i> </a>
							</div>
						</div>
						<div class="box-content">
							<br>
							<ul class="thumbnails gallery">
								<%
									ArrayList<MediaBean> mediaList = Connect.getImageList();

									if (mediaList != null) {
										for (MediaBean media : mediaList) {
								%>
								<li id='image-<%=media.getMediaID()%>' class="thumbnail"><a
									style="background: url(easySignageLibrary/<%=media.getFileName()%>)"
									title="Sample Image <%=media.getMediaID()%>"
									href="easySignageLibrary/<%=media.getFileName()%>"><img
										class="grayscale"
										src="easySignageLibrary/<%=media.getFileName()%>"
										alt="Sample Image <%=media.getMediaID()%>"> </a>
								</li>

								<%
									}
									}
								%>
							</ul>
						</div>
					</div>
				</div>
				<!--/span-->

			</div>
			<!--/row-->

			<!-- content ends -->
		</div>
		<!--/#content.col-md-0-->

		<hr>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h4>Upload Media</h4>
					</div>
					<div class="modal-body">
						<div class="file-upload" upload-file-name="">
							<form id="fileUploadForm" action="" method="post"
								enctype="multipart/form-data">
								Select a file to upload: <input id="fileToUpload" type="file"
									name="file" size="50" /><br /> <input id="fileUpload"
									type="submit" value="Upload File" />
							</form>
						</div>
						<div class="add-media">
							<form id="media-info" action="addMedia.do" method="post">
								<ul>
									<li>Media Name: <input type="text" id="mediaName"
										name="mediaName" size="30">
									</li>
									<li></li>
									<li>Media Duration: <input type="text" id="mediaDuration"
										name="mediaDuration" size="5">
									</li>
									<li><input type="submit" name="mediaDuration"
										value="Add Media">
									</li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/easy_gallery.js"></script>
		<%@ include file="footer.jsp"%>