package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.SmokeSensor;
import com.beowulfe.hap.accessories.properties.SmokeDetectedState;

public class _SmokeSensor implements SmokeSensor {
	public _SmokeSensor(Integer iD, String label, SmokeDetectedState smoVal) {
		super();
		ID = iD;
		Label = label;
		SmoVal = smoVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "SmokeSensor";
	
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
		return "SmokeSensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// ___ GET + SET
	// ---------------------------
	
	private SmokeDetectedState SmoVal = SmokeDetectedState.NOT_DETECTED;
	private HomekitCharacteristicChangeCallback SmoCB = null;
	
	@Override
	public CompletableFuture<SmokeDetectedState> getSmokeDetectedState() {
		return CompletableFuture.completedFuture(SmoVal);
	}
	public CompletableFuture<Void>   setSmokeDetectedState(SmokeDetectedState Value) throws Exception { // Own
		SmoVal = Value;
		if (SmoCB != null) {SmoCB.changed();}
		System.out.println(ID + "_Cur@" + Label + " is now " + SmoVal);
		return CompletableFuture.completedFuture(null);
	}
	
	
	@Override
	public void subscribeSmokeDetectedState(HomekitCharacteristicChangeCallback callback) {
		SmoCB = callback;
	}
	@Override
	public void unsubscribeSmokeDetectedState() {
		SmoCB = null;
	}

}
