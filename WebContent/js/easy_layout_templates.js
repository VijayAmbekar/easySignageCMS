//    $('.btn-setting').click(function (e) {
//        e.preventDefault();
//        $('#myModal').modal('show');
//    });

$(document)
		.ready(
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
									$('#myModal .modal-footer').attr(
											'template-id', template_id);

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

						var canvasContext = $('#layoutTemplate')[0]
								.getContext('2d');

						canvasContext.clearRect(0, 0, 400, 225);
						$('region', $xml).each(
								function(i) {
									console.log("Region Id:"
											+ $(this).attr('id'));
									console.log("Region Top:"
											+ $(this).attr('top'));
									console.log("Region Left:"
											+ $(this).attr('left'));
									console.log("Region Width:"
											+ $(this).attr('width'));
									console.log("Region Height:"
											+ $(this).attr('height'));
									canvasContext.fillStyle = "#00f";
									canvasContext.fillRect($(this).attr('top')
											* scaleFactor, $(this).attr('left')
											* scaleFactor, $(this)
											.attr('width')
											* scaleFactor, $(this).attr(
											'height')
											* scaleFactor);
								});

					}

					$('#createLayout')
							.click(
									function() {
										try {
											strCreateLayout = "<div><h4>Create layout from template</h4><input type='text' id='save_layout_name' size='30' maxlength='30' placeholder='Enter Layout Name'/><input type='button' id='save_from_template' value='Save Layout'></div>";
											$('div.modal-footer').html(
													strCreateLayout);
											$('div.modal-footer').delegate(
													'#save_from_template',
													'click',
													saveLayoutFromTemplate);
										} catch (e) {
											console
													.log('Error in click createLayout '
															+ e);
										}
									});

					function saveLayoutFromTemplate() {
						try {
							strLayoutName = $(
									'div.modal-footer #save_layout_name').val();
							if (strLayoutName == "") {
								alert("Please enter layout name!!!")
								return;
							}

							alert("LayoutName : " + strLayoutName);
							temp_id = $('div.modal-footer').attr('template-id');
							alert("Template ID: " + temp_id);

							// send this to save this in layout and temp_layout
							// table.
							// Published layout will be in layout table
							// when layout is unpulished its modified data is in
							// temp layout and published data is in layout table
							// In unpublished state layout entry will be in both
							// layout and temp_layout tables

						} catch (e) {
							console.log('Error saving layout from template:'
									+ e);
						}
					}
				});