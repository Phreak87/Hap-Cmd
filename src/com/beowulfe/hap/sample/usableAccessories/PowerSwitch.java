package com.beowulfe.hap.sample.usableAccessories;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Switch;

public class PowerSwitch implements Switch {

	public PowerSwitch(int iD, String label, Boolean state) {
		super();
		ID = iD;
		Label = label;
		State = state;
	}


	private int ID;
	private String Label;
	private Boolean State;
	
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
		return "SN1234ABC";
	}

	@Override
	public String getModel() {
		return "PowerSwitch";
	}

	@Override
	public String getManufacturer() {
		return "NerdCoreWG";
	}

	@Override
	public CompletableFuture<Boolean> getSwitchState() {
		return CompletableFuture.completedFuture(State);
	}

	@Override
	public CompletableFuture<Void> setSwitchState(boolean state) throws Exception {
		this.State = state;
		System.out.println(ID + Label + " is now " + State);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeSwitchState(HomekitCharacteristicChangeCallback callback) {

	}

	@Override
	public void unsubscribeSwitchState() {

	}
	

}
