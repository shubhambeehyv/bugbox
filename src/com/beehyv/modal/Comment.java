package com.beehyv.modal;


public class Comment {
	private int idComment;
	private String comment;
	private int idCommentedBy;
	private int idIssue;
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getIdIssue() {
		return idIssue;
	}
	public void setIdIssue(int idIssue) {
		this.idIssue = idIssue;
	}
	public String toString(){
		return"";
	}
	public int getIdCommentedBy() {
		return idCommentedBy;
	}
	public void setIdCommentedBy(int idCommentedBy) {
		this.idCommentedBy = idCommentedBy;
	}
}
