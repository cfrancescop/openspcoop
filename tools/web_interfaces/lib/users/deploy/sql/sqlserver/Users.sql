-- **** Utenti ****

CREATE TABLE users
(
	login VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	tipo_interfaccia VARCHAR(255) NOT NULL,
	permessi VARCHAR(255) NOT NULL,
	-- fk/pk columns
	id BIGINT IDENTITY,
	-- unique constraints
	CONSTRAINT unique_users_1 UNIQUE (login),
	-- fk/pk keys constraints
	CONSTRAINT pk_users PRIMARY KEY (id)
);



