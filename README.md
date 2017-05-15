## Hap-Cmd

- Apple Homekit for Windows Commandline (CMD)
- runs without java installation on Windows!
- Feedback via commandline (for CMD/Shell-Applications or EVAGui2)
- Control over Commandline parameters.
- based on Beowolfe\Hap-Java Library and IKVM

## How to start

- Run Windows-Project\com.beowulfe.hap.exe
- Allow this application on Windows-firewall.
- on your IPhone open Apple-Home, select Test-Bridge and par with pin 123-45-678
- now you should see switches, a motionsensor and a temperature sensor.
- for more applicable devices open config.xml and enter label and a type for other devices (types in device list).
- on the CMD-Window input ID;Value[;Value]? to set the device-state e.g 2;true to set a value.
- the ID from the Device is the n-th entry in XML-Config starting at ID 2.
- after input a ID the description to set a value is shown in the following structure:
> [I]= Integer (non-decimal values), [D] = double(decimal values) , [B] = bool (true or false)

### Examples: 

> 2;true .. if ID 2 is a switch, this switch has now the state "on"
> 3;20 .. if ID 3 is a temperature sensor the actual temperature is now set to 20°C
> 2;20 .. if ID 2 is a switch the parameter does not match and you see a Message like [ID];[B]State

## Devices
### The following device types are implemented and ready to use in config.xml as type-node:

- Switch  						
- TemperatureSensor   							
- MotionSensor 			
- Outlet  											
- SmokeSensor   			
- CarbonMonoxideSensor	
- ContactSensor   		
- Fan   					
- HumiditySensor   		
- ColorfulLightbulb   	        	
- DimmableLightbulb   				        	
- Lightbulb   									
- LightSensor   										
- GarageDoor   			
- LockableLockMechanism   
- LockMechanism   		
- Thermostat   			
- HorizontalTiltingWindowCovering    		
- SecuritySystem    		
- VerticalTiltingWindowCovering   
- WindowCovering    		

## Build

- Install Java > V 1.8 and Eclipse for Java development and start Eclipse.
- Goto File - Open Projects from Filesystem and select the Folder "Java-Project"
- Switch to Properties -> Java Build Path and select "add external JARs"
- Add all librarys from Java-Librarys.
- right click on Project and select "export" - Switch to Java\Runnable JAR File 
- export to the Windows-Project folder
- decompress ikvm.zip from Windows-Project to Windows-Project
- run CMD - "ikvmc GeneratedJARFile.jar" and press Enter.
- run created exe file and have fun.

## Experiments

- IKVM Converts to C# dll/exe (show contents with ILSPY)
- VS.Net can import the generated exe/or dll-File (add ikvm libs!)

### Tests

- VS.Net Application with each java library as single dll -> doesn´t work
- VS.Net Application with one dll (including all Librarys) -> works to start Bridge
- + Adding Devices via VS.net doesn´t work -> Netty crashes on GlobalEventExecutor ?? 
- + Please Help (VS.Net example Sourcecode: VSNet_Tests.txt) 
