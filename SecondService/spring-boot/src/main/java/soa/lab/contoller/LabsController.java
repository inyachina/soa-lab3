package soa.lab.contoller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("bars/api/v1/")
@AllArgsConstructor
public class LabsController {
//    private SecondService secondService;
//
//
//    @GetMapping("/disciplines/{discipline-id}/get-hardcore")
//    private ResponseEntity getHardcore(@PathVariable(name = "discipline-id") Integer disciplineId) {
//        List<Lab> labs = this.secondService.getHardcoreLabs(disciplineId);
//        if (labs.isEmpty()) return ResponseEntity.noContent().build();
//
//        return ResponseEntity.ok().body(labs);
//    }
//
//    @PostMapping("/labwork/{labwork-id}/difficulty/decrease/{steps-count}")
//    private ResponseEntity decreaseLabDifficulty(@PathVariable("labwork-id") Integer labId, @PathVariable("steps-count") Integer stepsCount) {
//        return ResponseEntity.ok().body(this.secondService.decreaseLabDifficulty(labId, stepsCount));
//    }
}
