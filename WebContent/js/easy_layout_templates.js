//    $('.btn-setting').click(function (e) {
//        e.preventDefault();
//        $('#myModal').modal('show');
//    });

$(document).ready(
		function() {

			$('.btn-layout-popup').click(
					function(e) {
						e.preventDefault();
						template_id = $(this).attr('template-id');
						// alert("Template ID: " + template_id);

						// get this template
						$.get('ajax/ajaxGetTemplate.jsp', {
							'template-id' : template_id
						}, function(data) {
							// alert("Received : " + data);
							var jsonObject = $.parseJSON(data);

							// alert("jsonObject: " + jsonObject);

							// alert("Template Id:" +
							// jsonObject.templateId);
							// alert("Template Name:" +
							// jsonObject.templateName);
							// alert("Template XML:" +
							// jsonObject.templateXml);
							$('#myModal .modal-header h3').html(
									jsonObject.templateName);

							parseXMLLayout(jsonObject.templateXml);
						});

						$('#myModal').modal('show');
					});

			function parseXMLLayout(xmldata) {
				var xmlDoc = $.parseXML(xmldata);
				$xml = $(xmlDoc);
				$layout = $xml.find('layout');

				var layoutWidth = $layout.attr('width');
				var layoutHeight = $layout.attr('height');

				var bgcolor = $layout.attr('bgcolor');
				// alert("Width: " + layoutWidth);
				// alert("Width: " + layoutHeight);

				var realWidth = 400;
				var realHeight = 225;

				var scaleFactor = Math.min((realWidth / layoutWidth),
						(realHeight / layoutHeight));
				console.log("scalefactor: " + scaleFactor);

				var scaledWidth = scaleFactor * layoutWidth;
				var scaledHeight = scaleFactor * layoutHeight;

				console.log("sWidth: " + scaledWidth);
				console.log("sHeight: " + scaledHeight);

				// $('#myModal .modal-body')
				// .html(
				// // background:#000000
				// "<canvas id='layoutTemplate' width='"
				// + scaledWidth
				// + "' height='"
				// + scaledHeight
				// + "' style='border:solid 1px #000000;'></canvas>");


				var canvasContext = $('#layoutTemplate')[0].getContext('2d');

				canvasContext.clearRect(0, 0, 400, 225);
				$('region', $xml).each(
						function(i) {
							console.log("Region Id:" + $(this).attr('id'));
							console.log("Region Top:" + $(this).attr('top'));
							console.log("Region Left:" + $(this).attr('left'));
							console
									.log("Region Width:"
											+ $(this).attr('width'));
							console.log("Region Height:"
									+ $(this).attr('height'));
							canvasContext.fillStyle = "#00f";
							canvasContext.fillRect($(this).attr('top')
									* scaleFactor, $(this).attr('left')
									* scaleFactor, $(this).attr('width')
									* scaleFactor, $(this).attr('height')
									* scaleFactor);
						});

			}
		});