create table locations
(
    id serial,
    name varchar
);

alter table locations
    add constraint locations_pk
        primary key (id);


create table facets
(
    id serial
        constraint facets_pk
        primary key,
    name varchar not null,
    dataType varchar not null
);

create table if not exists facet_values
(
    "facetId" integer
        constraint facet_values_facets_id_fk
            references facets
            on update cascade on delete cascade,
    "locationId" integer
        constraint facet_values_locations_id_fk
            references locations
            on update cascade on delete cascade,
    value varchar,
    id serial
        constraint facet_values_pk
            primary key
);

alter table facet_values owner to postgres;

create unique index if not exists facet_values_id_uindex
    on facet_values (id);

