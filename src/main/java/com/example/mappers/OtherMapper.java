package com.example.mappers;

import com.example.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherMapper {
    public Category GetCategoryByName(String category_name);
    public void AddCategory(Category category);
    public void updateCategory(Category category);

    public Device GetDeviceByNameAndModel(@Param("device_name") String device_name, @Param("device_modal") String device_modal);
    public void AddDevice(Device device);

    public Element GetElementByElementAndCategoryId(@Param("element_name") String element_name, @Param("category_id") Integer category_id);
    public void AddElement(Element element);

    public Equipment GetEquipment(String equipment_id);
    public void AddEquipment(Equipment equipment);


}
