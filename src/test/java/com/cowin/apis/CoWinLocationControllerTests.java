package com.cowin.apis;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.service.CoWinAppointmentService;
import com.cowin.apis.service.CoWinAuthenticationService;
import com.cowin.apis.service.CoWinLocationService;
import com.cowin.apis.service.impl.CoWinLocationServiceImpl;
import com.cowin.apis.utils.RestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

/**
 * Junit test cases for @{@link com.cowin.apis.controller.CoWinLocationController}
 */
@ExtendWith(SpringExtension.class)
@TestPropertySource(value = "classpath:cowin.properties")
@WebMvcTest
public class CoWinLocationControllerTests {

    @TestConfiguration
    static class LocationServiceTestConfiguration{
        @Bean
        public CoWinLocationService coWinLocationService(){
            return new CoWinLocationServiceImpl();
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
    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoWinAppointmentService coWinAppointmentService;

    @MockBean
    private CoWinAuthenticationService coWinAuthenticationService;

    @Autowired
    private CoWinLocationService coWinLocationService;

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
}
