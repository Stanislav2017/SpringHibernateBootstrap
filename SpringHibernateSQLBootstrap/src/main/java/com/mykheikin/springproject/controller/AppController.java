package com.mykheikin.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mykheikin.springproject.model.Pass;
import com.mykheikin.springproject.model.UserInfo;
import com.mykheikin.springproject.service.PassService;
import com.mykheikin.springproject.service.UserInfoService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	PassService passService;

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listPasses(ModelMap model) {

		model.addAttribute("userInfo", userInfoService.findById(2));
		model.addAttribute("passList", passService.findAllPasses());

		return "list";
	}

	@RequestMapping(value = { "/newpass" }, method = RequestMethod.GET)
	public String newPass(ModelMap model) {

		model.addAttribute("pass", new Pass());
		model.addAttribute("edit", false);
		return "passform";
	}

	// ------------------------------------------------------------------------------
	@RequestMapping(value = { "/newuserinfo" }, method = RequestMethod.GET)
	public String newUserInfo(ModelMap model) {

		model.addAttribute("userInfo", new UserInfo());
		model.addAttribute("edit", false);
		return "userform";
	}
	// ------------------------------------------------------------------------------

	@RequestMapping(value = { "/newpass" }, method = RequestMethod.POST)
	public String savePass(@ModelAttribute("pass") Pass pass) {

		passService.save(pass);

		return "redirect:/list";
	}

	// -----------------------------------------------------------------------------
	@RequestMapping(value = { "/newuserinfo" }, method = RequestMethod.POST)
	public String saveUserInfo(@ModelAttribute("userinfo") UserInfo userInfo) {

		userInfoService.save(userInfo);

		return "redirect:/list";
	}
	// -----------------------------------------------------------------------------

	@RequestMapping(value = { "/edit-pass-{id}" }, method = RequestMethod.GET)
	public String editPass(@PathVariable int id, ModelMap model) {

		model.addAttribute("pass", passService.findById(id));
		model.addAttribute("edit", true);

		return "passform";
	}

	// -----------------------------------------------------------------------------
	@RequestMapping(value = { "/edit-userinfo-{id}" }, method = RequestMethod.GET)
	public String editUserInfo(@PathVariable int id, ModelMap model) {

		model.addAttribute("userInfo", userInfoService.findById(id));
		model.addAttribute("edit", true);

		return "userform";
	}
	// -----------------------------------------------------------------------------

	// -----------------------------------------------------------------------------
	@RequestMapping(value = { "/edit-userinfo-{id}" }, method = RequestMethod.POST)
	public String updateUserInfo(@ModelAttribute("userInfo") UserInfo userInfo) {

		userInfoService.updateUserInfo(userInfo);

		return "redirect:/list";
	}
	// -----------------------------------------------------------------------------

	@RequestMapping(value = { "/edit-pass-{id}" }, method = RequestMethod.POST)
	public String updatePass(@ModelAttribute("pass") Pass pass) {

		passService.updatePass(pass);

		return "redirect:/list";
	}

	// -----------------------------------------------------------------------------
	@RequestMapping(value = { "/delete-userinfo-{id}" }, method = RequestMethod.GET)
	public String deleteUserInfo(@PathVariable int id) {

		userInfoService.deleteById(id);

		return "redirect:/list";
	}
	// -----------------------------------------------------------------------------

	@RequestMapping(value = { "/delete-pass-{id}" }, method = RequestMethod.GET)
	public String deletePass(@PathVariable int id) {

		passService.deleteById(id);

		return "redirect:/list";
	}
}
