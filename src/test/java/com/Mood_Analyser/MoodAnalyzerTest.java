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

    /* Test cse 2.1 : Given message is In Constructor Should Return Happy*/
    @Test
    public void givenMessage_InConstuctor_WhenContainsNull_ShouldReturnHappy()
   {
       moodAnalyzer=new MoodAnalyzer(null);
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Happy",mood);
   }


}
