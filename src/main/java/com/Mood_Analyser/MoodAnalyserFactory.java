package com.Mood_Analyser;
import java.lang.reflect.Constructor;

public class MoodAnalyserFactory
{
    public static MoodAnalyzer createMoodAnalyzer()
    {
        try
        {
            Constructor<?> constructor=Class.forName("com.Mood_Analyser.MoodAnalyzer").getConstructor();
            MoodAnalyzer obj=(MoodAnalyzer)constructor.newInstance();
            return obj;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
    public static Constructor<?>getConstructor(String className ,Class constructor) throws MoodAnalyzerException
    {
        try
        {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(constructor);
        }
        catch (ClassNotFoundException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.CLASS_NOT_FOUND,exception.getMessage());
        }
        catch (NoSuchMethodException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.METHOD_NOT_FOUND,exception.getMessage());
        }
    }
}
