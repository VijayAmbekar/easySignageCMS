/**
 * 
 */
package com.easysignage.cms.bean;

/**
 * @author Owner
 * 
 */
public class LayoutTemplate {
	private int templateID;
	private String templateName;
	private String templateXml;

	public LayoutTemplate(int templateID, String templateName,
			String templateXml) {
		this.templateID = templateID;
		this.templateName = templateName;
		this.templateXml = templateXml;
	}

	/**
	 * @return the templateID
	 */
	public int getTemplateID() {
		return templateID;
	}

	/**
	 * @param templateID the templateID to set
	 */
	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the templateXml
	 */
	public String getTemplateXml() {
		return templateXml;
	}

	/**
	 * @param templateXml the templateXml to set
	 */
	public void setTemplateXml(String templateXml) {
		this.templateXml = templateXml;
	}
	
}
