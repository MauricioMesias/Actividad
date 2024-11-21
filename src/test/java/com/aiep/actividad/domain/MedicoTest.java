package com.aiep.actividad.domain;

import static com.aiep.actividad.domain.MedicoTestSamples.*;
import static com.aiep.actividad.domain.ReservaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.aiep.actividad.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class MedicoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Medico.class);
        Medico medico1 = getMedicoSample1();
        Medico medico2 = new Medico();
        assertThat(medico1).isNotEqualTo(medico2);

        medico2.setId(medico1.getId());
        assertThat(medico1).isEqualTo(medico2);

        medico2 = getMedicoSample2();
        assertThat(medico1).isNotEqualTo(medico2);
    }

    @Test
    void reservaTest() {
        Medico medico = getMedicoRandomSampleGenerator();
        Reserva reservaBack = getReservaRandomSampleGenerator();

        medico.addReserva(reservaBack);
        assertThat(medico.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getMedico()).isEqualTo(medico);

        medico.removeReserva(reservaBack);
        assertThat(medico.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getMedico()).isNull();

        medico.reservas(new HashSet<>(Set.of(reservaBack)));
        assertThat(medico.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getMedico()).isEqualTo(medico);

        medico.setReservas(new HashSet<>());
        assertThat(medico.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getMedico()).isNull();
    }
}
