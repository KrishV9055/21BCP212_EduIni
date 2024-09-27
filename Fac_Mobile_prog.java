package DP;

interface Mobile
{
    void print_OS();
}

class Samsung implements Mobile
{
    public void print_OS()
    {
        System.out.println("OS: Android");
    }
}
class IPhone implements Mobile
{
    public void print_OS()
    {
        System.out.println("OS: IOS");
    }
}
class Nokia implements Mobile
{
    public void print_OS()
    {
        System.out.println("OS: Windows");
    }
}
class mobile_factory
{
    Mobile create_mobile(String S)
    {
        if(S.equalsIgnoreCase("Samsung"))
        {
            return new Samsung();
        }
        else if(S.equalsIgnoreCase("IPhone"))
        {
            return new IPhone();
        }
        else
        {
            return new Nokia();
        }
    }
}
public class Fac_Mobile_prog {
    public static void main(String[] args) {
        mobile_factory mb1 = new mobile_factory();
        Mobile m1=mb1.create_mobile("Samsung");
        m1.print_OS();
        Mobile m2=mb1.create_mobile("IPhone");
        m2.print_OS();
        Mobile m3=mb1.create_mobile("Nokia");
        m3.print_OS();
    }
}