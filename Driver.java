import Core.Team;
import Helper.PrintHelper;

import java.util.*;

public class Driver {


    public static void main(String[] args) {

        int players = 5;
        int overs = 2;

        Team T1 = new Team(1, players);
        T1.setBattingOrder(Arrays.asList(1, 2, 3, 4, 5));
        List<String> Over = Arrays.asList("1", "1", "1", "1", "1", "2");
        List<String> Over2 = Arrays.asList("W", "4", "4", "Wd", "W", "1", "6");

        playOver(T1, Over);
        PrintHelper.printScoreCard(T1);

        playOver(T1, Over2);
        PrintHelper.printScoreCard(T1);

        Team T2 = new Team(2, players);
        T2.setBattingOrder(Arrays.asList(6, 7, 8, 9, 10));
        List<String> Over3 = Arrays.asList("4", "6", "W", "W", "1", "1");
        List<String> Over4 = Arrays.asList("6", "1", "W", "W");

        playOver(T2, Over3);
        PrintHelper.printScoreCard(T2);

        playOver(T2, Over4);
        PrintHelper.printScoreCard(T2);

        PrintHelper.printWinningTeam(T1, T2);

    }

    public static void playOver(Team currentPlayingTeam, List<String> oversPlayArray){
        oversPlayArray.forEach(run -> {
            if(isNumeric(run)){
                currentPlayingTeam.runsScored(Integer.parseInt(run));
            } else if(run.equals("Wd")){
                currentPlayingTeam.wideBallPlayed();
            } else if(run.equals("W")){
                currentPlayingTeam.playerOut();
            }
        });
        currentPlayingTeam.strikeChange();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
