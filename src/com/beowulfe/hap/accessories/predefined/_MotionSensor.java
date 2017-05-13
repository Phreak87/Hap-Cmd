package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.MotionSensor;

public class _MotionSensor implements MotionSensor{
	public _MotionSensor(Integer iD, String label, Boolean motValue) {
		super();
		ID = iD;
		Label = label;
		MotVal = motValue;
	}
	
	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "MotionSensor";

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
		return "MotionSensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// ___ GET + SET
	// ---------------------------
		
	private Boolean MotVal = false;
	private HomekitCharacteristicChangeCallback MotCB = null;
	
	@Override
	public CompletableFuture<Boolean> getMotionDetected() {
		return CompletableFuture.completedFuture(MotVal);
	}
	public CompletableFuture<Void>   setMotionDetected(Boolean Value) throws Exception { // Own
		MotVal = Value;
		if (MotCB != null) {MotCB.changed();}
		System.out.println(ID + "_Mot@" + Label + " is now " + MotVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeMotionDetected(HomekitCharacteristicChangeCallback callback) {
		MotCB = callback;
	}
	@Override
	public void unsubscribeMotionDetected() {
		MotCB = null;
	}

}
