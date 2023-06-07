package org.nachc.cad.tools.ponos.util.params.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.nachc.tools.fhirtoomop.util.databricks.properties.DatabricksProperties;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDatabricksProperties {

	//
	// instance variables
	//
	
	private String configPath;

	private File configFile;

	private String configFileName;

	private List<String> errorMessages = new ArrayList<String>();
	
	private boolean configFileExists = false;

	//
	// getters
	//
	
	public List<String> getErrorMessages() {
		return this.errorMessages;
	}
	
	public boolean isValid() {
		return errorMessages.size() == 0;
	}

	public boolean configFileExists() {
		return this.configFileExists;
	}
	
	//
	// constructor
	//
	
	public TestDatabricksProperties() {
		this.configPath = DatabricksProperties.getConfigPath();
		this.configFile = DatabricksProperties.getPropsFile();
		initConfigFileName();
		if(configPath == null) {
			errorMessages.add("configPath is not defined by DatabricksProperties.getConfigPath(). This should never happen and indicates a problem with the DatabricksProperties class");
		}
		if(configFileName == null) {
			errorMessages.add("Could not get config file: You need to add this file to your java classpath: " + configPath);
		}
		if(configFile == null) {
			errorMessages.add("Could not file file: " + configFileName);
		} 
		if(configFile != null && configFile.exists() == false) {
			errorMessages.add("File does not exist: " + FileUtil.getCanonicalPath(configFile));
		}
		if(configFile != null && configFile.exists() == true) {
			this.configFileExists = true;
		}
		String msg = "\n\n";
		msg += "---------\n";
		msg += "Databricks Configuration: \n";
		msg += "Config Path:        " + configPath + "\n";
		msg += "Config File Name:   " + configFileName + "\n";
		msg += "Config File Path:   " + FileUtil.getCanonicalPath(configFile) + "\n";
		msg += "Config File Exists: " + this.configFileExists() + "\n";
		msg += "---------\n\n";
		log.info(msg);
	}

	//
	// method to get the config file name
	//
	
	private void initConfigFileName() {
		try {
			if (this.configPath != null) {
				this.configFileName = FileUtil.getAsString(configPath);
				if (this.configFileName != null) {
					this.configFileName = this.configFileName.trim();
				}
			} else {
				log.info("configPath is null");
			}
		} catch (Exception exp) {
			String msg = "Could not find file on java classpath: " + configPath;
			this.errorMessages.add(msg);
			log.info(msg);
			this.configFileName = null;
			this.configFileName = null;
		}
	}

}
