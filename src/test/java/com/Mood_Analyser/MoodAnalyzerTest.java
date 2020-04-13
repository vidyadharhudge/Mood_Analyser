package com.Mood_Analyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    MoodAnalyzer moodAnalyzer=null;

    /* Test cse 1.1 : Given I am In Sad Mood Message In Constructor Should Return Sad*/
   @Test
    public void givenMood_WhenSad_ShouldReturnSad()
   {
       moodAnalyzer=new MoodAnalyzer("i am in a Sad mood");
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Sad",mood);

   }
   /* Test cse 1.2 : Given I am In Happy Mood Message In Constructor Should Return Happy*/
   @Test
    public void givenMood_WhenHappy_ShouldReturnHappy()
   {
       moodAnalyzer=new MoodAnalyzer("i am in a Any mood");
       String mood=moodAnalyzer.analyseTheMood();
       Assert.assertEquals("Happy",mood);

   }
}
