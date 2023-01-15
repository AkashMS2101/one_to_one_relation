package one_to_one_uni.controller;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import one_to_one_uni.dao.PersonAadharCRUD;
import one_to_one_uni.dto.AadharCard;
import one_to_one_uni.dto.PersonAdhc;

public class PersonAadharMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PersonAdhc adhc = new PersonAdhc();
		PersonAadharCRUD personAadharCRUD = new PersonAadharCRUD();
		boolean mainexit = true;
		do {
			System.out.println("enter your choise");
			System.out.println("1.to insert data \n2.to update data \n3.to view by id \n4.to view all \n5.to delete \n6.to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter enter your data");
				
				System.out.println("enter your id");
				adhc.setId(scanner.nextInt());
				
				System.out.println("enter your name");
				adhc.setName(scanner.next());
				
				System.out.println("enter your address");
				adhc.setAddress(scanner.next());
				
				System.out.println("enter your phone number");
				adhc.setPhone(scanner.nextLong());
				
				System.out.println("enter your aadhar details");
				
				AadharCard aadharCard = new AadharCard();
				
				System.out.println("enter your aadhar id");
				aadharCard.setAid(scanner.nextInt());
				
				System.out.println("enter your name");
				aadharCard.setName(scanner.next());
				
				System.out.println("enter your address");
				aadharCard.setAddress(scanner.next());

				adhc.setAadharCard(aadharCard);
				
				personAadharCRUD.savePersonAadhar(adhc);

				break;
			}
			case 2: {
				System.out.println("enter your id to update");
				int id = scanner.nextInt();
				System.out.println("enter new name");
				String name = scanner.next();
				personAadharCRUD.updatePersonAadhar(id,name);

				break;
			}
			case 3: {
				System.out.println("enter your id to view your details");
				personAadharCRUD.displayPersonAadharById(scanner.nextInt());
				break;
			}
			case 4:{
				System.out.println("here is all data from table");
				personAadharCRUD.displayAllPersonAadhar();
				break;
			}
			case 5:{
				System.out.println("enter id to delete");
				personAadharCRUD.deletePersonAadhar(scanner.nextInt());
				break;
			}
			case 6:{
				System.out.println("thank you");
				mainexit=false;
			}
			}
		} while (mainexit);

	}
}
