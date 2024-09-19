package ar.entdu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.ejercicio_01.Ejercicio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "diasr_de_entrenamiento")
public class DiaDeEntrenamiento {
  @OneToMany
  @JoinColumn(name = "dia_de_entrenamiento_id")
  private List<Ejercicio> ejercicios;

  @Column(name = "numero")
  private Integer numero; // representa el orden en la duracion de la rutina.

  @OneToOne
  @JoinColumn(name = "dia_siguiente_id")
  private DiaDeEntrenamiento siguienteDia;

  public DiaDeEntrenamiento() {
    this.ejercicios = new ArrayList<>();
  }
  public void agregarEjercicio(Ejercicio ejercicio) {
    this.ejercicios.add(ejercicio);
  }
}
