package com.example;

import com.example.entity.Group;
import com.example.mappers.GroupMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private GroupMapper groupMapper;



    @Test
    public void checkGetGroup(){
        Group group1 = groupMapper.GetSchemeGroupBySchemeIdAndGroupType(12, "repair");
        System.out.println(group1);
    }
}
