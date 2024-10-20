CREATE TABLE IF NOT EXISTS brigades
(
    uuid uuid NOT NULL,
    CONSTRAINT brigades_pkey PRIMARY KEY (uuid)
    );

CREATE TABLE IF NOT EXISTS bags
(
    id serial NOT NULL,
    weight integer NOT NULL DEFAULT 60,
    country character varying COLLATE pg_catalog."default" NOT NULL,
    percentage_of_robusta real NOT NULL,
    percentage_of_arabica real NOT NULL,
    variety character varying COLLATE pg_catalog."default" NOT NULL,
    brigade_uuid uuid,
    CONSTRAINT bags_pkey PRIMARY KEY (id),
    CONSTRAINT bags_brigade_uuid_fkey FOREIGN KEY (brigade_uuid)
    REFERENCES public.brigades (uuid) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS roasting
(
    id serial NOT NULL,
    brigade_uuid uuid NOT NULL,
    count_of_bags integer NOT NULL,
    country character varying COLLATE pg_catalog."default" NOT NULL,
    variety character varying COLLATE pg_catalog."default" NOT NULL,
    output_weight integer NOT NULL,
    CONSTRAINT roasting_pkey PRIMARY KEY (id),
    CONSTRAINT roasting_brigade_uuid_fkey FOREIGN KEY (brigade_uuid)
    REFERENCES public.brigades (uuid) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    );