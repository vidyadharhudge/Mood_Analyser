package com.Mood_Analyser;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest
{
    MoodAnalyzer moodAnalyzer=null;

    /* Test cse 1.1 : Given I am In Sad Mood Message In Constructor Should Return Sad*/
   @Test
   public void givenMessage_InConstuctor_WhenContainsSadMood_ThenShouldReturnSad()
   {
       moodAnalyzer=new MoodAnalyzer("i am in a Sad mood");
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Sad",mood);
   }

   /* Test cse 1.2 : Given I am In Happy Mood Message In Constructor Should Return Happy*/
   @Test
    public void givenMessage_InConstuctor_WhenContainsAnyMood_ThenShouldReturnHappy()
   {
       moodAnalyzer=new MoodAnalyzer("i am in a Any mood");
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Happy",mood);
   }

   /* Test cse 3.1 : Given Empty Mood Should Throw MoodAnalyzerException Indicating Empty Mood*/
   @Test
   public void givenMessage_InConstuctor_WhenEmpty_ThenShouldThrowMoodAnalyzerException()
   {
       String Message = " ";
       try
       {
           moodAnalyzer = new MoodAnalyzer(Message);
           String mood = moodAnalyzer.analyseTheMood();
       }
       catch (MoodAnalyzerException exception)
       {
           Assert.assertEquals("Mood Cannot Be EMPTY ,Please Enter Valid Mood", exception.type);
       }
   }

    /* Test cse 3.2 : Given Null Mood Should Throw MoodAnalyzerException */
    @Test
    public void givenMessage_InConstuctor_WhenNull_ThenShouldThrowMoodAnalyzerException()
    {
        try
        {
            moodAnalyzer = new MoodAnalyzer(null);
            String mood = moodAnalyzer.analyseTheMood();
        }
        catch (MoodAnalyzerException exception)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NULL, exception.type);
        }
    }

    /* Reflection Code */
    @Test
    public void givenMessageInConstructorUsingReflection_WhenContainsAnyMood_ShouldReturnHappy() {
        try
        {
            Constructor<?> constructor = Class.forName("com.Mood_Analyser.MoodAnalyzer").getConstructor(String.class);
            MoodAnalyzer moodAnalyser = (MoodAnalyzer) constructor.newInstance("I am in Happy Mood");
            /* analyseTheMood Is The Methode */
            String mood = moodAnalyser.analyseTheMood();
            Assert.assertEquals("Happy", mood);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /* 4.1 Given MoodAnalyser Class Name Should Return MoodAnalyser object*/
    @Test
    public void givenMoodAnalyzerClassUsingDefaultConstructor_WhenProper_ThenShouldReturnObject()
    {
        try
        {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzer(),reflectionMoodObject);
        }
        catch (MoodAnalyzerException exception)
        {
            exception.printStackTrace();
        }
    }

    /* 4.2 Given Class Name Is Inproper Should Throw MoodAnalyzer Exception */
    @Test
    public void givenClassName_WhenImproper_ThenShouldReturnMoodAnalyzerException()
    {
        try
        {
            MoodAnalyserFactory.getConstructor("com.Mood_Analyser.MoodAnalyzer",String.class);
        }
        catch (MoodAnalyzerException exception)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,exception.type);
        }
    }

    /* 4.3 Given Class When Constructor Not Proper Should Throw MoodAnalyzer Exception */
    @Test
    public void givenClassName_WhenConstructorNotproper_ThenShouldReturnMoodAnalyzerException()
    {
        try
        {
            MoodAnalyserFactory.getConstructor("com.Mood_Analyser.MoodAnalyzer",String.class);
        }
        catch (MoodAnalyzerException exception)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHODE,exception.type);
        }

    }

    /*  Test Case :5.1 Given MoodAnalyzer Is Proper Return MoodAnalyzer Object */
    /* 5.2,5.3 test case is same as Test Case 4.2,4.3 */
    @Test
    public void givenMoodAnalyzerClassUsingParameterizedConstructor_WhenProper_ThenShouldReturnObject()
    {
        try
        {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer("I Am In Happy Mood");
            Assert.assertEquals(new MoodAnalyzer("I Am In Happy Mood"),reflectionMoodObject);
        }
        catch (MoodAnalyzerException exception)
        {
            exception.printStackTrace();
        }

    }

    /* Test Case 6.1 :Given Happy Message Using Reflection When Proper Should Return Happy Mood */
    @Test
    public void givenProperMethodName_WhenInvoked_ThenShouldReturnHappy()
    {
        try
        {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer("I Am In Happy Mood");
            String mood=MoodAnalyserFactory.invokeMethode(reflectionMoodObject,"analyseTheMood");
            Assert.assertEquals( "Happy",mood);
        }
        catch (MoodAnalyzerException exception)
        {
            exception.printStackTrace();
        }
    }

    /* Test Case 6.2 :Given Happy Message When ImProper Method Should Throw MoodAnalyzerException */
    @Test
    public void givenMethodName_WhenNotProper_ThenShouldThrowMoodAnalyzerException()
    {
        try
        {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer("I Am In Happy Mood");
            MoodAnalyserFactory.invokeMethode(reflectionMoodObject,"analyseTheMood1");
        }
        catch (MoodAnalyzerException exception)
        {
           Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHODE,exception.type);
        }

    }

    /* Test Case 7.1 :Set Happy Message With Reflector Should Return Happy Mood */
    @Test
    public void givenFieldNameAndItsValue_WhenProper_ThenShouldReturnValue()
    {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer();
            String mood=MoodAnalyserFactory.setFieldValue(reflectionMoodObject,"I Am In Happy Mood","message");
            Assert.assertEquals( "Happy",mood);
    }

    /* Test Case 7.2 : Set Field  When ImProper Should Throw Exception With No Such Field */
    @Test
    public void givenFieldNameAndItsValue_WhenFieldNotFound_ThenShouldThrowMoodAnalyzerException()
    {
        try
        {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer();
            MoodAnalyserFactory.setFieldValue(reflectionMoodObject,"Happy","message1");
        }
        catch (MoodAnalyzerException exception)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD,exception.type);
        }

    }

    /* Test Case 7.3 : Set Null Message  With Reflector Should Throw Exception */
    @Test
    public void givenFieldNameAndNullValue_ThenShouldThrowMoodAnalyzerException()
    {
        try
        {
            MoodAnalyzer reflectionMoodObject=MoodAnalyserFactory.createMoodAnalyzer();
            MoodAnalyserFactory.setFieldValue(reflectionMoodObject,"null","message");
        }
        catch (MoodAnalyzerException exception)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.METHODE_INVOCATION_ISSUE,exception.type);
        }

    }








}
