package com.aiep.actividad.domain;

import static com.aiep.actividad.domain.PacienteTestSamples.*;
import static com.aiep.actividad.domain.ReservaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.aiep.actividad.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PacienteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Paciente.class);
        Paciente paciente1 = getPacienteSample1();
        Paciente paciente2 = new Paciente();
        assertThat(paciente1).isNotEqualTo(paciente2);

        paciente2.setId(paciente1.getId());
        assertThat(paciente1).isEqualTo(paciente2);

        paciente2 = getPacienteSample2();
        assertThat(paciente1).isNotEqualTo(paciente2);
    }

    @Test
    void reservaTest() {
        Paciente paciente = getPacienteRandomSampleGenerator();
        Reserva reservaBack = getReservaRandomSampleGenerator();

        paciente.addReserva(reservaBack);
        assertThat(paciente.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getPaciente()).isEqualTo(paciente);

        paciente.removeReserva(reservaBack);
        assertThat(paciente.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getPaciente()).isNull();

        paciente.reservas(new HashSet<>(Set.of(reservaBack)));
        assertThat(paciente.getReservas()).containsOnly(reservaBack);
        assertThat(reservaBack.getPaciente()).isEqualTo(paciente);

        paciente.setReservas(new HashSet<>());
        assertThat(paciente.getReservas()).doesNotContain(reservaBack);
        assertThat(reservaBack.getPaciente()).isNull();
    }
}
