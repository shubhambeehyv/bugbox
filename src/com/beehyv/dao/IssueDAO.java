package com.beehyv.dao;
import java.util.List;

import com.beehyv.modal.Issue;

public interface IssueDAO {
	public List<Issue> getIssueByReleaseId(int idRelease);
	public void addIssue(Issue newIssue);
		
	

}
