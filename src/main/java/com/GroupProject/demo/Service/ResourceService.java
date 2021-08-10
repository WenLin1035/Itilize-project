package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.Resource;

import java.util.List;

public interface ResourceService {
    void saveresource(Resource resource);

    Resource findbyid(Integer id);

    Resource findbyname(String name);

    Resource findbyresourcecode(Integer code);

    void updateresourcename(Resource resource);

    void updateresourcecode(Resource resource);

    void  deletebyresource(Resource resource);

    List<Resource> findallresources();

    boolean doesresourceexist(Resource resource);
}
