use `boot-demo`;

create table if not exists `boot-demo`.my_message
(
    id  bigint       not null
        primary key,
    msg varchar(255) null
);
