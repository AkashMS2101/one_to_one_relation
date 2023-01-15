package one_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonAdhc {
	@Id
	private int id;

	@Override
	public String toString() {
		return "PersonAdhc [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", aadharCard="
				+ aadharCard + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public AadharCard getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}

	private String name;
	private String address;
	private long phone;
	@OneToOne
	private AadharCard aadharCard;

}
