package com.aiep.actividad.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class MedicoTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Medico getMedicoSample1() {
        return new Medico().id(1L).rut("rut1").nombre("nombre1").aPaterno("aPaterno1").aMaterno("aMaterno1").especialidad("especialidad1");
    }

    public static Medico getMedicoSample2() {
        return new Medico().id(2L).rut("rut2").nombre("nombre2").aPaterno("aPaterno2").aMaterno("aMaterno2").especialidad("especialidad2");
    }

    public static Medico getMedicoRandomSampleGenerator() {
        return new Medico()
            .id(longCount.incrementAndGet())
            .rut(UUID.randomUUID().toString())
            .nombre(UUID.randomUUID().toString())
            .aPaterno(UUID.randomUUID().toString())
            .aMaterno(UUID.randomUUID().toString())
            .especialidad(UUID.randomUUID().toString());
    }
}
