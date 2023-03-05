public class ParagraphFrequency implements Comparable<ParagraphFrequency>{
    // step 17 Create ParagraphFrequency Class
    Integer frequency;
    String word;

    //constructor
    public ParagraphFrequency(Integer frequency, String word){
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String newWord)
    {
        this.word = newWord;
    }

    public Integer getFrequency()
    {
        return frequency;
    }

    //convert to words string
    @Override
    public String toString() {
        return "Word = " + this.word + " Frequency = " + frequency;
    }

    //compare words in accending frequency order
    @Override
    public int compareTo(ParagraphFrequency otherWordFrequency) 
    {
        int compareValue = 0;
        if(this.frequency > otherWordFrequency.frequency)
        {
            compareValue = 1;
        }
        if(this.frequency < otherWordFrequency.frequency)
        {
            compareValue = -1;
        }
        if(this.frequency == otherWordFrequency.frequency)
        {
            compareValue = 0;
        }
        return compareValue;
    }
    
}
