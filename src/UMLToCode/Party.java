package UMLToCode;

import java.util.List;

public class Party {
    protected List<Party> excludedParties;

    // public Party(Party excludedParties) {
    //     this.excludedParties.add(excludedParties);
    // }

    public List<Party> getExcludedParties() {
        return this.excludedParties;
    }

    public void setExcludedParties(List<Party> excludedParties) {
        this.excludedParties = excludedParties;
    }

    public String getName() {
        return "Unkown Party";
    }

    public int getSeats() {
        return 0;
    }

    



    
}
