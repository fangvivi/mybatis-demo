create table t_user
(
    id       int primary key not null auto_increment,
    username varchar(20),
    password varchar(20),
    age      int,
    sex      char,
    email    varchar(30)
) engine = innodb
  charset = utf8mb4;

create table t_dept
(
    did       int primary key not null auto_increment,
    dept_name varchar(20)
) charset = utf8mb4;

create table t_emp
(
    eid      int primary key not null auto_increment,
    emp_name varchar(20),
    age      int,
    sex      char(1),
    email    varchar(20),
    did      int
) charset = utf8mb4;