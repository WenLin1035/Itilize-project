package com.GroupProject.demo.Controller;

import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Resource;
import com.GroupProject.demo.Service.ColumnsService;
import com.GroupProject.demo.Service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/columns")
public class ColumnController {

    @Autowired
    private ColumnsService service;

    @PutMapping("/createcolumns")
    public void createcolumn(@RequestParam("columnName") String name,
                             @RequestParam("col_type")ColumnType type){
        Columns col = new Columns();
        col.setColumnName(name);
        col.setColumnType(type);
        service.savecolumn(col);
    }

    @GetMapping("/getcolumn")
    public Columns getcolumnbyid(@RequestParam("columnid") Integer id){
        return service.findbyid(id);
    }

    @GetMapping("/getcolumns")
    public List<Columns> getallcolumns(){
        return service.findallcolumns();
    }

    @PutMapping("/updatecolumnname")
    public Columns updatecolumnname(@RequestParam("columnid") Integer id,
                                    @RequestParam("columnName") String name){
        Columns col = service.findbyid(id);
        col.setColumnName(name);
        service.updatecolumncontent(col);
        return col;
    }
    
    @PutMapping("/deletecolumn")
    public void deletecolumn(@RequestParam("columnid") Integer id){
        service.deleteonecolumn(service.findbyid(id));
    }
}
