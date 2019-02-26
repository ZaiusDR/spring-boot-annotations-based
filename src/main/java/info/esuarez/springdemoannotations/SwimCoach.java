package info.esuarez.springdemoannotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${coach.mail}")
    private String mail;

    @Value("${coach.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice croll for 2 hours with your team: " + team;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
