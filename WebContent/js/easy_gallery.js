$(document)
		.ready(
				function() {
					$('#fileUploadForm')
							.submit(
									function(e) {
										e.preventDefault();

										var $input = $(this).find(
												'#fileToUpload').val();

										if ($input == '') {
											alert("you must choose an image file!!!");
											return false;
										}

										var ext = $input.split('.').pop()
												.toLowerCase();

										if ($.inArray(ext, [ 'gif', 'png',
												'jpg', 'jpeg' ]) == -1) {
											alert('invalid file extension!');
											return false;
										}

										var data = new FormData(this); // <--
										// 'this'
										// is
										// your
										// form element

										$
												.ajax({
													url : 'ajax/ajaxUploadFile.jsp',
													data : data,
													cache : false,
													contentType : false,
													processData : false,
													type : 'POST',
													success : function(data) {
														try {
															var jsonObject = $
																	.parseJSON(data);
															// alert("File
															// Uploaded: "
															// +
															// jsonObject.fileName);
															$(
																	'#myModal .file-upload')
																	.attr(
																			'upload-file-name',
																			jsonObject.fileName);
															$(
																	'#myModal .file-upload')
																	.html(
																			jsonObject.fileName);
														} catch (e) {
															alert("Error parsing json: "
																	+ e);
														}

													}
												});
									});

					// Add Media Submit Event
					$('#media-info').submit(
							function(e) {
								e.preventDefault();
								var mediaName = $(this).find('#mediaName')
										.val();
								if (mediaName == '') {
									alert('Please specify media name');
									return false;
								}

								var mediDuration = $(this).find(
										'#mediaDuration').val();
								if (mediaDuration == '') {
									alert('Please specify media duration');
									return false;
								}

								var fileName = $('#myModal .file-upload').attr(
										'upload-file-name');
								alert(fileName);

								if (fileName == '') {
									alert('Please upload file first');
									return false;
								}

								var formdata = $("#media-info")
										.serializeArray();

								formdata.push({
									name : 'fileName',
									value : fileName
								});

								alert("Sending: " + formdata);

								$.ajax({
									url : 'addMedia.do',
									data : formdata,
									type : 'POST',
									success : function(rdata) {
										alert("Response: " + rdata);
										location.reload();
									}

								});

							});
				});