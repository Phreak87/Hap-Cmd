package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Switch;

public class _Switch implements Switch{
	public _Switch(Integer iD, String label, Boolean swiVal) {
		super();
		ID = iD;
		Label = label;
		SwiVal = swiVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "Switch";
	
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
		return "Switch";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// ___ GET + SET
	// ---------------------------
	private Boolean SwiVal = false;
	private HomekitCharacteristicChangeCallback SwiCB = null;
	
	@Override
	public CompletableFuture<Boolean> getSwitchState() {
		return CompletableFuture.completedFuture(SwiVal);
	}
	@Override
	public CompletableFuture<Void> setSwitchState(boolean state) throws Exception {
		SwiVal = state;
		if (SwiCB != null) {SwiCB.changed();}
		System.out.println(ID + "_Cur@" + Label + " is now " + SwiVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeSwitchState(HomekitCharacteristicChangeCallback callback) {
		SwiCB = callback;
	}
	@Override
	public void unsubscribeSwitchState() {
		SwiCB = null;
	}

}
