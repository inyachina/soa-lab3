package soa.lab.service;

import soa.lab.exception.ApiException;
import soa.lab.model.Lab;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface SecondService {

    List<Lab> getHardcoreLabs(Integer disciplineId) throws ApiException;

    Lab decreaseLabDifficulty(Integer labId, Integer stepsCount) throws ApiException;

}
