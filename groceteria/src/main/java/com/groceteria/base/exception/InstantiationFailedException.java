package com.groceteria.base.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstantiationFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Class<?> targetClass;

	public InstantiationFailedException(Class<?> targetClass, Throwable cause) {

		super("Failed to create an instance of " + targetClass.getName(), cause);

		this.targetClass = targetClass;
	}

	public Class<?> getTargetClass() {

		return targetClass;
	}
}