package com.angkko.service;

public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}
}
