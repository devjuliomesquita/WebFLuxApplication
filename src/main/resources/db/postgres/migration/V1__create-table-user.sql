create table if not exists tb_users (
    "user_id" uuid primary key not null,
    "user_email" varchar(255) not null,
    "user_active" boolean not null
);