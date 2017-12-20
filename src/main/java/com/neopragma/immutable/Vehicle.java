package com.neopragma.immutable;

import java.util.List;

public interface Vehicle {
	
	int getTankCapacity();
	
	List<OptionPackage> getOptionPackages();
	Vehicle addOptionPackage(OptionPackage optionPackage);

}
