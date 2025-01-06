package ProjetoHotel.Hotel.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ScannerConfig {

    @Bean
    public Scanner entrada(){
      return new Scanner(System.in);
    }
}
