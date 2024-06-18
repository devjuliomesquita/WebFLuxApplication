create extension if not exists "uuid-ossp";
create table if not exists tb_employees(
    "employee_id" uuid primary key default uuid_generate_v4(),
    "employee_name" varchar(255) not null,
    "employee_age" int,
    "employee_user_id" uuid,
    "employee_department_id" uuid,
    "employee_salary_id" uuid,
    foreign key (employee_user_id) references "tb_users"(user_id),
    foreign key (employee_department_id) references "tb_departments"(department_id),
    foreign key (employee_salary_id) references "tb_salaries"(salary_id)
);