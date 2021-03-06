/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman_compressie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Milton
 */
public class HoffmanManager
{
    private String input = "superaardappelbananensplit";
    private PriorityQueue<HuffKnopp> charFrequency;
    private PriorityQueue<HuffKnopp> huffTree = new PriorityQueue<>();
    private HashMap<Character, String> codes = new HashMap<>();
    private HuffKnopp root;
    
    private String encodedMessage;
    private String decodedMessage;
    
    public HoffmanManager()
    {
        
        System.out.println(input);
//        System.out.println("Calculating frequencies");
        charFrequency = frequency(input);
//        for(HuffKnopp huffKnopp : charFrequency)
//        {
//            System.out.println(huffKnopp.toString());
//        }
//        
//        System.out.println("______________");
//        
//        System.out.println("generate HuffTree");
        root = generateHuffTree();
        
        for(HuffKnopp huffKnopp : huffTree)
        {
            System.out.println(huffKnopp.toString());
        }
//        
//        System.out.println("encoding characters");
        lettercodes(root, "");
        System.out.println(codes);
        
//        for(Entry<Character, String> entry : codes.entrySet())
//        {
//            System.out.println(entry.toString());
//        }
        
        encodedMessage = encodeMessage(input);
        
        System.out.println(encodedMessage);
        
        //decodeMessage(encodedMessage, root);
        System.out.println(decodeMessage(encodedMessage));
        
//        System.out.println(decodedMessage);
    }
    
    private PriorityQueue<HuffKnopp> frequency(String input)
    {
        ArrayList<Character> wordsCounted = new ArrayList<>();
        HashSet<Character> wordsUnique = new HashSet<>();
        
        List<HuffKnopp> list = new ArrayList<>();
        PriorityQueue<HuffKnopp> frequencies = new PriorityQueue<>();
        
        for (Character character : input.toCharArray())
        {
            wordsCounted.add(character);
        }
        wordsUnique.addAll(wordsCounted);
        
        for (Character character : wordsUnique)
        {
            list.add(new HuffKnopp(character, Collections.frequency(wordsCounted, character)));
        }
        
        list.sort(null);
        frequencies.addAll(list);
        return frequencies;
    }
    
    private HuffKnopp generateHuffTree()
    {
        while(charFrequency.size() > 1)
        //for(int i = charFrequency.size(); i > 1; i--)
        {
            HuffKnopp leftChild = charFrequency.poll();
            HuffKnopp rightChild = charFrequency.poll();
            HuffKnopp parent = new HuffKnopp(leftChild, rightChild);
                        
            charFrequency.add(parent);
            
//            huffTree.add(leftChild);
//            huffTree.add(rightChild);
//            huffTree.add(parent);
        }
        
        return charFrequency.poll();
    }
    
    private void lettercodes(HuffKnopp huffKnopp, String code)
    {
        
            if(huffKnopp.leftChild == null && huffKnopp.rightChild == null)
            {
                codes.put(huffKnopp.character, code);
            }
            else
            {
                lettercodes(huffKnopp.leftChild, code += 0);
                lettercodes(huffKnopp.rightChild, code += 1);
            }
        
//        for(char character : input.toCharArray())
//        {
//            String code = "";
//            
//            for(HuffKnopp huffKnopp : huffTree)
//            {
//                if(huffKnopp.character == character)
//                {
//                    code = parentCode(huffKnopp);
//                }
//            }
//            
//            codes.put(character, code);
//        }
    }
    
//    private String parentCode(HuffKnopp huffKnopp)
//    {
//        String code = "";
//        
//        if(huffKnopp.parent.leftChild == huffKnopp)
//        {
//            code += 0;
//        }
//        else
//        {
//            code += 1;
//        }
//        
//        if(huffKnopp.parent.parent != null)
//        {
//            code += parentCode(huffKnopp.parent);
//        }
//        
//        return new StringBuilder(code).reverse().toString();
//    }
    
    private String encodeMessage(String input)
    {
        String encodedMessage = "";
        for(char character : input.toCharArray())
        {
            encodedMessage += codes.get(character);
        }
        
        return encodedMessage;
    }
    
    private String decodeMessage(String encodedMessage/*, HuffKnopp huffKnopp*/)
    {
        String result = "";
        HuffKnopp currentKnoop = root;
                
        for(char bit : encodedMessage.toCharArray())
        {
            if(bit  == '0')
            {
                currentKnoop = currentKnoop.leftChild;
            }
            if(bit == '1')
            {
                currentKnoop = currentKnoop.rightChild;
            }
            
            if(currentKnoop.character != '*')
            {
                result += currentKnoop.character;
                currentKnoop = root;
            }
        }
        
        return result;
        
//        if(huffKnopp.character != '*')
//        {
//            decodedMessage += huffKnopp.character;
//            
//            decodeMessage(encodedMessage, root);
//        }
//        else
//        {
//            for(char bit : encodedMessage.toCharArray())
//            {
//                if(bit == '0')
//                {
//                    decodeMessage(encodedMessage.substring(1), huffKnopp.leftChild);
//                }
//                else if(bit == '1')
//                {
//                    decodeMessage(encodedMessage.substring(1), huffKnopp.rightChild);
//                }
//            }    
//        }
        
////            for(Entry<Character, String> entry : codes.entrySet())
////            {
////                if(entry.getValue() == code)
////                {
////                    decodedMessage += entry.getKey();
////                }
////            }
////        }
//        
////        return decodedMessage;
    }
}