-- **** Messaggi ****

CREATE TABLE MESSAGGI
(
	ID_MESSAGGIO VARCHAR(255) NOT NULL,
	TIPO VARCHAR(255) NOT NULL,
	RIFERIMENTO_MSG VARCHAR(255),
	ERRORE_PROCESSAMENTO MEDIUMTEXT,
	-- data dalla quale il msg puo' essere rispedito in caso di errori
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	RISPEDIZIONE TIMESTAMP(3) NOT NULL DEFAULT 0,
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	ORA_REGISTRAZIONE TIMESTAMP(3) NOT NULL DEFAULT 0,
	PROPRIETARIO VARCHAR(255),
	-- le colonne seguenti servono per il servizio di TransactionManager
	MOD_RICEZ_CONT_APPLICATIVI VARCHAR(255),
	MOD_RICEZ_BUSTE VARCHAR(255),
	MOD_INOLTRO_BUSTE VARCHAR(255),
	MOD_INOLTRO_RISPOSTE VARCHAR(255),
	MOD_IMBUSTAMENTO VARCHAR(255),
	MOD_IMBUSTAMENTO_RISPOSTE VARCHAR(255),
	MOD_SBUSTAMENTO VARCHAR(255),
	MOD_SBUSTAMENTO_RISPOSTE VARCHAR(255),
	-- Thread Pool:impedisce la gestione di messaggi gia schedulati
	SCHEDULING INT DEFAULT 0,
	-- permette la riconsegna del messaggio dopo tot tempo
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	REDELIVERY_DELAY TIMESTAMP(3) NOT NULL DEFAULT 0,
	-- numero di riconsegne effettuate
	REDELIVERY_COUNT INT DEFAULT 0,
	-- id del nodo del cluster che deve gestire questo messaggio.
	CLUSTER_ID VARCHAR(255),
	-- memorizza l'ora in cui il messaggio e stato schedulato la prima volta
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	SCHEDULING_TIME TIMESTAMP(3) DEFAULT 0,
	-- contiene un messaggio serializzato
	MSG_BYTES MEDIUMBLOB,
	CORRELAZIONE_APPLICATIVA VARCHAR(255),
	CORRELAZIONE_RISPOSTA VARCHAR(255),
	PROTOCOLLO VARCHAR(255) NOT NULL,
	-- fk/pk columns
	-- check constraints
	CONSTRAINT chk_MESSAGGI_1 CHECK (TIPO IN ('INBOX','OUTBOX')),
	-- fk/pk keys constraints
	CONSTRAINT pk_MESSAGGI PRIMARY KEY (ID_MESSAGGIO,TIPO)
)ENGINE INNODB CHARACTER SET latin1 COLLATE latin1_general_cs;

-- index
CREATE INDEX MESSAGGI_SEARCH ON MESSAGGI (ORA_REGISTRAZIONE,RIFERIMENTO_MSG,TIPO,PROPRIETARIO);
CREATE INDEX MESSAGGI_RIFMSG ON MESSAGGI (RIFERIMENTO_MSG);
CREATE INDEX MESSAGGI_TESTSUITE ON MESSAGGI (PROPRIETARIO,ID_MESSAGGIO,RIFERIMENTO_MSG);

CREATE TABLE MSG_SERVIZI_APPLICATIVI
(
	ID_MESSAGGIO VARCHAR(255) NOT NULL,
	TIPO VARCHAR(255) NOT NULL DEFAULT 'INBOX',
	SERVIZIO_APPLICATIVO VARCHAR(255) NOT NULL,
	SBUSTAMENTO_SOAP INT NOT NULL,
	SBUSTAMENTO_INFO_PROTOCOL INT NOT NULL,
	INTEGRATION_MANAGER INT NOT NULL,
	MOD_CONSEGNA_CONT_APPLICATIVI VARCHAR(255),
	-- Assume il valore 'Connettore' se la consegna avviente tramite un connettore,
	-- 'ConnectionReply' se viene ritornato tramite connectionReply,
	-- 'IntegrationManager' se e' solo ottenibile tramite IntegrationManager
	TIPO_CONSEGNA VARCHAR(255) NOT NULL,
	ERRORE_PROCESSAMENTO TEXT,
	-- data dalla quale il msg puo' essere rispedito in caso di errori
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	RISPEDIZIONE TIMESTAMP(3) NOT NULL DEFAULT 0,
	NOME_PORTA VARCHAR(255),
	-- fk/pk columns
	-- check constraints
	CONSTRAINT chk_MSG_SERVIZI_APPLICATIVI_1 CHECK (TIPO IN ('INBOX','OUTBOX')),
	CONSTRAINT chk_MSG_SERVIZI_APPLICATIVI_2 CHECK (TIPO_CONSEGNA IN ('Connettore','ConnectionReply','IntegrationManager')),
	-- fk/pk keys constraints
	CONSTRAINT fk_MSG_SERVIZI_APPLICATIVI_1 FOREIGN KEY (ID_MESSAGGIO,TIPO) REFERENCES MESSAGGI(ID_MESSAGGIO,TIPO) ON DELETE CASCADE,
	CONSTRAINT pk_MSG_SERVIZI_APPLICATIVI PRIMARY KEY (ID_MESSAGGIO,SERVIZIO_APPLICATIVO)
)ENGINE INNODB CHARACTER SET latin1 COLLATE latin1_general_cs;

-- index
CREATE INDEX MSG_SERV_APPL_LIST ON MSG_SERVIZI_APPLICATIVI (SERVIZIO_APPLICATIVO,INTEGRATION_MANAGER);
CREATE INDEX MSG_SERV_APPL_TIMEOUT ON MSG_SERVIZI_APPLICATIVI (ID_MESSAGGIO,TIPO_CONSEGNA,INTEGRATION_MANAGER);

CREATE TABLE DEFINIZIONE_MESSAGGI
(
	ID_MESSAGGIO VARCHAR(255) NOT NULL,
	TIPO VARCHAR(255) NOT NULL,
	SOAP_ACTION VARCHAR(255),
	CONTENT_TYPE VARCHAR(255) NOT NULL,
	CONTENT_LOCATION VARCHAR(255),
	MSG_BYTES MEDIUMBLOB,
	-- fk/pk columns
	-- check constraints
	CONSTRAINT chk_DEFINIZIONE_MESSAGGI_1 CHECK (TIPO IN ('INBOX','OUTBOX')),
	-- fk/pk keys constraints
	CONSTRAINT fk_DEFINIZIONE_MESSAGGI_1 FOREIGN KEY (ID_MESSAGGIO,TIPO) REFERENCES MESSAGGI(ID_MESSAGGIO,TIPO) ON DELETE CASCADE,
	CONSTRAINT pk_DEFINIZIONE_MESSAGGI PRIMARY KEY (ID_MESSAGGIO,TIPO)
)ENGINE INNODB CHARACTER SET latin1 COLLATE latin1_general_cs;


-- **** Correlazione Applicativa ****

CREATE TABLE CORRELAZIONE_APPLICATIVA
(
	ID_MESSAGGIO VARCHAR(255) NOT NULL,
	ID_APPLICATIVO VARCHAR(255) NOT NULL,
	SERVIZIO_APPLICATIVO VARCHAR(255) NOT NULL,
	TIPO_MITTENTE VARCHAR(255) NOT NULL,
	MITTENTE VARCHAR(255) NOT NULL,
	TIPO_DESTINATARIO VARCHAR(255) NOT NULL,
	DESTINATARIO VARCHAR(255) NOT NULL,
	TIPO_SERVIZIO VARCHAR(255),
	SERVIZIO VARCHAR(255),
	AZIONE VARCHAR(255),
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	SCADENZA TIMESTAMP(3) DEFAULT 0,
	-- Precisione ai millisecondi supportata dalla versione 5.6.4, se si utilizza una versione precedente non usare il suffisso '(3)'
	ora_registrazione TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
	-- fk/pk columns
	id BIGINT AUTO_INCREMENT,
	-- fk/pk keys constraints
	CONSTRAINT pk_CORRELAZIONE_APPLICATIVA PRIMARY KEY (id)
)ENGINE INNODB CHARACTER SET latin1 COLLATE latin1_general_cs;

-- index
CREATE INDEX CORR_APPL_SCADUTE ON CORRELAZIONE_APPLICATIVA (SCADENZA);
CREATE INDEX CORR_APPL_OLD ON CORRELAZIONE_APPLICATIVA (ora_registrazione);


