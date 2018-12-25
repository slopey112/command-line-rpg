package powers;
import objects.power;

public class rejuvenation extends power {
    public rejuvenation (int ap) {
        name = "rejuvenation";
        description = "A healing sprite that temporarily substantially increases HP.";
        field = "hp";
        affectsPlayer = 0;
        value = ap * 2;
        cost = 5;
        skips = -1;
        dot = -1;
        dotL = 6;
    }
}
