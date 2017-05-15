package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Outlet;

public class _Outlet implements Outlet{
	public _Outlet(Integer iD, String label, Boolean powVal, Boolean Use) {
		super();
		ID = iD;
		Label = label;
		PowVal = powVal;
		UseVal = Use;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "Outlet";
	
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
		return "Outlet";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// Power GET + SET
	// ---------------------------
	private boolean PowVal = false;
	private HomekitCharacteristicChangeCallback PowCB = null;
	
	@Override
	public CompletableFuture<Boolean> getPowerState() {
		return CompletableFuture.completedFuture(PowVal);
	}
	@Override
	public CompletableFuture<Void> setPowerState(boolean state) throws Exception {
		PowVal = state;
		if (PowCB != null) {PowCB.changed();}
		System.out.println(ID + "_Pow@" + Label + " is now " + PowVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribePowerState(HomekitCharacteristicChangeCallback callback) {
		PowCB = callback;
	}
		@Override
	public void unsubscribePowerState() {
			PowCB = null;
	}
		
	// ---------------------------
	// Used GET + SET
	// ---------------------------
		
	private boolean UseVal = false;
	private HomekitCharacteristicChangeCallback UseCB = null;
	
	@Override
	public CompletableFuture<Boolean> getOutletInUse() {
		return CompletableFuture.completedFuture(UseVal);
	}
	public CompletableFuture<Void>   setOutletInUse(Boolean Value) throws Exception { // Own
		UseVal = Value;
		if (UseCB != null) {UseCB.changed();}
		System.out.println(ID + "_Use@" + Label + " is now " + UseVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeOutletInUse(HomekitCharacteristicChangeCallback callback) {
		UseCB = callback;
		
	}
	@Override
	public void unsubscribeOutletInUse() {
		UseCB = null;
	}

}
