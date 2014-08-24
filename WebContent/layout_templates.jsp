<%@page import="com.easysignage.cms.bean.LayoutTemplate"%>
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
					<li><a href="#">Home</a>
					</li>
					<li><a href="#">Layout Templates</a>
					</li>
				</ul>
			</div>

			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-user"></i> Layout Templates
						</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i> </a> <a href="#"
								class="btn btn-close btn-round btn-default"><i
								class="glyphicon glyphicon-remove"></i> </a>
						</div>
					</div>
					<div class="box-content">
						<table
							class="table table-striped table-bordered bootstrap-datatable datatable responsive">
							<thead>
								<tr>
									<th>ID</th>
									<th>Template Name</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<LayoutTemplate> templateList = Connect
											.getLayoutTemplateList();

									if (templateList != null) {
										for (LayoutTemplate template : templateList) {
								%>
								<tr>
									<td><%=template.getTemplateID()%></td>
									<td><%=template.getTemplateName()%></td>
									<td><a href="#"
										class="btn btn-layout-popup btn-round btn-default btn-success"
										template-id="<%=template.getTemplateID()%>"><i
											class="glyphicon glyphicon-cog"></i> View</a>
									</td>
								</tr>
								<%
									}
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!--/span-->

		</div>
		<!--/row-->

		<hr>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">×</button>
						<h3>Layout Template Name</h3>
					</div>
					<div class="modal-body" align="center">
						<canvas id='layoutTemplate' width='400' height='225'
							style='border: solid 1px #000000;'></canvas>
					</div>
					<div class="modal-footer">
						<button id="createLayout"  type="button" class="btn btn-default">Create Layout</button>
						<!-- <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
						<a href="#" class="btn btn-primary" data-dismiss="modal">Save
							changes</a> -->
					</div>
				</div>
			</div>
		</div>
		<script src="js/easy_layout_templates.js"></script>
		<%@ include file="footer.jsp"%>