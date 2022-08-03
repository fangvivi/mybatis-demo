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

insert into t_emp values (null,'张三',23,'男','123@qq.com',null),
                         (null,'李四',32,'女','123@qq.com',null),
                         (null,'王五',12,'男','123@qq.com',null),
                         (null,'赵六',34,'女','123@qq.com',null),
                         (null,'田七',28,'男','123@qq.com',null);

insert into t_dept values(null,'A'),(null,'B'),(null,'C');