package com.beehyv.dao;

import java.util.List;

import com.beehyv.modal.Comment;

public interface CommentDAO {
	public List<Comment> getCommentByIssueId(int idIssue);
	public void addComment(Comment newComment);
	
}
