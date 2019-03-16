create table location_info
(
  location_id integer primary key AUTO_INCREMENT,
  longitude   decimal(8, 3) not null,
  latitude    decimal(8, 3) not null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table environment_info
(
  environment_id integer primary key AUTO_INCREMENT,
  location_id    integer       not null,
  month_time     integer       not null,
  temperature    decimal(8, 2) not null,
  rainfall       decimal(8, 2) not null,
  snowfall       decimal(8, 2) not null,
  sunshine       decimal(8, 2) not null,
  wind_level     decimal(8, 2) not null,
  pressure       decimal(8, 2) not null,
  corrosion      decimal(8, 2) not null,
  foreign key (location_id) references location_info (location_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


create table platoon_info
(
  platoon_id   integer primary key AUTO_INCREMENT,
  platoon_name varchar(32) not null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


create table army_info
(
  army_id     integer primary key AUTO_INCREMENT,
  platoon_id  integer,
  army_name   varchar(32) not null,
  army_people integer,
  foreign key (platoon_id) references platoon_info (platoon_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


create table scheme_info
(
  scheme_id         integer primary key AUTO_INCREMENT,
  scheme_name       varchar(32) not null,
  scheme_code       varchar(32) not null,
  location_id       integer     not null,
  combat_direction  varchar(32) not null,
  safeguard_mode    varchar(32) not null,
  carry_method      varchar(32) not null,
  scheme_type       varchar(32) not null,
  scheme_begin_time TIMESTAMP   not null,
  scheme_end_time   TIMESTAMP   not null,
  foreign key (location_id) references location_info (location_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


create table group_info
(
  group_id   integer primary key AUTO_INCREMENT,
  scheme_id  integer     not null,
  group_name varchar(32) not null,
  group_type varchar(32) not null,
  foreign key (scheme_id) references scheme_info (scheme_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table team_info
(
  team_id   integer primary key AUTO_INCREMENT,
  group_id  integer     not null,
  team_name varchar(32) not null,
  army_id   integer     not null,
  foreign key (group_id) references group_info (group_id),
  foreign key (army_id) references army_info (army_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table department_info
(
  department_id     integer primary key AUTO_INCREMENT,
  department_name   varchar(32) not null,
  people_max_number integer
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table category_info
(
  category_id      integer primary key AUTO_INCREMENT,
  category_name    varchar(32)  not null,
  category_type    varchar(16)  not null,
  category_unit    varchar(16)  not null,
  category_comment varchar(255) not null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table equipment_info
(
  equipment_id     integer primary key AUTO_INCREMENT,
  category_id      integer,
  equipment_name   varchar(32) not null,
  equipment_create timestamp   not null,
  army_id          integer     not null,
  foreign key (category_id) references category_info (category_id),
  foreign key (army_id) references army_info (army_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table element_info
(
  element_id   integer primary key AUTO_INCREMENT,
  category_id  integer,
  element_name varchar(32),
  element_type varchar(32),
  foreign key (category_id) references category_info (category_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table supplier_info
(
  supplier_id    integer primary key AUTO_INCREMENT,
  location_id    integer,
  supplier_name  varchar(32) not null,
  supplier_head  varchar(64),
  supplier_phone varchar(32),
  case_position  varchar(64),
  foreign key (location_id) references location_info (location_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table spare_part_info
(
  spare_part_id       integer primary key,
  element_id          integer,
  supplier_id         integer,
  spare_part_name     varchar(64),
  spare_part_model    varchar(64),
  spare_part_quantity integer,
  foreign key (element_id) references element_info (element_id),
  foreign key (supplier_id) references supplier_info (supplier_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table equipment_element_info
(
  equipment_element_id integer primary key auto_increment,
  equipment_id         integer,
  element_id           integer,
  work_time            integer,
  foreign key (equipment_id) references equipment_info (equipment_id),
  foreign key (element_id) references element_info (element_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table element_maintain_info
(
  element_maintain_id     integer primary key AUTO_INCREMENT,
  equipment_element_id    integer,
  spare_part_id           integer,
  maintain_time           timestamp,
  malfunction_description varchar(2048),
  reason_description      varchar(2048),
  foreign key (equipment_element_id) references equipment_element_info (equipment_element_id),
  foreign key (spare_part_id) references spare_part_info (spare_part_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table special_case_info
(
  case_id       integer primary key AUTO_INCREMENT,
  case_position varchar(64) not null,
  case_type     varchar(8)  not null,
  month_time    integer,
  description   varchar(1024)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
create table special_solve_info
(
  special_case_id      integer,
  special_solve_number integer,
  special_solve_body   varchar(255) not null,
  primary key (special_case_id, special_solve_number)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table scheme_army_info
(
  scheme_id   integer not null,
  army_id     integer not null,
  army_people integer not null,
  foreign key (scheme_id) references scheme_info (scheme_id),
  foreign key (army_id) references army_info (army_id),
  primary key (scheme_id, army_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table scheme_equipment_info
(
  scheme_id    integer,
  equipment_id integer,
  foreign key (scheme_id) references scheme_info (scheme_id),
  foreign key (equipment_id) references equipment_info (equipment_id),
  primary key (scheme_id, equipment_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table team_department_info
(
  team_id           integer,
  department_id     integer,
  department_people integer
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

create table team_category_info
(
  team_id         integer,
  category_id     integer,
  category_number integer,
  foreign key (team_id) references team_info (team_id),
  foreign key (category_id) references category_info (category_id),
  primary key (team_id, category_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

