package com.cowin.apis.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * This class contains cowin public APIs URLs
 * @author navneetprabhakar
 */
@Configuration
@PropertySources(value = {@PropertySource("classpath:cowin.properties")})
@Getter
@Component
public class CowinProperties {

    @Value("${cowin.base.url}")
    private String baseUrl;
    @Value("${cowin.generate.otp}")
    private String generateOtp;
    @Value("${cowin.confirm.otp}")
    private String confirmOtp;
    @Value("${cowin.location.states}")
    private String locationStates;
    @Value("${cowin.location.district}")
    private String locationDistrict;
    @Value("${cowin.appointment.by.pin}")
    private String findByPin;
    @Value("${cowin.appointment.by.district}")
    private String findByDistrict;
    @Value("${cowin.appointment.calendar.by.pin}")
    private String calendarByPin;
    @Value("${cowin.appointment.calendar.by.district}")
    private String calendarByDistrict;

}
