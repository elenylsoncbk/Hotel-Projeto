package ProjetoHotel.Hotel.repository;

import ProjetoHotel.Hotel.Hoteis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoteisRepository extends JpaRepository<Hoteis, Long> {
}
