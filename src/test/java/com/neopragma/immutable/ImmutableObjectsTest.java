package com.neopragma.immutable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.ref.SoftReference;

import org.junit.Test;

import com.neopragma.immutable.Car;
import com.neopragma.immutable.Drive;
import com.neopragma.immutable.OptionPackage;
import com.neopragma.immutable.PowerType;
import com.neopragma.immutable.Tank;
import com.neopragma.immutable.Vehicle;

public class ImmutableObjectsTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void car_cannot_be_instantiated_with_invalid_power_type() {
		new Car(null, Drive.LEFT_HAND, Tank.SMALL);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void car_cannot_be_instantiated_with_invalid_drive() {
		new Car(PowerType.DIESEL, null, Tank.SMALL);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void car_cannot_be_instantiated_with_invalid_tank() {
		new Car(PowerType.DIESEL, Drive.LEFT_HAND, null);
	}	
	
	@Test
	public void assignment_uses_interning() {
		Car car1 = new Car(PowerType.DIESEL, Drive.LEFT_HAND, Tank.SMALL);
		SoftReference<Vehicle> sr1 = new SoftReference<Vehicle>(car1);
		Car car2 = car1;
		SoftReference<Vehicle> sr2 = new SoftReference<Vehicle>(car2);
		assertEquals(sr2.get(), sr1.get());		
	}
	
	@Test
	public void adding_an_option_package_creates_a_copy_of_the_car_instance() {
		Car car1 = new Car(PowerType.DIESEL, Drive.LEFT_HAND, Tank.SMALL);
		SoftReference<Vehicle> sr1 = new SoftReference<Vehicle>(car1);
        car1 = car1.addOptionPackage(OptionPackage.SPORT);
		SoftReference<Vehicle> sr2 = new SoftReference<Vehicle>(car1);
		assertNotEquals(sr2.get(), sr1.get());		        
	}

}
