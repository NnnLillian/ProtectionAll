package com.example;

import com.example.entity.Category;
import com.example.entity.Group;
import com.example.mappers.EquipmentMapper;
import com.example.mappers.GroupMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;



    @Test
    public void checkGetGroup(){
        Group group1 = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(12, "repair");
        System.out.println(group1);
    }

    @Test
    public void getProtectCategory(){
        List<Category> categoryList = equipmentMapper.GetCategoryByPlatoonIdAndType(1,"protect");
        System.out.println(categoryList);
    }
}
