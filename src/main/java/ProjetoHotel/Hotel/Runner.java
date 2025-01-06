package ProjetoHotel.Hotel;

import ProjetoHotel.Hotel.repository.HoteisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner { //Procura um comand para funcinara e somente com o spring

    @Autowired
    private HoteisRepository HotelRepository;// cra uma instancia

    @Autowired
    private Scanner entrada;
    @Override
    // padrao de classe sobrescrevendo
    public void run(String... args) throws Exception {

        Hoteis ushoteis = new Hoteis("Elenylson");
        HotelRepository.save(ushoteis);


        try {
            var u1 = HotelRepository.findById(1L).get();
            System.out.println(u1);
            System.out.println(u1.getNome());

        } catch (Exception e) {
            System.out.println("Ta nulo, animal");
        }
    entrada.close();


    }
}
