package info.esuarez.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService fortuneService;

    public FootballCoach() {
    }

    /* To use @Qualifier in a constructor

    public FootballCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService
    }

    */

    @Override
    public String getDailyWorkout() {
        return "Practice shooting to goal.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
