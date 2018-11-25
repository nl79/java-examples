import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> items = new ArrayList<>();
    items.add(1);
    items.add(2);
    items.add(3);
    items.add(4);
    items.add(5);

    printDoubled(items);

    FootballPlayer joe = new FootballPlayer("Joe");
    BaseballPlayer pat = new BaseballPlayer("Pat");
    SoccerPlayer beckham = new SoccerPlayer("Beckham");

    Team<FootballPlayer> adelaidCrows = new Team<>("AdelaidCrows");
    Team<BaseballPlayer> baseballTeam = new Team<>("Cubs");
    Team<SoccerPlayer> soccerTeam = new Team<>("this wont work");
    Team<FootballPlayer> melbourne = new Team<>("Melbourne");
    
    FootballPlayer banks = new FootballPlayer("Gordon");
    melbourne.addPlayer(banks);
    adelaidCrows.addPlayer(joe);
    baseballTeam.addPlayer(pat);
    soccerTeam.addPlayer(beckham);

    Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
    Team<FootballPlayer> fremantle = new Team<>("Freemantle");

    hawthorn.matchResult(fremantle, 1, 0);
    hawthorn.matchResult(adelaidCrows, 3, 8);

    adelaidCrows.matchResult(fremantle, 2, 1);
    // adelaidCrows.matchResult(baseballTeam, 1, 1);

    System.out.println(adelaidCrows.numPlayers());

    System.out.println("Rankings");
    System.out.println(adelaidCrows.getName() + " : " + adelaidCrows.ranking());
    System.out.println(melbourne.getName() + " : " + melbourne.ranking());
    System.out.println(fremantle.getName() + " : " + fremantle.ranking());
    System.out.println(hawthorn.getName() + " : " + hawthorn.ranking());

    System.out.println(adelaidCrows.compareTo(melbourne));
    System.out.println(adelaidCrows.compareTo(hawthorn));

    League<Team<FootballPlayer>> footballLeague = new League<>("AFL");
    footballLeague.add(adelaidCrows);
    footballLeague.add(melbourne);
    footballLeague.add(hawthorn);
    footballLeague.add(fremantle);

    footballLeague.showLeagueTable();
  
  }

  private static void printDoubled(ArrayList<Integer> n) {
    for(Integer i : n) {
      System.out.println(i * 2);
    }
  }

}