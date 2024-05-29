package rpgItemPack;


public interface IEquipable {

     enum EquipType{

        InProgress,
        Primary_Weapon,
        Secondary_Weapon,
        Head, Neck, Torso,
        Finger, Legs,Feet

    }

    EquipType getEquipType();
    void setEquipType(EquipType equipType);

    boolean equip();
    void unEquip();
}
