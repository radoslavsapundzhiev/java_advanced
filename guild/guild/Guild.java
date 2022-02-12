package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if(this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player: this.roster) {
            if(player.getName().equals(name)) {
                return this.roster.remove(player);
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player: this.roster) {
            if(player.getName().equals(name)) {
                if(!player.getRank().equals("Member")) {
                    player.setRank("Member");
                }
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player: this.roster) {
            if(player.getName().equals(name)) {
                if(!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                }
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        for (Player player: this.roster) {
            if(player.getClazz().equals(clazz)) {
                kickedPlayers.add(player);
            }
        }
        Player[] kickedPlayersArray = new Player[kickedPlayers.size()];
        for (int i = 0; i < kickedPlayers.size(); i++) {
            this.roster.remove(kickedPlayers.get(i));
            kickedPlayersArray[i] = kickedPlayers.get(i);
        }
        return kickedPlayersArray;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:", this.name))
                .append(System.lineSeparator());
        for (Player player: this.roster) {
            builder.append(player).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
