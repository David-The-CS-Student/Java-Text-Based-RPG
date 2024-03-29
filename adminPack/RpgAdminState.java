package adminPack;

public  abstract class RpgAdminState {

    private final AdminState state;


   public RpgAdminState(AdminState state){this.state = state;}

    public AdminState getState() {return this.state;}
    public abstract void update();
}
