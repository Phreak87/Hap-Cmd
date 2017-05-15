package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.DimmableLightbulb;

public class _DimmableLightbulb implements DimmableLightbulb {
	public _DimmableLightbulb(Integer iD, String label, Boolean powValue, Integer briValue) {
		super();
		ID = iD;
		Label = label;
		PowVal = powValue;
		BriVal = briValue;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "DimmableLightbulb";
	
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
		return "DimmableLightbulb";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// Power GET + SET
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
		PowCB = callback;
	}
	@Override
	public void unsubscribeLightbulbPowerState() {
		PowCB = null;
	}

	// ---------------------------
	// Bri GET + SET
	// ---------------------------
	private Integer BriVal = 0;
	private HomekitCharacteristicChangeCallback BriCB = null;
	
	@Override
	public CompletableFuture<Integer> getBrightness() {
		return CompletableFuture.completedFuture(BriVal);
	}
	@Override
	public CompletableFuture<Void> setBrightness(Integer value) throws Exception {
		BriVal = value;
		if (BriCB != null) {BriCB.changed();}
		System.out.println(ID + "_Bri@" + Label + " is now " + BriVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeBrightness(HomekitCharacteristicChangeCallback callback) {
		BriCB = callback;
	}
	@Override
	public void unsubscribeBrightness() {
		BriCB = null;
	}
}
