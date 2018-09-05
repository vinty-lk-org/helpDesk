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
    name character varying(255),
    address character varying(255)
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
-- Name: listeners; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE listeners (
    id integer NOT NULL,
    name character varying(100)
);


ALTER TABLE listeners OWNER TO root;

--
-- Name: listeners_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE listeners_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE listeners_id_seq OWNER TO root;

--
-- Name: listeners_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE listeners_id_seq OWNED BY listeners.id;


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
    e_mail character varying(50),
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
-- Name: tasks; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE tasks (
    id integer NOT NULL,
    name character varying(50) DEFAULT NULL::character varying,
    listener_id integer,
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
-- Name: listeners id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY listeners ALTER COLUMN id SET DEFAULT nextval('listeners_id_seq'::regclass);


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
-- Name: tasks id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks ALTER COLUMN id SET DEFAULT nextval('task_id_seq'::regclass);


--
-- Name: branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('branch_id_seq', 342, true);


--
-- Data for Name: branches; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO branches VALUES (3, 'Минск', 'Minsk city');
INSERT INTO branches VALUES (1, 'Колядичи', 'Minsk city');
INSERT INTO branches VALUES (325, 'Запись для теста №1 (save)', NULL);
INSERT INTO branches VALUES (326, 'ABC', NULL);
INSERT INTO branches VALUES (327, 'DEF', NULL);


--
-- Data for Name: listeners; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO listeners VALUES (1, 'рограммисты');
INSERT INTO listeners VALUES (2, 'Хозяйственный отдел');


--
-- Name: listeners_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('listeners_id_seq', 20, true);


--
-- Data for Name: privileges; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO privileges VALUES (1, 'Admin');
INSERT INTO privileges VALUES (2, 'User');
INSERT INTO privileges VALUES (3, 'Operator');
INSERT INTO privileges VALUES (4, 'Executor');


--
-- Name: privileges_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('privileges_id_seq', 4, true);


--
-- Name: subdivision_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('subdivision_id_seq', 154, true);


--
-- Data for Name: subdivisions; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO subdivisions VALUES (1, 'Админы');
INSERT INTO subdivisions VALUES (2, 'Бухгалтерия
');


--
-- Name: system_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('system_user_id_seq', 73, true);


--
-- Data for Name: system_users; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO system_users VALUES (23, 'Ярослав', 'Зыскунов', 'lkghost7@gmail.com', NULL, '1', 3, 1);
INSERT INTO system_users VALUES (38, 'ff', 'sdfgsdfg', 'sdfg@fsdg.com', NULL, 'dfdfd', 1, 2);
INSERT INTO system_users VALUES (22, 'Виталий', 'Ушаков', 'vinty@i.ua', NULL, '1', 1, 2);


--
-- Name: task_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('task_id_seq', 32, true);


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO tasks VALUES (25, 'Cenderel', 2, 'нако использование', 23, 22, 23);
INSERT INTO tasks VALUES (24, 'Levit', 1, 'какой то сложный текст', 23, 22, 23);
INSERT INTO tasks VALUES (26, 'Gorton', 1, 'аблица Orders', 22, 23, 23);


--
-- Data for Name: users_privileges; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO users_privileges VALUES (22, 1);
INSERT INTO users_privileges VALUES (23, 3);
INSERT INTO users_privileges VALUES (23, 4);


--
-- Name: branches branch_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY branches
    ADD CONSTRAINT branch_pkey PRIMARY KEY (id);


--
-- Name: listeners listeners_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY listeners
    ADD CONSTRAINT listeners_pkey PRIMARY KEY (id);


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
-- Name: system_users_e_mail_uindex; Type: INDEX; Schema: public; Owner: root
--

CREATE UNIQUE INDEX system_users_e_mail_uindex ON system_users USING btree (e_mail);


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
-- Name: tasks tasks_listeners_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY tasks
    ADD CONSTRAINT tasks_listeners_id_fk FOREIGN KEY (listener_id) REFERENCES listeners(id);


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

