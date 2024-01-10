package UMLToCode;

public class D66 extends Party{
    protected String name;
    protected int seats = 1;

    public D66(String partyName) {
        this.name = partyName;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getSeats() {
        return this.seats;
    }
}
