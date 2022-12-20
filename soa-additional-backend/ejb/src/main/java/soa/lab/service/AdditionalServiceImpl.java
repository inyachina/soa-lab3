package service;

import exception.ApiException;
import exception.DecreaseDifficultyException;
import lombok.extern.slf4j.Slf4j;
import model.Difficulty;
import model.Discipline;
import model.Lab;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Stateless
public class AdditionalServiceImpl implements AdditionalService {
    @EJB
    private CallingService callingService;


    @Override
    public List<Lab> getHardcoreLabs(Integer disciplineId) throws ApiException {
        this.callingService.get("/disciplines/" + disciplineId, Discipline.class);
        Lab[] labs = this.callingService.get("/labs/all", Lab[].class);
        return Stream.of(labs).filter(lab -> lab.getDiscipline().getId() == disciplineId)
                .filter(lab -> lab.getDifficulty().equals(Difficulty.VERY_HARD))
                .limit(10).collect(Collectors.toList());
    }
    @Override
    public Lab decreaseLabDifficulty(Integer labId, Integer stepsCount) throws ApiException {
        Lab lab = this.callingService.get("/labs/" + labId, Lab.class);
        Integer currentLevel = lab.getDifficulty().getLevel();

        if (currentLevel - stepsCount < 0) throw new DecreaseDifficultyException("Impossible to decrease on this step");

        lab.setDifficulty(Difficulty.getDifficultyByLevel(currentLevel - stepsCount));
        return this.callingService.put("/labs/" + labId, lab);
    }

}
