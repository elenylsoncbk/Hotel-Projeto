package ProjetoHotel.Hotel;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hoteis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @OneToMany(mappedBy = "hotel")
    private List<Quarto> quartos;


    public Hoteis() {
    }

    public Hoteis(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Hoteis{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
