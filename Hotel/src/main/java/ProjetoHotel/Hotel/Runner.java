package ProjetoHotel.Hotel;

import ProjetoHotel.Hotel.repository.HotelRepository;
import ProjetoHotel.Hotel.repository.QuartoRepository;
import ProjetoHotel.Hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {
    Scanner entrada = new Scanner(System.in);

    @Autowired
    private QuartoRepository quartoRepository;
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public void run(String... args)throws Exception  {
        String comand;
        System.out.println("\n      ------ Início do Programa ------      ");
        do{
            System.out.println("\n=========MENU=========\n");
            System.out.println("""
                    1 - Cadastrar HOTEL
                    2 - Cadastrar QUARTO
                    3 - cadastrar Reserva
                    4 - finalizar Reserva
                    5 - Listar Hoteis
                    6 - Listar Quartos
                    7 - Listar Reservas
                    0 - Sair
                     """);
            System.out.print("Opção: ");
            comand = entrada.nextLine().trim();
            switch(comand){
                case("1"): cadastrarHotel(); break;
                case("2"): cadatrarQuarto(); break;
                case("3"): cadastrarReserva(); break;
                case("4"): finalizarReserva();break;
                case("5"): listarHoteis();break;
                case("6"): listarQuartos();break;
                case("7"): listarReservas(); break;
                case("0"): break;
                default:
                    System.out.println("OPÇÃO INDIPONIVEL");
            }
        }while (!comand.equalsIgnoreCase("0"));
        System.out.println("FINALIZADO");
    }
    void cadastrarHotel(){
        System.out.println("----------------------------");
        try {
            System.out.println("Cadastro de Hotel");
            System.out.print("Nome do Hotel: ");
            String nome = entrada.nextLine().trim().replaceAll("\\s+", " ");

            hotelRepository.save(new Hotel(nome));

            System.out.println("Hotel cadastrado com sucesso!");
        } catch (ArithmeticException e) {
            System.out.println("INVALIDO");
            System.out.println("----------------------------\n");
        }
        System.out.println("----------------------------\n");
    }
    void cadatrarQuarto(){
        System.out.println("----------------------------");
        var hoteis = hotelRepository.findAll();
        if (hoteis.isEmpty()) {
            System.out.println("\nNão Há Hoteis Cadastradas!\n");
        }else {
            try {
                System.out.println("Cadastro de Quarto");
                System.out.print("Número do Quarto: ");
                String numero = entrada.nextLine().trim().replaceAll("\\s+", " ");
                hotelRepository.findAll().forEach(hotel -> {
                    System.out.println("----------------------------");
                    System.out.println("ID: " +hotel.getId() +" Hotel: " + hotel.getNome() );
                    System.out.println("----------------------------");
                });
                System.out.println("Digite Id do Hotel:");
                int idHotel = entrada.nextInt();
                var hotel = hotelRepository.findById(idHotel).get();
                Quarto novoQuarto = new Quarto(numero);
                novoQuarto.setHotel(hotel);
                quartoRepository.save(novoQuarto);
                System.out.println("Quarto cadastrado com sucesso!");
                entrada.nextLine();

            } catch (Exception e) {
                System.out.println(" ID DO QUARTO INVALIDO");
                System.out.println("----------------------------\n");
            }
        }
        System.out.println("----------------------------\n");
    }
    void cadastrarReserva(){
        System.out.println("----------------------------");
        var quartos = quartoRepository.findAll();
        if (quartos.isEmpty()) {
            System.out.println("\nNão Há Quartos Cadastradas!\n");
        }else {
            try {

                System.out.println("Cadastro de Reserva");
                quartoRepository.findAll().forEach(quarto -> {
                    System.out.println("----------------------------");
                    System.out.println("ID: "+ quarto.getId()+" quarto: " + quarto.getNumero()
                            + "\nStatus: " + quarto.getStatus()
                            + " Hotel: " + quarto.getHotel());
                    System.out.println("----------------------------");
                });
                System.out.println("ID do Quarto:");
                int idQuarto = entrada.nextInt();
                Quarto quarto = quartoRepository.findById(idQuarto).get();
                if (quarto.getStatus() != Status.DISPONIVEL){
                    System.out.println("Quarto Ocupado!");
                }else {
                    Reserva reserva = new Reserva();
                    reserva.setQuarto(quarto);
                    quarto.setStatus(Status.OCUPADO);
                    quartoRepository.save(quarto);
                    reserva.setDataInicio(LocalDate.now());
                    reservaRepository.save(reserva);
                }entrada.nextLine();
            } catch (Exception e) {
                System.out.println("ID RESERVA INVALIDO");
            }
        }
        System.out.println("----------------------------\n");
    }
    void finalizarReserva(){
        System.out.println("----------------------------");
        var reservas = reservaRepository.findAll();
        if (reservas.isEmpty()){
            System.out.println("Nenhuma Reserva Cadastrada");
        }else {
            try {
                System.out.println("Finalizar Reserva");
                reservaRepository.findAll().forEach(reserva -> {
                    System.out.println("----------------------------");
                    if (reserva.getQuarto().getStatus() != Status.DISPONIVEL) {
                        System.out.println("ID de Reserva: " + reserva.getId()
                                + " Status: " + reserva.getQuarto().getStatus()
                                + " Hotel: " + reserva.getQuarto().getHotel().getNome());
                    }
                    System.out.println("----------------------------");
                });
                System.out.println("Numero do Quarto:");
                int idReserva = entrada.nextInt();
                Reserva reserva = reservaRepository.findById(idReserva).get();
                reserva.setDataFim(LocalDate.now());
                reservaRepository.save(reserva);
                entrada.nextLine();
            } catch (Exception e) {
                System.out.println("\nID DA RESERVA INVALDO\n");
                System.out.println("----------------------------");
            }
        }
        System.out.println("----------------------------\n");
    }
    void listarHoteis(){
        System.out.println("----------------------------");
        var hotels = hotelRepository.findAll();
        if (hotels.isEmpty()) {
            System.out.println("\nNão Há Hoteis Cadastradas!\n");
        }else {
            hotelRepository.findAll().forEach(hotel -> {
                System.out.println("ID: " + hotel.getId() + " Hotel: " + hotel.getNome());
                System.out.println("----------------------------");
            });
        }
    }
    void listarQuartos() {
        System.out.println("----------------------------");
        var Quartos = quartoRepository.findAll();
        if (Quartos.isEmpty()) {
            System.out.println("\nNão Há Quartos Cadastradas!\n");
        }else {
        quartoRepository.findAll().forEach(Quarto -> {
            System.out.println("ID: " + Quarto.getId() + " Quarto: " + Quarto.getNumero()
                    + " Hotel: " + Quarto.getHotel().getNome()
                    + " Status: " + Quarto.getStatus());
            System.out.println("\n");
            System.out.println("----------------------------");
        });
    }
        System.out.println("----------------------------\n");
    }
    void listarReservas(){

        var reservas = reservaRepository.findAll();
        if (reservas.isEmpty()) {
            System.out.println("\nNão Há Reservas Cadastradas!\n");
        }else {
            reservaRepository.findAll().forEach(reserva -> {
                System.out.println("----------------------------");
                System.out.println("ID: " + reserva.getId()
                        + "\nStatus: " + reserva.getQuarto().getStatus()
                        + " Hotel: " + reserva.getQuarto().getHotel().getNome()
                        + "\nInicio Da Reserva: " + reserva.getDataInicio());
                if(reserva.getDataFim() != null){
                    System.out.println("Fim DA Reserva: " + reserva.getDataFim());
                }
                System.out.println("\n");
                System.out.println("----------------------------");
            });
        }
        System.out.println("----------------------------\n");
    }
}