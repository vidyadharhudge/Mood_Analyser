package com.Mood_Analyser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    /* For Default Constructor */
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

    /* parameterized Constructor */
    public static MoodAnalyzer createMoodAnalyzer(String message)
    {
        try
        {
            Constructor<?> constructor=Class.forName("com.Mood_Analyser.MoodAnalyzer").getConstructor(String.class);
            MoodAnalyzer obj=(MoodAnalyzer)constructor.newInstance(message);
            return obj;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    /* Methode For Invoking */
    public static String invokeMethode(MoodAnalyzer obj,String methodeName)
    {
        try
        {
            return (String) obj.getClass().getDeclaredMethod(methodeName).invoke(obj);
        }
        catch (NoSuchMethodException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHODE,exception.getMessage());
        }
        catch (IllegalAccessException | InvocationTargetException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }

    /* Methode For Setting Field Value */
    public static String setFieldValue(MoodAnalyzer obj,String message,String fieldName)
    {
        try
        {
            Field field=obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj,message);
            return (String) obj.getClass().getDeclaredMethod("analyseTheMood").invoke(obj);
        }
        catch (InvocationTargetException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.METHODE_INVOCATION_ISSUE,exception.getMessage());
        }
        catch(NoSuchFieldException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD,exception.getMessage());
        }
        catch (NoSuchMethodException | IllegalAccessException exception)
        {
            exception.printStackTrace();
        }
        return "message";
    }

    /* Exception Methode */
    public static Constructor<?>getConstructor(String className ,Class constructor) throws MoodAnalyzerException
    {
        try
        {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(constructor);
        }
        catch (ClassNotFoundException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,exception.getMessage());
        }
        catch (NoSuchMethodException exception)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHODE,exception.getMessage());
        }
    }

}
