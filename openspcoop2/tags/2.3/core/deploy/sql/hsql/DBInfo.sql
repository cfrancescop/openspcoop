CREATE SEQUENCE seq_db_info AS BIGINT START WITH 1 INCREMENT BY 1 ; -- (Scommentare in hsql 2.x) NO CYCLE;

CREATE TABLE db_info
(
	major_version INT NOT NULL,
	minor_version INT NOT NULL,
	notes VARCHAR(255) NOT NULL,
	-- fk/pk columns
	id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
	-- fk/pk keys constraints
	CONSTRAINT pk_db_info PRIMARY KEY (id)
);

CREATE TABLE db_info_init_seq (id BIGINT);
INSERT INTO db_info_init_seq VALUES (NEXT VALUE FOR seq_db_info);

