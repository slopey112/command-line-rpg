package powers;
import objects.power;

public class hurricane extends power {
    public hurricane (int ap, int lvl) {
        name = "hurricane";
        description = "A blast of wind that stuns the opponent.";
        field = "dmg";
        affectsPlayer = 1;
        value = ap + lvl;
        cost = 15;
        skips = 0;
    }
}
