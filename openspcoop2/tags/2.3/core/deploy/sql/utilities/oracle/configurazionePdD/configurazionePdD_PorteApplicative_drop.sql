-- Gli indici vengono eliminati automaticamente una volta eliminata la tabella
-- DROP INDEX INDEX_PA_WSSRES;
-- DROP INDEX INDEX_PA_WSSREQ;
-- DROP INDEX INDEX_PA_MTOMTRES;
-- DROP INDEX INDEX_PA_MTOMTREQ;
-- DROP INDEX INDEX_PA_PROP;
-- DROP INDEX INDEX_PA_SA;
DROP TRIGGER trg_pa_correlazione_risposta;
DROP TRIGGER trg_pa_correlazione;
DROP TRIGGER trg_pa_ws_response;
DROP TRIGGER trg_pa_ws_request;
DROP TRIGGER trg_pa_mtom_response;
DROP TRIGGER trg_pa_mtom_request;
DROP TRIGGER trg_pa_properties;
DROP TRIGGER trg_porte_applicative_sa;
DROP TRIGGER trg_porte_applicative;
DROP TABLE pa_correlazione_risposta;
DROP TABLE pa_correlazione;
DROP TABLE pa_ws_response;
DROP TABLE pa_ws_request;
DROP TABLE pa_mtom_response;
DROP TABLE pa_mtom_request;
DROP TABLE pa_properties;
DROP TABLE porte_applicative_sa;
DROP TABLE porte_applicative;
DROP SEQUENCE seq_pa_correlazione_risposta;
DROP SEQUENCE seq_pa_correlazione;
DROP SEQUENCE seq_pa_ws_response;
DROP SEQUENCE seq_pa_ws_request;
DROP SEQUENCE seq_pa_mtom_response;
DROP SEQUENCE seq_pa_mtom_request;
DROP SEQUENCE seq_pa_properties;
DROP SEQUENCE seq_porte_applicative_sa;
DROP SEQUENCE seq_porte_applicative;
