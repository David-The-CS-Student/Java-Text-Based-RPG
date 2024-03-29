package rpgItemPack;

import rpgBasePack.BaseAttributes;

public class SpellBookLv1 extends SpellBook{

    public SpellBookLv1(){

        super("Spell Book Lv 1", "A novice spell book", 50,
                new BaseAttributes(0,0,1,0,2,0));
    }

    public SpellBookLv1(SpellBookLv1 copy){
        super(copy);
    }

    @Override
    public Item clone() {
        return new SpellBookLv1(this);
    }
}
