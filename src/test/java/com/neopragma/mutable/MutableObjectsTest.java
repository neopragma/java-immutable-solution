package com.neopragma.mutable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.ref.SoftReference;

import org.junit.Before;
import org.junit.Test;

import com.neopragma.mutable.Car;
import com.neopragma.mutable.Constants;
import com.neopragma.mutable.Vehicle;

public class MutableObjectsTest {
	
	private Vehicle v;
	
	@Before
	public void beforeEach() {
	    v = new Car();
	}
	
	@Test
	public void car_can_be_instantiated_with_invalid_power_type() {
		assertFalse(v.validatePowerType());
	}	
	
	@Test
	public void setting_power_type_mutates_car_instance() {
		SoftReference<Vehicle> sr1 = new SoftReference<Vehicle>(v);
		v.setPowerType(Constants.GASOLINE);
		SoftReference<Vehicle> sr2 = new SoftReference<Vehicle>(v);
		assertEquals(sr2.get(), sr1.get());		
	}
	
	@Test
	public void valid_car_instance_can_be_corrupted_by_setting_invalid_power_type() { 
        v.setPowerType(Constants.GASOLINE);
        assertTrue(v.validatePowerType());
        v.setPowerType(3);
        assertFalse(v.validatePowerType());
	}
	
	@Test
	public void car_can_be_instantiated_with_invalid_hand() {
		assertFalse(v.validateHand());
	}
	
	@Test
	public void setting_hand_mutates_the_car_instance() {
		SoftReference<Vehicle> sr1 = new SoftReference<Vehicle>(v);
		v.setHand(Constants.RIGHT_HAND_DRIVE);
		SoftReference<Vehicle> sr2 = new SoftReference<Vehicle>(v);
		assertEquals(sr2.get(), sr1.get());				
	}
	
	@Test
	public void valid_car_instance_can_be_corrupted_by_setting_invalid_hand() { 
        v.setHand(Constants.LEFT_HAND_DRIVE);
        assertTrue(v.validateHand());
        v.setHand(999);
        assertFalse(v.validateHand());
	}

	@Test
	public void valid_car_instance_can_be_corrupted_by_setting_invalid_tank() {
		v.setTank(1);
		assertEquals(13, v.getTankCapacity());
		v.setTank(999);
		assertEquals(0, v.getTankCapacity());
	}
	
	@Test
	public void adding_an_option_package_mutates_the_car_instance() {
		v.setHand(1);
		v.setPowerType(1);
		v.setTank(1);
		SoftReference<Vehicle> sr1 = new SoftReference<Vehicle>(v);
        v.addOptionPackage(1);
		SoftReference<Vehicle> sr2 = new SoftReference<Vehicle>(v);
		assertEquals(sr2.get(), sr1.get());				        
	}
	
}
