package powers;
import objects.power;

public class fireball extends power {
    public fireball (int ap) {
        name = "fireball";
        description = "A fiery blast of fire that ignites the opponent.";
        affectsPlayer = 1;
        value = ap - 5;
        cost = 10;
        skips = -1;
        dot = 3;
        dotL = 3;
    }
}
