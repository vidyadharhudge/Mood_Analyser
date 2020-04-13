package com.Mood_Analyser;

public class MoodAnalyzer
{
    private String message;

    /* parameterised constructor*/
    public MoodAnalyzer(String message)
    {
        this.message = message;
    }

    /*If Message Contains Sad Return Sad Else Return Happy*/
    public String analyseTheMood()
    {
        if (message.contains("Sad"))
        {
            return "Sad";
        }
        else
        {
            return "Happy";
        }
    }
}
