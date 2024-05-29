package rpgItemPack;

import rpgBasePack.BaseAttributes;

public class StaffCedar extends Staff {


    public StaffCedar(){

        super("Cedar Staff","A staff made of cedar", 50, new BaseAttributes(0.0,0.0,2.0,1.0,1.0,-1.0));
    }

    public StaffCedar(StaffCedar copy)
    {
        super(copy);
    }

    @Override
    public Item clone() {
        return new StaffCedar(this) ;
    }
}
