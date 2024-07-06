package com.tfg.arquitecturabase.models.sleep;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.tfg.arquitecturabase.models.training.Exercise;
import com.tfg.arquitecturabase.models.training.Serie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "restTracks")
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestTrack {

    @Id
    private String id;
    @NonNull
	@Indexed(unique = true)
    private LocalDate date;
    private int hoursSlept;
    private int timesWokeUp;
    private int subjectiveRecovery;
    private int chestFatigue;
    private int backFatigue;
    private int quadricepsFatigue;
    private int femoralFatigue;
    private int calfsFatigue;
    private int bicepsFatigue;
    private int tricepsFatigue;
    private int forearmsFatigue;
    private int shouldersFatigue;
    private int motivation;

}