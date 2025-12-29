package edu.cjc.sms.app.servicei;

import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServiceI {

public	void saveStudentData(Student s);
public List<Student> getAllStudents();
public void deleteStudent(int rollno);

public List<Student> searchStudentByBatch(String batchNumber, String batchMode);
public Student getSingleStudent(int studentId);
public void payFees(int studentId, double ammount);

}
