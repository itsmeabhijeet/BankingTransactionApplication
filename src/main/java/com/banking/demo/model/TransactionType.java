package com.banking.demo.model;

public enum TransactionType {

	DEPOSIT(1), WITHDRAW(2);
	private final int typeCode;

	TransactionType(int type) {
		this.typeCode = type;
	}

	public int getTransactionTypeCode() {
		return this.typeCode;
	}

}
