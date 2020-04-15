package com.Mood_Analyser;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    MoodAnalyzer moodAnalyzer=null;

    /* Test cse 1.1 : Given I am In Sad Mood Message In Constructor Should Return Sad*/
   @Test
   public void givenMessage_InConstuctor_WhenContainsSadMood_ShouldReturnSad()
   {

       moodAnalyzer=new MoodAnalyzer("i am in a Sad mood");
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Sad",mood);
   }

   /* Test cse 1.2 : Given I am In Happy Mood Message In Constructor Should Return Happy*/
   @Test
    public void givenMessage_InConstuctor_WhenContainsAnyMood_ShouldReturnHappy()
   {
       moodAnalyzer=new MoodAnalyzer("i am in a Any mood");
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Happy",mood);
   }

   /* Test cse 3.1 : Given Empty Mood Should Throw MoodAnalyzerException Indicating Empty Mood*/
   @Test
   public void givenMessage_InConstuctor_WhenEmpty_ShouldThrowMoodAnalyzerException()
   {
       String Message = " ";
       try
       {
           moodAnalyzer = new MoodAnalyzer(Message);
           String mood = moodAnalyzer.analyseTheMood();
       }
       catch (MoodAnalyzerException exception)
       {
           Assert.assertEquals("Mood Cannot Be IS_EMPTY ,Please Enter Proper Mood", exception.type);
       }
   }

    /* Test cse 3.2 : Given Null Mood Should Throw MoodAnalyzerException */
    @Test
    public void givenMessage_InConstuctor_WhenNull_ShouldThrowMoodAnalyzerException()
    {
        try
        {
            moodAnalyzer = new MoodAnalyzer(null);
            String mood = moodAnalyzer.analyseTheMood();
        }
        catch (MoodAnalyzerException exception)
        {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.IS_NULL, exception.type);
        }
    }
}
