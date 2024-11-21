package com.aiep.actividad.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Medico.
 */
@Entity
@Table(name = "medico")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "rut", nullable = false)
    private String rut;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "a_paterno", nullable = false)
    private String aPaterno;

    @Column(name = "a_materno")
    private String aMaterno;

    @Column(name = "especialidad")
    private String especialidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medico")
    @JsonIgnoreProperties(value = { "paciente", "medico", "centroSalud" }, allowSetters = true)
    private Set<Reserva> reservas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Medico id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return this.rut;
    }

    public Medico rut(String rut) {
        this.setRut(rut);
        return this;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Medico nombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return this.aPaterno;
    }

    public Medico aPaterno(String aPaterno) {
        this.setaPaterno(aPaterno);
        return this;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return this.aMaterno;
    }

    public Medico aMaterno(String aMaterno) {
        this.setaMaterno(aMaterno);
        return this;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public Medico especialidad(String especialidad) {
        this.setEspecialidad(especialidad);
        return this;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        if (this.reservas != null) {
            this.reservas.forEach(i -> i.setMedico(null));
        }
        if (reservas != null) {
            reservas.forEach(i -> i.setMedico(this));
        }
        this.reservas = reservas;
    }

    public Medico reservas(Set<Reserva> reservas) {
        this.setReservas(reservas);
        return this;
    }

    public Medico addReserva(Reserva reserva) {
        this.reservas.add(reserva);
        reserva.setMedico(this);
        return this;
    }

    public Medico removeReserva(Reserva reserva) {
        this.reservas.remove(reserva);
        reserva.setMedico(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medico)) {
            return false;
        }
        return getId() != null && getId().equals(((Medico) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Medico{" +
            "id=" + getId() +
            ", rut='" + getRut() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", aPaterno='" + getaPaterno() + "'" +
            ", aMaterno='" + getaMaterno() + "'" +
            ", especialidad='" + getEspecialidad() + "'" +
            "}";
    }
}
