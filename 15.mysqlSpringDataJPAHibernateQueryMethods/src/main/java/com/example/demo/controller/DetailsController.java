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
		details.setFirstName("Roger");
		details.setLastName("Singh");
		details.setAge(23);
		details.setStatus(true);
		details.setStartDate(new Date());
		details.setEndDate(new Date());
		detailsRepository.save(details);
		return "Date Saved!";
	}

	@GetMapping("/show")
	@ResponseBody
	public String namedMethods() {

		// Fetch all row
		Iterable<Details> listAll = detailsRepository.findAll();
		listAll.forEach(row -> System.out.println(row.toString()));

		// Find by id
		int id = 23;
		Details obj = detailsRepository.findById(id).get();
		System.out.println(obj.toString());

		// Update a row
		Details userDetails = new Details();
		userDetails.setId(108);
		userDetails.setFirstName("Ragnar");
		userDetails.setLastName("Lothbrok");
		userDetails.setAge(23);
		userDetails.setStatus(true);
		userDetails.setStartDate(new Date());
		userDetails.setEndDate(new Date());
		detailsRepository.save(userDetails);

		// Delete a row
		Details userDetails1 = new Details();
		userDetails1.setId(108);
		userDetails1.setFirstName("Ragnar");
		userDetails1.setLastName("Lothbrok");
		userDetails1.setAge(23);
		userDetails1.setStatus(true);
		userDetails1.setStartDate(new Date());
		userDetails1.setEndDate(new Date());
		detailsRepository.delete(userDetails1);

		List<Details> detailsList = detailsRepository.findByAgeOrderByLastNameDesc(23);
		detailsList.forEach(row -> System.out.println(row.toString()));

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
		detailsList1.forEach(row -> System.out.println(row.toString()));

		List<Details> detailsList2 = detailsRepository.findByFirstNameStartingWith("k");
		detailsList2.forEach(row -> System.out.println(row.toString()));

		List<Details> detailsList3 = detailsRepository.findByFirstNameContaining("am");
		detailsList3.forEach(row -> System.out.println(row.toString()));

		List<Integer> ageList = new ArrayList<>(Arrays.asList(1, 23, 24, 45, 67, 70));
		List<Details> detailsList4 = detailsRepository.findByAgeIn(ageList);
		detailsList4.forEach(row -> System.out.println(row.toString()));

		List<Details> onlineUserList = detailsRepository.findByStatusTrue();
		onlineUserList.forEach(row -> System.out.println(row.toString()));

		List<Details> detailsList5 = detailsRepository.findFirstNameDistinctByFirstNameStartingWith("K");
		detailsList5.forEach(row -> System.out.println(row.toString()));

		Calendar startDate1 = Calendar.getInstance();
		startDate1.setTime(new Date());
		startDate1.add(Calendar.YEAR, -1);

		Calendar endDate1 = Calendar.getInstance();
		endDate1.setTime(new Date());

		List<Details> detailsList6 = detailsRepository.findByStartDateAfterAndEndDateBefore(startDate1.getTime(),
				endDate1.getTime());
		detailsList6.forEach(row -> System.out.println(row.toString()));
		System.out.println(startDate1.getTime().toString());
		System.out.println(endDate1.getTime().toString());
		
		List<Details> detailsList7 = detailsRepository.findByAgeIsNull();
		detailsList7.forEach(row -> System.out.println(row.toString()));

		return "Result displayed in console!";
	}
}
