package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;

import java.util.Collection;
import java.util.OptionalInt;

public final class ArbitraryBuilding implements Building {
    private final int maxNumberOfResources;

    public ArbitraryBuilding(final int maxNumberOfResources) {
        this.maxNumberOfResources = maxNumberOfResources;
        if (maxNumberOfResources <= 0 || maxNumberOfResources > 7) {
            throw new IllegalArgumentException("At least 1 and most 7 resources are required");
        }
    }
    @Override
    public OptionalInt build(final Collection<Effect> resources) {
        if (resources.size() > maxNumberOfResources || resources.isEmpty()) {
            return OptionalInt.empty();
        }
        int sum = 0;
        for (Effect resource : resources) {
            if (!resource.isResource()) {
                return OptionalInt.empty();
            }
            sum += resource.points();
        }
        return OptionalInt.of(sum);
    }

}
