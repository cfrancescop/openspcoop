-- Gli indici vengono eliminati automaticamente una volta eliminata la tabella
-- DROP INDEX TRACCE_EXT_INFO;
-- DROP INDEX TRACCE_ALLEGATI_INDEX;
-- DROP INDEX TRACCE_ECC;
-- DROP INDEX TRACCE_TR;
-- DROP INDEX TRACCE_RIS;
-- DROP INDEX TRACCE_SEARCH_RIF_SOGGETTO;
-- DROP INDEX TRACCE_SEARCH_ID_SOGGETTO;
-- DROP INDEX TRACCE_SEARCH_RIF;
-- DROP INDEX TRACCE_SEARCH_ID;
DROP TRIGGER trg_tracce_ext_protocol_info;
DROP TRIGGER trg_tracce_allegati;
DROP TRIGGER trg_tracce_eccezioni;
DROP TRIGGER trg_tracce_trasmissioni;
DROP TRIGGER trg_tracce_riscontri;
DROP TRIGGER trg_tracce;
DROP TABLE tracce_ext_protocol_info;
DROP TABLE tracce_allegati;
DROP TABLE tracce_eccezioni;
DROP TABLE tracce_trasmissioni;
DROP TABLE tracce_riscontri;
DROP TABLE tracce;
DROP SEQUENCE seq_tracce_ext_protocol_info;
DROP SEQUENCE seq_tracce_allegati;
DROP SEQUENCE seq_tracce_eccezioni;
DROP SEQUENCE seq_tracce_trasmissioni;
DROP SEQUENCE seq_tracce_riscontri;
DROP SEQUENCE seq_tracce;
