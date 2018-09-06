--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: branches; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.branches (
    id integer NOT NULL,
    name character varying(255),
    address character varying(255)
);


ALTER TABLE public.branches OWNER TO root;

--
-- Name: branch_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.branch_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.branch_id_seq OWNER TO root;

--
-- Name: branch_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.branch_id_seq OWNED BY public.branches.id;


--
-- Name: listeners; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.listeners (
    id integer NOT NULL,
    name character varying(100)
);


ALTER TABLE public.listeners OWNER TO root;

--
-- Name: listeners_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.listeners_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.listeners_id_seq OWNER TO root;

--
-- Name: listeners_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.listeners_id_seq OWNED BY public.listeners.id;


--
-- Name: privileges; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.privileges (
    id integer NOT NULL,
    name character varying(100) DEFAULT NULL::character varying
);


ALTER TABLE public.privileges OWNER TO root;

--
-- Name: privileges_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.privileges_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.privileges_id_seq OWNER TO root;

--
-- Name: privileges_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.privileges_id_seq OWNED BY public.privileges.id;


--
-- Name: problems; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.problems (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.problems OWNER TO root;

--
-- Name: problems_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.problems_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.problems_id_seq OWNER TO root;

--
-- Name: problems_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.problems_id_seq OWNED BY public.problems.id;


--
-- Name: status; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.status (
    id integer NOT NULL,
    name character varying(10) NOT NULL
);


ALTER TABLE public.status OWNER TO root;

--
-- Name: status_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_id_seq OWNER TO root;

--
-- Name: status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.status_id_seq OWNED BY public.status.id;


--
-- Name: subdivisions; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.subdivisions (
    id integer NOT NULL,
    name character varying(255) DEFAULT NULL::character varying
);


ALTER TABLE public.subdivisions OWNER TO root;

--
-- Name: subdivision_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.subdivision_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.subdivision_id_seq OWNER TO root;

--
-- Name: subdivision_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.subdivision_id_seq OWNED BY public.subdivisions.id;


--
-- Name: system_users; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.system_users (
    id integer NOT NULL,
    name character varying(50) DEFAULT NULL::character varying,
    family character varying(50) DEFAULT NULL::character varying,
    e_mail character varying(50),
    password character varying(100) NOT NULL,
    branch_id integer,
    subdivision_id integer
);


ALTER TABLE public.system_users OWNER TO root;

--
-- Name: system_user_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.system_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.system_user_id_seq OWNER TO root;

--
-- Name: system_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.system_user_id_seq OWNED BY public.system_users.id;


--
-- Name: tasks; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.tasks (
    id integer NOT NULL,
    name character varying(50) DEFAULT NULL::character varying,
    listener_id integer,
    text text,
    system_user_id integer,
    executor_id integer,
    operator_id integer,
    status_id integer NOT NULL
);


ALTER TABLE public.tasks OWNER TO root;

--
-- Name: task_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.task_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.task_id_seq OWNER TO root;

--
-- Name: task_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.task_id_seq OWNED BY public.tasks.id;


--
-- Name: users_privileges; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.users_privileges (
    user_id integer NOT NULL,
    privilege_id integer NOT NULL
);


ALTER TABLE public.users_privileges OWNER TO root;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.branches ALTER COLUMN id SET DEFAULT nextval('public.branch_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.listeners ALTER COLUMN id SET DEFAULT nextval('public.listeners_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.privileges ALTER COLUMN id SET DEFAULT nextval('public.privileges_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.problems ALTER COLUMN id SET DEFAULT nextval('public.problems_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.status ALTER COLUMN id SET DEFAULT nextval('public.status_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.subdivisions ALTER COLUMN id SET DEFAULT nextval('public.subdivision_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.system_users ALTER COLUMN id SET DEFAULT nextval('public.system_user_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.task_id_seq'::regclass);


--
-- Name: branch_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.branch_id_seq', 453, true);


--
-- Data for Name: branches; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.branches (id, name, address) VALUES (410, 'Минск-северный', 'Минск');
INSERT INTO public.branches (id, name, address) VALUES (1, 'Колядичи', 'Минск');
INSERT INTO public.branches (id, name, address) VALUES (404, 'Степянка', 'Минск');
INSERT INTO public.branches (id, name, address) VALUES (3, 'Воронянского', 'Минск');
INSERT INTO public.branches (id, name, address) VALUES (440, 'Брест-литовская', 'Брест-литовская 13а');
INSERT INTO public.branches (id, name, address) VALUES (441, '123', '444');


--
-- Data for Name: listeners; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.listeners (id, name) VALUES (2, 'Хозяйственный отдел');
INSERT INTO public.listeners (id, name) VALUES (1, 'Программисты');
INSERT INTO public.listeners (id, name) VALUES (92, 'Бухгалтерия');


--
-- Name: listeners_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.listeners_id_seq', 104, true);


--
-- Data for Name: privileges; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.privileges (id, name) VALUES (1, 'Admin');
INSERT INTO public.privileges (id, name) VALUES (2, 'User');
INSERT INTO public.privileges (id, name) VALUES (3, 'Operator');
INSERT INTO public.privileges (id, name) VALUES (4, 'Executor');


--
-- Name: privileges_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.privileges_id_seq', 62, true);


--
-- Data for Name: problems; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.problems (id, name) VALUES (2, 'Принтеры');
INSERT INTO public.problems (id, name) VALUES (4, 'Картриджи');
INSERT INTO public.problems (id, name) VALUES (5, 'Интернет');
INSERT INTO public.problems (id, name) VALUES (6, 'Сапод');
INSERT INTO public.problems (id, name) VALUES (7, 'Товарная касса');
INSERT INTO public.problems (id, name) VALUES (8, 'Электронная перевозка');
INSERT INTO public.problems (id, name) VALUES (9, 'Счетфактуры');


--
-- Name: problems_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.problems_id_seq', 9, true);


--
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.status (id, name) VALUES (1, 'SUBMITTED');
INSERT INTO public.status (id, name) VALUES (2, 'PENDING');
INSERT INTO public.status (id, name) VALUES (3, 'COMPLETED');
INSERT INTO public.status (id, name) VALUES (4, 'CLOSED');


--
-- Name: status_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.status_id_seq', 4, true);


--
-- Name: subdivision_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.subdivision_id_seq', 241, true);


--
-- Data for Name: subdivisions; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.subdivisions (id, name) VALUES (1, 'Админы');
INSERT INTO public.subdivisions (id, name) VALUES (2, 'Бухгалтерия
');
INSERT INTO public.subdivisions (id, name) VALUES (142, 'Маркетинг');
INSERT INTO public.subdivisions (id, name) VALUES (229, 'Жэс №32');


--
-- Name: system_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.system_user_id_seq', 156, true);


--
-- Data for Name: system_users; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (23, 'Ярослав', 'Зыскунов', 'lkghost7@gmail.com', '1', 3, 1);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (38, 'Станислав', 'Китовский', 'kit@nip.com', '1', 1, 2);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (115, 'Татьяна', 'Малькова', 'tat@i.ru', '1', 3, 1);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (22, 'Виталий', 'Ушаков', 'vinty@i.ua', '1', 1, 2);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (130, '', '', '', '', 404, 142);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (132, '1212', '1212', '1212', '1212', 1, 1);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (137, 'Василенко', 'Руслан', 'lk@belint.by', '1234567', 1, 2);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (138, '', '', 'lk@bselint.by', '12345', 3, 1);
INSERT INTO public.system_users (id, name, family, e_mail, password, branch_id, subdivision_id) VALUES (143, 'aaaaaa', '', 'sddssdsd@gfhfgh.drt', '12345', 3, 1);


--
-- Name: task_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.task_id_seq', 90, true);


--
-- Data for Name: tasks; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (68, 'Заявка №55', NULL, 'Описание проблемы', NULL, NULL, NULL, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (24, 'Levit', 1, 'какой то сложный текст', 23, 22, 23, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (25, 'Cenderel', 2, 'нако использование', 23, 22, 23, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (26, 'Gorton', 1, 'аблица Orders', 38, 23, 23, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (86, '', NULL, '', NULL, NULL, NULL, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (38, 'Заявка №1', 1, 'текст заявки', 22, 22, 23, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (39, 'Заявка №1', 1, 'текст заявки', 22, 22, 23, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (69, 'наименование заявки №33', NULL, 'Проблема возникла недавно что то сделали с принтером', NULL, NULL, NULL, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (89, 'Заявка №2', 1, 'текст заявки', 22, 22, 23, 1);
INSERT INTO public.tasks (id, name, listener_id, text, system_user_id, executor_id, operator_id, status_id) VALUES (90, 'Заявка №2', 1, 'текст заявки', 22, 22, 23, 1);


--
-- Data for Name: users_privileges; Type: TABLE DATA; Schema: public; Owner: root
--

INSERT INTO public.users_privileges (user_id, privilege_id) VALUES (22, 1);
INSERT INTO public.users_privileges (user_id, privilege_id) VALUES (23, 3);
INSERT INTO public.users_privileges (user_id, privilege_id) VALUES (23, 4);
INSERT INTO public.users_privileges (user_id, privilege_id) VALUES (137, 2);
INSERT INTO public.users_privileges (user_id, privilege_id) VALUES (138, 2);
INSERT INTO public.users_privileges (user_id, privilege_id) VALUES (143, 2);


--
-- Name: branch_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.branches
    ADD CONSTRAINT branch_pkey PRIMARY KEY (id);


--
-- Name: listeners_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.listeners
    ADD CONSTRAINT listeners_pkey PRIMARY KEY (id);


--
-- Name: privileges_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.privileges
    ADD CONSTRAINT privileges_pkey PRIMARY KEY (id);


--
-- Name: problems_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.problems
    ADD CONSTRAINT problems_pkey PRIMARY KEY (id);


--
-- Name: status_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- Name: subdivision_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.subdivisions
    ADD CONSTRAINT subdivision_pkey PRIMARY KEY (id);


--
-- Name: system_user_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT system_user_pkey PRIMARY KEY (id);


--
-- Name: task_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);


--
-- Name: users_privileges_user_id_privilege_id_pk; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.users_privileges
    ADD CONSTRAINT users_privileges_user_id_privilege_id_pk PRIMARY KEY (user_id, privilege_id);


--
-- Name: problems_name_uindex; Type: INDEX; Schema: public; Owner: root
--

CREATE UNIQUE INDEX problems_name_uindex ON public.problems USING btree (name);


--
-- Name: status_name_uindex; Type: INDEX; Schema: public; Owner: root
--

CREATE UNIQUE INDEX status_name_uindex ON public.status USING btree (name);


--
-- Name: system_users_e_mail_uindex; Type: INDEX; Schema: public; Owner: root
--

CREATE UNIQUE INDEX system_users_e_mail_uindex ON public.system_users USING btree (e_mail);


--
-- Name: system_user_branch_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT system_user_branch_id_fk FOREIGN KEY (branch_id) REFERENCES public.branches(id);


--
-- Name: system_user_subdivision_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.system_users
    ADD CONSTRAINT system_user_subdivision_id_fk FOREIGN KEY (subdivision_id) REFERENCES public.subdivisions(id);


--
-- Name: task_executor_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT task_executor_id_fk FOREIGN KEY (executor_id) REFERENCES public.system_users(id);


--
-- Name: task_operator_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT task_operator_id_fk FOREIGN KEY (operator_id) REFERENCES public.system_users(id);


--
-- Name: task_system_user_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT task_system_user_id_fk FOREIGN KEY (system_user_id) REFERENCES public.system_users(id);


--
-- Name: tasks_listeners_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_listeners_id_fk FOREIGN KEY (listener_id) REFERENCES public.listeners(id);


--
-- Name: tasks_status_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_status_id_fk FOREIGN KEY (status_id) REFERENCES public.status(id);


--
-- Name: users_privileges_privileges_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.users_privileges
    ADD CONSTRAINT users_privileges_privileges_id_fk FOREIGN KEY (privilege_id) REFERENCES public.privileges(id);


--
-- Name: users_privileges_system_user_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.users_privileges
    ADD CONSTRAINT users_privileges_system_user_id_fk FOREIGN KEY (user_id) REFERENCES public.system_users(id);


--
-- PostgreSQL database dump complete
--

