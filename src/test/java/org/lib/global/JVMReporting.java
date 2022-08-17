package org.lib.global;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class JVMReporting {
	public static void main(String[] args) {
		JVMReporting.generateReport("target\\report.json");
	}
	
	public static void generateReport(String jsonPath) {
 
		File f = new File("target");
		
		Configuration c = new Configuration(f, "AdactInHotel application");
		c.addClassifications("Platform", "Windows");
		
		
		List<String> l = new ArrayList<String>();
		l.add(jsonPath);
		
		ReportBuilder r = new  ReportBuilder(l,c);
		r.generateReports();
				
	}

}
