package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.ActionResult;
import sk.uniba.fmph.dcs.stone_age.Effect;

public class GetSomethingThrow implements EvaluateCivilisationCardImmediateEffect {
    private final CurrentThrow currentThrow;
    private static final int NUMBER_OF_DICES = 2;

    public GetSomethingThrow(final CurrentThrow currentThrow) {
        this.currentThrow = currentThrow;
    }

    @Override
    public final ActionResult performEffect(final Player player, final Effect choice) {
        if (!choice.isResource()) {
            return ActionResult.FAILURE;
        }
        currentThrow.initiate(player, choice, NUMBER_OF_DICES);
        return ActionResult.ACTION_DONE_WAIT_FOR_TOOL_USE;
    }

}