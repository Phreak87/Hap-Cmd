package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.VerticalTiltingWindowCovering;
import com.beowulfe.hap.accessories.properties.WindowCoveringPositionState;

public class _VerticalTiltingWindowCovering implements VerticalTiltingWindowCovering {
	public _VerticalTiltingWindowCovering(Integer iD, String label) {
		super();
		ID = iD;
		Label = label;
	}
	public _VerticalTiltingWindowCovering(Integer iD, String label, Integer curPosVal, Integer tarPosVal,
			WindowCoveringPositionState posStateVal, Boolean obstVal, Boolean holdVal, Integer curVertVal,
			Integer tarVertVal) {
		super();
		ID = iD;
		Label = label;
		CurPosVal = curPosVal;
		TarPosVal = tarPosVal;
		PosStateVal = posStateVal;
		ObstVal = obstVal;
		HoldVal = holdVal;
		CurVertVal = curVertVal;
		TarVertVal = tarVertVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "VerticalTiltingWindowCovering";
	
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
		return "VerticalTiltingWindowCovering";
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
		System.out.println(ID + "TarPos@" + Label + " is now " + TarPosVal);
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
	// PosState GET + SET
	// ---------------------------

	private WindowCoveringPositionState PosStateVal = WindowCoveringPositionState.STOPPED;
	private HomekitCharacteristicChangeCallback PosStateCB = null;
	
	@Override
	public CompletableFuture<WindowCoveringPositionState> getPositionState() {
		return CompletableFuture.completedFuture(PosStateVal);
	}
	public CompletableFuture<Void> setPositionState(WindowCoveringPositionState position) throws Exception {
		PosStateVal = position;
		if (PosStateCB != null){PosStateCB.changed();}
		System.out.println(ID + "PosStateVal@" + Label + " is now " + PosStateVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribePositionState(HomekitCharacteristicChangeCallback callback) {
		PosStateCB = callback;
	}
	@Override
	public void unsubscribePositionState() {
		PosStateCB = null;
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
	public CompletableFuture<Void> setObstructionDetected(Boolean Obst) throws Exception {
		ObstVal = Obst;
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

	// ---------------------------
	// CurrVertAngle GET + SET
	// ---------------------------
	private Integer CurVertVal = 0;
	private HomekitCharacteristicChangeCallback CurVertCB = null;
	
	@Override
	public CompletableFuture<Integer> getCurrentVerticalTiltAngle() {
		return CompletableFuture.completedFuture(CurVertVal);
	}
	public CompletableFuture<Void> setCurrentVerticalTiltAngle(int angle) throws Exception {
		CurVertVal = angle;
		if (CurVertCB != null){CurVertCB.changed();}
		System.out.println(ID + "CurVertVal@" + Label + " is now " + CurVertVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeCurrentVerticalTiltAngle(HomekitCharacteristicChangeCallback callback) {
		CurVertCB = callback;
	}
	@Override
	public void unsubscribeCurrentVerticalTiltAngle() {
		CurVertCB = null;
	}
	
	// ---------------------------
	// TargVertAngle GET + SET
	// ---------------------------
	private Integer TarVertVal = 0;
	private HomekitCharacteristicChangeCallback TarVertCB = null;
	
	@Override
	public CompletableFuture<Integer> getTargetVerticalTiltAngle() {
		return CompletableFuture.completedFuture(TarVertVal);
	}
	@Override
	public CompletableFuture<Void> setTargetVerticalTiltAngle(int angle) throws Exception {
		TarVertVal = angle;
		if (TarVertCB != null){TarVertCB.changed();}
		System.out.println(ID + "TarPos@" + Label + " is now " + TarVertVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeTargetVerticalTiltAngle(HomekitCharacteristicChangeCallback callback) {
		TarVertCB = callback;
	}
	@Override
	public void unsubscribeTargetVerticalTiltAngle() {
		TarVertCB = null;
	}

}
