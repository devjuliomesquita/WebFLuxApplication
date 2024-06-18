create extension if not exists "uuid-ossp";
create table if not exists tb_salaries(
    "salary_id" uuid primary key default uuid_generate_v4(),
    "salary_rule" varchar(255) not null,
    "salary_value" numeric(38,2)
);