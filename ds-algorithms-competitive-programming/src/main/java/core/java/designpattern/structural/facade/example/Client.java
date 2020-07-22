package core.java.designpattern.structural.facade.example;

import core.java.designpattern.structural.facade.example.pojos.Both;
import core.java.designpattern.structural.facade.example.pojos.NonVegMenu;
import core.java.designpattern.structural.facade.example.pojos.VegMenu;

public class Client
{
    public static void main (String[] args)
    {
        HotelFacade keeper = new HotelFacade();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both both = keeper.getVegNonMenu();

    }
}
