package com.Mood_Analyser;
import com.Mood_Analyser.MoodAnalyzerException;

public class MoodAnalyzer
{
    private String message;

    /* Default constructor*/
    public MoodAnalyzer()
    {
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
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.IS_EMPTY, "Mood Cannot Be IS_EMPTY ,Please Enter Proper Mood");
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
        catch(NullPointerException e)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.IS_NULL,"Mood Cannot Be IS_NULL,Please Enter Proper Mood");

        }
    }
}