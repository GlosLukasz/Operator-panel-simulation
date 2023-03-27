package com.koltech.koltech.adapter;

import com.koltech.koltech.model.Measurement;
import com.koltech.koltech.model.MeasurementRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface SqlMeasurementRepository extends MeasurementRepository, JpaRepository<Measurement,Integer> {

    @Query(nativeQuery = true, value ="SELECT * FROM MEASUREMENTS ORDER BY id DESC LIMIT 1")
    Measurement findLastValue();
}
