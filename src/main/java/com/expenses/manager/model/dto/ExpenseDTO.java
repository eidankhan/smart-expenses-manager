package com.expenses.manager.model.dto;

public class ExpenseDTO {
	private Double amount;
	private String description;
	private String date;

	public ExpenseDTO() {
	}

	public ExpenseDTO(Double amount, String description, String date) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
	}


	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ExpenseDTO [amount=" + amount + ", description=" + description + ", date=" + date + "]";
	}

}
