package com.tfg.arquitecturabase.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tfg.arquitecturabase.models.diet.FoodDayTemplate;
import com.tfg.arquitecturabase.models.sleep.RestTrack;
import com.tfg.arquitecturabase.repositories.FoodDayTemplateRepository;
import com.tfg.arquitecturabase.repositories.RestTrackRepository;

import lombok.RequiredArgsConstructor;

@Service("sleepServiceImpl")
@RequiredArgsConstructor
public class SleepServiceImpl {
	@Autowired
	@Qualifier("restTrackRepository")
	RestTrackRepository _restTrackRepository;
	
	public RestTrack getTodayRestTrack() {
		LocalDate today = LocalDate.now();
        return _restTrackRepository.findByDate(today)
                .orElseGet(() -> null);
	}
	
	public RestTrack saveRestTrack(RestTrack restTrack) {
        restTrack.setDate(LocalDate.now());
        return _restTrackRepository.save(restTrack);
    }
}
