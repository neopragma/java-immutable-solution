package com.neopragma.mutable;

import java.util.ArrayList;
import java.util.List;

public class Car implements Vehicle, Constants {
	
	private int powerType;
	private int hand;
	private int tank;
    private List<Integer> optionPackages;
    
    public Car() {
    	optionPackages = new ArrayList<Integer>();
    }
	
	public int getPowerType() {
		return powerType;
	}

	public void setPowerType(int powerType) {
        this.powerType = powerType;
	}
	
	public boolean validatePowerType() {
		return powerType == GASOLINE || 
			   powerType == DIESEL || 
			   powerType == ELECTRIC || 
			   powerType == GASOLINE_ELECTRIC || 
			   powerType == DIESEL_ELECTRIC;
	}
	
	public int getHand() {
		return hand;
	}
	
	public void setHand(int hand) {
		this.hand = hand;
	}

	public boolean validateHand() {
		return hand > 0 && hand < 3;
	}
	
	public int getTank() {
		return tank;
	}
	
	public void setTank(int tank) {
		this.tank = tank;
	}
	
	public int getTankCapacity() {
		if (tank == 1) return 13;
		if (tank == 2) return 20;
		return 0;
	}

	public List<Integer> getOptionPackages() {
        return optionPackages;
	}

	public void addOptionPackage(int packageId) {
		optionPackages.add(packageId);
		
	}
	
}
