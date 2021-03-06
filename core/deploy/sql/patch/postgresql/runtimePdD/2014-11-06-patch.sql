CREATE SEQUENCE seq_LISTA_EXT_PROTOCOL_INFO start 1 increment 1 maxvalue 9223372036854775807 minvalue 1 cache 1 CYCLE;

CREATE TABLE LISTA_EXT_PROTOCOL_INFO
(
        ID_MESSAGGIO VARCHAR(255) NOT NULL,
        TIPO VARCHAR(255) NOT NULL,
        NOME VARCHAR(255) NOT NULL,
        VALORE TEXT NOT NULL,
        -- fk/pk columns
        id BIGINT DEFAULT nextval('seq_LISTA_EXT_PROTOCOL_INFO') NOT NULL,
        -- check constraints
        CONSTRAINT chk_LISTA_EXT_PROTOCOL_INFO_1 CHECK (TIPO IN ('INBOX','OUTBOX')),
        -- fk/pk keys constraints
        CONSTRAINT fk_LISTA_EXT_PROTOCOL_INFO_1 FOREIGN KEY (ID_MESSAGGIO,TIPO) REFERENCES REPOSITORY_BUSTE(ID_MESSAGGIO,TIPO) ON DELETE CASCADE,
        CONSTRAINT pk_LISTA_EXT_PROTOCOL_INFO PRIMARY KEY (id)
);

-- index
CREATE INDEX LISTA_EXT_ID ON LISTA_EXT_PROTOCOL_INFO (ID_MESSAGGIO,TIPO);

