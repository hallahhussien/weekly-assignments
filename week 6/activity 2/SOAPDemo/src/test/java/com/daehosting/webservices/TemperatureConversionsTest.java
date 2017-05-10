package com.daehosting.webservices;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by student on 2/26/17.
 */
public class TemperatureConversionsTest {
    @org.junit.Test
    public void getTemperatureConversionsSoap12() throws Exception {
        TemperatureConversionsSoapType service = new TemperatureConversions().getTemperatureConversionsSoap12();

        BigDecimal celsiusToFahrenheitResult = service.celsiusToFahrenheit(BigDecimal.valueOf(0.0));
        assertEquals("The celsius-to-Farenheit conversion failed", celsiusToFahrenheitResult, BigDecimal.valueOf(32));


        BigDecimal fahrenheitToCelsiusResult = service.fahrenheitToCelsius(BigDecimal.valueOf(32));
        assertEquals("The Farenheit-to-celsius conversion failed", fahrenheitToCelsiusResult, BigDecimal.valueOf(0));


        BigDecimal windChillInFahrenheitResult = service.windChillInFahrenheit(BigDecimal.valueOf(32), BigDecimal.valueOf(5));
        assertEquals("The windchill for farenheit failed", windChillInFahrenheitResult, BigDecimal.valueOf(24.638));


        BigDecimal windChillInCelsiusResult = service.windChillInCelsius(BigDecimal.valueOf(0), BigDecimal.valueOf(5));
        assertEquals("The windchill for celsius failed", windChillInCelsiusResult, BigDecimal.valueOf(-4.09));

    }

}