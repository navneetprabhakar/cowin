package com.cowin.apis;

import com.cowin.apis.constants.CowinProperties;
import com.cowin.apis.service.CoWinAppointmentService;
import com.cowin.apis.service.CoWinAuthenticationService;
import com.cowin.apis.service.CoWinLocationService;
import com.cowin.apis.service.impl.CoWinAppointmentServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Junit test cases for @{@link com.cowin.apis.controller.CoWinAppointmentController}
 */
@ExtendWith(SpringExtension.class)
@TestPropertySource(value = "classpath:cowin.properties")
@WebMvcTest
public class CoWinAppointmentControllerTests {

    @TestConfiguration
    static class AppointmentServiceTestConfiguration{
        @Bean
        public CoWinAppointmentService coWinAppointmentService(){
            return new CoWinAppointmentServiceImpl();
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
    private CoWinAuthenticationService coWinAuthenticationService;

    @MockBean
    private CoWinLocationService coWinLocationService;

    @Autowired
    private CoWinAppointmentService coWinAppointmentService;

    private static final SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");

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

}
