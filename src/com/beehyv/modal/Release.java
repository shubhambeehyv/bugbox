package com.beehyv.modal;

import java.sql.Date;


public class Release {
	private int idRelease;
	private String releaseName;
	private String releaseDescription;
	private String releaseStatus;
	private Date releaseDate;
	private String releaseNote;
	private int idProject;
	public int getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(int idRelease) {
		this.idRelease = idRelease;
	}
	public String getReleaseName() {
		return releaseName;
	}
	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}
	public String getReleaseDescription() {
		return releaseDescription;
	}
	public void setReleaseDescription(String releaseDescription) {
		this.releaseDescription = releaseDescription;
	}
	public String getReleaseStatus() {
		return releaseStatus;
	}
	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getReleaseNote() {
		return releaseNote;
	}
	public void setReleaseNote(String releaseNote) {
		this.releaseNote = releaseNote;
	}
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	
	public String toString(){
		return "";
	}
	
}
