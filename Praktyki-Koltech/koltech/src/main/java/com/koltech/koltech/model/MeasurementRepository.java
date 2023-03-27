package com.koltech.koltech.model;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository {

    List<Measurement> findAll();

    Measurement save(Measurement entity);

    Measurement findLastValue();
}
