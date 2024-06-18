create table if not exists tb_departments (
    "department_id" uuid primary key not null,
    "department_name" varchar(255) not null
);