package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Controller
public class AdminController {
	
	@Autowired
	StudentServiceI ssi;
	
	
	@RequestMapping("/")
	public String preLogin() {
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		
		if(username.equals("admin") && password.equals("admin"))
		{
			     List<Student> list  =ssi.getAllStudents();
			m.addAttribute("data", list);
			return "adminscreen";
		}else {
			m.addAttribute("login_fail","Enter valid username and password");
			return "login";
		}
	
	}
	
	
	@RequestMapping("/enroll_student")
	public String saveStudentDetails(@ModelAttribute Student s,Model m) {
		    ssi.saveStudentData(s); 
		    List<Student> list  =ssi.getAllStudents();
			m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/delete")
	public String removeStudent(@RequestParam("rollno") int rollno,Model m) {
		
		ssi.deleteStudent(rollno);
		
		  List<Student> list  =ssi.getAllStudents();
			m.addAttribute("data", list);
		return "adminscreen";
	}
	

}
