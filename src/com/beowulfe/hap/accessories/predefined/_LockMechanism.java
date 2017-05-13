package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.LockMechanism;
import com.beowulfe.hap.accessories.properties.LockMechanismState;

public class _LockMechanism implements LockMechanism {
	public _LockMechanism(Integer iD, String label, LockMechanismState curVal) {
		super();
		ID = iD;
		Label = label;
		CurVal = curVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
		private Integer ID = 0; 
	private String Label = "LockMechanism";
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
		return "LockMechanism";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// CurState GET + SET
	// ---------------------------
		
	private LockMechanismState CurVal = LockMechanismState.SECURED;
	private HomekitCharacteristicChangeCallback CurCB = null;
	
	@Override
	public CompletableFuture<LockMechanismState> getCurrentMechanismState() {
		return CompletableFuture.completedFuture(CurVal);
	}
	public CompletableFuture<Void>   setCurrentMechanismState(LockMechanismState Value) throws Exception { // Own
		CurVal = Value;
		if (CurCB != null) {CurCB.changed();}
		System.out.println(ID + "_Cur@" + Label + " is now " + CurVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeCurrentMechanismState(HomekitCharacteristicChangeCallback callback) {
		CurCB = callback;
	}
	@Override
	public void unsubscribeCurrentMechanismState() {
		CurCB = null;
	}

}
