package com.GroupProject.demo.Service.impl;

import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Repository.ColumnsRepository;
import com.GroupProject.demo.Service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ColumnsServiceImp implements ColumnsService {

    @Autowired
    ColumnsRepository repository;

    @Override
    public void savecolumn(Columns col) {
        col.setCreatedata(LocalDate.now());
        col.setLastupdate(LocalDate.now());
        repository.save(col);
    }

    @Override
    public Columns findbyid(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Columns> findbytype(ColumnType type) {
        List<Columns> all = repository.findAll();
        List<Columns> result = new ArrayList<>();
        for(Columns temp : all){
            if(temp.getColumnType().equals(type)){
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public List<Columns> findallcolumns() {
        return repository.findAll();
    }

    @Override
    public List<Resource> findallresource() {
        List<Columns> allcol = repository.findAll();
        List<Resource> allresource = new ArrayList<>();
        for (Columns temp: allcol){
            if(!allresource.contains(temp.getResource())){
                allresource.add(temp.getResource());
            }
        }
        return allresource;
    }

    @Override
    public void updatecolumncontent(Columns col) {
        col.setLastupdate(LocalDate.now());
        repository.save(col);
    }

    @Override
    public void updatecolumntype(Columns col) {
        col.setLastupdate(LocalDate.now());
        repository.save(col);
    }

    @Override
    public void deleteonecolumn(Columns col) {
        repository.delete(col);
    }
}
