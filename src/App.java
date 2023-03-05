import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// Author Michael Feisthauer

public class App {              
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> words = readWords("res/words.txt"); //step 4
        HashMap<String, Integer> wordCounter = buildHashMap(words); // step 5
        createHTMLFile(wordCounter); // step 6

        //step 9 put HashMap into arraylist
        ArrayList<WordFrequency> wordFrequencyArray = new ArrayList<>();

        for(String key: wordCounter.keySet())
        {
            WordFrequency wordFrequency = new WordFrequency(wordCounter.get(key), key);
            wordFrequencyArray.add(wordFrequency);
        }

        Collections.sort(wordFrequencyArray);
        createSortedHTML(wordFrequencyArray);

        //step 14 read input file
        ArrayList<String> paragraphArray = readWords("res/paragraph.txt");

        //step 15 Count Word Occurrences
        HashMap<String, Integer> paragraphCounter = buildHashMap(paragraphArray);

        //step 16 passing values to create html file
        createParagraphHTMLFile(paragraphCounter);

        //step 18/19 (repeated step?) create ArrayList of ParagraphFrequency with data in HashMap
        ArrayList<ParagraphFrequency> paragraphFrequencyArray = new ArrayList<>();

        for(String key: wordCounter.keySet())
        {
            ParagraphFrequency paragraphFrequency = new ParagraphFrequency(wordCounter.get(key), key);
            paragraphFrequencyArray.add(paragraphFrequency);
        }

        //step 20 sort ArrayList & create sorted ParagraphWords.html
        Collections.sort(paragraphFrequencyArray);
        createSortedParagraphHTML(paragraphFrequencyArray);
    }

    //step 4-read input file
    private static ArrayList<String> readWords(String fileName){
        File file = new File(fileName);
        ArrayList<String> wordList = new ArrayList<>();

        try {                   //read the words.txt file
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while(line != null) {

                String[] words = line.split("[ .,]+");
                for(String word: words)
                {
                    if(word.trim().length() > 0)        //get rid of blank spaces after a word.
                    {
                        wordList.add(word.toLowerCase());
                    }
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordList;
    }

    //step 5: count word occurences
    private static HashMap<String, Integer> buildHashMap(ArrayList<String> words){
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for(String word:words) {
            Integer count = wordCounter.get(word);  //count how many times a word appears in the file.
            if(count == null)
            {
                wordCounter.put(word, 1);
            }
            else
            {
                wordCounter.put(word, count + 1);
            }
        }
        return wordCounter;
    }

    //step 6: create output HTMLfile
    private static void createHTMLFile(HashMap<String, Integer> wordCounter){
        File file= new File("res/words.html");

        try{
            FileWriter FileWriter = new FileWriter(file); //writing to an html file
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");

            builder.append("<table border = 1> ");  
            for(String key: wordCounter.keySet()){  //put each word into the table
                builder.append("<tr>");
                builder.append("<td>" + key +"</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());
            FileWriter.close();
        } catch(IOException e) {  //catch errors
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //step 10 create sorted HTML file
    private static void createSortedHTML(ArrayList<WordFrequency> passedArrayList)
    {
        File sortedFile= new File("res/sortedWords.html");

        try{
            FileWriter FileWriter = new FileWriter(sortedFile); //writing to an html file
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");

            builder.append("<table border = 1> ");  
            for(WordFrequency key : passedArrayList){  //put each word into the table
                builder.append("<tr>");
                builder.append("<td>" + key.getWord() +"</td>");
                builder.append("<td>" + key.getFrequency() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());

            FileWriter.close();
        } catch(IOException e) {  //catch errors
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //step 16 Create Output HTML File for paragraph.html
    private static void createParagraphHTMLFile(HashMap<String, Integer> wordCounter)
    {
        File file= new File("res/paragraph.html");

        try{
            FileWriter FileWriter = new FileWriter(file); //writing to an html file
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");

            builder.append("<table border = 1> ");  
            for(String key: wordCounter.keySet()){  //put each word into the table
                builder.append("<tr>");
                builder.append("<td>" + key +"</td>");
                builder.append("<td>" + wordCounter.get(key) + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());
            FileWriter.close();
        } catch(IOException e) {  //catch errors
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //step 20 create html for sorted paragraphFrequency arraylist
    private static void createSortedParagraphHTML(ArrayList<ParagraphFrequency> passedArrayList)
    {
        File sortedFile= new File("res/sortedParagraphWords.html");

        try{
            FileWriter FileWriter = new FileWriter(sortedFile); //writing to an html file
            StringBuilder builder = new StringBuilder();
            builder.append("<h1>Word Count</h1>");

            builder.append("<table border = 1> ");  
            for(ParagraphFrequency key : passedArrayList){  //put each word into the table
                builder.append("<tr>");
                builder.append("<td>" + key.getWord() +"</td>");
                builder.append("<td>" + key.getFrequency() + "</td>");
                builder.append("</tr>");
            }
            builder.append("</table>");
            FileWriter.append(builder.toString());

            FileWriter.close();
        } catch(IOException e) {  //catch errors
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}