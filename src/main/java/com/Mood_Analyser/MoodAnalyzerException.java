package com.Mood_Analyser;

public class MoodAnalyzerException extends RuntimeException
{
    /* Enum Methode For IS_EMPTY and IS_NULL*/
    public enum ExceptionType
    {
        IS_EMPTY,IS_NULL;
    }
    public final ExceptionType type;

   public MoodAnalyzerException(ExceptionType type,String Message)
    {
      super(Message);
      this.type=type;
    }
}
