package com.aiep.actividad.domain;

import static com.aiep.actividad.domain.CentroSaludTestSamples.*;
import static com.aiep.actividad.domain.ReservaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.aiep.actividad.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class CentroSaludTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CentroSalud.class);
        CentroSalud centroSalud1 = getCentroSaludSample1();
        CentroSalud centroSalud2 = new CentroSalud();
        assertThat(centroSalud1).isNotEqualTo(centroSalud2);

        centroSalud2.setId(centroSalud1.getId());
        assertThat(centroSalud1).isEqualTo(centroSalud2);

        centroSalud2 = getCentroSaludSample2();
        assertThat(centroSalud1).isNotEqualTo(centroSalud2);
    }

    @Test
    void reservaTest() {
        CentroSalud centroSalud = getCentroSaludRandomSampleGenerator();
        Reserva reservaBack = getReservaRandomSampleGenerator();

        centroSalud.addReserva(reservaBack);
        assertThat(centroSalud.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getCentroSalud()).isEqualTo(centroSalud);

        centroSalud.removeReserva(reservaBack);
        assertThat(centroSalud.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getCentroSalud()).isNull();

        centroSalud.reservas(new HashSet<>(Set.of(reservaBack)));
        assertThat(centroSalud.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getCentroSalud()).isEqualTo(centroSalud);

        centroSalud.setReservas(new HashSet<>());
        assertThat(centroSalud.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getCentroSalud()).isNull();
    }
}
