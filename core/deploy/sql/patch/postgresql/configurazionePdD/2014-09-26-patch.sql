ALTER TABLE configurazione ADD COLUMN validazione_contenuti_mtom VARCHAR(255);

ALTER TABLE porte_delegate ADD COLUMN mtom_request_mode VARCHAR(255);
ALTER TABLE porte_delegate ADD COLUMN mtom_response_mode VARCHAR(255);
ALTER TABLE porte_delegate ADD COLUMN ws_security_mtom_req VARCHAR(255);
ALTER TABLE porte_delegate ADD COLUMN ws_security_mtom_res VARCHAR(255);
ALTER TABLE porte_delegate ADD COLUMN validazione_contenuti_mtom VARCHAR(255);

CREATE SEQUENCE seq_pd_mtom_request start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_mtom_request
(
        id_porta BIGINT NOT NULL,
        nome VARCHAR(255) NOT NULL,
	pattern TEXT NOT NULL,
	content_type VARCHAR(255),
	required INT NOT NULL,
        -- fk/pk columns
        id BIGINT DEFAULT nextval('seq_pd_mtom_request') NOT NULL,
        -- fk/pk keys constraints
        CONSTRAINT fk_pd_mtom_request_1 FOREIGN KEY (id_porta) REFERENCES porte_delegate(id),
        CONSTRAINT pk_pd_mtom_request PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_PD_MTOMTREQ ON pd_mtom_request (id_porta);



CREATE SEQUENCE seq_pd_mtom_response start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pd_mtom_response
(
        id_porta BIGINT NOT NULL,
        nome VARCHAR(255) NOT NULL,
	pattern TEXT NOT NULL,
	content_type VARCHAR(255),
	required INT NOT NULL,
        -- fk/pk columns
        id BIGINT DEFAULT nextval('seq_pd_mtom_response') NOT NULL,
        -- fk/pk keys constraints
        CONSTRAINT fk_pd_mtom_response_1 FOREIGN KEY (id_porta) REFERENCES porte_delegate(id),
        CONSTRAINT pk_pd_mtom_response PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_PD_MTOMTRES ON pd_mtom_response (id_porta);



ALTER TABLE porte_applicative ADD COLUMN mtom_request_mode VARCHAR(255);
ALTER TABLE porte_applicative ADD COLUMN mtom_response_mode VARCHAR(255);
ALTER TABLE porte_applicative ADD COLUMN ws_security_mtom_req VARCHAR(255);
ALTER TABLE porte_applicative ADD COLUMN ws_security_mtom_res VARCHAR(255);
ALTER TABLE porte_applicative ADD COLUMN validazione_contenuti_mtom VARCHAR(255);


CREATE SEQUENCE seq_pa_mtom_request start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_mtom_request
(
        id_porta BIGINT NOT NULL,
        nome VARCHAR(255) NOT NULL,
	pattern TEXT NOT NULL,
	content_type VARCHAR(255),
	required INT NOT NULL,
        -- fk/pk columns
        id BIGINT DEFAULT nextval('seq_pa_mtom_request') NOT NULL,
        -- fk/pk keys constraints
        CONSTRAINT fk_pa_mtom_request_1 FOREIGN KEY (id_porta) REFERENCES porte_applicative(id),
        CONSTRAINT pk_pa_mtom_request PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_PA_MTOMTREQ ON pa_mtom_request (id_porta);



CREATE SEQUENCE seq_pa_mtom_response start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 NO CYCLE;

CREATE TABLE pa_mtom_response
(
        id_porta BIGINT NOT NULL,
        nome VARCHAR(255) NOT NULL,
	pattern TEXT NOT NULL,
	content_type VARCHAR(255),
	required INT NOT NULL,
        -- fk/pk columns
        id BIGINT DEFAULT nextval('seq_pa_mtom_response') NOT NULL,
        -- fk/pk keys constraints
        CONSTRAINT fk_pa_mtom_response_1 FOREIGN KEY (id_porta) REFERENCES porte_applicative(id),
        CONSTRAINT pk_pa_mtom_response PRIMARY KEY (id)
);

-- index
CREATE INDEX INDEX_PA_MTOMTRES ON pa_mtom_response (id_porta);

