-- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- account
-- -- -- -- -- -- -- -- -- -- -- -- -- --
create table account (
    id bigint not null auto_increment,
    created_at datetime(6),
    updated_at datetime(6),
    email varchar(255),
    name varchar(255),
    password varchar(255),
    refresh_token varchar(255),
    primary key (id)
);

create table black_access_token (
    id bigint not null auto_increment,
    access_token varchar(255),
    account_id bigint,
    expired_at datetime(6),
    primary key (id)
);

-- -- -- -- -- -- -- -- -- -- -- -- -- --
-- product
-- -- -- -- -- -- -- -- -- -- -- -- -- --
create table product (
    id bigint not null auto_increment,
    created_at datetime(6),
    updated_at datetime(6),
    name varchar(255),
    price integer,
    state integer,
    primary key (id)
);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- order
-- -- -- -- -- -- -- -- -- -- -- -- -- --
create table order_item (
    id bigint not null auto_increment,
    created_at datetime(6),
    updated_at datetime(6),
    price integer not null,
    quantity integer not null,
    sub_total integer not null,
    order_id bigint,
    product_id bigint,
    primary key (id)
);

create table orders (
    id bigint not null auto_increment,
    created_at datetime(6),
    updated_at datetime(6),
    account_id bigint not null,
    address1 varchar(255),
    address2 varchar(255),
    name varchar(255),
    phone_number varchar(255),
    postal_code varchar(255),
    amount integer not null,
    status enum ('CANCELLED','DELIVERED','FAILED','PACKING','PAID','PENDING','PROCESSING','REFUNDED','RETURNED','RETURN_REQUESTED','SHIPPED','SHIPPING'),
    primary key (id)
);

alter table order_item
    add constraint order_item_ibfk_1
    foreign key (order_id)
    references orders (id);

alter table order_item
    add constraint order_item_ibfk_2
    foreign key (product_id)
    references product (id);

-- -- -- -- -- -- -- -- -- -- -- -- -- -- 
-- payment
-- -- -- -- -- -- -- -- -- -- -- -- -- --
create table payment (
    id bigint not null auto_increment,
    created_at datetime(6),
    updated_at datetime(6),
    account_id bigint not null,
    amount integer not null,
    order_id bigint not null,
    payment_type enum ('CARD','CASH','POINT'),
    status enum ('CANCELED','FAILED','PENDING','SUCCESS'),
    transaction_id varchar(255),
    primary key (id)
);

create index payment_account_id_idx on payment (account_id);
create index payment_order_id_idx on payment (order_id);
create unique index payment_transaction_id_idx on payment (transaction_id);

alter table payment
    add constraint payment_ibfk_1
    foreign key (order_id)
    references orders (id);

alter table payment
    add constraint payment_ibfk_2
    foreign key (account_id)
    references account (id);
-- -- -- -- -- -- -- -- -- -- -- -- -- -- 