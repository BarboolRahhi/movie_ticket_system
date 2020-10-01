package com.capg.omts.sreen_show.exception;

import java.time.LocalDateTime;
/**
 * ErrorResponseInfo class
 *
 * @author :Devu Om SriDatta Sai Swaroop
 * @version :1.0
 * @since :2020-09-19
 **/
public class ErrorResponseInfo {
	private LocalDateTime timestamp;
	private String message;
	private String status;
	private int error;
	private String path;
	public ErrorResponseInfo() {
		super();
		
	}
	public ErrorResponseInfo(LocalDateTime timestamp, String message, String status, int error, String path) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.error = error;
		this.path = path;
	}
	
	public ErrorResponseInfo(LocalDateTime timestamp, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ErrorResponseInfo [timestamp=" + timestamp + ", message=" + message + ", status=" + status + ", error="
				+ error + ", path=" + path + "]";
	}
	
}
