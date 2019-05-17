package ua.lviv.lgs.dto;

public class MultipartUploadResponse {

	private String userFirstName;
	private String userLastName;
	private Integer userAge;
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public MultipartUploadResponse(String uFName, String uLName, Integer uAge, String fileName, String fileDownloadUri,
			String fileType, long size) {
		this.userFirstName = uFName;
		this.userLastName = uLName;
		this.userAge = uAge;
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public MultipartUploadResponse() {
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
