package com.tfg.arquitecturabase.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tfg.arquitecturabase.models.sleep.RestTrack;
import com.tfg.arquitecturabase.models.training.Exercise;

@Repository("restTrackRepository")
public interface RestTrackRepository extends MongoRepository<RestTrack,String> {
	Optional<RestTrack> findByDate(LocalDate date);
}
