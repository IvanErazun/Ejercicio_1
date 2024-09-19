package ar.edu.utn.frba.dds.ejercicio_01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "rutinas")
public class Rutina {
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deportista_id")
    private Deportista deportista;

    @OneToMany
    @JoinColumn(name = "rutina_id")
    private List<ar.entdu.utn.frba.dds.ejercicio_01.DiaDeEntrenamiento> diasDeEntrenamiento;

    @OneToOne
    @JoinColumn(name = "rutina_anterior_id")
    private Rutina rutinaAnterior;

    public Rutina() {
        this.diasDeEntrenamiento = new ArrayList<>();
    }

    public void agregarDiaDeEntrenamiento(ar.entdu.utn.frba.dds.ejercicio_01.DiaDeEntrenamiento diaDeEntrenamiento) {
        this.diasDeEntrenamiento.add(diaDeEntrenamiento);
    }
}
