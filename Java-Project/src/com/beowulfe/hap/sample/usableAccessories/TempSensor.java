package com.beowulfe.hap.sample.usableAccessories;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.TemperatureSensor;;

public class TempSensor  implements TemperatureSensor{

	public TempSensor(int id, String label, double InitState) {
		super();
		Label = label;
		State = InitState;
		ID = id;
	}

	private HomekitCharacteristicChangeCallback subscribeCallback = null;
	private Double State;
	private String Label;
	private int ID = 1;

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
		System.out.println(Label + " identify event called");
	}

	@Override
	public String getSerialNumber() {
		return "ABC1234";
	}

	@Override
	public String getModel() {
		return "TempSensor";
	}

	@Override
	public String getManufacturer() {
		return "NerdCoreWG";
	}

	@Override
	public CompletableFuture<Double> getCurrentTemperature() {
		return CompletableFuture.completedFuture(State);
	}

	public CompletableFuture<Void> setTemperature(double state) throws Exception {
		this.State = state;
		if (subscribeCallback != null) {subscribeCallback.changed();}
		return CompletableFuture.completedFuture(null);
	}
	
	@Override
	public void subscribeCurrentTemperature(HomekitCharacteristicChangeCallback callback) {
		this.subscribeCallback = callback;
	}

	@Override
	public void unsubscribeCurrentTemperature() {
		this.subscribeCallback = null;
	}

	@Override
	public double getMinimumTemperature() {
		return 0;
	}

	@Override
	public double getMaximumTemperature() {
		return 100;
	}

}
