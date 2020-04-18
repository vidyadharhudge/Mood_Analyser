package com.Mood_Analyser;

public class MoodAnalyzer
{
    private String message;
    /* Default constructor*/
    public MoodAnalyzer()
    {
        message = "Default";
    }
    /* parameterised constructor*/
    public MoodAnalyzer(String message)
    {
        this.message = message;
    }
    /*If Message Contains Sad Return Sad Else Return Happy*/
    public String analyseTheMood()
    {
        try
        {
            if (message.length() == 0)
            {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.EMPTY, "Mood Cannot Be EMPTY ,Please Enter Valid Mood");
            }
            if (message.contains("Sad"))
            {
                return "Sad";
            }
            else
            {
                return "Happy";
            }
        }
        catch (NullPointerException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL, "Mood Cannot Be NULL,Please Enter Valid Mood");
        }
    }
    /* Comparing two objects*/
    @Override
    public boolean equals(Object another)
    {
        if (this.message.equals(((MoodAnalyzer) another).message))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}