package com.ujc.clouddishes.controller;

import java.io.FileInputStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujc.clouddishes.model.User;
import com.ujc.clouddishes.service.UserService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
@RequestMapping("/api/client")//url padrao
public class ClientController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("sign-up")//api/client/sign-up
	public ResponseEntity<?> saveClient (@RequestBody User user){
		
		
		if(userService.findByUsername(user.getUsername()).isPresent()) {
			
			return new ResponseEntity<>(HttpStatus.CONFLICT);	
		}

		return new ResponseEntity<>(userService.saveClient(user), HttpStatus.CREATED);
	}
	
	
	@GetMapping("findall")//api/client/findall
	public ResponseEntity<?> findAllClients(){
		
		return new ResponseEntity<>(userService.findAllClients(), HttpStatus.OK);
	}
	
	
	
	@GetMapping("report")//api/client/report
	public ResponseEntity<byte[]> generatePdf() throws Exception, JRException {
		
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(userService.findAllClients());
		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/cloudDishes-user-reports.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();//we use Object in map because the content must be of any type
		map.put("reportTitle", "Customer List Report");//to dynmaically map a textfield...
		JasperPrint report =  JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
	    //JasperExportManager.exportReportToPdfFile(report, "cloudDishesuserReport.pdf");
		
	    byte[] data = JasperExportManager.exportReportToPdf(report);
	    
	    
	    HttpHeaders headers = new HttpHeaders();
	    
	    headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=cloudDishesCustomersListReport.pdf");
	
	    return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}
	
	
	
	
	

}
