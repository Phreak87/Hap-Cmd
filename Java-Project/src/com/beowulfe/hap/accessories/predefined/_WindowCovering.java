package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.WindowCovering;
import com.beowulfe.hap.accessories.properties.WindowCoveringPositionState;

public class _WindowCovering implements WindowCovering{
	public _WindowCovering(Integer iD, String label) {
		super();
		ID = iD;
		Label = label;
	}
	public _WindowCovering(Integer iD, String label, Integer curPosVal, Integer tarPosVal, Boolean obstVal,
			WindowCoveringPositionState posVal, Boolean holdVal) {
		super();
		ID = iD;
		Label = label;
		CurPosVal = curPosVal;
		TarPosVal = tarPosVal;
		ObstVal = obstVal;
		PosVal = posVal;
		HoldVal = holdVal;
	}
	
	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "WindowCovering";
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
		return "WindowCovering";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// CurrPos GET + SET
	// ---------------------------
	
	private Integer CurPosVal = 0;
	private HomekitCharacteristicChangeCallback CurPosCB = null;
	
	@Override
	public CompletableFuture<Integer> getCurrentPosition() {
		return CompletableFuture.completedFuture(CurPosVal);
	}
	public CompletableFuture<Void> setCurrentPosition(int position) throws Exception {
		CurPosVal = position;
		if (CurPosCB != null){CurPosCB.changed();}
		System.out.println(ID + "CurPosVal@" + Label + " is now " + CurPosVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeCurrentPosition(HomekitCharacteristicChangeCallback callback) {
		CurPosCB = callback;
	}
	@Override
	public void unsubscribeCurrentPosition() {
		CurPosCB = null;
	}
	
	// ---------------------------
	// TargPos GET + SET
	// ---------------------------
	private Integer TarPosVal = 0;
	private HomekitCharacteristicChangeCallback TarPosCB = null;
	
	@Override
	public CompletableFuture<Integer> getTargetPosition() {
		return CompletableFuture.completedFuture(TarPosVal);
	}
	@Override
	public CompletableFuture<Void> setTargetPosition(int position) throws Exception {
		TarPosVal = position;
		if (TarPosCB != null){TarPosCB.changed();}
		System.out.println(ID + "TarPosVal@" + Label + " is now " + TarPosVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeTargetPosition(HomekitCharacteristicChangeCallback callback) {
		TarPosCB = callback;
	}
	@Override
	public void unsubscribeTargetPosition() {
		TarPosCB = null;
	}
	
	// ---------------------------
	// Obst GET + SET
	// ---------------------------
	private Boolean ObstVal = false;
	private HomekitCharacteristicChangeCallback ObstCB = null;
	
	@Override
	public CompletableFuture<Boolean> getObstructionDetected() {
		return CompletableFuture.completedFuture(ObstVal);
	}
	public CompletableFuture<Void> setObstructionDetected(Boolean obst) throws Exception {
		ObstVal = obst;
		if (ObstCB != null){ObstCB.changed();}
		System.out.println(ID + "ObstVal@" + Label + " is now " + ObstVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeObstructionDetected(HomekitCharacteristicChangeCallback callback) {
		 ObstCB = callback;
	}
	@Override
	public void unsubscribeObstructionDetected() {
		 ObstCB = null;
	}
	
	// ---------------------------
	// PosState GET + SET
	// ---------------------------
	private WindowCoveringPositionState PosVal = WindowCoveringPositionState.STOPPED;
	private HomekitCharacteristicChangeCallback PosCB = null;
	
	@Override
	public CompletableFuture<WindowCoveringPositionState> getPositionState() {
		return CompletableFuture.completedFuture(PosVal);
	}
	public CompletableFuture<Void> setPositionState(WindowCoveringPositionState State) throws Exception {
		PosVal = State;
		if (PosCB != null){PosCB.changed();}
		System.out.println(ID + "PosVal@" + Label + " is now " + PosVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribePositionState(HomekitCharacteristicChangeCallback callback) {
		PosCB = callback;
	}
	@Override
	public void unsubscribePositionState() {
		PosCB = null;
	}
	
	// ---------------------------
	// Hold GET + SET
	// ---------------------------
	private Boolean HoldVal = false;
	private HomekitCharacteristicChangeCallback HoldCB = null;
	
	public CompletableFuture<Boolean> getHoldPosition() {
		return CompletableFuture.completedFuture(HoldVal);
	}
	@Override
	public CompletableFuture<Void> setHoldPosition(boolean hold) throws Exception {
		HoldVal = hold;
		if (HoldCB != null){HoldCB.changed();}
		System.out.println(ID + "HoldVal@" + Label + " is now " + HoldVal);
		return CompletableFuture.completedFuture(null);
	}

	public void subscribeHoldPosition(HomekitCharacteristicChangeCallback callback) {
		HoldCB = callback;
	}
	public void unsubscribeHoldPosition() {
		HoldCB = null;
	}
	
	
}
