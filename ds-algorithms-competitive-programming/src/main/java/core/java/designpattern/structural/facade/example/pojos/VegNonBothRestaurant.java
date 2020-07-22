package core.java.designpattern.structural.facade.example.pojos;

public class VegNonBothRestaurant implements Hotel
{
    public Menus getMenus()
    {
        Both b = new Both();
        return b;
    }
}
