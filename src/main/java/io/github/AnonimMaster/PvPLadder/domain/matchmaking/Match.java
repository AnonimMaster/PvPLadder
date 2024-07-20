package io.github.AnonimMaster.PvPLadder.domain.matchmaking;

import io.github.AnonimMaster.PvPLadder.domain.arenas.Arena;

import java.util.ArrayList;
import java.util.UUID;

public class Match {
    public ArrayList<UUID> TeamBlue;
    public ArrayList<UUID> TeamRed;
    public Teams WinnerTeam;
    public MatchState state;
    public Arena arena;
}
