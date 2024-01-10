package UMLToCode;

public class VVD extends Party{
    protected String name;
    protected int seats = 1;

    public VVD(String partyName) {
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
