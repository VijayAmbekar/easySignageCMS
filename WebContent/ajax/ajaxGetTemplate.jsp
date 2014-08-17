<%@page import="com.easysignage.cms.dao.Connect"%>
<%@page import="com.easysignage.cms.bean.LayoutTemplate"%>
<%@page import="org.json.simple.JSONObject"%>
<%
	int templateId = Integer.parseInt(request
			.getParameter("template-id"));

	LayoutTemplate template = Connect.getLayoutTemplate(templateId);

	JSONObject obj = new JSONObject();
	obj.put("templateId", template.getTemplateID());
	obj.put("templateName", template.getTemplateName());
	obj.put("templateXml", template.getTemplateXml());

	response.getWriter().write(obj.toString());
%>