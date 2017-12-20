package com.neopragma.mutable;

import java.util.List;

public interface Vehicle {
	
	int getPowerType();
	void setPowerType(int powerType);
	boolean validatePowerType();
	
	int getHand();
	void setHand(int hand);
	boolean validateHand();
	
	int getTank();
	void setTank(int tank);
	int getTankCapacity();
	
	List<Integer> getOptionPackages();
	void addOptionPackage(int packageId);

}
