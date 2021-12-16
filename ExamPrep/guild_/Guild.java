package ExamPrep.guild_;

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
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).toArray(Player[]::new);
        this.roster.removeIf(p -> p.getClazz().equals(clazz));
        return removed;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the ExamPrep.guild: ").append(name).append(":\n");
        this.roster.forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }
}
