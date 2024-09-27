package DP;

interface Icecream {
    void type();
}

abstract class Toppings implements Icecream {
    protected Icecream newIceCream;

    public Toppings(Icecream newIceCream) {
        this.newIceCream = newIceCream;
    }

    public void type() {
        newIceCream.type();
    }
}


class JellyTopping extends Toppings {
    public JellyTopping(Icecream newIceCream) {
        super(newIceCream);
    }

    private void Nuts(Icecream newIceCream) {
        System.out.println("Jelly has been added in the ice-cream as a topping");
    }

    public void type() {
        newIceCream.type();
        Nuts(newIceCream);
    }
}

class VanilaIcecream implements Icecream {
    public void type() {
        System.out.println("Ice cream : Vanilla");
    }
}

class ChocolateIcecream implements Icecream {
    public void type() {
        System.out.println("Ice cream : Chocolate");
    }
}

class Decorator_R_IceCream_prog {
    public static void main(String[] args) {
        System.out.println();
        Icecream i1 = new VanilaIcecream();
        i1.type();
        Icecream i2 = new ChocolateIcecream();
        i2.type();

        System.out.println();
        Icecream t1 = new JellyTopping(i1);
        t1.type();

        System.out.println();
        Icecream t2 = new JellyTopping(i2);
        t2.type();
    }
}