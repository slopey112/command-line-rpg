package powers;

import objects.power;

public class laser_beam extends power {
    public laser_beam(int lvl) {
        name = "laser beam";
        description = "A blast from a deadly laser, able to stun foes!";
        value = lvl + 5;
        skips = 1;
    }
}
