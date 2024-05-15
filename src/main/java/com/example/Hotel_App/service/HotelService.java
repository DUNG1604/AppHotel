package com.example.Hotel_App.service;

import com.example.Hotel_App.dto.request.HotelCreationRequest;
import com.example.Hotel_App.entity.Hotel;
import com.example.Hotel_App.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    public Hotel createHotel(HotelCreationRequest request){
        Hotel hotel = new Hotel();

        hotel.setName(request.getName());
        hotel.setAdress(request.getAdress());
        hotel.setCheckin(request.getCheckin());
        hotel.setInfor(request.getInfor());
        hotel.setOverview(request.getOverview());
        hotel.setPrice(request.getPrice());
        hotel.setStar(request.getStar());
        hotel.setImg(request.getImg());
        return  hotelRepository.save(hotel);
    }
     public List<Hotel> getHotels(){
        return  hotelRepository.findAll();
     }

     public  Hotel  getHotel (String id){
        return  hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hotel not found"));
     }

     public  void  deleteHotel (String id){
        hotelRepository.deleteById(id);
     }

     public  List<Hotel> searchHotel(String name, String adress) {
        return hotelRepository.searchHotel(name, adress);
    }

}
