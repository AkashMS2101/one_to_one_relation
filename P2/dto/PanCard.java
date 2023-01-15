package com.ty.one_to_one_uni2.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {
	@Id
	private int p_id;

	@Override
	public String toString() {
		return "PanCard [p_id=" + p_id + ", pan_num=" + pan_num + ", name=" + name + "]";
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getPan_num() {
		return pan_num;
	}

	public void setPan_num(String pan_num) {
		this.pan_num = pan_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String pan_num;
	private String name;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
