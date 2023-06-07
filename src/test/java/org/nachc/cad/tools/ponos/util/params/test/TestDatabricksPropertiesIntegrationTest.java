package org.nachc.cad.tools.ponos.util.params.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDatabricksPropertiesIntegrationTest {
	
	@Test
	public void shouldGetConfig() {
		log.info("Starting test...");
		TestDatabricksProperties test = new TestDatabricksProperties();
		if(test.isValid() == false) {
			String msg = "\n\n";
			msg += "---------\n";
			msg += "ERRORS: \n";
			for(String str : test.getErrorMessages()) {
				msg += str + "\n";
			}
			msg += "---------\n\n";
			log.info(msg);
			assertTrue("Errors occured trying to get configuration.", false);
		}
		log.info("Done.");
	}
	
}
