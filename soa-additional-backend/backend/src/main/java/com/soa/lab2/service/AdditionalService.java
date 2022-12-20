package com.soa.lab2.service;

import com.soa.lab2.exception.ApiException;
import com.soa.lab2.exception.DecreaseDifficultyException;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Discipline;
import com.soa.lab2.model.Lab;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdditionalService {
    private CallingService callingService;


    public List<Lab> getHardcoreLabs(Integer disciplineId) throws ApiException {
        this.callingService.get("/disciplines/" + disciplineId, Discipline.class);
        List<Lab> labs = List.of(this.callingService.get("/labs/all", Lab[].class));
        return labs.stream().filter(lab -> lab.getDiscipline().getId() == disciplineId)
                .filter(lab -> lab.getDifficulty().equals(Difficulty.VERY_HARD))
                .limit(10).collect(Collectors.toList());
    }


    public Lab decreaseLabDifficulty(Integer labId, Integer stepsCount) throws ApiException {
        Lab lab = this.callingService.get("/labs/" + labId, Lab.class);
        Integer currentLevel = lab.getDifficulty().getLevel();

        if (currentLevel - stepsCount < 0) throw new DecreaseDifficultyException("Impossible to decrease on this step");

        lab.setDifficulty(Difficulty.getDifficultyByLevel(currentLevel - stepsCount));
        return this.callingService.put("/labs/" + labId, lab);
    }
}
