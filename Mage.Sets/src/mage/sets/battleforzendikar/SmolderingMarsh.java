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
package mage.sets.battleforzendikar;

import java.util.UUID;
import mage.abilities.common.EntersBattlefieldAbility;
import mage.abilities.condition.Condition;
import mage.abilities.condition.InvertCondition;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.common.TapSourceEffect;
import mage.abilities.mana.BlackManaAbility;
import mage.abilities.mana.RedManaAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.filter.common.FilterLandPermanent;
import mage.filter.predicate.mageobject.SupertypePredicate;

/**
 *
 * @author fireshoes
 */
public class SmolderingMarsh extends CardImpl {
    
    private static final FilterLandPermanent filter = new FilterLandPermanent();
    
    static {
        filter.add(new SupertypePredicate("Basic"));
    }

    public SmolderingMarsh(UUID ownerId) {
        super(ownerId, 247, "Smoldering Marsh", Rarity.RARE, new CardType[]{CardType.LAND}, "");
        this.expansionSetCode = "BFZ";
        this.subtype.add("Swamp");
        this.subtype.add("Mountain");

        // Smoldering Marsh enters the battlefield tapped unless you control two or more basic lands.
        Condition controls = new InvertCondition(new PermanentsOnTheBattlefieldCondition(filter, PermanentsOnTheBattlefieldCondition.CountType.MORE_THAN, 1));
        String abilityText = "tapped unless you control two or more basic lands";
        this.addAbility(new EntersBattlefieldAbility(new ConditionalOneShotEffect(new TapSourceEffect(), controls, abilityText), abilityText));
        this.addAbility(new BlackManaAbility());
        this.addAbility(new RedManaAbility());
    }

    public SmolderingMarsh(final SmolderingMarsh card) {
        super(card);
    }

    @Override
    public SmolderingMarsh copy() {
        return new SmolderingMarsh(this);
    }
}
