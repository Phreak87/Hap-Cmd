package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.HumiditySensor;

public class _HumiditySensor implements HumiditySensor {
	public _HumiditySensor(Integer iD, String label, Double humValue) {
		super();
		ID = iD;
		Label = label;
		HumVal = humValue;
	}

	private Integer ID = 0; 
	private String Label = "HumiditySensor";

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	
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
		return "HumiditySensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// ___ GET + SET
	// ---------------------------
		
	private Double HumVal = 0.0;
	private HomekitCharacteristicChangeCallback HumCB = null;
	
	@Override
	public CompletableFuture<Double> getCurrentRelativeHumidity() {
		return CompletableFuture.completedFuture(HumVal);
	}
	public void setCurrentRelativeHumidity(Double value) {
		HumVal = value;
		if (HumCB != null) {HumCB.changed();}
		System.out.println(ID + "_Hum@" + Label + " is now " + HumVal);
	}

	@Override
	public void subscribeCurrentRelativeHumidity(HomekitCharacteristicChangeCallback callback) {
		HumCB = callback;
	}
	@Override
	public void unsubscribeCurrentRelativeHumidity() {
		HumCB = null;
	}

}
