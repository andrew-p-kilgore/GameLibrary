package com.jtakdn.gameLibrary.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Loan
{

    
    private String loanId;
    @NotNull
    @NotBlank(message = "Game ID is mandatory.")
    private String gameId;
    @NotNull
    @NotBlank(message = "Customer ID is mandatory.")
    private String customerId;
    @NotNull
    @NotBlank(message = "Start Date is mandatory.")
    private String startDate; // These two can be changed to a Date format
    @NotNull
    @NotBlank(message = "End Date is mandatory.")
    private String endDate;
    private String cost;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost){
        this.cost = cost;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cost == null) ? 0 : cost.hashCode());
        result = prime * result
                + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((gameId == null) ? 0 : gameId.hashCode());
        result = prime * result + ((loanId == null) ? 0 : loanId.hashCode());
        result = prime * result
                + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Loan other = (Loan) obj;
        if (cost == null)
        {
            if (other.cost != null) return false;
        }
        else
            if (!cost.equals(other.cost)) return false;
        if (customerId == null)
        {
            if (other.customerId != null) return false;
        }
        else
            if (!customerId.equals(other.customerId)) return false;
        if (endDate == null)
        {
            if (other.endDate != null) return false;
        }
        else
            if (!endDate.equals(other.endDate)) return false;
        if (gameId == null)
        {
            if (other.gameId != null) return false;
        }
        else
            if (!gameId.equals(other.gameId)) return false;
        if (loanId == null)
        {
            if (other.loanId != null) return false;
        }
        else
            if (!loanId.equals(other.loanId)) return false;
        if (startDate == null)
        {
            if (other.startDate != null) return false;
        }
        else
            if (!startDate.equals(other.startDate)) return false;
        return true;
    }
    
    
}
