/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.odyssey;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.costs.Cost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.game.Game;
import mage.game.stack.Spell;
import mage.players.Player;
import mage.target.TargetSpell;

/**
 *
 * @author cbt33, Rafbill (Frightful Delustions)
 */
public class Divert extends CardImpl {

    public Divert(UUID ownerId) {
        super(ownerId, 82, "Divert", Rarity.RARE, new CardType[]{CardType.INSTANT}, "{U}");
        this.expansionSetCode = "ODY";


        // Change the target of target spell with a single target unless that spell's controller pays {2}.
        this.getSpellAbility().addTarget(new TargetSpell());
        this.getSpellAbility().addEffect(new DivertEffect());
    }

    public Divert(final Divert card) {
        super(card);
    }

    @Override
    public Divert copy() {
        return new Divert(this);
    }
}

class DivertEffect extends OneShotEffect {

    public DivertEffect() {
        super(Outcome.Detriment);
        this.staticText = "Change the target of target spell with a single target unless that spell's controller pays {2}.";
    }

    public DivertEffect(final DivertEffect effect) {
        super(effect);
    }

    @Override
    public DivertEffect copy() {
        return new DivertEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Spell spell = game.getStack().getSpell(source.getFirstTarget());
        Cost cost = new GenericManaCost(2);
        if (spell != null) {
            Player player = game.getPlayer(spell.getControllerId());
            if (player != null) {
                cost.clearPaid();
                if (!cost.pay(source, game, spell.getControllerId(),
                        spell.getControllerId(), false, null)) {
                    return spell.chooseNewTargets(game, source.getControllerId(), true, true, null);
                }
            }
        }
        return false;
    }

}
