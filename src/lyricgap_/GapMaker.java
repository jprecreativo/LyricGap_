package lyricgap_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.lang.model.element.Element;

/**
 * This class makes gaps in the song following certein rules.
 * @author jprecreativo
 */
public abstract class GapMaker 
{
    private static String song = "I'm here alone\n\nSick of love\nmy ear is sick of love";

    public static String makeGaps()
    {
        String[] phrases = song.split("\n");
        List<String> wordList = Arrays.asList(song.replaceAll("\n", " ").replaceAll("\n", "").split(" "));
        ArrayList<String> wordArray = GapMaker.toWordArray(wordList);
        int numWords = wordArray.size(), numGaps = 0;
        
        System.out.println("");
        
        return song;
    }
    
    private static ArrayList<String> toWordArray(List<String> wordList)
    {
        ArrayList<String> wordArray = new ArrayList();
        
        for (String word : wordList) 
            if (!"".equals(word)) 
                wordArray.add(word);
        
        return wordArray;
    }
    
    private static void oneGapInEachParagraph(String[] prases)
    {
        
    }
}
