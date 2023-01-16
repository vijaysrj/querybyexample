package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevTeamController {

	@Autowired
	private DevTeamRepository repository;

	@GetMapping("/getTechMembers")
	public List<DevTeam> getTechMembers(@RequestParam(name = "technology") String technology,
			@RequestParam(name = "experience") String experience) {

		DevTeam devTeam = new DevTeam();
		devTeam.setExperience(experience);
		devTeam.setTechnology(technology);

		return repository.findAll(Example.of(devTeam));

	}
}