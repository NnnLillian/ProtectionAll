package com.example.mappers;

import com.example.entity.Location;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationMapper {
    public Location GetAllLocationByID(Integer location_id);

    public Integer GetLocationID(@Param("longitude") double longitude, @Param("latitude") double latitude);

    public void AddLocation(Location location);
}
