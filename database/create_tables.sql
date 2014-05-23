SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;






SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE "Ingredient_Flags" (
    "FK_IngredientID" integer NOT NULL,
    "FK_FlagID" integer NOT NULL
);


ALTER TABLE public."Ingredient_Flags" OWNER TO postgres;


CREATE SEQUENCE "2_FlagID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."2_FlagID_seq" OWNER TO postgres;


ALTER SEQUENCE "2_FlagID_seq" OWNED BY "Ingredient_Flags"."FK_FlagID";


CREATE SEQUENCE "2_IngredientID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."2_IngredientID_seq" OWNER TO postgres;


ALTER SEQUENCE "2_IngredientID_seq" OWNED BY "Ingredient_Flags"."FK_IngredientID";


CREATE TABLE "Article" (
    "ID" bigint NOT NULL,
    "Name" text,
    "Description" text,
    "ImageURI" text
);


ALTER TABLE public."Article" OWNER TO postgres;


COMMENT ON TABLE "Article" IS 'private IEAN id;
private String name;
private String description;
private URI imageURI;
private List<IIngredient> ingredients;
private List<IFlag> flags;
';



CREATE TABLE "Article_Flags" (
    "FK_ArticleID" bigint NOT NULL,
    "FK_FlagID" bigint NOT NULL
);


ALTER TABLE public."Article_Flags" OWNER TO postgres;


CREATE TABLE "Article_Ingredients" (
    "FK_ArticleID" bigint NOT NULL,
    "FK_IngredientID" bigint NOT NULL
);


ALTER TABLE public."Article_Ingredients" OWNER TO postgres;


CREATE TABLE "Flag" (
    "ID" integer NOT NULL,
    "Name" text NOT NULL,
    "Description" text NOT NULL,
    "LimitToProduct" boolean
);


ALTER TABLE public."Flag" OWNER TO postgres;


COMMENT ON TABLE "Flag" IS 'Flags';



CREATE TABLE "Ingredient" (
    "ID" integer NOT NULL,
    "Name" text NOT NULL
);


ALTER TABLE public."Ingredient" OWNER TO postgres;


CREATE SEQUENCE "Ingredient_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Ingredient_ID_seq" OWNER TO postgres;


ALTER SEQUENCE "Ingredient_ID_seq" OWNED BY "Ingredient"."ID";



CREATE SEQUENCE "flag_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."flag_ID_seq" OWNER TO postgres;


ALTER SEQUENCE "flag_ID_seq" OWNED BY "Flag"."ID";


ALTER TABLE ONLY "Flag" ALTER COLUMN "ID" SET DEFAULT nextval('"flag_ID_seq"'::regclass);



ALTER TABLE ONLY "Ingredient" ALTER COLUMN "ID" SET DEFAULT nextval('"Ingredient_ID_seq"'::regclass);



SELECT pg_catalog.setval('"2_FlagID_seq"', 1, false);



SELECT pg_catalog.setval('"2_IngredientID_seq"', 1, false);





SELECT pg_catalog.setval('"Ingredient_ID_seq"', 1, false);



SELECT pg_catalog.setval('"flag_ID_seq"', 1, false);



ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "2_FlagID_key" UNIQUE ("FK_FlagID");


ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "2_IngredientID_key" UNIQUE ("FK_IngredientID");



ALTER TABLE ONLY "Article_Ingredients"
    ADD CONSTRAINT "ArticleIngredientPKConstraint" PRIMARY KEY ("FK_ArticleID", "FK_IngredientID");


ALTER TABLE ONLY "Article_Flags"
    ADD CONSTRAINT "Article_FlagPK" PRIMARY KEY ("FK_ArticleID", "FK_FlagID");


--
-- Name: Article_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Article"
    ADD CONSTRAINT "Article_pkey" PRIMARY KEY ("ID");


ALTER TABLE ONLY "Ingredient"
    ADD CONSTRAINT "Ingredient_pkey" PRIMARY KEY ("ID");


ALTER TABLE ONLY "Flag"
    ADD CONSTRAINT flag_pkey PRIMARY KEY ("ID");


ALTER TABLE ONLY "Article_Flags"
    ADD CONSTRAINT "Article_Flags_FK_FlagID_fkey" FOREIGN KEY ("FK_FlagID") REFERENCES "Flag"("ID");

ALTER TABLE ONLY "Article_Ingredients"
    ADD CONSTRAINT "FK_ArticleID" FOREIGN KEY ("FK_ArticleID") REFERENCES "Article"("ID");


ALTER TABLE ONLY "Article_Flags"
    ADD CONSTRAINT "FK_ArticleID_Constraint" FOREIGN KEY ("FK_ArticleID") REFERENCES "Article"("ID");

ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "FK_Flag" FOREIGN KEY ("FK_FlagID") REFERENCES "Flag"("ID");

ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "FK_Ingredient" FOREIGN KEY ("FK_IngredientID") REFERENCES "Ingredient"("ID");


ALTER TABLE ONLY "Article_Ingredients"
    ADD CONSTRAINT "FK_IngredientID" FOREIGN KEY ("FK_IngredientID") REFERENCES "Ingredient"("ID");


REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM foodscanner;
GRANT ALL ON SCHEMA public TO foodscanner;
GRANT ALL ON SCHEMA public TO PUBLIC;

