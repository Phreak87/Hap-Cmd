package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.TemperatureSensor;

public class _TemperatureSensor implements TemperatureSensor {
	public _TemperatureSensor(Integer iD, String label, Double tmpVal) {
		super();
		ID = iD;
		Label = label;
		TmpVal = tmpVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "TemperatureSensor";
	
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
		return "TemperatureSensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// Temp GET + SET
	// ---------------------------
	private Double TmpVal = 0.0;
	private HomekitCharacteristicChangeCallback TmpCB = null;
	
	@Override
	public CompletableFuture<Double> getCurrentTemperature() {
		return CompletableFuture.completedFuture(TmpVal);
	}
	public CompletableFuture<Void> setCurrentTemperature(double state) throws Exception {
		TmpVal = state;
		if (TmpCB != null) {TmpCB.changed();}
		System.out.println(ID + "_Tmp@" + Label + " is now " + TmpVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeCurrentTemperature(HomekitCharacteristicChangeCallback callback) {
		TmpCB = callback;
	}
	@Override
	public void unsubscribeCurrentTemperature() {
		TmpCB = null;
	}

	// ---------------------------
	// Min Max GET + SET
	// ---------------------------
	@Override
	public double getMinimumTemperature() {
		return 0;
	}
	@Override
	public double getMaximumTemperature() {
		return 100;
	}

}
