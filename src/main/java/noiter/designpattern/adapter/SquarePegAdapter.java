package noiter.designpattern.adapter;

public class SquarePegAdapter {

    private SquarePeg sp;

    public SquarePegAdapter(double w) {
        sp = new SquarePeg(w);
    }

    public void makeFit(RoundHole rh) {

        double amount = sp.getWidth() - rh.getRadius() * Math.sqrt(2);
        System.out.println("reducing SquarePeg " + sp.getWidth() + " by " + ((amount < 0) ? 0 : amount) + " amount");

        if (amount > 0) {
            sp.setWidth(sp.getWidth() - amount);
            System.out.println("   width is now " + sp.getWidth());
        }
    }
}
