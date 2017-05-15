package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.ColorfulLightbulb;

public class _ColorfulLightbulb implements ColorfulLightbulb {
	
	public _ColorfulLightbulb(Integer iD, String label, Boolean powValue, double hueValue, double satValue) {
		super();
		ID = iD;
		Label = label;
		PowVal = powValue;
		HueVal = hueValue;
		SatVal = satValue;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID    =  0; 
	private String  Label = "ColorfulLightbulb";
	
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
		return "ColorfulLightbulb";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}
	
	// ----------------------
	// Power GET + SET
	// ----------------------
	private Boolean                             PowVal = false;
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
	
	// ----------------------
	// HUE GET + SET
	// ----------------------
	private double 								HueVal = 0;
	private HomekitCharacteristicChangeCallback HueCB = null;
	
	@Override
	public CompletableFuture<Double> getHue() {
		return  CompletableFuture.completedFuture(HueVal);
	}
	@Override
	public CompletableFuture<Void>   setHue(Double value) throws Exception {
		HueVal = value; 
		if (HueCB != null) {HueCB.changed();}
		System.out.println(ID + "_Hue@" + Label + " is now " + HueVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeHue(HomekitCharacteristicChangeCallback callback) {
		HueCB = callback;
	}
	@Override
	public void unsubscribeHue() {
		HueCB = null;
	}

	// ----------------------
	// SAT GET + SET
	// ----------------------
	private double 								SatVal = 0;
	private HomekitCharacteristicChangeCallback SatCB = null;
	
	@Override
	public CompletableFuture<Double> getSaturation() {
		return CompletableFuture.completedFuture(SatVal);
	}
	@Override
	public CompletableFuture<Void>   setSaturation(Double value) throws Exception {
		SatVal = value; 
		if (SatCB != null) {SatCB.changed();}
		System.out.println(ID + "_Sat@" + Label + " is now " + SatVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeSaturation(HomekitCharacteristicChangeCallback callback) {
		SatCB = callback;
	}
	@Override
	public void unsubscribeSaturation() {
		SatCB = null;
	}

}
