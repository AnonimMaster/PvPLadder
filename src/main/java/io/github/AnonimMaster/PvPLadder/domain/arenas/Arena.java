package io.github.AnonimMaster.PvPLadder.domain.arenas;

import org.bukkit.Location;

public class Arena {
    private String title;
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    private boolean enabled = false;
    
    public boolean isEnabled(){
        return enabled;
    }
    
    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }
    
    private int timeToPrepare = 60;
    
    public int getTimeToPrepare(){
        return timeToPrepare;
    }
    
    public void setTimeToPrepare(int timeToPrepare){
        this.timeToPrepare = timeToPrepare;
    }

    private Location lobbyTeam1Pos1;
    
    public Location getLobbyTeam1Pos1(){
        return lobbyTeam1Pos1;
    }
    
    public void setLobbyTeam1Pos1(Location lobbyTeam1Pos1){
        this.lobbyTeam1Pos1 = lobbyTeam1Pos1;
    }
    
    private Location lobbyTeam1Pos2;
    
    public Location getLobbyTeam1Pos2(){
        return lobbyTeam1Pos2;
    }
    
    public void setLobbyTeam1Pos2(Location lobbyTeam1Pos2){
        this.lobbyTeam1Pos2 = lobbyTeam1Pos2;
    }

    private Location lobbyTeam2Pos1;
    
    public Location getLobbyTeam2Pos1(){
        return lobbyTeam2Pos1;
    }
    
    public void setLobbyTeam2Pos1(Location lobbyTeam2Pos1){
        this.lobbyTeam2Pos1 = lobbyTeam2Pos1;
    }
    
    private Location lobbyTeam2Pos2;
    
    public Location getLobbyTeam2Pos2(){
        return lobbyTeam2Pos2;
    }
    
    public void setLobbyTeam2Pos2(Location lobbyTeam2Pos2){
        this.lobbyTeam2Pos2 = lobbyTeam2Pos2;
    }

    private boolean support1x1;
    
    public boolean isSupport1x1(){
        return support1x1;
    }
    
    public void setSupport1x1(boolean support1x1){
        this.support1x1 = support1x1;
    }
    
    private boolean support2x2;
    
    public boolean isSupport2x2(){
        return support2x2;
    }
    
    public void setSupport2x2(boolean support2x2){
        this.support2x2 = support2x2;
    }
    
    private boolean support3x3;
    
    public boolean isSupport3x3(){
        return support3x3;
    }
    
    public void setSupport3x3(boolean support3x3){
        this.support3x3 = support3x3;
    }

    private Location EndPos;
    
    public Location getEndPos(){
        return EndPos;
    }
    
    public void setEndPos(Location EndPos){
        this.EndPos = EndPos;
    }

    private Location arenaPos1;
    
    public Location getArenaPos1(){
        return arenaPos1;
    }
    
    public void setArenaPos1(Location arenaPos1){
        this.arenaPos1 = arenaPos1;
    }
    
    private Location arenaPos2;
    
    public Location getArenaPos2(){
        return arenaPos2;
    }
    
    public void setArenaPos2(Location arenaPos2){
        this.arenaPos2 = arenaPos2;
    }
    
    public Arena(){
        
    }
    
    public Arena(String title, boolean enabled, Location lobbyTeam1Pos1, Location lobbyTeam1Pos2, Location lobbyTeam2Pos1, Location lobbyTeam2Pos2, boolean support1x1, boolean support2x2, boolean support3x3, Location endPos, Location arenaPos1, Location arenaPos2) {
        this.title = title;
        this.enabled = enabled;
        this.lobbyTeam1Pos1 = lobbyTeam1Pos1;
        this.lobbyTeam1Pos2 = lobbyTeam1Pos2;
        this.lobbyTeam2Pos1 = lobbyTeam2Pos1;
        this.lobbyTeam2Pos2 = lobbyTeam2Pos2;
        this.support1x1 = support1x1;
        this.support2x2 = support2x2;
        this.support3x3 = support3x3;
        this.EndPos = endPos;
        this.arenaPos1 = arenaPos1;
        this.arenaPos2 = arenaPos2;
    }
}
