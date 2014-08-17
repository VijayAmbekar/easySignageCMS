<%@ include file="header.jsp"%>
<div class="ch-container">
	<div class="row">

<%@ include file="left_menu.jsp" %>

		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Dashboard</a></li>
				</ul>
			</div>
			<div class=" row">
				<div class="col-md-3 col-sm-3 col-xs-6">
					<a data-toggle="tooltip" title="4 new pro members."
						class="well top-block" href="#"> <i
						class="glyphicon glyphicon-star green"></i>
						<div>Total Displays</div>
						<div>0</div></a>
				</div>
			</div>

			<div class="row">
				<div class="box col-md-12"></div>
			</div>

			<hr>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h3>Settings</h3>
						</div>
						<div class="modal-body">
							<p>Here settings can be configured...</p>
						</div>
						<div class="modal-footer">
							<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
							<a href="#" class="btn btn-primary" data-dismiss="modal">Save
								changes</a>
						</div>
					</div>
				</div>
			</div>

			<%@ include file="footer.jsp"%>