package com.cowin.apis;

import com.cowin.apis.config.TwitterConfig;
import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.models.AuthenticationRequest;
import com.cowin.apis.models.OTPRequest;
import com.cowin.apis.service.CoWinAppointmentService;
import com.cowin.apis.service.CoWinAuthenticationService;
import com.cowin.apis.service.CoWinLocationService;
import com.cowin.apis.service.TwitterService;
import com.cowin.apis.service.impl.CoWinAppointmentServiceImpl;
import com.cowin.apis.service.impl.CoWinAuthenticationServiceImpl;
import com.cowin.apis.service.impl.CoWinLocationServiceImpl;
import com.cowin.apis.service.impl.TwitterServiceImpl;
import com.cowin.apis.utils.RestUtils;
import com.cowin.apis.utils.TwitterUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Junit test cases for @{@link com.cowin.apis.controller.CoWinAppointmentController} & @{@link com.cowin.apis.controller.CoWinLocationController}
 */
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations ={"classpath:cowin.properties", "classpath:twitter4j.properties"})
@WebMvcTest
public class CoWinApiTests {

    @TestConfiguration
    static class CoWinServiceTestConfiguration{
        @Bean
        public CoWinLocationService coWinLocationService(){
            return new CoWinLocationServiceImpl();
        }
        @Bean
        public CoWinAppointmentService coWinAppointmentService(){
            return new CoWinAppointmentServiceImpl();
        }
        @Bean
        public CoWinAuthenticationService coWinAuthenticationService(){
            return new CoWinAuthenticationServiceImpl();
        }
        @Bean
        public TwitterService twitterService(){
            return new TwitterServiceImpl();
        }
        @Bean
        public RestTemplate restTemplate(){
            return new RestTemplate();
        }
        @Bean
        public RestUtils restUtils(){
            return new RestUtils();
        }
        @Bean
        public CowinProperties cowinProperties(){
            return new CowinProperties();
        }
        @Bean
        public TwitterUtils twitterUtils(){
            return new TwitterUtils();
        }
        @Bean
        public Twitter twitter(){
            return TwitterFactory.getSingleton();
        }

    }

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper mapper=new ObjectMapper();
    private static final SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

    @Test
    public void allStatesTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/location/states")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void districtTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/location/findDistrictsByStateId")
                .param("state_id","1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findByPinTest() throws Exception{
        String paramDate=sdf.format(new Date());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/appointment/findByPin")
                .param("pincode","110001")
                .param("date", paramDate)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findByDistrictTest() throws Exception{
        String paramDate=sdf.format(new Date());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/appointment/findByDistrict")
                .param("district_id","1")
                .param("date", paramDate)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void calendarByPinTest() throws Exception{
        String paramDate=sdf.format(new Date());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/appointment/calendarByPin")
                .param("pincode","110001")
                .param("date", paramDate)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void calendarByDistrictTest() throws Exception{
        String paramDate=sdf.format(new Date());
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v1/appointment/calendarByDistrict")
                .param("district_id","1")
                .param("date", paramDate)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void generateOtpTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/authentication/generateOtp")
                .content(mapper.writeValueAsString(new AuthenticationRequest("123456789")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void confirmOtpTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/authentication/confirmOtp")
                .content(mapper.writeValueAsString(new OTPRequest("123456789","123")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }
}
