package edu.cjc.sms.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repositary.StudentRepositary;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI
{

	@Autowired
	StudentRepositary sr;
	
	@Override
	public void saveStudentData(Student s) {
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
	
		return sr.findAll();
	}

	@Override
	public void deleteStudent(int rollno) {
	
		sr.deleteById(rollno);
		
	}

}
