package com.beehyv.modal;

import java.sql.Date;


public class Issue {
	private int idIssue;
	private String issueTitle;
	private String issueDescription;
	private Date issueDueDate;
	private int idIssueAssignee;
	private String issueAssigneeName;
	private int idIssueReporter;
	private int idRelease;
	private String issueStatus;
	public int getIdIssue() {
		return idIssue;
	}
	public void setIdIssue(int idIssue) {
		this.idIssue = idIssue;
	}
	public String getIssueTitle() {
		return issueTitle;
	}
	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}
	public String getIssueDescription() {
		return issueDescription;
	}
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	public Date getIssueDueDate() {
		return issueDueDate;
	}
	public void setIssueDueDate(Date issueDueDate) {
		this.issueDueDate = issueDueDate;
	}
	public int getIdIssueAssignee() {
		return idIssueAssignee;
	}
	public void setIdIssueAssignee(int idIssueAssignee) {
		this.idIssueAssignee = idIssueAssignee;
	}
	public int getIdIssueReporter() {
		return idIssueReporter;
	}
	public void setIdIssueReporter(int idIssueReporter) {
		this.idIssueReporter = idIssueReporter;
	}
	public int getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(int idRelease) {
		this.idRelease = idRelease;
	}
	
	public String toString(){
		return"";
	}
	public String getIssueAssigneeName() {
		return issueAssigneeName;
	}
	public void setIssueAssigneeName(String issueAssigneeName) {
		this.issueAssigneeName = issueAssigneeName;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

}
