package service;

import exception.ApiException;
import model.Lab;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AdditionalService {

    List<Lab> getHardcoreLabs(Integer disciplineId) throws ApiException;

    Lab decreaseLabDifficulty(Integer labId, Integer stepsCount) throws ApiException;

}
