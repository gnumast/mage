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
package mage.sets.khansoftarkir;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.keyword.HexproofAbility;
import mage.abilities.keyword.ProwessAbility;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;

/**
 *
 * @author LevelX2
 */
public class WhirlwindAdept extends CardImpl {

    public WhirlwindAdept(UUID ownerId) {
        super(ownerId, 63, "Whirlwind Adept", Rarity.COMMON, new CardType[]{CardType.CREATURE}, "{4}{U}");
        this.expansionSetCode = "KTK";
        this.subtype.add("Djinn");
        this.subtype.add("Monk");

        this.power = new MageInt(4);
        this.toughness = new MageInt(2);

        // Hexproof
        this.addAbility(HexproofAbility.getInstance());
        // Prowess
        this.addAbility(new ProwessAbility());
    }

    public WhirlwindAdept(final WhirlwindAdept card) {
        super(card);
    }

    @Override
    public WhirlwindAdept copy() {
        return new WhirlwindAdept(this);
    }
}
