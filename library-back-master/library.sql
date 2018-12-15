--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2018-06-11 16:52:06

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 67467)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE books (
    book_id bigint NOT NULL,
    author character varying(255),
    available bigint,
    category character varying(255),
    title character varying(255)
);


ALTER TABLE books OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 67465)
-- Name: books_book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE books_book_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE books_book_id_seq OWNER TO postgres;

--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 185
-- Name: books_book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE books_book_id_seq OWNED BY books.book_id;


--
-- TOC entry 188 (class 1259 OID 67478)
-- Name: borrow; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE borrow (
    borrow_id bigint NOT NULL,
    extend boolean,
    term timestamp without time zone,
    book_id bigint,
    user_id bigint
);


ALTER TABLE borrow OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 67476)
-- Name: borrow_borrow_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE borrow_borrow_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE borrow_borrow_id_seq OWNER TO postgres;

--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 187
-- Name: borrow_borrow_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE borrow_borrow_id_seq OWNED BY borrow.borrow_id;


--
-- TOC entry 190 (class 1259 OID 67486)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE employees (
    employee_id bigint NOT NULL,
    email character varying(255),
    firstname character varying(255) NOT NULL,
    lastname character varying(255),
    password character varying(255) NOT NULL
);


ALTER TABLE employees OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 67484)
-- Name: employees_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employees_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employees_employee_id_seq OWNER TO postgres;

--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 189
-- Name: employees_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employees_employee_id_seq OWNED BY employees.employee_id;


--
-- TOC entry 192 (class 1259 OID 67497)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    user_id bigint NOT NULL,
    email character varying(255),
    firstname character varying(255),
    lastname character varying(255),
    password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 67495)
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_user_id_seq OWNER TO postgres;

--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 191
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_user_id_seq OWNED BY users.user_id;


--
-- TOC entry 2022 (class 2604 OID 67470)
-- Name: books book_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY books ALTER COLUMN book_id SET DEFAULT nextval('books_book_id_seq'::regclass);


--
-- TOC entry 2023 (class 2604 OID 67481)
-- Name: borrow borrow_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY borrow ALTER COLUMN borrow_id SET DEFAULT nextval('borrow_borrow_id_seq'::regclass);


--
-- TOC entry 2024 (class 2604 OID 67489)
-- Name: employees employee_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees ALTER COLUMN employee_id SET DEFAULT nextval('employees_employee_id_seq'::regclass);


--
-- TOC entry 2025 (class 2604 OID 67500)
-- Name: users user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN user_id SET DEFAULT nextval('users_user_id_seq'::regclass);


--
-- TOC entry 2158 (class 0 OID 67467)
-- Dependencies: 186
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY books (book_id, author, available, category, title) FROM stdin;
1	J.K rowling	2	Fantasy Heroic	Harry Potter
2	Tolkien	1	Fantasy Heroic	Seigneur des anneaux
3	Stendhal	1	Roman	Le rouge et le noir
4	Tolstoi	2	Roman historique	Guerre et paix
5	Frantz Fanon	3	Essai	Peau noire, masques blancs
6	Nabila Benattia	0	Essai politique	Trop vite
\.


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 185
-- Name: books_book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('books_book_id_seq', 6, true);


--
-- TOC entry 2160 (class 0 OID 67478)
-- Dependencies: 188
-- Data for Name: borrow; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY borrow (borrow_id, extend, term, book_id, user_id) FROM stdin;
1	f	2018-07-09 14:53:30.655	2	1
2	f	2018-07-09 14:53:47.921	5	1
\.


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 187
-- Name: borrow_borrow_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('borrow_borrow_id_seq', 2, true);


--
-- TOC entry 2162 (class 0 OID 67486)
-- Dependencies: 190
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY employees (employee_id, email, firstname, lastname, password) FROM stdin;
\.


--
-- TOC entry 2178 (class 0 OID 0)
-- Dependencies: 189
-- Name: employees_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employees_employee_id_seq', 1, false);


--
-- TOC entry 2164 (class 0 OID 67497)
-- Dependencies: 192
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (user_id, email, firstname, lastname, password) FROM stdin;
1	bou@test.com	jean	bou	oui
\.


--
-- TOC entry 2179 (class 0 OID 0)
-- Dependencies: 191
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_user_id_seq', 1, true);


--
-- TOC entry 2027 (class 2606 OID 67475)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);


--
-- TOC entry 2029 (class 2606 OID 67483)
-- Name: borrow borrow_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY borrow
    ADD CONSTRAINT borrow_pkey PRIMARY KEY (borrow_id);


--
-- TOC entry 2031 (class 2606 OID 67494)
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 2035 (class 2606 OID 67509)
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 2033 (class 2606 OID 67507)
-- Name: employees uk_j9xgmd0ya5jmus09o0b8pqrpb; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employees
    ADD CONSTRAINT uk_j9xgmd0ya5jmus09o0b8pqrpb UNIQUE (email);


--
-- TOC entry 2037 (class 2606 OID 67505)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2039 (class 2606 OID 67515)
-- Name: borrow fkrby7un94muby8qxwumbkioiu9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY borrow
    ADD CONSTRAINT fkrby7un94muby8qxwumbkioiu9 FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- TOC entry 2038 (class 2606 OID 67510)
-- Name: borrow fktrw1lxelfcyso4uenvk1wy9q5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY borrow
    ADD CONSTRAINT fktrw1lxelfcyso4uenvk1wy9q5 FOREIGN KEY (book_id) REFERENCES books(book_id);


-- Completed on 2018-06-11 16:52:07

--
-- PostgreSQL database dump complete
--

