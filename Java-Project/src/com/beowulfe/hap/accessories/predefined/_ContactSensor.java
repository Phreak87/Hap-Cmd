package com.beowulfe.hap.accessories.predefined;

import java.util.concurrent.CompletableFuture;
import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.ContactSensor;
import com.beowulfe.hap.accessories.properties.ContactState;

public class _ContactSensor implements ContactSensor {
	public _ContactSensor(Integer iD, String label, ContactState state) {
		super();
		ID = iD;
		Label = label;
		StaVal = state;
	}

	// ---------------------------
	// HomeKitAccessory GET + SET
	// ---------------------------
	private Integer ID = 0; 
	private String Label = "ContactSensor";
	
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
		return "ContactSensor";
	}
	@Override
	public String getManufacturer() {
		return "JamesV3";
	}
	
	// ---------------------------
	// State GET + SET
	// ---------------------------
	private ContactState StaVal = ContactState.NOT_DETECTED;
	private HomekitCharacteristicChangeCallback StaCB = null;
	
	@Override
	public CompletableFuture<ContactState> getCurrentState() {
		return CompletableFuture.completedFuture(StaVal);
	}
	public CompletableFuture<Void> setCurrentState(ContactState value) {
		StaVal = value;
		if (StaCB != null) {StaCB.changed();}
		System.out.println(ID + "_Sat@" + Label + " is now " + StaVal);
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public void subscribeContactState(HomekitCharacteristicChangeCallback callback) {
		StaCB = callback;
	}
	@Override
	public void unsubscribeContactState() {
		StaCB = null;
	}

}
