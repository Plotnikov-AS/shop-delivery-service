create table if not exists delivery
(
    id       uuid primary key,
    sale_id  uuid  not null,
    address  text  not null,
    products jsonb not null
);

comment on table delivery is 'Доставки';
comment on column delivery.sale_id is 'ID продажи';
comment on column delivery.address is 'Адрес доставки';
comment on column delivery.products is 'Товары';

