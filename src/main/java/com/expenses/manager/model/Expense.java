package com.expenses.manager.model;

public class Expense {
	private Double amount;
	private String description;
	private Long entryDate;

	public Expense() {

	}

	public Expense(Double amount, String description, Long entryDate) {
		this.amount = amount;
		this.description = description;
		this.entryDate = entryDate;
	}

	@Override
	public String toString() {
		return "Expense [amount=" + amount + ", description=" + description + ", entryDate=" + entryDate
				+ "]";
	}

	public Long getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Long entryDate) {
		this.entryDate = entryDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
