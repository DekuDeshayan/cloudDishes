package com.ujc.clouddishes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ujc.clouddishes.service.FileStorageService;
import com.ujc.clouddishes.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant") // url padrao da api
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	FileStorageService fileStorageService;
	

	@PostMapping(value = "save", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})//api/restaurant/save
	public ResponseEntity<?> saveRestaurant(@RequestParam("restaurant") String restaurant, @RequestParam(name="restaurantImage", required=false) MultipartFile restaurantImage) {
				
		if(restaurantImage!= null) {
			
			int lastDotIndex = restaurantImage.getOriginalFilename().lastIndexOf('.');
			String s = restaurantImage.getOriginalFilename().substring(0, lastDotIndex ) + fileStorageService.DateFormattedForUploads() + restaurantImage.getOriginalFilename().substring(lastDotIndex);
			
			fileStorageService.save(restaurantImage);
			String restaurantImageUrl = ServletUriComponentsBuilder
			          .fromCurrentContextPath()
			          .path("/api/restaurant/files/")
			          .path(s)
			          .toUriString();
			return new ResponseEntity<>(restaurantService.saveRestaurant(restaurant, restaurantImage, restaurantImageUrl), HttpStatus.CREATED);
			 
		}
		
		
		return new ResponseEntity<>(restaurantService.saveRestaurantNoImage(restaurant), HttpStatus.CREATED);
	}
	
	

	@GetMapping("files/{filename:.+}")//api/meal/files/{filename.extension}
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = fileStorageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	


	@GetMapping("geosearch")//api/restaurant/geosearch?province=code&district=code&neigh=code
	public ResponseEntity<?> retrieveRestaurantListByGeolocalization(@RequestParam(name="province", required=false) Integer province,
			@RequestParam(name="district", required=false)  Integer district, @RequestParam(name="neigh", required=false)  Integer neigh) {
		
		
		if(province==null || district==null || neigh==null) {
			return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
		}
		
		return ResponseEntity.ok(restaurantService.retrieveRestaurantListByGeolocation(province, district, neigh));
	}
	
	@GetMapping("findById/{id}")//api/restaurant/findById/{id}
	public ResponseEntity<?> findById(@PathVariable Long id){
		return new ResponseEntity<>(restaurantService.findById(id), HttpStatus.OK);
	}
	
	
	
	@GetMapping("findall")//api/restaurant/findall
	public ResponseEntity<?> findAllRestaurants(){
		
		return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
	}

}
