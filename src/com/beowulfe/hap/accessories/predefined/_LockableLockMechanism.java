package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.LockableLockMechanism;
import com.beowulfe.hap.accessories.properties.LockMechanismState;

public class _LockableLockMechanism implements LockableLockMechanism {
	public _LockableLockMechanism(Integer iD, String label, LockMechanismState curVal, LockMechanismState tarVal) {
		super();
		ID = iD;
		Label = label;
		CurVal = curVal;
		TarVal = tarVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "LockableLockMechanism";
	
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
		return "LockableLockMechanism";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// Current MechanismState GET + SET
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
	
	// ---------------------------
	// Target MechanismState GET + SET
	// ---------------------------
	private LockMechanismState TarVal = LockMechanismState.SECURED;
	private HomekitCharacteristicChangeCallback TarCB = null;
	
	@Override
	public CompletableFuture<LockMechanismState> getTargetMechanismState() {
		return CompletableFuture.completedFuture(TarVal);
	}
	@Override
	public void setTargetMechanismState(LockMechanismState state) throws Exception {
		TarVal = state;
		if (TarCB != null) {TarCB.changed();}
		System.out.println(ID + "_Tar@" + Label + " is now " + TarVal);
	}

	@Override
	public void subscribeTargetMechanismState(HomekitCharacteristicChangeCallback callback) {
		TarCB = callback;
	}
	@Override
	public void unsubscribeTargetMechanismState() {
		TarCB = null;
	}

}
