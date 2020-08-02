package designpattern.structural.facade.example;

import designpattern.structural.facade.example.pojos.Both;
import designpattern.structural.facade.example.pojos.NonVegMenu;
import designpattern.structural.facade.example.pojos.VegMenu;

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
