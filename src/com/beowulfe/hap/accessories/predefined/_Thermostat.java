package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Thermostat;
import com.beowulfe.hap.accessories.properties.ThermostatMode;

@SuppressWarnings("deprecation")
public class _Thermostat implements Thermostat{
	public _Thermostat(Integer iD, String label, ThermostatMode curModVal, Double tmpTarVal, Double tmpCurVal,
			Double heatVal, Double coolVal) {
		super();
		ID = iD;
		Label = label;
		CurModVal = curModVal;
		TmpTarVal = tmpTarVal;
		TmpCurVal = tmpCurVal;
		HeatVal = heatVal;
		CoolVal = coolVal;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "Thermostat";
	
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
		return "Thermostat";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}

	// ---------------------------
	// CurrentMode GET + SET
	// ---------------------------
	
	private ThermostatMode CurModVal = ThermostatMode.AUTO;
	private HomekitCharacteristicChangeCallback CurModCB = null;
	
	@Override
	public CompletableFuture<ThermostatMode> getCurrentMode() {
		return CompletableFuture.completedFuture(CurModVal);
	}
	public void setCurrentMode(ThermostatMode mode) throws Exception {
		CurModVal = mode;
		if (CurModCB != null) {CurModCB.changed();}
		System.out.println(ID + "_CurMod@" + Label + " is now " + CurModVal);
	}

	@Override
	public void subscribeCurrentMode(HomekitCharacteristicChangeCallback callback) {
		CurModCB = callback;
	}
	@Override
	public void unsubscribeCurrentMode() {
		CurModCB = null;
	}

	// ---------------------------
	// TargetMode GET + SET
	// ---------------------------
	
	private ThermostatMode TarModVal = ThermostatMode.AUTO;
	private HomekitCharacteristicChangeCallback TarModCB = null;
	
	@Override
	public CompletableFuture<ThermostatMode> getTargetMode() {
		return CompletableFuture.completedFuture(TarModVal);
	}
	@Override
	public void setTargetMode(ThermostatMode mode) throws Exception {
		TarModVal = mode;
		if (TarModCB != null) {TarModCB.changed();}
		System.out.println(ID + "TarMod@" + Label + " is now " + TarModVal);
	}

	@Override
	public void subscribeTargetMode(HomekitCharacteristicChangeCallback callback) {
		TarModCB = callback;
	}
	@Override
	public void unsubscribeTargetMode() {
		TarModCB = null;
	}

	// ---------------------------
	// TargetTemp GET + SET
	// ---------------------------
	private Double TmpTarVal = 0.0;
	private HomekitCharacteristicChangeCallback TmpTarCB = null;
	
	@Override
	public CompletableFuture<Double> getTargetTemperature() {
		return CompletableFuture.completedFuture(TmpTarVal);
	}
	@Override
	public void setTargetTemperature(Double value) throws Exception {
		TmpTarVal = value;
		if (TmpTarCB != null) {TmpTarCB.changed();}
		System.out.println(ID + "TmpTar@" + Label + " is now " + TmpTarVal);
	}
	
	@Override
	public void subscribeTargetTemperature(HomekitCharacteristicChangeCallback callback) {
		TmpTarCB = callback;
	}
	@Override
	public void unsubscribeTargetTemperature() {
		TmpTarCB = null;
	}
	
	// ---------------------------
	// CurrentTemp GET + SET
	// ---------------------------
	private Double TmpCurVal = 0.0;
	private HomekitCharacteristicChangeCallback TmpCurCB = null;
	
	@Override
	public CompletableFuture<Double> getCurrentTemperature() {
		return CompletableFuture.completedFuture(TmpCurVal);
	}
	public void setCurrentTemperature(Double value) throws Exception {
		TmpCurVal = value;
		if (TmpCurCB != null) {TmpCurCB.changed();}
		System.out.println(ID + "_TmpCur@" + Label + " is now " + TmpCurVal);
	}
	
	@Override
	public void subscribeCurrentTemperature(HomekitCharacteristicChangeCallback callback) {
		TmpCurCB = callback;
	}
	@Override
	public void unsubscribeCurrentTemperature() {
		TmpCurCB = null;
	}

	// ---------------------------
	// Min/Max Temp GET 
	// ---------------------------

	@Override
	public double getMinimumTemperature() {
		return 0;
	}
	@Override
	public double getMaximumTemperature() {
		return 100;
	}

	// ---------------------------
	// HeatTH Temp GET + SET
	// ---------------------------
	private Double HeatVal = 0.0;
	private HomekitCharacteristicChangeCallback HeatCB = null;
	
	@Override
	public CompletableFuture<Double> getHeatingThresholdTemperature() {
		return CompletableFuture.completedFuture(HeatVal);
	}
	@Override
	public void setHeatingThresholdTemperature(Double value) throws Exception {
		HeatVal = value;
		if (HeatCB != null) {HeatCB.changed();}
		System.out.println(ID + "Heat@" + Label + " is now " + HeatVal);
	}
	
	@Override
	public void subscribeHeatingThresholdTemperature(HomekitCharacteristicChangeCallback callback) {
		HeatCB = callback;
	}
	@Override
	public void unsubscribeHeatingThresholdTemperature() {
		HeatCB = null;
	}

	// ---------------------------
	// CoolTH Temp GET + SET
	// ---------------------------
	private Double CoolVal = 0.0;
	private HomekitCharacteristicChangeCallback CoolCB = null;
	
	@Override
	public CompletableFuture<Double> getCoolingThresholdTemperature() {
		return CompletableFuture.completedFuture(CoolVal);
	}
	@Override
	public void setCoolingThresholdTemperature(Double value) throws Exception {
		CoolVal = value;
		if (CoolCB != null) {CoolCB.changed();}
		System.out.println(ID + "_Cool@" + Label + " is now " + CoolVal);
	}
	
	@Override
	public void subscribeCoolingThresholdTemperature(HomekitCharacteristicChangeCallback callback) {
		CoolCB = callback;
	}
	@Override
	public void unsubscribeCoolingThresholdTemperature() {
		CoolCB = null;
	}

}
