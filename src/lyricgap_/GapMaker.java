package lyricgap_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This class makes gaps in the song following certain rules.
 * @author jprecreativo
 */
public abstract class GapMaker 
{
    private static int numGaps;
    private static final ArrayList<String> stopWords = new ArrayList();
    private static String song = "Why, you wanna tell me how to live my life?\n" +
                                 "Who, are you to tell me if it's black or white?\n" +
                                 "Mama, can you hear me? try to understand\n" +
                                 "Is innocence the difference between a boy and a man\n" +
                                 "My daddy lived the lie, it's just the price that he paid\n" +
                                 "Sacrificed his life, just slavin' away\n" +
                                 "\n" +
                                 "Oh, if there's one thing I hang onto\n" +
                                 "That gets me through the night\n" +
                                 "I ain't gonna do what I don't want to\n" +
                                 "I'm gonna live my life\n" +
                                 "Shining like a diamond, rolling with the dice\n" +
                                 "Standing on the ledge, I show the wind how to fly\n" +
                                 "When the world gets in my face\n" +
                                 "I say, have a nice day\n" +
                                 "Have a nice day\n" +
                                 "\n" +
                                 "Take a look around you; nothing's what it seems\n" +
                                 "We're living in the broken home of hopes and dreams\n" +
                                 "Let me be the first to shake a helping hand\n" +
                                 "Anybody brave enough to take a stand\n" +
                                 "I've knocked on every door, on every dead end street\n" +
                                 "Looking for forgiveness\n" +
                                 "What's left to believe?\n" +
                                 "\n" +
                                 "Oh, if there's one thing I hang onto\n" +
                                 "That gets me through the night\n" +
                                 "I ain't gonna do what I don't want to\n" +
                                 "I'm gonna live my life\n" +
                                 "Shining like a diamond, rolling with the dice\n" +
                                 "Standing on the ledge, I show the wind how to fly\n" +
                                 "When the world gets in my face\n" +
                                 "I say, have a nice day\n" +
                                 "Have a nice day\n" +
                                 "\n" +
                                 "Oh, if there's one thing I hang onto\n" +
                                 "That gets me through the night\n" +
                                 "I ain't gonna do what I don't want to\n" +
                                 "I'm gonna live my life\n" +
                                 "Shining like a diamond, rolling with the dice\n" +
                                 "Standing on the ledge, I show the wind how to fly\n" +
                                 "When the world gets in my face\n" +
                                 "I say, have a nice day\n" +
                                 "Have a nice day\n" +
                                 "Have a nice day\n" +
                                 "Have a nice day\n" +
                                 "Have a nice day\n" +
                                 "\n" +
                                 "When the world keeps trying, to drag me down\n" +
                                 "I've gotta raise my hands, gonna stand my ground\n" +
                                 "Well I say, have a nice day\n" +
                                 "Have a nice day\n" +
                                 "Have a nice day";
    
    /***
     * It makes the gaps.
     * @return The song with the gaps.
     */
    public static String makeGaps()
    {
        GapMaker.addStopWords();
        
        numGaps = 0;
        song = song.toUpperCase();
        String[] phrases = song.split("\n");
        List<String> wordList = Arrays.asList(song.replaceAll("\n", " ").replaceAll("\n", "").split(" "));
        ArrayList<String> wordArray = GapMaker.toWordArray(wordList);
        int numWords = wordArray.size(); 

        GapMaker.oneGapInEachParagraph(phrases, wordArray);
        
        while((float) numGaps/numWords < 0.05)
            GapMaker.doMoreGaps(wordArray);

        return song;
    }
    
    /***
     * It does gaps.
     * @param wordArray The words are erased of wordArray.
     */
    private static void doMoreGaps(ArrayList<String> wordArray)
    {
        Random ran  = new Random(System.currentTimeMillis());
        int posWord = ran.nextInt(wordArray.size());
        String word = wordArray.get(posWord);
        
        GapMaker.wordToGap(word, wordArray);
    }
    
    /***
     * Add a list of stop words to the 'stopWords' array.
     */
    private static void addStopWords()
    {
        stopWords.add("I");
        stopWords.add("YOU");
        stopWords.add("IT");
        stopWords.add("HE");
        stopWords.add("SHE");
        stopWords.add("WE");
        stopWords.add("THEY");
        stopWords.add("ME");
        stopWords.add("HIM");
        stopWords.add("US");
        stopWords.add("THEM");
        stopWords.add("MY");
        stopWords.add("YOUR");
        stopWords.add("HIS");
        stopWords.add("HER");
        stopWords.add("ITS");
        stopWords.add("OUR");
        stopWords.add("THEIR");
        
        stopWords.add("ON");
        stopWords.add("IN");
        stopWords.add("AT");
        stopWords.add("SINCE");
        stopWords.add("FOR");
        stopWords.add("AGO");
        stopWords.add("BEFORE");
        stopWords.add("TO");
        stopWords.add("PAST");
        stopWords.add("TILL");
        stopWords.add("UNTIL");
        stopWords.add("BY");
        stopWords.add("NEXT");
        stopWords.add("BESIDE");
        stopWords.add("UNDER");
        stopWords.add("BELOW");
        stopWords.add("OVER");
        stopWords.add("ABOVE");
        stopWords.add("ACROSS");
        stopWords.add("INTO");
        stopWords.add("TOWARDS");
        stopWords.add("ONTO");
        stopWords.add("FROM");
        stopWords.add("OF");
        stopWords.add("OFF");
        stopWords.add("OUT");
        
        stopWords.add("IF");
        stopWords.add("THE");
        stopWords.add("BE");
        stopWords.add("IS");
        stopWords.add("ARE");
        stopWords.add("I'M");
        stopWords.add("I'VE");
        stopWords.add("YOU'RE");
        stopWords.add("HE'S");
        stopWords.add("SHE'S");
        stopWords.add("IT'S");
        stopWords.add("WE'RE");
        stopWords.add("THEY'RE");
        stopWords.add("WILL");
        stopWords.add("I'LL");
        stopWords.add("YOU'LL");
        stopWords.add("HE'LL");
        stopWords.add("SHE'LL");
        stopWords.add("IT'LL");
        stopWords.add("WE'LL");
        stopWords.add("THEY'LL");
        stopWords.add("WON'T");
        stopWords.add("DO");
        stopWords.add("DON'T");
        stopWords.add("DOES");
        stopWords.add("DOESN'T");
        stopWords.add("WAS");
        stopWords.add("WERE");
        stopWords.add("HAVE");
        stopWords.add("HAS");
        stopWords.add("GONNA");
        stopWords.add("WANNA");
        stopWords.add("NOT");
        stopWords.add("CAN");
        stopWords.add("CAN'T");
        stopWords.add("CANNOT");
        stopWords.add("SHOULD");
        stopWords.add("MUST");
        stopWords.add("OUGTH");
        stopWords.add("SHALL");
        stopWords.add("AS");
        stopWords.add("LET'S");
        stopWords.add("MORE");
        stopWords.add("LESS");
        stopWords.add("THAN");
        stopWords.add("THAT");
        stopWords.add("NO");
        stopWords.add("YES");
        stopWords.add("WITH");
        stopWords.add("WITHOUT");
        stopWords.add("OUT");
        stopWords.add("A");
        stopWords.add("OR");
        stopWords.add("AND");
        stopWords.add("THOSE");
        stopWords.add("THIS");
        stopWords.add("THESE");
        stopWords.add("AIN'T");
    }
    
    /***
     * It adds all words in the song that are not empty to an ArrayList.
     * @param wordList List of words that also contains empty strings.
     * @return The ArrayList with the words.
     */
    private static ArrayList<String> toWordArray(List<String> wordList)
    {
        ArrayList<String> wordArray = new ArrayList();
        
        for(String word : wordList) 
            if(!"".equals(word)) 
                wordArray.add(word);
        
        return wordArray;
    }
    
    /**
     * It takes care of make at least one gap in each paragraph.
     * @param phrases The phrases of the song.
     * @param wordArray It will use in 'wordToGap'.
     */
    private static void oneGapInEachParagraph(String[] phrases, ArrayList<String> wordArray)
    {
        ArrayList<Integer> posLineBreaks = GapMaker.findLineBreaks(phrases);
        int indexParagraphBegin = 0;
        
        for(int i = 0; i < posLineBreaks.size(); i++)
        {
            if(i > 0)
                indexParagraphBegin = posLineBreaks.get(i - 1) + 1;
            
            Random ran = new Random(System.currentTimeMillis());
            int posPhrase = indexParagraphBegin + ran.nextInt(posLineBreaks.get(i) - indexParagraphBegin);
            String[] phraseWords = phrases[posPhrase].split(" ");
            String word = phraseWords[ran.nextInt(phraseWords.length)];
            
            if(!GapMaker.wordToGap(word, wordArray))
                i--;
        }
        
        // Make a gap in the last paragraph:
       
        boolean gap;
        
        do
        {
            Random ran = new Random(System.currentTimeMillis());
            String[] phraseWords = phrases[phrases.length - 1].split(" ");
            String word = phraseWords[ran.nextInt(phraseWords.length)];
            
            gap = GapMaker.wordToGap(word, wordArray);
        }
        while(!gap);
    }
    
    /***
     * It replaces the word into a gap all times that the word appears in the song.
     * @param word The word to convert in gap.
     * @param wordArray The word 'word' will be deleted of 'wordArray'.
     */
    private static boolean wordToGap(String word, ArrayList<String> wordArray)
    {
        wordArray.remove(word);
        
        String gap = "";
        
        for(int i = 0; i < word.length(); i++)
            gap += "_";
        
        if(!stopWords.contains(word))
        {
            song = song.replaceAll(word, gap);
            numGaps++;
            
            return true;
        }
        
        return false;
    }
    
    /**
     * It finds the line breaks of the song, that are the empty strings.
     * @param phrases The phrases of the song.
     * @return An int ArrayList that contains the position of line breaks.
     */
    private static ArrayList<Integer> findLineBreaks(String[] phrases)
    {
        ArrayList<Integer> lineBreaks = new ArrayList();
        
        for(int i = 0; i < phrases.length; i++)
            if("".equals(phrases[i]))
                lineBreaks.add(i);
        
        return lineBreaks;
    }
}
