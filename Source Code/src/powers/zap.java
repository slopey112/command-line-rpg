package powers;
import objects.power;

public class zap extends power {
    public zap (int lvl) {
        name = "zap";
        description = "A powerful bolt of lightning that strikes the opponent!";
        value = lvl * 2;
    }
}
