package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.studentController;
import Model.Student;
import Model.StudentModify;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JLabel labelGender;
	private JTextField txtName;
	private JLabel labelName;
	private JTextField txtAge;
	private JLabel labelAge;
	private JComboBox<String> cbGender;
	private JTextField txtEmail;
	private JLabel labelEmail;
	private JTextField txtAddress;
	private JLabel labelAddress;
	private JTable tblStudent;
	
	private DefaultTableModel tableModel;
	private List<Student> studentList = new ArrayList<>();
	private JButton btnExit;
	private JButton btnShow;

	public StudentForm() {
		initComponents();
		
		tableModel = (DefaultTableModel) tblStudent.getModel();
		showStudent();
		
	}
	
	private void initComponents() {
		this.setTitle("Student Management");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ActionListener action = new studentController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelID = new JLabel("ID");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelID.setBounds(87, 12, 58, 26);
		contentPane.add(labelID);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtID.setBounds(206, 10, 416, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		labelGender = new JLabel("Gender");
		labelGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelGender.setBounds(87, 109, 58, 26);
		contentPane.add(labelGender);
		
		cbGender = new JComboBox();
		cbGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbGender.setBounds(206, 107, 117, 30);
		cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Gender 3rd" }));
		contentPane.add(cbGender);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBounds(206, 55, 416, 30);
		contentPane.add(txtName);
		
		labelName = new JLabel("Full Name");
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setBounds(87, 57, 81, 26);
		contentPane.add(labelName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBounds(206, 160, 416, 30);
		contentPane.add(txtAge);
		
		labelAge = new JLabel("Age");
		labelAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAge.setBounds(87, 162, 81, 26);
		contentPane.add(labelAge);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(206, 220, 416, 30);
		contentPane.add(txtEmail);
		
		labelEmail = new JLabel("Email");
		labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEmail.setBounds(87, 222, 81, 26);
		contentPane.add(labelEmail);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBounds(206, 275, 416, 30);
		contentPane.add(txtAddress);
		
		labelAddress = new JLabel("Address");
		labelAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAddress.setBounds(87, 277, 81, 26);
		contentPane.add(labelAddress);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(action);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSave.setBounds(206, 336, 85, 30);
		contentPane.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(action);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(319, 336, 85, 30);
		contentPane.add(btnReset);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(432, 336, 85, 30);
		contentPane.add(btnDelete);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(action);
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFind.setBounds(537, 336, 85, 30);
		contentPane.add(btnFind);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 376, 756, 13);
		contentPane.add(separator);
		
		tblStudent = new JTable();
		tblStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tblStudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Gender", "Age","Email", "Address"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(tblStudent);
		scrollPane.setBounds(10, 399, 756, 207);
		contentPane.add(scrollPane);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(action);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBounds(661, 12, 85, 30);
		contentPane.add(btnExit);
		
		btnShow = new JButton("Show");
		btnShow.addActionListener(action);
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShow.setBounds(661, 55, 85, 30);
		contentPane.add(btnShow);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void showStudent() {
		studentList = StudentModify.findAll();
		
		tableModel.setRowCount(0);
		
		for (Student student : studentList) {
			tableModel.addRow(new Object[] {
					student.getID(),
					student.getFullname(),
					student.getGender(),
					student.getAge(),
					student.getEmail(),
					student.getAddress()
			});
		}
	}

	public void resetForm() {
		txtID.setText("");
		txtName.setText("");
		cbGender.setSelectedIndex(0);
		txtAge.setText("");
		txtEmail.setText("");
		txtAddress.setText("");
	}

	public void saveIntoDatabase() {
		String id = txtID.getText();
		String fullname = txtName.getText();
		String gender = cbGender.getSelectedItem().toString();
		int age = Integer.parseInt(txtAge.getText());
		String email = txtEmail.getText();
		String address = txtAddress.getText();
		
		Student std = new Student(id, fullname, address, gender, email, age);
		
		StudentModify.insert(std);
		
		showStudent();
	}

	public void deleteStudent() {
		int selectedIndex = tblStudent.getSelectedRow();
		if(selectedIndex >= 0) {
			Student std = studentList.get(selectedIndex);
			
			int option = JOptionPane.showConfirmDialog(this, "Delete this item?");
			if(option == 0) {
				StudentModify.remove(std.getID());
				
				showStudent();
			}
		}
	}

	public void findStudent() {
		String input = JOptionPane.showInputDialog(this, "Enter name to search!");
		if(input.length() > 0 && input != null) {
			studentList = StudentModify.searchByName(input);
			
			tableModel.setRowCount(0);
			
			for (Student student : studentList) {
				tableModel.addRow(new Object[] {
						student.getID(),
						student.getFullname(),
						student.getGender(),
						student.getAge(),
						student.getEmail(),
						student.getAddress()
				});
			}
		} else {
			showStudent();
		}
	}
}
