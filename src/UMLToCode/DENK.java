package UMLToCode;

public class DENK extends Party{
    protected String name;
    protected int seats = 1;

    public DENK(String partyName) {
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
