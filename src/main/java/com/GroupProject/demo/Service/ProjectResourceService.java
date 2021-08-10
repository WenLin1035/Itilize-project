package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.Project;
import com.GroupProject.demo.Entity.ProjectResource;
import com.GroupProject.demo.Entity.Resource;

import java.util.List;

public interface ProjectResourceService {
    ProjectResource findbyid(Integer id);

    void saveprojectresource(ProjectResource pr);

    void addresourcetoproject(Project project, Resource resource);

    Project getprojectbyprid(Integer prid);

    Resource getresourcebyprid(Integer prid);

    void deleteoneprojectresource(ProjectResource pr);

    void deleteresourcefromproject(Resource resource, Project project);
}
