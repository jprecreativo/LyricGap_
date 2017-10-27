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
    protected static final ArrayList<String> STOP_WORDS = new ArrayList();
    protected static String song;
    
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
        
        while((float) numGaps/numWords < 0.045)
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
     * Add a list of stop words to the 'STOP_WORDS' array.
     */
    private static void addStopWords()
    {
        STOP_WORDS.add("I");
        STOP_WORDS.add("YOU");
        STOP_WORDS.add("IT");
        STOP_WORDS.add("HE");
        STOP_WORDS.add("SHE");
        STOP_WORDS.add("WE");
        STOP_WORDS.add("THEY");
        STOP_WORDS.add("ME");
        STOP_WORDS.add("HIM");
        STOP_WORDS.add("US");
        STOP_WORDS.add("THEM");
        STOP_WORDS.add("MY");
        STOP_WORDS.add("YOUR");
        STOP_WORDS.add("HIS");
        STOP_WORDS.add("HER");
        STOP_WORDS.add("ITS");
        STOP_WORDS.add("OUR");
        STOP_WORDS.add("THEIR");
        
        STOP_WORDS.add("ON");
        STOP_WORDS.add("IN");
        STOP_WORDS.add("AT");
        STOP_WORDS.add("SINCE");
        STOP_WORDS.add("FOR");
        STOP_WORDS.add("AGO");
        STOP_WORDS.add("BEFORE");
        STOP_WORDS.add("TO");
        STOP_WORDS.add("PAST");
        STOP_WORDS.add("TILL");
        STOP_WORDS.add("UNTIL");
        STOP_WORDS.add("BY");
        STOP_WORDS.add("NEXT");
        STOP_WORDS.add("BESIDE");
        STOP_WORDS.add("UNDER");
        STOP_WORDS.add("BELOW");
        STOP_WORDS.add("OVER");
        STOP_WORDS.add("ABOVE");
        STOP_WORDS.add("ACROSS");
        STOP_WORDS.add("INTO");
        STOP_WORDS.add("TOWARDS");
        STOP_WORDS.add("ONTO");
        STOP_WORDS.add("FROM");
        STOP_WORDS.add("OF");
        STOP_WORDS.add("OFF");
        STOP_WORDS.add("OUT");
        
        STOP_WORDS.add("IF");
        STOP_WORDS.add("THE");
        STOP_WORDS.add("BE");
        STOP_WORDS.add("IS");
        STOP_WORDS.add("ARE");
        STOP_WORDS.add("I'M");
        STOP_WORDS.add("I'VE");
        STOP_WORDS.add("YOU'RE");
        STOP_WORDS.add("HE'S");
        STOP_WORDS.add("SHE'S");
        STOP_WORDS.add("IT'S");
        STOP_WORDS.add("WE'RE");
        STOP_WORDS.add("THEY'RE");
        STOP_WORDS.add("WILL");
        STOP_WORDS.add("I'LL");
        STOP_WORDS.add("YOU'LL");
        STOP_WORDS.add("HE'LL");
        STOP_WORDS.add("SHE'LL");
        STOP_WORDS.add("IT'LL");
        STOP_WORDS.add("WE'LL");
        STOP_WORDS.add("THEY'LL");
        STOP_WORDS.add("WON'T");
        STOP_WORDS.add("DO");
        STOP_WORDS.add("DON'T");
        STOP_WORDS.add("DOES");
        STOP_WORDS.add("DOESN'T");
        STOP_WORDS.add("WAS");
        STOP_WORDS.add("WERE");
        STOP_WORDS.add("HAVE");
        STOP_WORDS.add("HAS");
        STOP_WORDS.add("GONNA");
        STOP_WORDS.add("WANNA");
        STOP_WORDS.add("NOT");
        STOP_WORDS.add("CAN");
        STOP_WORDS.add("CAN'T");
        STOP_WORDS.add("CANNOT");
        STOP_WORDS.add("SHOULD");
        STOP_WORDS.add("MUST");
        STOP_WORDS.add("OUGTH");
        STOP_WORDS.add("SHALL");
        STOP_WORDS.add("AS");
        STOP_WORDS.add("LET'S");
        STOP_WORDS.add("MORE");
        STOP_WORDS.add("LESS");
        STOP_WORDS.add("THAN");
        STOP_WORDS.add("THAT");
        STOP_WORDS.add("NO");
        STOP_WORDS.add("YES");
        STOP_WORDS.add("WITH");
        STOP_WORDS.add("WITHOUT");
        STOP_WORDS.add("OUT");
        STOP_WORDS.add("A");
        STOP_WORDS.add("OR");
        STOP_WORDS.add("AND");
        STOP_WORDS.add("THOSE");
        STOP_WORDS.add("THIS");
        STOP_WORDS.add("THESE");
        STOP_WORDS.add("AIN'T");
        STOP_WORDS.add("O");
        STOP_WORDS.add("AM");
        STOP_WORDS.add("ONE");
        STOP_WORDS.add("TWO");
        STOP_WORDS.add("THREE");
        STOP_WORDS.add("FOUR");
        STOP_WORDS.add("FIVE");
        STOP_WORDS.add("SIX");
        STOP_WORDS.add("SEVEN");
        STOP_WORDS.add("EIGHT");
        STOP_WORDS.add("NINE");
        STOP_WORDS.add("TEN");
        STOP_WORDS.add("THING");
        STOP_WORDS.add("EVERY");
        STOP_WORDS.add("SOME");
        STOP_WORDS.add("TIME");
        STOP_WORDS.add("ANY");
        STOP_WORDS.add("JUST");
        STOP_WORDS.add("UP");
        STOP_WORDS.add("DOWN");
        STOP_WORDS.add("WHEN");
        STOP_WORDS.add("WHERE");
        STOP_WORDS.add("WHO");
        STOP_WORDS.add("WHY");
        STOP_WORDS.add("WHAT");
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
       
        String word;
        ArrayList<String> lastParagraphWords = new ArrayList();
        int indexLastParagraph = GapMaker.findLineBreaks(phrases).get(findLineBreaks(phrases).size() - 1);
        
        for(int i = indexLastParagraph + 1; i < phrases.length; i++)
            lastParagraphWords.addAll(Arrays.asList(phrases[i].split(" ")));
        
        do
        {
            Random ran = new Random(System.currentTimeMillis());
            
            word = lastParagraphWords.get(ran.nextInt(lastParagraphWords.size()));
        }
        while(!GapMaker.wordToGap(word, wordArray));
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
        
        if(!STOP_WORDS.contains(word))
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
