package com.abc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abc.model.CustomEntity;
import com.abc.repository.CustomEntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@Service
public class CustomEntityService {

	@Autowired
	private CustomEntityRepository repo;

	@SneakyThrows
	public CustomEntity getJson(String user, List<MultipartFile> file) {

		CustomEntity customEntity = new CustomEntity();

		ObjectMapper objectMapper = new ObjectMapper();
		customEntity = objectMapper.readValue(user, CustomEntity.class);

		customEntity.setName(file.iterator().next().getOriginalFilename());
		customEntity.setJsonValue(Arrays.asList(file.get(0).getBytes().toString()));

		repo.save(customEntity);

		return customEntity;

	}

	public List<CustomEntity> findAll() {
		return repo.findAll();
	}

}
