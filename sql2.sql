insert into platoon_info values(1,'1旅');
insert into platoon_info values(2,'2旅');
insert into army_info values(1,1,'一营',1000);
insert into army_info values(2,1,'二营',1000);
insert into army_info values(3,1,'三营',1000);
insert into army_info values(4,2,'一营',1100);
insert into army_info values(5,2,'二营',1010);
insert into army_info values(6,2,'三营',1010);
insert into category_info values(1,'指挥车','repair','辆','指挥车辆');
insert into category_info values(2,'机械维修车','repair','辆','机械维修车辆');
insert into category_info values(3,'机械备件车','repair','辆','运载维修备件');
insert into category_info values(4,'弹筒测试车','repair','辆','测试弹筒');
insert into category_info values(5,'运输车','repair','辆','运输设备');
insert into category_info values(6,'红九筒弹','equip','辆','测试弹筒');
insert into equipment_info values(1,6,'001','2018-10-01',1);
insert into equipment_info values(2,6,'002','2018-10-01',1);
insert into equipment_info values(3,6,'003','2018-10-01',1);
insert into equipment_info values(4,6,'004','2018-10-01',2);
insert into equipment_info values(5,6,'005','2018-10-01',2);
insert into equipment_info values(6,6,'006','2018-10-01',3);

insert into location_info values (1,90.5,30.3);
insert into location_info values (2,91.5,29.3);
insert into element_info values (1,6,'支腿','1');
insert into element_info values (2,6,'发射架','1');
insert into element_info values (3,6,'轮胎','1');
insert into equipment_element_info values (1,1,1,100);
insert into equipment_element_info values (2,1,2,100);
insert into equipment_element_info values (3,1,3,100);
insert into supplier_info values (1,1,'test1','001','12345678',3);
insert into supplier_info values (2,2,'test2','002','87654321',3);
insert into spare_part_info values (1,1,1,'支腿部件','x001','10');
insert into element_maintain_info values (1,1,1,'2018-02-03','不平衡','支腿损坏');