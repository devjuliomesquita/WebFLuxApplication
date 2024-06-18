create extension if not exists "uuid-ossp";
create table if not exists tb_users (
    "user_id" uuid primary key default uuid_generate_v4(),
    "user_email" varchar(255) not null,
    "user_active" boolean not null
);