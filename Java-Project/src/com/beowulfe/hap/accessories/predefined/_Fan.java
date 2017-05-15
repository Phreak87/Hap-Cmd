package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Fan;
import com.beowulfe.hap.accessories.properties.RotationDirection;

public class _Fan implements Fan {
	public _Fan(Integer iD, String label, Boolean powValue, RotationDirection dirValue, Integer speValue) {
		super();
		ID = iD;
		Label = label;
		PowVal = powValue;
		DirVal = dirValue;
		SpeVal = speValue;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "Fan";
	
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
		return "Fan";
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
	public CompletableFuture<Boolean> getFanPower() {
		return CompletableFuture.completedFuture(PowVal);
	}
	@Override
	public CompletableFuture<Void>    setFanPower(boolean state) throws Exception {
		PowVal = state;
		if (PowCB != null) {PowCB.changed();}
		System.out.println(ID + "_Pow@" + Label + " is now " + PowVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeFanPower(HomekitCharacteristicChangeCallback callback) {
		PowCB = callback;
	}
	@Override
	public void unsubscribeFanPower() {
		PowCB = null;
	}
	
	// ---------------------------
	// RotationDirection GET + SET
	// ---------------------------
	private RotationDirection DirVal = RotationDirection.CLOCKWISE;
	private HomekitCharacteristicChangeCallback DirCB = null;
	
	@Override
	public CompletableFuture<RotationDirection> getRotationDirection() {
		return CompletableFuture.completedFuture(DirVal);
	}
	@Override
	public CompletableFuture<Void>              setRotationDirection(RotationDirection direction) throws Exception {
		DirVal = direction;
		if (DirCB != null) {DirCB.changed();}
		System.out.println(ID + "_Rot@" + Label + " is now " + DirVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeRotationDirection(HomekitCharacteristicChangeCallback callback) {
		DirCB = callback;
	}
	@Override
	public void unsubscribeRotationDirection() {
		DirCB = null;
	}
	
	// ---------------------------
	// RotationSpeed GET + SET
	// ---------------------------
	private Integer SpeVal = 0;
	private HomekitCharacteristicChangeCallback SpeCB = null;
	
	@Override
	public CompletableFuture<Integer> getRotationSpeed() {
		return CompletableFuture.completedFuture(SpeVal);
	}
	@Override
	public CompletableFuture<Void>    setRotationSpeed(Integer speed) throws Exception {
		SpeVal = speed;
		if (SpeCB != null) {SpeCB.changed();}
		System.out.println(ID + "_Spe@" + Label + " is now " + SpeCB);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeRotationSpeed(HomekitCharacteristicChangeCallback callback) {
		SpeCB = callback;
	}
	@Override
	public void unsubscribeRotationSpeed() {
		SpeCB = null;
	}

}
