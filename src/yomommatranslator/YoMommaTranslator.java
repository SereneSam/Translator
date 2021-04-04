package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class YoMommaTranslator 
{

    public static void main(String[] args) throws FileNotFoundException 
    {
        Map<String,String> acronyms=new TreeMap<>();
        
        File inFile=new File("acronyms.txt");
        Scanner in=new Scanner(inFile);
        
        String line;
        
        while(in.hasNextLine())
        {
            line=in.nextLine();
            String[] split = line.split("\\t");
            acronyms.put(split[0].toLowerCase(), split[1]);
        }
        in.close(); 
        
        System.out.println("Enter a sentence: ");
        Scanner inUser = new Scanner(System.in).useDelimiter("\\n");
        String sentence = inUser.next();
        String[] words = sentence.split("\\s+");
        
        String newword="";
        for(int i=0;i<words.length;i++)
        {
            if(acronyms.containsKey(words[i]))
            {
                newword=newword+acronyms.get(words[i].toLowerCase())+" ";
            }
            else
            {
                newword=newword+words[i]+" ";
            }
        }
        System.out.println(newword.toLowerCase());
        
    }
    
}
