package com.beowulfe.hap.sample;

import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.beowulfe.hap.accessories.predefined.*;
import com.beowulfe.hap.accessories.properties.*;
import com.beowulfe.hap.HomekitAccessory;
import com.beowulfe.hap.HomekitRoot;
import com.beowulfe.hap.HomekitServer;

public class Main {
	
	private static final int PORT = 9123;
	private static Map <Integer,Object> dictionary = new HashMap <Integer,Object>();
	private static HomekitRoot bridge;

	public static void main(String[] args) {
		try {

			MockAuthInfo MockUse = GetMockInfo();
			
			HomekitServer homekit = new HomekitServer(PORT);
			bridge = homekit.createBridge(MockUse, "Test Bridge", "TestBridge, Inc.", "G6", "111abe234");
	
			ReadXMLConf();
			bridge.start();
			ReadConsole();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static MockAuthInfo GetMockInfo () {
		MockAuthInfo MockUse;
		try {
			try {
				FileInputStream fin = new FileInputStream ("Test.auth");
				ObjectInputStream oin = new ObjectInputStream (fin);
				MockUse = (MockAuthInfo) oin.readObject(); oin.close();
				return MockUse;
			} catch (Exception e1) {
				MockUse = new MockAuthInfo();
				FileOutputStream fout = new FileOutputStream("Test.auth");
				ObjectOutputStream oout = new ObjectOutputStream (fout);
				oout.writeObject(MockUse); oout.close();
				return MockUse;
			}
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void ReadConsole () throws IOException{
		
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while (!line.equals("exit")){
        	line = (String) br.readLine();if (line.equals("exit")){System.exit(0);}
        	String[] splits = line.split(";");
        	HomekitAccessory ThisAccess = (HomekitAccessory) dictionary.get(Integer.parseInt(splits[0]));
        	
        	try {
        		String ThisModel = ThisAccess.getModel();
				switch (ThisModel) {
					case "Switch" : 			
										_Switch 				ThisPowerSwitch 		= (_Switch) ThisAccess; 
										System.out.println("[B]Power");
										ThisPowerSwitch.setSwitchState(Boolean.parseBoolean(splits[1]));
										break;						
					case "TemperatureSensor":   	
										_TemperatureSensor 		ThisTempSensor 			= (_TemperatureSensor) ThisAccess;
										System.out.println("[D]Temp");
										ThisTempSensor.setCurrentTemperature(Double.parseDouble(splits[1]));
										break;
																			
					case "MotionSensor":  		 	
										_MotionSensor 			ThisMotionSensor 		= (_MotionSensor) ThisAccess;
										System.out.println("[B]Motion");
										ThisMotionSensor.setMotionDetected(Boolean.parseBoolean(splits[1]));
										break;
																			
					case "Outlet":  			 	
										_Outlet 				ThisOutlet 				= (_Outlet) ThisAccess;
										System.out.println("[B]Power;[B]Used");
										ThisOutlet.setPowerState(Boolean.parseBoolean(splits[1]));
										ThisOutlet.setOutletInUse(Boolean.parseBoolean(splits[2]));
										break;
																			
					case "SmokeSensor":   			
										_SmokeSensor 			ThisSmokeSensor 		= (_SmokeSensor) ThisAccess;
										System.out.println("[B]Detected");
										ThisSmokeSensor.setSmokeDetectedState (Boolean.parseBoolean(splits[1]) ? SmokeDetectedState.DETECTED : SmokeDetectedState.NOT_DETECTED);

										break;
					case "CarbonMonoxideSensor":	
										_CarbonMonoxideSensor 	ThisCarbonMonoxideSensor = (_CarbonMonoxideSensor) ThisAccess;
										System.out.println("[B]Detected");
										ThisCarbonMonoxideSensor.setCarbonMonoxideDetectedState(Boolean.parseBoolean(splits[1]) ? CarbonMonoxideDetectedState.ABNORMAL : CarbonMonoxideDetectedState.NORMAL);

										break;
					case "ContactSensor":   		
										_ContactSensor 			ThisContactSensor 		= (_ContactSensor) ThisAccess;
										System.out.println("[B]Detected");
										ThisContactSensor.setCurrentState(Boolean.parseBoolean(splits[1]) ? ContactState.DETECTED : ContactState.NOT_DETECTED);

										break;
					case "Fan":   					
										_Fan 					ThisFan = (_Fan) ThisAccess;
										System.out.println("[B]Power;[B]Clockwise];[I]Speed");
										ThisFan.setFanPower(Boolean.parseBoolean(splits[1]));
							        	ThisFan.setRotationDirection((Boolean.parseBoolean(splits[2]) ? RotationDirection.CLOCKWISE : RotationDirection.COUNTER_CLOCKWISE));
							        	ThisFan.setRotationSpeed(Integer.parseInt(splits[3]));

										break;
					case "HumiditySensor":   		
										_HumiditySensor 		ThisHumiditySensor 		= (_HumiditySensor) ThisAccess;
										System.out.println("[D]Humidity");
										ThisHumiditySensor.setCurrentRelativeHumidity(Double.parseDouble(splits[1]));

										break;
					case "ColorfulLightbulb":   	
										_ColorfulLightbulb 		ThisColorfulLightbulb 	= (_ColorfulLightbulb) ThisAccess;
										System.out.println("[B]Power;[D]Hue];[D]Saturation");
							        	ThisColorfulLightbulb.setLightbulbPowerState(Boolean.parseBoolean(splits[1]));
							        	ThisColorfulLightbulb.setHue(Double.parseDouble(splits[2]));
							        	ThisColorfulLightbulb.setSaturation(Double.parseDouble(splits[3]));

										break;					        	
					case "DimmableLightbulb":   	
										_DimmableLightbulb 		ThisDimmableLightbulb 	= (_DimmableLightbulb) ThisAccess;
										System.out.println("[B]Power;[I]Bright]");
							        	ThisDimmableLightbulb.setLightbulbPowerState(Boolean.parseBoolean(splits[1]));
							        	ThisDimmableLightbulb.setBrightness(Integer.parseInt(splits[2]));

										break;				        	
					case "Lightbulb":   			
										_Lightbulb 				ThisLightbulb 			= (_Lightbulb) ThisAccess;
										System.out.println("[B]Power");
										ThisLightbulb.setLightbulbPowerState(Boolean.parseBoolean(splits[1]));

										break;								
					case "LightSensor":   			
										_LightSensor 			ThisLightSensor 		= (_LightSensor) ThisAccess;
										System.out.println("[D]LightLevel");
										ThisLightSensor.setCurrentAmbientLightLevel(Double.parseDouble(splits[1]));

										break;								
					case "GarageDoor":   			
										_GarageDoor 			ThisGarageDoor 			= (_GarageDoor) ThisAccess;
										System.out.println("[B]Open");
										ThisGarageDoor.setTargetDoorState((Boolean.parseBoolean(splits[1]) ? DoorState.OPEN : DoorState.CLOSED));

										break;
					case "LockableLockMechanism":   
										_LockableLockMechanism 	ThisLockableLockMechanism = (_LockableLockMechanism) ThisAccess;
										System.out.println("[B]Current;[B]Target");
										ThisLockableLockMechanism.setCurrentMechanismState((Boolean.parseBoolean(splits[1]) ? LockMechanismState.SECURED : LockMechanismState.UNSECURED));
										ThisLockableLockMechanism.setTargetMechanismState(((Boolean.parseBoolean(splits[2]) ? LockMechanismState.SECURED : LockMechanismState.UNSECURED)));

										break;
					case "LockMechanism":   		
										_LockMechanism 			ThisLockMechanism = (_LockMechanism) ThisAccess;
										System.out.println("[B]Current");
										ThisLockMechanism.setCurrentMechanismState((Boolean.parseBoolean(splits[1]) ? LockMechanismState.SECURED : LockMechanismState.UNSECURED));

										break;
					case "Thermostat":   			
										_Thermostat ThisThermostat = (_Thermostat) ThisAccess;
										System.out.println("[I]Mode;[D]Temp;[D]CoolTH;[D]HeatTH");
										ThisThermostat.setTargetMode(ThermostatMode.AUTO);
										ThisThermostat.setTargetTemperature(Double.parseDouble(splits[1]));
										ThisThermostat.setCoolingThresholdTemperature(Double.parseDouble(splits[2]));
										ThisThermostat.setHeatingThresholdTemperature(Double.parseDouble(splits[3]));

										break;		
		            case "HorizontalTiltingWindowCovering":    		
										_HorizontalTiltingWindowCovering ThisHorizontalTiltingWindowCovering = (_HorizontalTiltingWindowCovering) ThisAccess;
										System.out.println("[B]Current");
										ThisHorizontalTiltingWindowCovering.setTargetPosition(1);

										break;
		            case "SecuritySystem":    		
        								_SecuritySystem ThisSecuritySystem = (_SecuritySystem) ThisAccess;
										System.out.println("[B]Current");
										ThisSecuritySystem.setTargetSecuritySystemState(CurrentSecuritySystemState.DISARMED);

										break;
		            case "VerticalTiltingWindowCovering":   
        								_VerticalTiltingWindowCovering 	ThisVerticalTiltingWindowCovering = (_VerticalTiltingWindowCovering) ThisAccess;
										System.out.println("[B]Current");
										ThisVerticalTiltingWindowCovering.setCurrentPosition(1);

										break;
		            case "WindowCovering":    		
        								_WindowCovering ThisWindowCovering = (_WindowCovering) ThisAccess;
										System.out.println("[B]Current");
										ThisWindowCovering.setCurrentPosition(1);

										break;
				}
			} catch (Exception e) {
				System.out.println("Wrong parameters for " + ThisAccess.getModel() + "/n" + e.getMessage());
			}
        }
        isr.close();
	}
	
	public static void ReadXMLConf () throws ParserConfigurationException, SAXException, IOException {

	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(new File("Config.xml"));
	    doc.normalize();
	    
	    Node HAP = doc.getFirstChild();
	    NodeList AccessoryList = HAP.getChildNodes();

        int counter = 2;
	    for (int temp = 0; temp < AccessoryList.getLength(); temp++) {
	        Node Accessory = AccessoryList.item(temp);
	        
	        if (Accessory.getNodeType() != Node.ELEMENT_NODE) {continue;} 
	        Element AccessoryNode = (Element) Accessory; 
	        	
	        	int ID = counter; counter ++;
	        	String Label = AccessoryNode.getElementsByTagName("Label").item(0).getTextContent();
	        	String Type = AccessoryNode.getElementsByTagName("Type").item(0).getTextContent();

	            switch (Type){
		            case "Switch": 
		            	System.out.println(ID + ": Configure Switch " + Label); 
		            	_Switch HAS_SWITCH = new com.beowulfe.hap.accessories.predefined._Switch(ID, Label, false);
		            	bridge.addAccessory(HAS_SWITCH);dictionary.put(ID, HAS_SWITCH);break;
		            case "TemperatureSensor": 
		            	System.out.println(ID + ": Configure TempSensor " + Label);
		            	_TemperatureSensor HAS_THERMAL = new com.beowulfe.hap.accessories.predefined._TemperatureSensor(ID, Label, 0.0);
		            	bridge.addAccessory(HAS_THERMAL);dictionary.put(ID, HAS_THERMAL);break;
		            case "MotionSensor":
		            	System.out.println(ID + ": Configure MotionSensor " + Label);
		            	_MotionSensor HAS_MOTION = new com.beowulfe.hap.accessories.predefined._MotionSensor(ID, Label, false);
		            	bridge.addAccessory(HAS_MOTION);dictionary.put(ID, HAS_MOTION);break;
		            case "Outlet": 
		            	System.out.println(ID + ": Configure Outlet " + Label); 
		            	_Outlet HAS_OUTLET = new com.beowulfe.hap.accessories.predefined._Outlet(ID, Label, false, false);
		            	bridge.addAccessory(HAS_OUTLET);dictionary.put(ID, HAS_OUTLET);break;
		            case "SmokeSensor": 
		            	System.out.println(ID + ": Configure SmokeSensor " + Label); 
		            	_SmokeSensor HAS_SMOKE = new com.beowulfe.hap.accessories.predefined._SmokeSensor(ID, Label, SmokeDetectedState.NOT_DETECTED);
		            	bridge.addAccessory(HAS_SMOKE);dictionary.put(ID, HAS_SMOKE);break;
		            case "CarbonMonoxideSensor": 
		            	System.out.println(ID + ": Configure CarbonMonoxideSensor " + Label); 
		            	_CarbonMonoxideSensor HAS_MONO = new com.beowulfe.hap.accessories.predefined._CarbonMonoxideSensor(ID, Label, CarbonMonoxideDetectedState.NORMAL);
		            	bridge.addAccessory(HAS_MONO);dictionary.put(ID, HAS_MONO);break;
		            case "ContactSensor": 
		            	System.out.println(ID + ": Configure ContactSensor " + Label); 
		            	_ContactSensor HAS_CONT = new com.beowulfe.hap.accessories.predefined._ContactSensor(ID, Label, ContactState.NOT_DETECTED);
		            	bridge.addAccessory(HAS_CONT);dictionary.put(ID, HAS_CONT);break;
		            case "Fan": 
		            	System.out.println(ID + ": Configure Fan " + Label); 
		            	_Fan HAS_FAN = new com.beowulfe.hap.accessories.predefined._Fan(ID, Label, false,RotationDirection.CLOCKWISE,0);
		            	bridge.addAccessory(HAS_FAN);dictionary.put(ID, HAS_FAN);break;
		            case "HumiditySensor": 
		            	System.out.println(ID + ": Configure HumiditySensor " + Label); 
		            	_HumiditySensor HAS_HUM = new com.beowulfe.hap.accessories.predefined._HumiditySensor(ID, Label,0.0);
		            	bridge.addAccessory(HAS_HUM);dictionary.put(ID, HAS_HUM);break;
		            case "ColorfulLightbulb": 
		            	System.out.println(ID + ": Configure ColorfulLightbulb " + Label); 
		            	_ColorfulLightbulb HAS_COL = new com.beowulfe.hap.accessories.predefined._ColorfulLightbulb(ID, Label,false, 0.0, 0.0);
		            	bridge.addAccessory(HAS_COL);dictionary.put(ID, HAS_COL);break;
		            case "DimmableLightbulb": 
		            	System.out.println(ID + ": Configure DimmableLightbulb " + Label); 
		            	_DimmableLightbulb HAS_DIM = new com.beowulfe.hap.accessories.predefined._DimmableLightbulb(ID, Label,false, 0);
		            	bridge.addAccessory(HAS_DIM);dictionary.put(ID, HAS_DIM);break;
		            case "Lightbulb": 
		            	System.out.println(ID + ": Configure Lightbulb " + Label); 
		            	_Lightbulb HAS_LIG = new com.beowulfe.hap.accessories.predefined._Lightbulb(ID, Label,false);
		            	bridge.addAccessory(HAS_LIG);dictionary.put(ID, HAS_LIG);break;
		            case "LightSensor": 
		            	System.out.println(ID + ": Configure LightSensor " + Label); 
		            	_LightSensor HAS_BRISEN = new com.beowulfe.hap.accessories.predefined._LightSensor(ID, Label,0.0);
		            	bridge.addAccessory(HAS_BRISEN);dictionary.put(ID, HAS_BRISEN);break;
		            case "GarageDoor": 
		            	System.out.println(ID + ": Configure GarageDoor " + Label); 
		            	_GarageDoor HAS_DOOR = new com.beowulfe.hap.accessories.predefined._GarageDoor(ID, Label,DoorState.CLOSED,DoorState.CLOSED,false);
		            	bridge.addAccessory(HAS_DOOR);dictionary.put(ID, HAS_DOOR);break;
		            case "LockableLockMechanism": 
		            	System.out.println(ID + ": Configure LockableLockMechanism " + Label); 
		            	_LockableLockMechanism HAS_LOCK = new com.beowulfe.hap.accessories.predefined._LockableLockMechanism(ID, Label, LockMechanismState.SECURED, LockMechanismState.SECURED);
		            	bridge.addAccessory(HAS_LOCK);dictionary.put(ID, HAS_LOCK);break;
		            case "LockMechanism": 
		            	System.out.println(ID + ": Configure LockMechanism " + Label); 
		            	_LockMechanism HAS_LOCK2 = new com.beowulfe.hap.accessories.predefined._LockMechanism(ID, Label, LockMechanismState.SECURED);
		            	bridge.addAccessory(HAS_LOCK2);dictionary.put(ID, HAS_LOCK2);break;
		            case "Thermostat": 
		            	System.out.println(ID + ": Configure Thermostat " + Label); 
		            	_Thermostat HAS_THERM = new com.beowulfe.hap.accessories.predefined._Thermostat(ID, Label, ThermostatMode.AUTO,0.0,0.0,0.0,0.0);
		            	bridge.addAccessory(HAS_THERM);dictionary.put(ID, HAS_THERM);break;
		            case "HorizontalTiltingWindowCovering": 
		            	System.out.println(ID + ": Configure HorizontalTiltingWindowCovering " + Label); 
		            	_HorizontalTiltingWindowCovering HAS_HORTILTWIN = new com.beowulfe.hap.accessories.predefined._HorizontalTiltingWindowCovering(ID, Label);
		            	bridge.addAccessory(HAS_HORTILTWIN);dictionary.put(ID,HAS_HORTILTWIN);break;
		            case "SecuritySystem": 
		            	System.out.println(ID + ": Configure HorizontalTiltingWindowCovering " + Label); 
		            	_SecuritySystem HAS_SECSYS = new com.beowulfe.hap.accessories.predefined._SecuritySystem(ID, Label,CurrentSecuritySystemState.DISARMED,TargetSecuritySystemState.DISARMED,SecuritySystemAlarmType.CLEARED);
		            	bridge.addAccessory(HAS_SECSYS);dictionary.put(ID,HAS_SECSYS);break;
		            case "VerticalTiltingWindowCovering": 
		            	System.out.println(ID + ": Configure HorizontalTiltingWindowCovering " + Label); 
		            	_VerticalTiltingWindowCovering HAS_VERTILTWIN = new com.beowulfe.hap.accessories.predefined._VerticalTiltingWindowCovering(ID, Label);
		            	bridge.addAccessory(HAS_VERTILTWIN);dictionary.put(ID,HAS_VERTILTWIN);break;
		            case "WindowCovering": 
		            	System.out.println(ID + ": Configure HorizontalTiltingWindowCovering " + Label); 
		            	_WindowCovering HAS_WINCOV = new com.beowulfe.hap.accessories.predefined._WindowCovering(ID, Label);
		            	bridge.addAccessory(HAS_WINCOV);dictionary.put(ID,HAS_WINCOV);break;

	            }
	        }
	}
}