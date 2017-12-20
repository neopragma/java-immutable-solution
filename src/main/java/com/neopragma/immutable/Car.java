package com.neopragma.immutable;

import java.util.ArrayList;
import java.util.List;

public class Car implements Vehicle {
	
	private PowerType powerType;
	private Drive drive;
	private Tank tank;
    private List<OptionPackage> optionPackages;
	
	public Car(PowerType powerType, Drive drive, Tank tank) {
		if (powerType == null || drive == null || tank == null) {
			throw new IllegalArgumentException();
		}
		this.powerType = powerType;
		this.drive = drive;
		this.tank = tank;
	}
	
	private Car(PowerType powerType, Drive drive, Tank tank, List<OptionPackage> optionPackages) {
		this(powerType, drive, tank);
	    this.optionPackages = optionPackages;
	}

	public PowerType getPowerType() {
		return powerType;
	}
	
	public Drive getDrive() {
		return drive;
	}
	
	public int getTankCapacity() {
		return tank.getCapacity();
	}

	public List<OptionPackage> getOptionPackages() {
		return optionPackages;
	}

	public Car addOptionPackage(OptionPackage optionPackage) {
		List<OptionPackage> newOptionPackages = optionPackages;
		if (newOptionPackages == null) {
			newOptionPackages = new ArrayList<OptionPackage>();
		}
		newOptionPackages.add(optionPackage);
		return new Car(powerType, drive, tank, newOptionPackages);
	}

}
