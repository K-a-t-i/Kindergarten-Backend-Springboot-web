-- Adminer 4.8.1 PostgreSQL 16.3 (Debian 16.3-1.pgdg120+1) dump

\connect "bookstore";

CREATE SEQUENCE customer_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."customer" (
                                     "id" integer DEFAULT nextval('customer_id_seq') NOT NULL,
                                     "first_name" character varying(50),
                                     "last_name" character varying(50),
                                     "email" character varying(100),
                                     CONSTRAINT "customer_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "customer" ("id", "first_name", "last_name", "email") VALUES
    (123456789,	'maxi',	'maximiliane',	'maxi.aximiliane@gmail.com');

-- 2024-06-19 12:24:21.619219+00
