package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResource;
import com.GroupProject.demo.Entity.Resource;

import java.util.List;
/*
    @Author: Wen Lin
*/
public interface ProjectResourceService {
    ProjectResource findbyid(Integer id);

    void saveprojectresource(ProjectResource pr);

    void addresourcetoproject(Integer project, Integer resource);

    Project getprojectbyprid(Integer prid);

    Resource getresourcebyprid(Integer prid);

    List<ProjectResource> getallpr();
    List<Resource> getresourcesbyproject(Integer id);

    void deleteoneprojectresource(ProjectResource pr);

    void deleteresourcefromproject(Resource resource, Project project);
}
