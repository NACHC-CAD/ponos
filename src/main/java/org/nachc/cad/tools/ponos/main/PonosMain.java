package org.nachc.cad.tools.ponos.main;

import org.nachc.cad.tools.ponos.databricks.connect.ConnectDatabricksCdmToOhdsi;
import org.nachc.cad.tools.ponos.databricks.demo.CreateDemoCdmInstance;
import org.nachc.cad.tools.ponos.util.params.test.TestDatabricksProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PonosMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println(getNoArgsMsg());
		}
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
		}
	}

	private static String getNoArgsMsg() {
		String msg = "\n\n";
		msg += "No args found.\n";
		msg += "Please include one of the following:\n";
		msg += "  db-params (displays the current parameters settings)\n";
		msg += "  db-demo   (creates a demo_cdm instance in Databricks)\n";
		msg += "  db-init   (connects an existing Databricks cdm to OHDSI)\n";
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
