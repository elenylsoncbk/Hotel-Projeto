package ProjetoHotel.Hotel.repository;


import ProjetoHotel.Hotel.Quarto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Integer> {
 //   List<Quarto> findByStatusAndHotel_Id(Status status, Long hotelId);
    List<Quarto> findByStatusAndHotel_Id(String numero, Integer hotelId);


}
