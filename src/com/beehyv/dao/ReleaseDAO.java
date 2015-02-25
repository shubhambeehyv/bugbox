package com.beehyv.dao;

import java.util.List;

import com.beehyv.modal.Release;


public interface ReleaseDAO  {
	public List<Release> getReleasesByProjectId(int idProject);
	public void addRelease(Release newRelease); 
	public Release getReleaseByReleaseId(int idRelease);

}
