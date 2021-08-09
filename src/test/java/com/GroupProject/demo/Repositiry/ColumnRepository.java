package com.GroupProject.demo.Repositiry;

import com.GroupProject.demo.Entity.ColumnType;
import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Repository.ColumnsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ColumnRepository {
    @Autowired
    ColumnsRepository columnRepository;
    @Test
    public void saveTest(){
        Columns col = new Columns();
        col.setColumnName("column1");
        col.setColumnType(ColumnType.TEXT);
        Columns test = columnRepository.save(col);
        System.out.println(test);
    }
}
