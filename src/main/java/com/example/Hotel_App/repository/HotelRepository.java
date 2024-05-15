package com.example.Hotel_App.repository;

import com.example.Hotel_App.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

    @Query(value = "CALL search_hotel(:name, :adress)", nativeQuery = true)
    List<Hotel> searchHotel(@Param("name") String name, @Param("adress") String adress);
}



