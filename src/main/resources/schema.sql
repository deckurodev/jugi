--
-- create schema hotel;
-- use hotel;

DROP TABLE  if exists hotel.acco_image_map;
create table hotel.acco_image_map
(
    acco_id       bigint null,
    main_image_id bigint null
);

