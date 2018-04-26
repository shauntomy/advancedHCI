//import the classes we will use
import grovepi.GrovePi;
import grovepi.Pin;
import grovepi.PinMode;
import grovepi.sensors.*;

//our main method
class Blink {
	public static void main(String[] args) {
		GrovePi grovePi = new GrovePi(); //declare an instance of the grovepi class
		grovePi.pinMode(Pin.ANALOG_PIN_0, PinMode.INPUT);
		ButtonSensor button = grovePi.getDeviceFactory().createButtonSensor(Pin.DIGITAL_PIN_4);
		//LightSensor lightSensor = grovePi.getDeviceFactory().createLightSensor(Pin.DIGITAL_PIN_2);
		Led led1 = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_5); //Online (show green)
		Led led2 = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_8); //Online (show flashing green)
		Led led3 = grovePi.getDeviceFactory().createLed(Pin.DIGITAL_PIN_7); //Do not disturb(show red)
		boolean state = false; //declare a boolean variable to hold the state of the LED
		System.out.println("HolaGram turned on...");
		System.out.println("Hello Mike");
		int counter = 0;
		int last = 0;
		while (true) { //create a continuous loop
			int sound = grovePi.analogRead(Pin.ANALOG_PIN_0);//Voice activation system
			int diff = Math.abs(last - sound);
			if(diff > 300 && diff < 800){
				/*Dummy voice activation*/
				if(sound > 470){
					counter++;
					System.out.println("Calling group1..."); //change depending on who user wants to call via voice activation
					/*Delay to simulate call being answered*/
					if(counter == 1){
						grovepi.common.Delay.milliseconds(2000);
						System.out.println("Call in progress");

					}
				}	
			}
			/*to demo online mode, press button once
			 * otherwise to demo in call, hold button down
			 */
			if(button.isPressed()){
				counter++;a
				//System.out.println("Hello Mike");
				led1.setState(true);
				led2.setState(true);
				led3.setState(true);
				/*on second button press turn off HoloGram*/
				if((counter % 2) == 0){
					System.out.println("Goodbye Mike");
					led1.setState(false);
					led2.setState(false);
				}
			}
			grovepi.common.Delay.milliseconds(100);
		}
	}
}
