package com.GirrajTechnology.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getIndexPage() {

		return "index";
	}

	@GetMapping("/index.html")
	public String getIndexPage2() {

		return "index";
	}


	@GetMapping("/about.html")
	public String getAboutPage() {

		return "about";
	}

	@GetMapping("/service.html")
	public String getServicePage() {

		return "service";
	}

	@GetMapping("/project.html")
	public String getProjectPage() {

		return "project";
	}

	@GetMapping("/blog.html")
	public String getBlogPage() {

		return "blog";
	}

	@GetMapping("/team.html")
	public String getTeamPage() {

		return "team";
	}

	@GetMapping("/testimonial.html")
	public String getTestimonialPage() {

		return "testimonial";
	}

	@GetMapping("/404.html")
	public String get404Page() {

		return "404";
	}

}
