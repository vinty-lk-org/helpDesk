--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: branches; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE branches (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE branches OWNER TO root;

--
-- Name: branch_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE branch_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE branch_id_seq OWNER TO root;

--
-- Name: branch_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE branch_id_seq OWNED BY branches.id;


--
-- Name: privileges; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE privileges (
    id integer NOT NULL,
    name character varying(100) DEFAULT NULL::character varying
);


ALTER TABLE privileges OWNER TO root;

--
-- Name: privileges_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE privileges_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE privileges_id_seq OWNER TO root;

--
-- Name: privileges_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE privileges_id_seq OWNED BY privileges.id;


--
-- Name: subdivisions; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE subdivisions (
    id integer NOT NULL,
    name character varying(255) DEFAULT NULL::character varying
);


ALTER TABLE subdivisions OWNER TO root;

--
-- Name: subdivision_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE subdivision_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE subdivision_id_seq OWNER TO root;

--
-- Name: subdivision_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE subdivision_id_seq OWNED BY subdivisions.id;


--
-- Name: system_users; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE system_users (
    id integer NOT NULL,
    name character varying(50) DEFAULT NULL::character varying,
    family character varying(50) DEFAULT NULL::character varying,
    e_mail character varying(50) NOT NULL,
    privilege_id integer,
    password character varying(100) NOT NULL,
    branch_id integer,
    subdivision_id integer
);


ALTER TABLE system_users OWNER TO root;

--
-- Name: system_user_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE system_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE system_user_id_seq OWNER TO root;

--
-- Name: system_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE system_user_id_seq OWNED BY system_users.id;


--
-- Name: targets_of_jobs; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE targets_of_jobs (
    id integer NOT NULL,
    name character varying(100)
);


ALTER TABLE listeners2 OWNER TO root;

--
-- Name: targets_of_jobs_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE targets_of_jobs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE targets_of_jobs_id_seq OWNER TO root;

--
-- Name: targets_of_jobs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE targets_of_jobs_id_seq OWNED BY targets_of_jobs.id;


--
-- Name: tasks; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE tasks (
    id integer NOT NULL,
    name character varying(50) DEFAULT NULL::character varying,
    type_of_job_id integer,
    text text,
    system_user_id integer,
    executor_id integer,
    operator_id integer
);


ALTER TABLE tasks OWNER TO root;

--
-- Name: task_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE task_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE task_id_seq OWNER TO root;

--
-- Name: task_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE task_id_seq OWNED BY tasks.id;


--
-- Name: users_privileges; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE users_privileges (
    user_id integer NOT NULL,
    privilege_id integer NOT NULL
);


ALTER TABLE users_privileges OWNER TO root;

--
-- Name: branches id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY branches ALTER COLUMN id SET DEFAULT nextval('branch_id_seq'::regclass);


--
-- Name: privileges id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY privileges ALTER COLUMN id SET DEFAULT nextval('privileges_id_seq'::regclass);


--
-- Name: subdivisions id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY subdivisions ALTER COLUMN id SET DEFAULT nextval('subdivision_id_seq'::regclass);


--
-- Name: system_users id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY system_users ALTER COLUMN id SET DEFAULT nextval('system_user_id_seq'::regclass);


--
-- Name: targets_of_jobs id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY targets_of_jobs ALTER COLUMN id SET DEFAULT nextval('targets_of_jobs_id_seq'::regclass);


--
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks ALTER COLUMN id SET DEFAULT nextval('task_id_seq'::regclass);


--
-- Name: branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('branch_id_seq', 4, true);


--
-- Data for Name: branches; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO branches VALUES (3, 'Минск');
INSERT INTO branches VALUES (1, 'Колядичи');


--
-- Data for Name: privileges; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO privileges VALUES (1, 'Admin');
INSERT INTO privileges VALUES (2, 'User');
INSERT INTO privileges VALUES (3, 'Operator');
INSERT INTO privileges VALUES (4, 'ExecutorSql');


--
-- Name: privileges_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('privileges_id_seq', 4, true);


--
-- Name: subdivision_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('subdivision_id_seq', 12, true);


--
-- Data for Name: subdivisions; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO subdivisions VALUES (1, 'Админы');
INSERT INTO subdivisions VALUES (2, 'Бухгалтерия
');
INSERT INTO subdivisions VALUES (3, 'Маркетинг');


--
-- Name: system_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('system_user_id_seq', 37, true);


--
-- Data for Name: system_users; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO system_users VALUES (23, 'Ярослав', 'Зыскунов', 'lkghost7@gmail.com', NULL, '1', 3, 1);
INSERT INTO system_users VALUES (22, 'Виталий', 'Ушаков', 'vinty@i.ua', NULL, '1', 1, 1);


--
-- Data for Name: targets_of_jobs; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- Name: targets_of_jobs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('targets_of_jobs_id_seq', 1, false);


--
-- Name: task_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('task_id_seq', 22, true);


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- Data for Name: users_privileges; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO users_privileges VALUES (22, 1);


--
-- Name: branches branch_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY branches
    ADD CONSTRAINT branch_pkey PRIMARY KEY (id);


--
-- Name: privileges privileges_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY privileges
    ADD CONSTRAINT privileges_pkey PRIMARY KEY (id);


--
-- Name: subdivisions subdivision_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY subdivisions
    ADD CONSTRAINT subdivision_pkey PRIMARY KEY (id);


--
-- Name: system_users system_user_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY system_users
    ADD CONSTRAINT system_user_pkey PRIMARY KEY (id);


--
-- Name: targets_of_jobs targets_of_jobs_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY targets_of_jobs
    ADD CONSTRAINT targets_of_jobs_pkey PRIMARY KEY (id);


--
-- Name: tasks task_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);


--
-- Name: users_privileges users_privileges_user_id_privilege_id_pk; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY users_privileges
    ADD CONSTRAINT users_privileges_user_id_privilege_id_pk PRIMARY KEY (user_id, privilege_id);


--
-- Name: system_users system_user_branch_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY system_users
    ADD CONSTRAINT system_user_branch_id_fk FOREIGN KEY (branch_id) REFERENCES branches(id);


--
-- Name: system_users system_user_privileges_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY system_users
    ADD CONSTRAINT system_user_privileges_id_fk FOREIGN KEY (privilege_id) REFERENCES privileges(id);


--
-- Name: system_users system_user_subdivision_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY system_users
    ADD CONSTRAINT system_user_subdivision_id_fk FOREIGN KEY (subdivision_id) REFERENCES subdivisions(id);


--
-- Name: tasks task_executor_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks
    ADD CONSTRAINT task_executor_id_fk FOREIGN KEY (executor_id) REFERENCES system_users(id);


--
-- Name: tasks task_operator_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks
    ADD CONSTRAINT task_operator_id_fk FOREIGN KEY (operator_id) REFERENCES system_users(id);


--
-- Name: tasks task_system_user_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks
    ADD CONSTRAINT task_system_user_id_fk FOREIGN KEY (system_user_id) REFERENCES system_users(id);


--
-- Name: tasks task_type_of_job_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks
    ADD CONSTRAINT task_type_of_job_id_fk FOREIGN KEY (target_of_job_id) REFERENCES privileges(id);


--
-- Name: users_privileges users_privileges_privileges_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY users_privileges
    ADD CONSTRAINT users_privileges_privileges_id_fk FOREIGN KEY (privilege_id) REFERENCES privileges(id);


--
-- Name: users_privileges users_privileges_system_user_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY users_privileges
    ADD CONSTRAINT users_privileges_system_user_id_fk FOREIGN KEY (user_id) REFERENCES system_users(id);


--
-- PostgreSQL database dump complete
--

