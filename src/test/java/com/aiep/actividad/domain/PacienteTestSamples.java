package com.aiep.actividad.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PacienteTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Paciente getPacienteSample1() {
        return new Paciente().id(1L).rut("rut1").nombre("nombre1").aPaterno("aPaterno1").aMaterno("aMaterno1");
    }

    public static Paciente getPacienteSample2() {
        return new Paciente().id(2L).rut("rut2").nombre("nombre2").aPaterno("aPaterno2").aMaterno("aMaterno2");
    }

    public static Paciente getPacienteRandomSampleGenerator() {
        return new Paciente()
            .id(longCount.incrementAndGet())
            .rut(UUID.randomUUID().toString())
            .nombre(UUID.randomUUID().toString())
            .aPaterno(UUID.randomUUID().toString())
            .aMaterno(UUID.randomUUID().toString());
    }
}
