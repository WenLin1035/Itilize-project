package com.GroupProject.demo.Service;

import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Resource;

import java.util.List;
/*
    @Author: Wen Lin
*/
public interface ColumnsService {
    void savecolumn(Columns col);

    Columns findbyid(Integer id);

    List<Columns> findbytype(ColumnType type);

    List<Columns> findallcolumns();

    List<Resource> findallresource();

    void updatecolumncontent(Columns col);

    void updatecolumntype(Columns col);

    void deleteonecolumn(Columns col);

    void updateColumnContext(Columns col);
}
