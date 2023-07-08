package com.example.Voting_APP;

public class Treasurer {
    public Object setVote;

    public String getVote() {
        return Vote;
    }

    public void setVote(String vote) {
        Vote = vote;
    }

    private String Vote;

    private Object DataSnapshot;

    private Object DatabaseError;
    public Treasurer(Object dataSnapshot, Object databaseError){

        DataSnapshot = dataSnapshot;
        DatabaseError = databaseError;
    }
}
