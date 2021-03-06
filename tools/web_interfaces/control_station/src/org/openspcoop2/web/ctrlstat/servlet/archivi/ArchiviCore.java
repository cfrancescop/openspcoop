/*
 * OpenSPCoop - Customizable API Gateway 
 * http://www.openspcoop2.org
 * 
 * Copyright (c) 2005-2016 Link.it srl (http://link.it). 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.openspcoop2.web.ctrlstat.servlet.archivi;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.List;

import org.openspcoop2.core.registry.Documento;
import org.openspcoop2.core.registry.constants.ProprietariDocumento;
import org.openspcoop2.core.registry.driver.DriverRegistroServiziException;
import org.openspcoop2.core.registry.driver.DriverRegistroServiziNotFound;
import org.openspcoop2.protocol.engine.ProtocolFactoryManager;
import org.openspcoop2.protocol.engine.archive.ArchiveRegistryReader;
import org.openspcoop2.protocol.engine.archive.ArchiveValidator;
import org.openspcoop2.protocol.engine.archive.DeleterArchiveUtils;
import org.openspcoop2.protocol.engine.archive.ExporterArchiveUtils;
import org.openspcoop2.protocol.engine.archive.ImportInformationMissingCollection;
import org.openspcoop2.protocol.engine.archive.ImportInformationMissingException;
import org.openspcoop2.protocol.engine.archive.ImporterArchiveUtils;
import org.openspcoop2.protocol.sdk.IProtocolFactory;
import org.openspcoop2.protocol.sdk.archive.Archive;
import org.openspcoop2.protocol.sdk.archive.ArchiveCascadeConfiguration;
import org.openspcoop2.protocol.sdk.archive.ArchiveEsitoDelete;
import org.openspcoop2.protocol.sdk.archive.ArchiveEsitoImport;
import org.openspcoop2.protocol.sdk.archive.ArchiveMode;
import org.openspcoop2.protocol.sdk.archive.ArchiveModeType;
import org.openspcoop2.protocol.sdk.archive.ExportMode;
import org.openspcoop2.protocol.sdk.archive.IArchive;
import org.openspcoop2.protocol.sdk.archive.MapPlaceholder;
import org.openspcoop2.protocol.sdk.constants.ArchiveType;
import org.openspcoop2.web.ctrlstat.core.ControlStationCore;
import org.openspcoop2.web.ctrlstat.driver.DriverControlStationDB;

/**
 * ArchiviCore
 * 
 * @author Andrea Poli (apoli@link.it)
 * @author $Author$
 * @version $Rev$, $Date$
 */
public class ArchiviCore extends ControlStationCore {

	public ArchiviCore() throws Exception {
		super();
	}
	public ArchiviCore(ControlStationCore core) throws Exception {
		super(core);
	}

	public boolean isCascadeEnabled(List<ExportMode> exportModes,String exportMode){
		boolean cascadeEnabled = false;
		for (ExportMode exp : exportModes) {
			if(exp.equals(exportMode)){
				if(exp.getCascade()!=null &&
						(exp.getCascade().isCascadePdd() || exp.getCascade().isCascadeSoggetti() ||
								exp.getCascade().isCascadeServiziApplicativi() || 
								exp.getCascade().isCascadePorteDelegate() ||
								exp.getCascade().isCascadePorteApplicative() ||
								exp.getCascade().isCascadeAccordoCooperazione() ||
								exp.getCascade().isCascadeAccordoServizioComposto() ||
								exp.getCascade().isCascadeAccordoServizioParteComune() ||
								exp.getCascade().isCascadeAccordoServizioParteSpecifica() ||
								exp.getCascade().isCascadeFruizioni()) ){
					cascadeEnabled = true;
					break;
				}
			}
		}
		return cascadeEnabled;
	}
	public ArchiveCascadeConfiguration getCascadeConfig(List<ExportMode> exportModes,String exportMode){
		for (ExportMode exp : exportModes) {
			if(exp.equals(exportMode)){
				return exp.getCascade();
			}
		}
		return null;
	}
	
	public byte[] export(String userLogin, boolean smista,
			String protocol,Archive archive,ArchiveMode archiveMode) throws Exception,ImportInformationMissingException{
		
		Connection con = null;
		DriverControlStationDB driver = null;

		ByteArrayOutputStream bout = null;
		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveEngine importerEngine = new ArchiveEngine(driver.getDriverRegistroServiziDB(), driver.getDriverConfigurazioneDB(), 
					this, smista, userLogin);
			
			ExporterArchiveUtils exportUtils = new ExporterArchiveUtils(importerEngine, log);
			
			bout = new ByteArrayOutputStream();
			exportUtils.export(protocol, archive, bout, archiveMode);
			
			bout.flush();
			bout.close();
			return bout.toByteArray();
			
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	public void export(String userLogin, boolean smista,
			String protocol,Archive archive,OutputStream out, ArchiveMode archiveMode) throws Exception,ImportInformationMissingException{
		
		Connection con = null;
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveEngine importerEngine = new ArchiveEngine(driver.getDriverRegistroServiziDB(), driver.getDriverConfigurazioneDB(), 
					this, smista, userLogin);
			
			ExporterArchiveUtils exportUtils = new ExporterArchiveUtils(importerEngine, log);
			
			exportUtils.export(protocol, archive, out, archiveMode);
			
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	public Archive readArchiveForExport(String userLogin, boolean smista,ArchiveType tipoEsportazione,List<?> listObject, ArchiveCascadeConfiguration cascadeConfig) throws Exception,ImportInformationMissingException{
		
		Connection con = null;
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveEngine importerEngine = new ArchiveEngine(driver.getDriverRegistroServiziDB(), driver.getDriverConfigurazioneDB(), 
					this, smista, userLogin);
			
			ExporterArchiveUtils exportUtils = new ExporterArchiveUtils(importerEngine, log);
			Archive archive = new Archive();
			exportUtils.fillArchive(archive, tipoEsportazione, listObject, cascadeConfig);
			
			return archive;
			
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	public String importArchive(Archive archive,ArchiveMode archiveMode,String protocol, String userLogin, boolean smista,
			boolean updateAbilitato, String nomePddOperativa) throws Exception,ImportInformationMissingException{
		
		Connection con = null;
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveEngine importerEngine = new ArchiveEngine(driver.getDriverRegistroServiziDB(), driver.getDriverConfigurazioneDB(), 
					this, smista, userLogin);
			
			ImporterArchiveUtils importerArchiveUtils = 
					new ImporterArchiveUtils(importerEngine, log, userLogin, nomePddOperativa, this.getImportArchivi_tipoPdD(), 
							this.isShowGestioneWorkflowStatoDocumenti(), updateAbilitato);
			
			ArchiveEsitoImport esito = importerArchiveUtils.importArchive(archive, userLogin, 
					this.isShowAccordiColonnaAzioni(),
					this.isAbilitatoControlloUnicitaImplementazioneAccordoPerSoggetto(), 
					this.isAbilitatoControlloUnicitaImplementazionePortTypePerSoggetto());
			
			IProtocolFactory pf = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocol);
			IArchive archiveEngine = pf.createArchive();
			return archiveEngine.toString(esito, archiveMode);
						
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	
	public String deleteArchive(Archive archive,ArchiveMode archiveMode,String protocol, String userLogin, boolean smista) throws Exception,ImportInformationMissingException{
		
		Connection con = null;
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveEngine importerEngine = new ArchiveEngine(driver.getDriverRegistroServiziDB(), driver.getDriverConfigurazioneDB(), 
					this, smista, userLogin);
			
			DeleterArchiveUtils deleterArchiveUtils = 
					new DeleterArchiveUtils(importerEngine, log, userLogin);
			
			ArchiveEsitoDelete esito = deleterArchiveUtils.deleteArchive(archive, userLogin);
			
			IProtocolFactory pf = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocol);
			IArchive archiveEngine = pf.createArchive();
			return archiveEngine.toString(esito, archiveMode);
						
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
			
	
	public void validateArchive(Archive archive, String protocolloEffettivo, 
			boolean validazioneDocumenti, ImportInformationMissingCollection importInformationMissingCollection, 
			String userLogin) throws Exception,ImportInformationMissingException{
		
		Connection con = null;
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveRegistryReader reader = new ArchiveRegistryReader(driver.getDriverRegistroServiziDB(),driver.getDriverConfigurazioneDB());
			
			ArchiveValidator validator = new ArchiveValidator(reader);
			validator.validateArchive(archive, protocolloEffettivo, validazioneDocumenti, importInformationMissingCollection, userLogin, 
					this.isShowCorrelazioneAsincronaInAccordi());
			
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	
	public Archive convert(byte[] file,ArchiveModeType type,ArchiveMode mode,String protocol,boolean validateDocuments,
			MapPlaceholder importInformationMissing_globalPlaceholder) throws Exception {
		Connection con = null;
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			ArchiveRegistryReader reader = new ArchiveRegistryReader(driver.getDriverRegistroServiziDB(),driver.getDriverConfigurazioneDB());
			
			IProtocolFactory pf = ProtocolFactoryManager.getInstance().getProtocolFactoryByName(protocol);
			IArchive archiveEngine = pf.createArchive();
			return archiveEngine.importArchive(file, mode, type, reader, validateDocuments, importInformationMissing_globalPlaceholder);
			
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	
	public Documento getDocumento(long idDocumento,boolean readBytes) throws DriverRegistroServiziException, DriverRegistroServiziNotFound {
		Connection con = null;
		String nomeMetodo = "getDocumento";
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			return driver.getDriverRegistroServiziDB().getDocumento(idDocumento,readBytes);
			
		} catch (DriverRegistroServiziException e) {
			ControlStationCore.log.error("[ControlStationCore::" + nomeMetodo + "] Exception :" + e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			ControlStationCore.log.error("[ControlStationCore::" + nomeMetodo + "] Exception :" + e.getMessage(), e);
			throw new DriverRegistroServiziException("[ControlStationCore::" + nomeMetodo + "] Error :" + e.getMessage(),e);
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
	
	public Documento getDocumento(String nome, String tipo, String ruolo, long idProprietario,boolean readBytes,ProprietariDocumento tipoProprietario) throws DriverRegistroServiziException, DriverRegistroServiziNotFound {
		Connection con = null;
		String nomeMetodo = "getDocumento";
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);

			return driver.getDriverRegistroServiziDB().getDocumento(nome,tipo,ruolo,idProprietario,readBytes,tipoProprietario);
			
		} catch (DriverRegistroServiziException e) {
			ControlStationCore.log.error("[ControlStationCore::" + nomeMetodo + "] Exception :" + e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			ControlStationCore.log.error("[ControlStationCore::" + nomeMetodo + "] Exception :" + e.getMessage(), e);
			throw new DriverRegistroServiziException("[ControlStationCore::" + nomeMetodo + "] Error :" + e.getMessage(),e);
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}

	public boolean existsDocumento(Documento documento,ProprietariDocumento proprietarioDocumento) throws DriverRegistroServiziException {
		Connection con = null;
		String nomeMetodo = "existsDocumento";
		DriverControlStationDB driver = null;

		try {
			// prendo una connessione
			con = ControlStationCore.dbM.getConnection();
			// istanzio il driver
			driver = new DriverControlStationDB(con, null, this.tipoDB);
			return driver.getDriverRegistroServiziDB().existsDocumento(documento.getFile(),documento.getTipo(),documento.getRuolo(),documento.getIdProprietarioDocumento(),proprietarioDocumento);
		} catch (Exception e) {
			ControlStationCore.log.error("[ControlStationCore::" + nomeMetodo + "] Exception :" + e.getMessage(), e);
			throw new DriverRegistroServiziException("[ControlStationCore::" + nomeMetodo + "] Error :" + e.getMessage(),e);
		} finally {
			ControlStationCore.dbM.releaseConnection(con);
		}
	}
}
