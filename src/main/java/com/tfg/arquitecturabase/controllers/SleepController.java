package com.tfg.arquitecturabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.arquitecturabase.models.diet.FoodDayTemplate;
import com.tfg.arquitecturabase.models.sleep.RestTrack;
import com.tfg.arquitecturabase.services.impl.DietServiceImpl;
import com.tfg.arquitecturabase.services.impl.SleepServiceImpl;

@RestController
@RequestMapping("/sleep")
@CrossOrigin(origins = "http://localhost:4200")
public class SleepController {
	@Autowired
	@Qualifier("sleepServiceImpl")
	SleepServiceImpl _sleepService;
	
	@GetMapping("/getTodayRestTrack")
	public RestTrack getTodayRestTrack(){
		return _sleepService.getTodayRestTrack();
	}
	
	@PostMapping("/saveRestTrack")
    public RestTrack saveRestTrack(@RequestBody RestTrack restTrack) {
        return _sleepService.saveRestTrack(restTrack);
    }
}
