package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.HorizontalTiltingWindowCovering;
import com.beowulfe.hap.accessories.properties.WindowCoveringPositionState;

public class _HorizontalTiltingWindowCovering implements HorizontalTiltingWindowCovering {
	public _HorizontalTiltingWindowCovering(Integer iD, String label) {
		super();
		ID = iD;
		Label = label;
	}
	public _HorizontalTiltingWindowCovering(Integer iD, String label, Integer curVal, Integer tarVal,
			WindowCoveringPositionState posVal, Boolean obstVal, boolean holdVal, Integer curHoreVal,
			Integer tarHoreVal) {
		super();
		ID = iD;
		Label = label;
		CurVal = curVal;
		TarVal = tarVal;
		PosVal = posVal;
		ObstVal = obstVal;
		HoldVal = holdVal;
		CurHoreVal = curHoreVal;
		TarHoreVal = tarHoreVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "HorizontalTiltingWindowCovering";

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
		return "HorizontalTiltingWindowCovering";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// Current Position GET + SET
	// ---------------------------	
	private Integer CurVal = 0;
	private HomekitCharacteristicChangeCallback CurCB = null;
	
	@Override
	public CompletableFuture<Integer> getCurrentPosition() {
		return CompletableFuture.completedFuture(CurVal);
	}
	public CompletableFuture<Void> setCurrentPosition(int position) throws Exception {
		CurVal = position;
		if (CurCB != null) {CurCB.changed();}
		System.out.println(ID + "_CurPos@" + Label + " is now " + CurVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeCurrentPosition(HomekitCharacteristicChangeCallback callback) {
		CurCB = callback;
	}
	@Override
	public void unsubscribeCurrentPosition() {
		CurCB = null;
	}
	
	// ---------------------------
	// Target Position GET + SET
	// ---------------------------
	private Integer TarVal = 0;
	private HomekitCharacteristicChangeCallback TarCB = null;
	
	@Override
	public CompletableFuture<Integer> getTargetPosition() {
		return CompletableFuture.completedFuture(TarVal);
	}
	@Override
	public CompletableFuture<Void> setTargetPosition(int position) throws Exception {
		TarVal = position;
		if (TarCB != null) {TarCB.changed();}
		System.out.println(ID + "_TarPos@" + Label + " is now " + TarVal);
		return CompletableFuture.completedFuture(null);
	}
	
	@Override	
	public void subscribeTargetPosition(HomekitCharacteristicChangeCallback callback) {
		TarCB = callback;
	}
	@Override
	public void unsubscribeTargetPosition() {
		TarCB = null;
	}
	
	// ---------------------------
	// Positon State GET + SET
	// ---------------------------
	private WindowCoveringPositionState PosVal = WindowCoveringPositionState.DECREASING;
	private HomekitCharacteristicChangeCallback PosCB = null;
	
	@Override
	public CompletableFuture<WindowCoveringPositionState> getPositionState() {
		return CompletableFuture.completedFuture(PosVal);
	}
	public CompletableFuture<Void> setPositionState(WindowCoveringPositionState position) throws Exception {
		PosVal = position;
		if (PosCB != null) {PosCB.changed();}
		System.out.println(ID + "_PosSta@" + Label + " is now " + PosVal);
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
	// Obstruction GET + SET
	// ---------------------------
	private Boolean ObstVal = false;
	private HomekitCharacteristicChangeCallback ObstCB = null;
	
	@Override
	public CompletableFuture<Boolean> getObstructionDetected() {
		return CompletableFuture.completedFuture(ObstVal);
	}
	public CompletableFuture<Void> setObstructionDetected(Boolean state) throws Exception {
		ObstVal = state;
		if (ObstCB != null) {ObstCB.changed();}
		System.out.println(ID + "_Obst@" + Label + " is now " + ObstVal);
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
	// HoldPosition GET + SET
	// ---------------------------
	private boolean HoldVal = false;
	private HomekitCharacteristicChangeCallback HoldCB = null;
	
	@Override
	public CompletableFuture<Void> setHoldPosition(boolean hold) throws Exception {
		HoldVal = hold;
		if (HoldCB != null) {HoldCB.changed();}
		System.out.println(ID + "_Hold@" + Label + " is now " + HoldVal);
		return CompletableFuture.completedFuture(null);
	}
	
	// ---------------------------
	// Current Horizontal Tilt GET + SET
	// ---------------------------
	private Integer CurHoreVal = 0;
	private HomekitCharacteristicChangeCallback CurHoreCB = null;
	
		@Override
	public CompletableFuture<Integer> getCurrentHorizontalTiltAngle() {
		return CompletableFuture.completedFuture(CurHoreVal);
	}
	public CompletableFuture<Void> setCurrentHorizontalTiltAngle(int angle) throws Exception {
		CurHoreVal = angle;
		if (CurHoreCB != null) {CurHoreCB.changed();}
		System.out.println(ID + "_CurHor@" + Label + " is now " + CurHoreVal);
		return CompletableFuture.completedFuture(null);
		}
		
	@Override
	public void subscribeCurrentHorizontalTiltAngle(HomekitCharacteristicChangeCallback callback) {
		CurHoreCB = callback;
	}
	@Override
	public void unsubscribeCurrentHorizontalTiltAngle() {
		CurHoreCB = null;
	}

	
	// ---------------------------
	// Target Horizontal Tilt GET + SET
	// ---------------------------
	private Integer TarHoreVal = 0;
	private HomekitCharacteristicChangeCallback TarHoreCB = null;
	
	@Override
	public CompletableFuture<Integer> getTargetHorizontalTiltAngle() {
		return CompletableFuture.completedFuture(TarHoreVal);
	}
	@Override
	public CompletableFuture<Void> setTargetHorizontalTiltAngle(int angle) throws Exception {
		TarHoreVal = angle;
		if (TarHoreCB != null) {TarHoreCB.changed();}
		System.out.println(ID + "_TarHor@" + Label + " is now " + TarHoreVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeTargetHorizontalTiltAngle(HomekitCharacteristicChangeCallback callback) {
		TarHoreCB = callback;
	}
	@Override
	public void unsubscribeTargetHorizontalTiltAngle() {
		TarHoreCB = null;
	}

}
