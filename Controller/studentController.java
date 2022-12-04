package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.StudentForm;

public class studentController implements ActionListener {
	
	private StudentForm stdForm;

	public studentController(StudentForm studentForm) {
		this.stdForm = studentForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Reset")) {
			this.stdForm.resetForm();
		} else if(command.equals("Save")) {
			this.stdForm.saveIntoDatabase();
		} else if(command.equals("Delete")) {
			this.stdForm.deleteStudent();
		} else if(command.equals("Find")) {
			this.stdForm.findStudent();
		}else if(command.equals("Show")) {
			this.stdForm.showStudent();
		}else if(command.equals("Exit")) {
			System.exit(0);
		}
	}
	
}
