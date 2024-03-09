package userm88.controller;

import java.util.Scanner;

import userm88.dao.UserDao;
import userm88.dto.User;

public class UserController {
public static void main(String[] args) {
	System.out.println("Welcome to User Application");
	System.out.println("Please enter1 to save the data");
	System.out.println("enter 2 to update the data");
	System.out.println("enter 3 to find the data");
	System.out.println("enter 4 to delete the data");
	System.out.println("enter 5 to go out");
	Scanner scanner=new Scanner(System.in);
	int choice=scanner.nextInt();
	
	UserDao dao=new UserDao();
	switch (choice) {
	case 1:{
		System.out.println("Please enter id ");
		int id=scanner.nextInt();
		System.out.println("please enter name");
		String name=scanner.next();
		System.out.println("please enter address");
		String address=scanner.next();
		User user=new User();
		user.setAddress(address);
		user.setId(id);
		user.setName(name);
		dao.saveUser(user);
		System.out.println("THANK YOU DATA SAVED SUCCESSFULLY");
	}break;
	case 2 :{
		System.out.println("Please enter id ");
		int id=scanner.nextInt();
		System.out.println("please enter name");
		String name=scanner.next();
		System.out.println("please enter address");
		String address=scanner.next();
		User user=new User();
		user.setAddress(address);
		user.setName(name);
		dao.UpdateUser(id, user);
		System.out.println("THANK YOU DATA UPDATED SUCCESSFULLY");
	}break;
	
	case 3:{
		System.out.println("Please enter id ");
		int id=scanner.nextInt();
		dao.findUser(id);
		System.out.println("THANK YOU DATA FETCHED SUCCESSFULLY");
	}break;
	case 4:{
		System.out.println("Please enter id ");
		int id=scanner.nextInt();
		dao.deleteUser(id);
		System.out.println("THANK YOU DATA DELETED SUCCESSFULLY");
	}break;
	case 5:{
		System.out.println("THANK YOU VISIT AGAIN");
	}
	
	}
	
	
	
}
}
