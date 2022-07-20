package com.expenses.manager.model.dto;

public class ExpenseDTO {
	private Integer id;
	private Double amount;
	private String description;
	private String date;

	public ExpenseDTO() {
	}

	public ExpenseDTO(Integer id, Double amount, String description, String date) {
		super();
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "ExpenseDTO [id=" + id + ", amount=" + amount + ", description=" + description + ", date=" + date + "]";
	}

}
