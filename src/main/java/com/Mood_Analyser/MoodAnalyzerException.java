package com.Mood_Analyser;

public class MoodAnalyzerException extends RuntimeException
{
    /* Enum Methode For IS_EMPTY and IS_NULL*/
    public enum ExceptionType
    {
        EMPTY,NULL,CLASS_NOT_FOUND,METHOD_NOT_FOUND;
    }
    public final ExceptionType type;

   public MoodAnalyzerException(ExceptionType type,String Message)
    {
      super(Message);
      this.type=type;
    }
}
