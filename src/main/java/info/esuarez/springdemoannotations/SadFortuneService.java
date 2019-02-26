package info.esuarez.springdemoannotations;


public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today will be terrible, sorry.";
    }
}
