package org.mmpp.sample.pi4j.boot;

import com.pi4j.io.gpio.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
    private static GpioController gpio;
    private static GpioPinDigitalOutput pinLED;

    private static void initialize() {
        if (gpio == null) {
            gpio = GpioFactory.getInstance();
            // Raspberry pi の piは 16 : GPIO_27
            pinLED = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "LED", PinState.LOW);
        }
    }

    public static void main(String[] args) throws Exception {
        initialize();
        while(true) {
            pinLED.toggle();
            try {
                Thread.sleep(3000); //3000ミリ秒Sleepする
            } catch (InterruptedException e) {
            }
        }

    }
}
