package com.jtakdn.gameLibrary.dto;

public class Game {

    private String gameId;
    private String gameName;
    private String gameGenre;
    private String gamePlatform;
    private String gameYear;
    private String gamePublisher;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public String getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(String gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public String getGameYear() {
        return gameYear;
    }

    public void setGameYear(String gameYear) {
        this.gameYear = gameYear;
    }

    public String getGamePublisher() {
        return gamePublisher;
    }

    public void setGamePublisher(String gamePublisher){
        this.gamePublisher = gamePublisher;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((gameGenre == null) ? 0 : gameGenre.hashCode());
        result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
        result = prime * result
                + ((gameName == null) ? 0 : gameName.hashCode());
        result = prime * result
                + ((gamePlatform == null) ? 0 : gamePlatform.hashCode());
        result = prime * result
                + ((gamePublisher == null) ? 0 : gamePublisher.hashCode());
        result = prime * result
                + ((gameYear == null) ? 0 : gameYear.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Game other = (Game) obj;
        if (gameGenre == null)
        {
            if (other.gameGenre != null) return false;
        }
        else
            if (!gameGenre.equals(other.gameGenre)) return false;
        if (gameId == null)
        {
            if (other.gameId != null) return false;
        }
        else
            if (!gameId.equals(other.gameId)) return false;
        if (gameName == null)
        {
            if (other.gameName != null) return false;
        }
        else
            if (!gameName.equals(other.gameName)) return false;
        if (gamePlatform == null)
        {
            if (other.gamePlatform != null) return false;
        }
        else
            if (!gamePlatform.equals(other.gamePlatform)) return false;
        if (gamePublisher == null)
        {
            if (other.gamePublisher != null) return false;
        }
        else
            if (!gamePublisher.equals(other.gamePublisher)) return false;
        if (gameYear == null)
        {
            if (other.gameYear != null) return false;
        }
        else
            if (!gameYear.equals(other.gameYear)) return false;
        return true;
    }

    
}
