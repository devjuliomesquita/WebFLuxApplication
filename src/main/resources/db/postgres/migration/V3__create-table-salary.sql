create table if not exists tb_salaries(
    "salary_id" uuid primary key not null,
    "salary_rule" varchar(255) not null,
    "salary_value" numeric(38,2)
);