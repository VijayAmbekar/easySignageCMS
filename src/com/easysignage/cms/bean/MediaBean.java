/**
 * 
 */
package com.easysignage.cms.bean;

/**
 * @author Owner
 * 
 */
public class MediaBean {

	private int mediaID;
	private String fileName;
	private String mediaType;
	private String mediaName;
	private int mediaDuration;
	private long mediaSize;

	public MediaBean(String fileName, String type, String name, int duration,
			int size) {
		this.fileName = fileName;
		this.mediaType = type;
		this.mediaName = name;
		this.mediaDuration = duration;
		this.mediaSize = size;
	}

	public MediaBean(int mediaID, String type, String name, String fileName,
			int duration, int size) {
		this.mediaID = mediaID;
		this.fileName = fileName;
		this.mediaType = type;
		this.mediaName = name;
		this.mediaDuration = duration;
		this.mediaSize = size;
	}

	/**
	 * @return the mediaID
	 */
	public int getMediaID() {
		return mediaID;
	}

	/**
	 * @param mediaID
	 *            the mediaID to set
	 */
	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * @param mediaType
	 *            the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @return the mediaName
	 */
	public String getMediaName() {
		return mediaName;
	}

	/**
	 * @param mediaName
	 *            the mediaName to set
	 */
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	/**
	 * @return the mediaDuration
	 */
	public int getMediaDuration() {
		return mediaDuration;
	}

	/**
	 * @param mediaDuration
	 *            the mediaDuration to set
	 */
	public void setMediaDuration(int mediaDuration) {
		this.mediaDuration = mediaDuration;
	}

	/**
	 * @return the mediaSize
	 */
	public long getMediaSize() {
		return mediaSize;
	}

	/**
	 * @param mediaSize
	 *            the mediaSize to set
	 */
	public void setMediaSize(long mediaSize) {
		this.mediaSize = mediaSize;
	}

}
