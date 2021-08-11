package com.GroupProject.demo.Repository;

import com.GroupProject.demo.Entity.Columns;
import com.GroupProject.demo.Entity.Enums.ColumnsType;
import com.GroupProject.demo.Entity.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ColumnRepositoryTest {

    @Autowired
    ColumnRepository columnRepository;
    @Autowired
    ResourceRepository resourceRepository;

    //Create Column
    @Test
    public void createColumnTest(){

        //Existing resource
        Integer resourceId = 2;
        Resource resource = resourceRepository.getOne(resourceId);

        //Create new column
        Columns column = new Columns();
        column.setContent("Quantity");
        column.setColumnsType(ColumnsType.NUMBER);
        column.setTimeCreated(LocalDateTime.now());
        column.setTimeUpdated(LocalDateTime.now());
        column.setResource(resource);

        Columns columnTest = columnRepository.save(column);

        boolean doesColumnExists = columnRepository.existsById(column.getColId());

        Assert.assertNotNull(columnTest);
        Assert.assertTrue(doesColumnExists);
        Assert.assertEquals(column, columnTest);
    }

    //Read Column
    @Test
    public void readColumnByIdTest(){
        Integer columnId = 3;

        boolean doesColumnExists = columnRepository.existsById(columnId);

        Assert.assertTrue(doesColumnExists);
    }

    //Update Column
    @Test
    public void updateColumnByIdTest(){
        Integer columnId= 3;
        Columns expected = columnRepository.getOne(columnId);
        expected.setContent("Quantity1");
        expected.setTimeUpdated(LocalDateTime.now());

        Columns actual = columnRepository.save(expected);

        Assert.assertEquals("Quantity1", actual.getContent());
    }

    //Delete Column
    @Test
    public void deleteColumnByIdTest(){

        Integer columnId= 3;

        columnRepository.deleteById(columnId);

        boolean actual = columnRepository.existsById(columnId);

        Assert.assertFalse(actual);
    }

}