package com.example.AdminService;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.AdminService.dao.AdminRepository;
import com.example.AdminService.entity.TrainDetails;
import com.example.AdminService.service.AdminServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class AdminServiceApplicationTests 
{
    @Autowired
    private AdminServiceImpl adminService;    
    
    @MockBean
    private AdminRepository adminRepo;
    

        @Test
        @DisplayName("Testing whether train details database is empty")
        public void getAllDetailsTest1() 
        {
            List<TrainDetails> details=adminService.getAllDetails();
            assertTrue(details.isEmpty());
        }
    
        @Test
        @DisplayName("Testing whether getAllDetails method is returning the records of db")
        public void getAllDetailsTest2() 
        {
            //Added train details
            List<TrainDetails> detailsList=new ArrayList<TrainDetails>();
            TrainDetails details=new TrainDetails(16758, "Hyderabad Express", "Kerela", 
                    "Chennai", "07:00Am", "07:00Pm", "12H", 50, 900,750,1500,930);
            detailsList.add(details);
            //checking whether it returns correct values
            when(adminRepo.findAll()).thenReturn(detailsList);
            List<TrainDetails> detailsListNew=adminService.getAllDetails();
            assertEquals(1, detailsListNew.size());
        }

 

        @Test 
        @DisplayName("Testing getTrainDetailsByTrainNo method")
        public void getDetailsByTrainNoTest1() 
        {         
            //Added train details
            Optional<TrainDetails> details=Optional.of(new TrainDetails(67892, "Dehradun Express", "Chennai", 
                    "Dehradun", "09:00Am", "05:00Pm", "8H", 50, 1500,1204,876,754));
            //Checking whether they are returning correct values or not
            when(adminRepo.findById(67892)).thenReturn(details);
            TrainDetails det=adminService.getDetailsByTrainNo(67892);
            assertEquals("Dehradun Express",det.getTrainName());
            assertEquals("Chennai",det.getStartStation());
            assertEquals("Dehradun",det.getDestStation());
            assertEquals("09:00Am",det.getArrivalTime());
            assertEquals("05:00Pm", det.getDeptTime());
            assertEquals("8H", det.getDuration());
            assertEquals(50, det.getNoOfSeats());
            assertEquals(1500, det.getFirstClassACFare());
            assertEquals(1204, det.getTwoTierAcFare());
            assertEquals(876, det.getThreeTierAcFare());
            assertEquals(754, det.getSleeperFare());
        }

 

        @Test
        @DisplayName("Testing addTrainDetails method")
        public void addTrainDetailsTest1()
        {
            //Added train details
            TrainDetails details=new TrainDetails(16758, "Hyderabad Express", "Kerela", 
                    "Chennai", "07:00Am", "07:00Pm", "12H", 50, 900,750,1500,930);
            adminService.addTrainDetails(details);
            //checking whether train details are added or not
            verify(adminRepo,times(1)).save(details);
        }
}