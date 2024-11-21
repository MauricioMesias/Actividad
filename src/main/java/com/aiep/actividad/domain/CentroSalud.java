package com.aiep.actividad.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A CentroSalud.
 */
@Entity
@Table(name = "centro_salud")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class CentroSalud implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "tipocentro", nullable = false)
    private String tipocentro;

    @NotNull
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "centroSalud")
    @JsonIgnoreProperties(value = { "paciente", "medico", "centroSalud" }, allowSetters = true)
    private Set<Reserva> reservas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public CentroSalud id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public CentroSalud nombre(String nombre) {
        this.setNombre(nombre);
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipocentro() {
        return this.tipocentro;
    }

    public CentroSalud tipocentro(String tipocentro) {
        this.setTipocentro(tipocentro);
        return this;
    }

    public void setTipocentro(String tipocentro) {
        this.tipocentro = tipocentro;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public CentroSalud direccion(String direccion) {
        this.setDireccion(direccion);
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Reserva> getReservas() {
        return this.reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        if (this.reservas != null) {
            this.reservas.forEach(i -> i.setCentroSalud(null));
        }
        if (reservas != null) {
            reservas.forEach(i -> i.setCentroSalud(this));
        }
        this.reservas = reservas;
    }

    public CentroSalud reservas(Set<Reserva> reservas) {
        this.setReservas(reservas);
        return this;
    }

    public CentroSalud addReserva(Reserva reserva) {
        this.reservas.add(reserva);
        reserva.setCentroSalud(this);
        return this;
    }

    public CentroSalud removeReserva(Reserva reserva) {
        this.reservas.remove(reserva);
        reserva.setCentroSalud(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CentroSalud)) {
            return false;
        }
        return getId() != null && getId().equals(((CentroSalud) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CentroSalud{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", tipocentro='" + getTipocentro() + "'" +
            ", direccion='" + getDireccion() + "'" +
            "}";
    }
}
