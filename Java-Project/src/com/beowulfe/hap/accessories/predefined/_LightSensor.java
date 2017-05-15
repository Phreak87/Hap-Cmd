package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.LightSensor;

public class _LightSensor implements LightSensor {
	public _LightSensor(Integer iD, String label, Double ambValue) {
		super();
		ID = iD;
		Label = label;
		AmbVal = ambValue;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "LightSensor";
	
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
		return "LightSensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// ___ GET + SET
	// ---------------------------
	private Double AmbVal = 0.0;
	private HomekitCharacteristicChangeCallback AmbCB = null;
	
	@Override
	public CompletableFuture<Double> getCurrentAmbientLightLevel() {
		return CompletableFuture.completedFuture(AmbVal);
	}
	public CompletableFuture<Void>   setCurrentAmbientLightLevel(Double Value) throws Exception { // Own
		AmbVal = Value;
		if (AmbCB != null) {AmbCB.changed();}
		System.out.println(ID + "_Amb@" + Label + " is now " + AmbVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeCurrentAmbientLightLevel(HomekitCharacteristicChangeCallback callback) {
		AmbCB = callback;
	}
	@Override
	public void unsubscribeCurrentAmbientLightLevel() {
		AmbCB = null;
	}

}
