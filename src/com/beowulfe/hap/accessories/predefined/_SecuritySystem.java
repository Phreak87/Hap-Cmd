package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.SecuritySystem;
import com.beowulfe.hap.accessories.properties.CurrentSecuritySystemState;
import com.beowulfe.hap.accessories.properties.SecuritySystemAlarmType;
import com.beowulfe.hap.accessories.properties.TargetSecuritySystemState;

public class _SecuritySystem implements SecuritySystem {
	public _SecuritySystem(Integer iD, String label, CurrentSecuritySystemState curVal,
			TargetSecuritySystemState tarVal, SecuritySystemAlarmType alarmVal) {
		super();
		ID = iD;
		Label = label;
		CurVal = curVal;
		TarVal = tarVal;
		AlarmVal = alarmVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "SecuritySystem";
	
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
		return "SecuritySystem";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// CurState GET + SET
	// ---------------------------
		
	private CurrentSecuritySystemState CurVal = CurrentSecuritySystemState.DISARMED;
	private HomekitCharacteristicChangeCallback CurCB = null;
	
	@Override
	public CompletableFuture<CurrentSecuritySystemState> getCurrentSecuritySystemState() {
		return CompletableFuture.completedFuture(CurVal);
	}
	public void setTargetSecuritySystemState(CurrentSecuritySystemState state) throws Exception {
		CurVal = state;
		if (CurCB != null) {CurCB.changed();}
		System.out.println(ID + "_Cur@" + Label + " is now " + CurVal);
	}
	
	@Override
	public void subscribeCurrentSecuritySystemState(HomekitCharacteristicChangeCallback callback) {
		CurCB = callback;
	}
	@Override
	public void unsubscribeCurrentSecuritySystemState() {
		CurCB = null;
	}

	// ---------------------------
	// TarState GET + SET
	// ---------------------------
	private TargetSecuritySystemState TarVal = TargetSecuritySystemState.DISARMED;
	private HomekitCharacteristicChangeCallback TarCB = null;
	
	@Override
	public CompletableFuture<TargetSecuritySystemState> getTargetSecuritySystemState() {
		return CompletableFuture.completedFuture(TarVal);
	}
	@Override
	public void setTargetSecuritySystemState(TargetSecuritySystemState state) throws Exception {
		TarVal = state;
		if (TarCB != null) {TarCB.changed();}
		System.out.println(ID + "_Tar@" + Label + " is now " + TarVal);
	}
	
	@Override
	public void subscribeTargetSecuritySystemState(HomekitCharacteristicChangeCallback callback) {
		TarCB = callback;
	}
	@Override
	public void unsubscribeTargetSecuritySystemState() {
		TarCB = null;
	}

	// ---------------------------
	// AlarmState GET + SET
	// ---------------------------
	private SecuritySystemAlarmType AlarmVal = SecuritySystemAlarmType.CLEARED;
	private HomekitCharacteristicChangeCallback AlarmCB = null;
	
	@Override
	public CompletableFuture<SecuritySystemAlarmType> getAlarmTypeState() {
		return CompletableFuture.completedFuture(AlarmVal);
	}
	public void setTargetSecuritySystemState(SecuritySystemAlarmType state) throws Exception {
		AlarmVal = state;
		if (AlarmCB != null) {AlarmCB.changed();}
		System.out.println(ID + "_Alarm@" + Label + " is now " + CurVal);
	}
	
	@Override
	public void subscribeAlarmTypeState(HomekitCharacteristicChangeCallback callback) {
		AlarmCB = callback;
	}
	@Override
	public void unsubscribeAlarmTypeState() {
		AlarmCB = null;
	}

}
