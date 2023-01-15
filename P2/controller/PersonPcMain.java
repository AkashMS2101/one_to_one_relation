package com.ty.one_to_one2.controller;

import java.util.Scanner;

import com.ty.one_to_one_uni2.dao.PancardCRUD;
import com.ty.one_to_one_uni2.dao.PersonPcCRUD;
import com.ty.one_to_one_uni2.dto.PanCard;
import com.ty.one_to_one_uni2.dto.PersonPc;

public class PersonPcMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PersonPc pc = new PersonPc();
		PanCard card = new PanCard();
		boolean mainexit = true;
		do {
			System.out.println("enter your choice");
			System.out.println("1.to insert data.\n2.to update.\n3.to delete.\n4.to view by id\n5.to view all\n6.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				// to insert
				System.out.println("enter your basic info");
				System.out.println("enter your id");
				pc.setPerson_id(scanner.nextInt());
				System.out.println("enter your name");
				pc.setPerson_name(scanner.next());
				System.out.println("enter your phone number");
				pc.setPhone(scanner.nextLong());
				System.out.println("enter your address");
				pc.setPerson_address(scanner.next());

				System.out.println("ente your PanCard details");
				System.out.println("enter Pan id");
				card.setP_id(scanner.nextInt());
				System.out.println("enter pan number");
				card.setPan_num(scanner.next());
				System.out.println("enter name as in pan");
				card.setName(scanner.next());
				System.out.println("enter address as in pan");
				card.setAddress(scanner.next());

				pc.setCard(card);

				PersonPcCRUD crud2 = new PersonPcCRUD();
				crud2.savePerson(pc);

				break;
			}
			case 2: {
				// update
				System.out.println("Enter choice");
				System.out.println("1.to update basic info\n2.to update pancard details");
				int choice1 = scanner.nextInt();
				System.out.println("enter the id to update");
				int id = scanner.nextInt();
				System.out.println("enter new name");
				String name = scanner.next();
				if (choice1 == 1) {
					PersonPcCRUD crud = new PersonPcCRUD();
					crud.updatePersonPc(id, name);
				} else if (choice1 == 2) {
					PancardCRUD crud = new PancardCRUD();
					crud.updatePanCard(id, name);
				}

				break;
			}
			case 3:{
				System.out.println("Enter choice");
				System.out.println("1.to delete basic info\n2.to delete all details");
				int choice1 = scanner.nextInt();
				System.out.println("enter the id to delete");
				int id = scanner.nextInt();
				if (choice1 == 1) {
					PersonPcCRUD crud = new PersonPcCRUD();
					crud.deletePerson(id);
				} 
				else if (choice1 == 2) {
					PancardCRUD crud = new PancardCRUD();
					crud.deletePanCard(id);
				}
				
				break;
			}
			case 4:{
				System.out.println("enter the id to display");
				int id = scanner.nextInt();
				PersonPcCRUD crud = new PersonPcCRUD();
				crud.displayPersonPcById(id);
			}
			
			case 5: {
				PersonPcCRUD crud = new PersonPcCRUD();
				crud.displayAllPersonPc();
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
