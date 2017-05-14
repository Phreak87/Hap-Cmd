# Hap-Cmd
- Apple Homekit Commandline CMD (Beowolfe\Hap-Java Library + IKVM)
- Run Homekit.exe with Pinconde 123-45-678
- and configure your devices via config.xml
- control your devices via ID;Value;Value? from the Commandline (Description per id is published)
- [i]= Integer, [d] = double, [b] = bool
- runs without java installation on Windows!
- Authentification is saved in auth file.
- Feedback via commandline (as Binary-Plugin for EVAGui)

# Devices
- Define Label and Type in Config.xml as Type

<HAP>
	<Accessory>
		<Label>Switch1</Label>
		<Type>Switch</Type>
	</Accessory>
</HAP>

Switch  						
TemperatureSensor   							
MotionSensor  		 											
Outlet  			 																			
SmokeSensor   			
CarbonMonoxideSensor	
ContactSensor   		
Fan   					
HumiditySensor   		
ColorfulLightbulb   	        	
DimmableLightbulb   				        	
Lightbulb   									
LightSensor   										
GarageDoor   			
LockableLockMechanism   
LockMechanism   		
Thermostat   			
HorizontalTiltingWindowCovering    		
SecuritySystem    		
VerticalTiltingWindowCovering   
WindowCovering    		

# Build
- Import Project in Eclipse
- Add Librarys from \lib
- Press Export (Complete Jar)
- run IKVMC >8.1 and Convert to .exe -file (ikvmc ExportFilename.jar)
- run created exe file and have fun
