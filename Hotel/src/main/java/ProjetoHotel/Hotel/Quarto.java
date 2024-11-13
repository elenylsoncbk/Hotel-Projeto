package ProjetoHotel.Hotel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "Quarto")
    private String numero;

    @Enumerated(EnumType.STRING)
    private Status status = Status.DISPONIVEL;

    @ManyToOne
    @JoinColumn(name = "Hotel_Id")
    private Hotel hotel;

    public Quarto() {
    }

    public Quarto(String numero) {
        this.numero = numero;
    }

    public Quarto(Status status) {
        this.status = status;
    }

    public Quarto(String numero, Status status) {
        this.numero = numero;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
