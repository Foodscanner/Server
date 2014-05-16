--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public."Article_Ingredients" DROP CONSTRAINT "FK_IngredientID";
ALTER TABLE ONLY public."Ingredient_Flags" DROP CONSTRAINT "FK_Ingredient";
ALTER TABLE ONLY public."Ingredient_Flags" DROP CONSTRAINT "FK_Flag";
ALTER TABLE ONLY public."Article_Flags" DROP CONSTRAINT "FK_ArticleID_Constraint";
ALTER TABLE ONLY public."Article_Ingredients" DROP CONSTRAINT "FK_ArticleID";
ALTER TABLE ONLY public."Article_Flags" DROP CONSTRAINT "Article_Flags_FK_FlagID_fkey";
ALTER TABLE ONLY public."Flag" DROP CONSTRAINT flag_pkey;
ALTER TABLE ONLY public."Ingredient" DROP CONSTRAINT "Ingredient_pkey";
ALTER TABLE ONLY public."Article" DROP CONSTRAINT "Article_pkey";
ALTER TABLE ONLY public."Article_Flags" DROP CONSTRAINT "Article_FlagPK";
ALTER TABLE ONLY public."Article_Ingredients" DROP CONSTRAINT "ArticleIngredientPKConstraint";
ALTER TABLE ONLY public."Ingredient_Flags" DROP CONSTRAINT "2_IngredientID_key";
ALTER TABLE ONLY public."Ingredient_Flags" DROP CONSTRAINT "2_FlagID_key";
ALTER TABLE public."Ingredient" ALTER COLUMN "ID" DROP DEFAULT;
ALTER TABLE public."Flag" ALTER COLUMN "ID" DROP DEFAULT;
DROP SEQUENCE public."flag_ID_seq";
DROP SEQUENCE public."Ingredient_ID_seq";
DROP TABLE public."Ingredient";
DROP TABLE public."Flag";
DROP TABLE public."Article_Ingredients";
DROP TABLE public."Article_Flags";
DROP TABLE public."Article";
DROP SEQUENCE public."2_IngredientID_seq";
DROP SEQUENCE public."2_FlagID_seq";
DROP TABLE public."Ingredient_Flags";
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: foodscanner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO foodscanner;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: foodscanner
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: Ingredient_Flags; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Ingredient_Flags" (
    "IngredientID" integer NOT NULL,
    "FlagID" integer NOT NULL
);


ALTER TABLE public."Ingredient_Flags" OWNER TO postgres;

--
-- Name: 2_FlagID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "2_FlagID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."2_FlagID_seq" OWNER TO postgres;

--
-- Name: 2_FlagID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "2_FlagID_seq" OWNED BY "Ingredient_Flags"."FlagID";


--
-- Name: 2_IngredientID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "2_IngredientID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."2_IngredientID_seq" OWNER TO postgres;

--
-- Name: 2_IngredientID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "2_IngredientID_seq" OWNED BY "Ingredient_Flags"."IngredientID";


--
-- Name: Article; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Article" (
    "ID" bigint NOT NULL,
    "Name" text,
    "Description" text,
    "ImageURI" text
);


ALTER TABLE public."Article" OWNER TO postgres;

--
-- Name: TABLE "Article"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE "Article" IS 'private IEAN id;
private String name;
private String description;
private URI imageURI;
private List<IIngredient> ingredients;
private List<IFlag> flags;
';


--
-- Name: Article_Flags; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Article_Flags" (
    "FK_ArticleID" bigint NOT NULL,
    "FK_FlagID" bigint NOT NULL
);


ALTER TABLE public."Article_Flags" OWNER TO postgres;

--
-- Name: Article_Ingredients; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Article_Ingredients" (
    "ArticleID" bigint NOT NULL,
    "IngredientID" bigint NOT NULL
);


ALTER TABLE public."Article_Ingredients" OWNER TO postgres;

--
-- Name: Flag; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Flag" (
    "ID" integer NOT NULL,
    "Name" text NOT NULL,
    "Description" text NOT NULL,
    "LimitToProduct" boolean
);


ALTER TABLE public."Flag" OWNER TO postgres;

--
-- Name: TABLE "Flag"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE "Flag" IS 'Flags';


--
-- Name: Ingredient; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "Ingredient" (
    "ID" integer NOT NULL,
    "Name" text NOT NULL
);


ALTER TABLE public."Ingredient" OWNER TO postgres;

--
-- Name: Ingredient_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Ingredient_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Ingredient_ID_seq" OWNER TO postgres;

--
-- Name: Ingredient_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Ingredient_ID_seq" OWNED BY "Ingredient"."ID";


--
-- Name: flag_ID_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "flag_ID_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."flag_ID_seq" OWNER TO postgres;

--
-- Name: flag_ID_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "flag_ID_seq" OWNED BY "Flag"."ID";


--
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Flag" ALTER COLUMN "ID" SET DEFAULT nextval('"flag_ID_seq"'::regclass);


--
-- Name: ID; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Ingredient" ALTER COLUMN "ID" SET DEFAULT nextval('"Ingredient_ID_seq"'::regclass);


--
-- Name: 2_FlagID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"2_FlagID_seq"', 1, false);


--
-- Name: 2_IngredientID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"2_IngredientID_seq"', 1, false);


--
-- Data for Name: Article; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: Article_Flags; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: Article_Ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: Flag; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: Ingredient; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: Ingredient_Flags; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: Ingredient_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Ingredient_ID_seq"', 1, false);


--
-- Name: flag_ID_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"flag_ID_seq"', 1, false);


--
-- Name: 2_FlagID_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "2_FlagID_key" UNIQUE ("FlagID");


--
-- Name: 2_IngredientID_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "2_IngredientID_key" UNIQUE ("IngredientID");


--
-- Name: ArticleIngredientPKConstraint; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Article_Ingredients"
    ADD CONSTRAINT "ArticleIngredientPKConstraint" PRIMARY KEY ("ArticleID", "IngredientID");


--
-- Name: Article_FlagPK; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Article_Flags"
    ADD CONSTRAINT "Article_FlagPK" PRIMARY KEY ("FK_ArticleID", "FK_FlagID");


--
-- Name: Article_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Article"
    ADD CONSTRAINT "Article_pkey" PRIMARY KEY ("ID");


--
-- Name: Ingredient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Ingredient"
    ADD CONSTRAINT "Ingredient_pkey" PRIMARY KEY ("ID");


--
-- Name: flag_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "Flag"
    ADD CONSTRAINT flag_pkey PRIMARY KEY ("ID");


--
-- Name: Article_Flags_FK_FlagID_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Article_Flags"
    ADD CONSTRAINT "Article_Flags_FK_FlagID_fkey" FOREIGN KEY ("FK_FlagID") REFERENCES "Flag"("ID");


--
-- Name: FK_ArticleID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Article_Ingredients"
    ADD CONSTRAINT "FK_ArticleID" FOREIGN KEY ("ArticleID") REFERENCES "Article"("ID");


--
-- Name: FK_ArticleID_Constraint; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Article_Flags"
    ADD CONSTRAINT "FK_ArticleID_Constraint" FOREIGN KEY ("FK_ArticleID") REFERENCES "Article"("ID");


--
-- Name: FK_Flag; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "FK_Flag" FOREIGN KEY ("FlagID") REFERENCES "Flag"("ID");


--
-- Name: FK_Ingredient; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Ingredient_Flags"
    ADD CONSTRAINT "FK_Ingredient" FOREIGN KEY ("IngredientID") REFERENCES "Ingredient"("ID");


--
-- Name: FK_IngredientID; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Article_Ingredients"
    ADD CONSTRAINT "FK_IngredientID" FOREIGN KEY ("IngredientID") REFERENCES "Ingredient"("ID");


--
-- Name: public; Type: ACL; Schema: -; Owner: foodscanner
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM foodscanner;
GRANT ALL ON SCHEMA public TO foodscanner;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
