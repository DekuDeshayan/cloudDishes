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
import com.ujc.clouddishes.service.MealService;

@RestController
@RequestMapping("/api/meal")
public class MealController {
	@Autowired
	private MealService mealService;
	
	@Autowired
	FileStorageService fileStorageService;
	

	@PostMapping(value = "save", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})//api/meal/save
	public ResponseEntity<?> saveMeal (@RequestParam("meal") String meal, @RequestParam(name="mealImage", required=false) MultipartFile mealImage){
		
		if(mealImage!=null) {
			
			int lastDotIndex = mealImage.getOriginalFilename().lastIndexOf('.');
			String s = mealImage.getOriginalFilename().substring(0, lastDotIndex ) + fileStorageService.DateFormattedForUploads() + mealImage.getOriginalFilename().substring(lastDotIndex);
			
			fileStorageService.save(mealImage);
			String mealImageUrl = ServletUriComponentsBuilder
			          .fromCurrentContextPath()
			          .path("/api/meal/files/")
			          .path(s)
			          .toUriString();
			return new ResponseEntity<>(mealService.saveMeal(meal, mealImage, mealImageUrl), HttpStatus.CREATED);
			 
		}
		
		return new ResponseEntity<>(mealService.saveMealNoImage(meal), HttpStatus.CREATED);
		 
	}
	

	@GetMapping("files/{filename:.+}")//api/meal/files/{filename.extension}
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = fileStorageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
	
	
	
	
	@GetMapping("search/{name}")//api/meal/search/{name}
	public ResponseEntity<?> searchMeals(@PathVariable String name){
		
		return  ResponseEntity.ok(mealService.searchMeals(name));
	}

	
	@GetMapping("retrieve-meal-by-rest/{rest_id}")//api/meal/retrieve-meal-by-rest/{rest_id}
	public ResponseEntity<?> retrieveMealListByRestaurant(@PathVariable Long rest_id){
		
		return ResponseEntity.ok(mealService.retrieveMealListByRestaurant(rest_id));
	}
	
	
	
	@GetMapping("retrieve-meal-by-id/{mealId}")//api/meal/retrieve-meal-by-id/{id}
	public ResponseEntity<?> retrieveMealById(@PathVariable Long mealId){
		
		return  ResponseEntity.ok(mealService.findByID(mealId));
	}
	
	@GetMapping("findall")//api/meal/findall
	public ResponseEntity<?> findAllMeals(){
		return ResponseEntity.ok(mealService.findAllMeals());
	}
	
}
