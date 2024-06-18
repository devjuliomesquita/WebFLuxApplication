create extension if not exists "uuid-ossp";
create table if not exists tb_departments (
    "department_id" uuid primary key default uuid_generate_v4(),
    "department_name" varchar(255) not null
);