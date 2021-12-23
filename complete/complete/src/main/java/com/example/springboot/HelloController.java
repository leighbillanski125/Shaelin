package com.example.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloController {
	private List<Person> personList;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/name/{name}")
	@ResponseBody
	public Person getName(@PathVariable String name) {
		Person person = new Person();
		this.personList();
		for (int i =0; i<this.personList.size(); i++) {
			if (this.personList.get(i).getName().equalsIgnoreCase(name)) {
				person = this.personList.get(i);
			}
		}
		return person;
	}

	private void personList() {
		personList = new ArrayList<>();

		personList.add(new Person("Kaylynn","Johnson",24));
		personList.add(new Person("John","Smith",30));
		personList.add(new Person("Simon","Roberts",50));
	}

}
