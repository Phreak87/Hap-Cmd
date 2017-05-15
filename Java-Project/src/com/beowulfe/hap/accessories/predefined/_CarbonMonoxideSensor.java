package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.CarbonMonoxideSensor;
import com.beowulfe.hap.accessories.properties.CarbonMonoxideDetectedState;

public class _CarbonMonoxideSensor implements CarbonMonoxideSensor {
	public _CarbonMonoxideSensor(Integer iD, String label, CarbonMonoxideDetectedState state) {
		super();
		ID = iD;
		Label = label;
		MonVal = state;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "CarbonMonoxideSensor";
	
	@Override
	public int getId() {
		return ID;
	}
	@Override
	public String getLabel() {
		return Label;
	}
	@Override
	public void identify() {
		System.out.println(ID + " Identify " + Label);
	}
	@Override
	public String getSerialNumber() {
		return ID + "_" + Label;
	}
	@Override
	public String getModel() {
		return "CarbonMonoxideSensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// State GET + SET
	// ---------------------------
	private CarbonMonoxideDetectedState MonVal = CarbonMonoxideDetectedState.NORMAL;
	private HomekitCharacteristicChangeCallback MonCB = null;
	
	public void setCarbonMonoxideDetectedState (CarbonMonoxideDetectedState state){
		MonVal = state;
		if (MonCB != null) {MonCB.changed();}
		System.out.println(ID + "_Mon@" + Label + " is now " + MonVal);
	}
	@Override
	public CompletableFuture<CarbonMonoxideDetectedState> getCarbonMonoxideDetectedState() {
		return CompletableFuture.completedFuture(MonVal);
	}

	@Override
	public void subscribeCarbonMonoxideDetectedState(HomekitCharacteristicChangeCallback callback) {
		MonCB = callback;
	}
	@Override
	public void unsubscribeCarbonMonoxideDetectedState() {
		MonCB = null;
	}
}
