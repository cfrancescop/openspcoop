-- **** Utenti ****

CREATE SEQUENCE seq_users AS BIGINT START WITH 1 INCREMENT BY 1 ; -- (Scommentare in hsql 2.x) NO CYCLE;

CREATE TABLE users
(
	login VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	tipo_interfaccia VARCHAR(255) NOT NULL,
	permessi VARCHAR(255) NOT NULL,
	-- fk/pk columns
	id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
	-- unique constraints
	CONSTRAINT unique_users_1 UNIQUE (login),
	-- fk/pk keys constraints
	CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE users_init_seq (id BIGINT);
INSERT INTO users_init_seq VALUES (NEXT VALUE FOR seq_users);


