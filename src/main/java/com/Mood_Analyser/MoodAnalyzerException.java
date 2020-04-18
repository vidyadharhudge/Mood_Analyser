package com.Mood_Analyser;

public class MoodAnalyzerException extends RuntimeException
{
    /* Enum Methode For IS_EMPTY and IS_NULL*/
    public enum ExceptionType
    {
        EMPTY,NULL,NO_SUCH_CLASS,NO_SUCH_METHODE,NO_SUCH_FIELD,METHODE_INVOCATION_ISSUE;
    }
    public final ExceptionType type;

   public MoodAnalyzerException(ExceptionType type,String Message)
    {
      super(Message);
      this.type=type;
    }
}
