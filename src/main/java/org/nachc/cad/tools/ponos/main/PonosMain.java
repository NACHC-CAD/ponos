package org.nachc.cad.tools.ponos.main;

import java.io.File;
import java.io.FileInputStream;

import org.nachc.cad.tools.ponos.databricks.broadsea.ConnectDatabricksCdmToOhdsiOnBroadsea;
import org.nachc.cad.tools.ponos.databricks.connect.ConnectDatabricksCdmToOhdsi;
import org.nachc.cad.tools.ponos.databricks.demo.CreateDemoCdmInstance;
import org.nachc.cad.tools.ponos.util.params.test.TestDatabricksProperties;
import org.nachc.tools.fhirtoomop.util.databricks.properties.DatabricksProperties;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PonosMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(getNoArgsMsg());
		} else {
			setDatabricksProperties();
			switch (args[0]) {
			case "db-params":
				new TestDatabricksProperties();
				break;
			case "db-demo":
				CreateDemoCdmInstance.main(args);
				break;
			case "db-init":
				ConnectDatabricksCdmToOhdsi.main(args);
				break;
			case "bs-init":
				ConnectDatabricksCdmToOhdsiOnBroadsea.main(args);
				break;
			}
		}
		log.info("Done.");
	}

	private static void setDatabricksProperties() {
		try {
			log.info("Getting config file...");
			File file = new File("./auth/app-databricks.properties");
			if(file.exists()) {
				FileInputStream is = new FileInputStream(file);
				DatabricksProperties.setProps(is);
				log.info("CONFIG FILE SUCCESSFULY SET");
			} else {
				String msg = "Could not find file: " + FileUtil.getCanonicalPath(file);
				log.info(msg);
				throw new RuntimeException(msg);
			}
		} catch(Exception exp) {
			throw new RuntimeException(exp);
		}
	}
	
	private static String getNoArgsMsg() {
		String msg = "\n\n";
		msg += "No args found.\n";
		msg += "Please include one of the following:\n";
		msg += "  db-params (displays the current parameters settings)\n";
		msg += "  db-demo   (creates a demo_cdm instance in Databricks)\n";
		msg += "  db-init   (connects an existing Databricks cdm to OHDSI)\n";
		msg += "  bs-init   (connects an existing Databricks cdm to OHDSI for a Broadsea implementation)\n";
		msg += "\n\n";
		return msg;
	}

	private static String getInvalidArgsMsg() {
		String msg = "\n\n";
		msg += "Invalid args found.\n";
		msg += "Please include one of the following:\n";
		msg += "  db-params (displays the current parameters settings)\n";
		msg += "  db-demo   (creates a demo_cdm instance in Databricks)\n";
		msg += "  db-init   (connects an existing Databricks cdm to OHDSI)\n";
		msg += "\n\n";
		return msg;
	}

}
