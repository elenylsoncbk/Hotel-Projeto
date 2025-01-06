package ProjetoHotel.Hotel;

import jakarta.persistence.*;
@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)//  Armazena o nome da enum como string
    private Status status;

    @OneToMany

    public Quarto() {
    }

    public Quarto(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
