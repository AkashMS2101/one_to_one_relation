package com.ty.one_to_one_uni2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonPc {
	@Id
	private int person_id;
	private String person_name;
	private String person_address;
	private long phone;
	@OneToOne
	private PanCard card;

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getPerson_address() {
		return person_address;
	}

	public void setPerson_address(String person_address) {
		this.person_address = person_address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public PanCard getCard() {
		return card;
	}

	public void setCard(PanCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "PersonPc [person_id=" + person_id + ", person_name=" + person_name + ", person_address="
				+ person_address + ", phone=" + phone + ", card=" + card + "]";
	}
}
