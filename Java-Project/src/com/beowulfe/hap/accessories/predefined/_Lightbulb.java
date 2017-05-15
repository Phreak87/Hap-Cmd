package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Lightbulb;

public class _Lightbulb implements Lightbulb{
	public _Lightbulb(Integer iD, String label, Boolean powValue) {
		super();
		ID = iD;
		Label = label;
		PowVal = powValue;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "Lightbulb";
	
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
		return "Lightbulb";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// ___ GET + SET
	// ---------------------------
	private Boolean PowVal = false;
	private HomekitCharacteristicChangeCallback PowCB = null;
	
	@Override
	public CompletableFuture<Boolean> getLightbulbPowerState() {
		return CompletableFuture.completedFuture(PowVal);
	}
	@Override
	public CompletableFuture<Void>    setLightbulbPowerState(boolean powerState) throws Exception {
		PowVal = powerState;
		if (PowCB != null) {PowCB.changed();}
		System.out.println(ID + "_Pow@" + Label + " is now " + PowVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeLightbulbPowerState(HomekitCharacteristicChangeCallback callback) {
		PowCB=  callback;
	}
	@Override
	public void unsubscribeLightbulbPowerState() {
		PowCB = null;
	}

}
