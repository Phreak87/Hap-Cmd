package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.GarageDoor;
import com.beowulfe.hap.accessories.properties.DoorState;

public class _GarageDoor implements GarageDoor {
	public _GarageDoor(Integer iD, String label, DoorState curValue, DoorState tarValue, Boolean obsValue) {
		super();
		ID = iD;
		Label = label;
		CurVal = curValue;
		TarVal = tarValue;
		ObsVal = obsValue;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "GarageDoor";
	
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
		return "GarageDoor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// CurrentDoorState GET + SET
	// ---------------------------
	
	private DoorState CurVal = DoorState.CLOSED;
	private HomekitCharacteristicChangeCallback CurCB = null;
		
	@Override
	public CompletableFuture<DoorState> getCurrentDoorState() {
		return CompletableFuture.completedFuture(CurVal);
	}
	public CompletableFuture<DoorState> setCurrentDoorState (DoorState value) { // Own
		CurVal = value;
		if (CurCB != null) {CurCB.changed();}
		System.out.println(ID + "_Cur@" + Label + " is now " + CurVal);
		return CompletableFuture.completedFuture(CurVal);
	}

	@Override
	public void subscribeCurrentDoorState(HomekitCharacteristicChangeCallback callback) {
		CurCB = callback;
	}
	@Override
	public void unsubscribeCurrentDoorState() {
		CurCB = null;
	}

	// ---------------------------
	// TargetDoorState GET + SET
	// ---------------------------
	private DoorState TarVal = DoorState.CLOSED;
	private HomekitCharacteristicChangeCallback TarCB = null;
	
	@Override
	public CompletableFuture<DoorState> getTargetDoorState() {
		return CompletableFuture.completedFuture(TarVal);
	}
	@Override
	public CompletableFuture<Void>      setTargetDoorState(DoorState state) throws Exception {
		TarVal = state;
		if (TarCB != null) {TarCB.changed();}
		System.out.println(ID + "_Tar@" + Label + " is now " + TarVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeTargetDoorState(HomekitCharacteristicChangeCallback callback) {
		TarCB = callback;
	}
	@Override
	public void unsubscribeTargetDoorState() {
		TarCB = null;
	}
	
	// ---------------------------
	// Obstruction GET + SET
	// ---------------------------
	private Boolean ObsVal = false;
	private HomekitCharacteristicChangeCallback ObsCB = null;
	
	@Override
	public CompletableFuture<Boolean>   getObstructionDetected() {
		return CompletableFuture.completedFuture(ObsVal);
	}
	public CompletableFuture<DoorState> setObstructionDetected (Boolean value) { // Own
		ObsVal = value;
		if (ObsCB != null) {ObsCB.changed();}
		System.out.println(ID + "_Obs@" + Label + " is now " + ObsVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeObstructionDetected(HomekitCharacteristicChangeCallback callback) {
		ObsCB = callback;
	}
	@Override
	public void unsubscribeObstructionDetected() {
		ObsCB = null;
	}

}
