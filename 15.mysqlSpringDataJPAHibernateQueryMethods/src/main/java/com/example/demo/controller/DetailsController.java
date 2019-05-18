package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Details;
import com.example.demo.repository.DetailsRepository;

@Controller
public class DetailsController {

	@Autowired
	DetailsRepository detailsRepository;

	@GetMapping("/save")
	@ResponseBody
	public String excuteQuery() {
		Details details = new Details();
		details.setFirstName("Kailash");
		details.setLastName("Uniyal");
		details.setAge(23);
		details.setStatus(1);
		details.setStartDate(new Date());
		details.setEndDate(new Date());
		detailsRepository.save(details);
		return "Date Saved!";
	}

	@GetMapping("/show")
	@ResponseBody
	public String display() {

		List<Details> detailsList = detailsRepository.findByAgeOrderByLastNameDesc(23);
		detailsList.forEach(det -> System.out.println(det.toString()));

		Details details = detailsRepository.findByFirstNameAndLastName("Jorrie", "Gowrich");
		if (details != null) {
			System.out.println(details.toString());
		} else {
			System.out.println("Not Preset!");
		}

		Calendar startDate = Calendar.getInstance();
		startDate.setTime(new Date());
		startDate.add(Calendar.YEAR, -3);

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(new Date());

		List<Details> detailsList1 = detailsRepository.findByStartDateBetween(startDate.getTime(), endDate.getTime());
		detailsList1.forEach(det -> System.out.println(det.toString()));

		List<Details> detailsList2 = detailsRepository.findByFirstNameStartingWith("k");
		detailsList2.forEach(det -> System.out.println(det.toString()));

		List<Details> detailsList3 = detailsRepository.findByFirstNameContaining("am");
		detailsList3.forEach(det -> System.out.println(det.toString()));

		List<Integer> ageList = new ArrayList<>(Arrays.asList(1, 23, 24, 45, 67, 70));
		List<Details> detailsList4 = detailsRepository.findByAgeIn(ageList);
		detailsList4.forEach(det -> System.out.println(det.toString()));
		return "Result displayed in console!";
	}
}
