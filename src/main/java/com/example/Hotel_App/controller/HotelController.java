package com.example.Hotel_App.controller;

import com.example.Hotel_App.dto.request.HotelCreationRequest;
import com.example.Hotel_App.entity.Hotel;
import com.example.Hotel_App.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    Hotel createHotel(@RequestBody HotelCreationRequest request){
        return hotelService.createHotel(request);
    }
    @GetMapping
    List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @GetMapping("/{hotelId}")
    Hotel getHotel (@PathVariable String hotelId){
        return hotelService.getHotel(hotelId);
    }

    @DeleteMapping("/{hotelId}")
    String deleteHotel (@PathVariable String hotelId){
        hotelService.deleteHotel(hotelId);
        return "xóa thành công";
    }

    @GetMapping("/search")
    List<Hotel> searchHotel(@RequestParam String name, @RequestParam String adress){
        return hotelService.searchHotel(name, adress);
    }
}
