package ProjetoHotel.Hotel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Hoteis")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;
    @OneToMany(mappedBy = "hotel")
    private List<Quarto> quartos;

    public Hotel() {
    }
    public Hotel(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
    @Override
    public String toString() {
        return "Hoteis{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }}
