package com.springbootprojects.myfirstproject;

public class HeroesQuotes {

    private String myQuote;

    public HeroesQuotes(String myQuote) {
        this.myQuote = myQuote;
    }

    public String customQuote() {
        return myQuote;
    }

    public String batmanQuote() {
        return "Death Is Powerless Against You If You Leave A Legacy Of Good Behind.";
    }

    public String captainMarvelQuote() {
        return "I make my decisions. I make my reality. And my reality is...I am...Captain Marvel!";
    }
}
