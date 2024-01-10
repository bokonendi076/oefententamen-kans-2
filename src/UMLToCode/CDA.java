package UMLToCode;

public class CDA extends Party{
    protected String name;
    protected int seats = 1;

    public CDA(String partyName) {
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
