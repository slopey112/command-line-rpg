package powers;

import objects.power;

public class shank extends power {
    public shank (int lvl, int def) {
        name = "shank";
        description = "A stealthy strike that penetrates the armor!";
        value = def + (lvl * 2 - 2);
    }
}
