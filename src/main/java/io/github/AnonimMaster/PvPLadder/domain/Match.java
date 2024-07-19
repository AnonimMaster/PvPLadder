package io.github.AnonimMaster.PvPLadder.domain;

import io.github.AnonimMaster.PvPLadder.domain.enums.Teams;

import java.util.ArrayList;
import java.util.UUID;

public class Match {
    public ArrayList<UUID> TeamBlue;
    public ArrayList<UUID> TeamRed;
    public Teams WinnerTeam;
    
}
