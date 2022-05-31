package com.cloudencryption.algorithm;

import java.io.IOException;
import java.util.*;

public class Arrr {
    public static List<String> keywords(String data) {
        List<String> stringsList;
        ArrayList<String> al2 = new ArrayList();
        al2.add(data);
        Set<String> hash_Set = new HashSet<String>();

        try {
            hash_Set = Stop1.stopWords(al2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        stringsList = new ArrayList<>(hash_Set);
        for (int i = 0; i < stringsList.size(); i++) {
            System.out.println(stringsList.get(i));
        }
        return stringsList;
    }
}
