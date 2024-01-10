package UMLToCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoalitionScout {
    private String name;
    private List<String> possibilities;
    private Map<Party, Integer> electionResult;

    public CoalitionScout(String name) {
        this.name = name;
    }

    private void addPossibility(Party lead, List<Party> others) {
        StringBuilder sb = new StringBuilder();

        sb.append(lead);
        sb.append(" wil coalitieverkenning met: ");
        
        for (Party party : others) {
            sb.append(party);
            sb.append(", ");
        }

        possibilities.add(sb.toString());

    }

    private List<Party> findPartners(Party lead, List<Party> others) {
        List<Party> potentialPartners = new ArrayList<>();
        int currentSeats = lead.getSeats();

        for (Party party : others) {

            int totalSeats = currentSeats += party.getSeats();
            if (totalSeats >= 76) {
                potentialPartners.add(party);
            }
        }

        return potentialPartners;
    }

    public void finalizeElection(Map<Party, Integer> result) {
       for (Map.Entry<Party, Integer> entry : result.entrySet()) {

           Party party = entry.getKey();
           int votes = entry.getValue();

           electionResult.put(party, votes);
       }     

    }

    public void exploreCoalitions() {

    }

    public void leakDocuments() {
        System.out.println("Mogelijke coalities gevormd door" + this.name + ":");

        for (String possibility : possibilities) {
            System.out.println(possibility);
        }

    }

    
}
