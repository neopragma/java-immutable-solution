package com.neopragma.immutable;

public enum Tank {
	
	SMALL(13), MEDIUM(20), LARGE(32);
	
	Tank(int capacity) {
		this.capacity = capacity;
	}
	
	private final int capacity;
	
	public int getCapacity() {
		return capacity;
	}

}
