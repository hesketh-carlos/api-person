--liquibase formatted sql
--changeset carlos.hesketh:001
CREATE TABLE public."person" (
    "id" UUID NOT NULL,
    "name" varchar(255) NOT NULL,
    "document" varchar(20) NOT NULL,
    "documenttype" varchar(20) NOT NULL,
    "documentcountry" char(3) NOT NULL,
	"fathername" varchar(255) NULL,
	"mothername" varchar(255) NULL,
	"bloodtype" varchar(3) NULL,
	"birthcountry" char(3) NULL,
	"birthcity" varchar(255) NULL,
	"birthdate" timestamp NULL,
	"registrationdate" timestamp with time zone NOT NULL,
	"observation" varchar NULL,
    CONSTRAINT "pkPerson" PRIMARY KEY ("id")
);
COMMENT ON TABLE public."person" IS 'table person';
COMMENT ON COLUMN public."person"."id" IS 'identity';
COMMENT ON COLUMN public."person"."name" IS 'name of person';
COMMENT ON COLUMN public."person"."document" IS 'document';
COMMENT ON COLUMN public."person"."documenttype" IS 'Type of document';
COMMENT ON COLUMN public."person"."documentcountry" IS 'Alpha-3 ISO 3166-1';
COMMENT ON COLUMN public."person"."fathername" IS 'Father name';
COMMENT ON COLUMN public."person"."mothername" IS 'Mother name';
COMMENT ON COLUMN public."person"."bloodtype" IS 'Type of Blood';
COMMENT ON COLUMN public."person"."birthcountry" IS 'Alpha-3 ISO 3166-1';
COMMENT ON COLUMN public."person"."birthcity" IS 'City of Birth';
COMMENT ON COLUMN public."person"."birthdate" IS 'name of person';
COMMENT ON COLUMN public."person"."registrationdate" IS 'name of person';
COMMENT ON COLUMN public."person"."observation" IS 'name of person';