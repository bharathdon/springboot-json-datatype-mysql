package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.model.CustomEntity;
import com.abc.service.CustomEntityService;

@RestController
public class CustomEntityController {

	@Autowired
	private CustomEntityService customEntityService;

	@PostMapping(path = "/upload", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<CustomEntity> abc(@RequestPart String user, @RequestPart List<MultipartFile> file) {

		CustomEntity customEntity = customEntityService.getJson(user, file);

		return new ResponseEntity<CustomEntity>(customEntity, HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<CustomEntity>> findAll() {
		List<CustomEntity> list = customEntityService.findAll();
		return new ResponseEntity<List<CustomEntity>>(list, HttpStatus.OK);
	}

}
