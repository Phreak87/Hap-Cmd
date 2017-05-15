package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.BatteryAccessory;

public class _BatteryAccessory implements BatteryAccessory {
	
	private Integer PowVal = 100;
	private HomekitCharacteristicChangeCallback PowCB = null;
	
	@Override
	public CompletableFuture<Integer> getBatteryLevelState() {
		return CompletableFuture.completedFuture(PowVal);
	}
	public void setBatteryLevelState(Integer state) {
		PowVal = state;
		if (PowCB != null) {PowCB.changed();}
		System.out.println("The Battery is now "+ PowVal);
	}
	
	@Override
	public void subscribeBatteryLevelState(HomekitCharacteristicChangeCallback callback) {
		this.PowCB = callback;
	}
	@Override
	public void unsubscribeBatteryLevelState() {
		this.PowCB = null;
	}

}