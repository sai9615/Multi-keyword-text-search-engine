package troubleShootSearch.visitors;

import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


public class dSeaGate implements visitor {

    public   Results res;
    public   ArrayList<String> myui = new ArrayList<String>();
    /**
     * Used to insert user input.
     * @param newValue - a string.
     */
    public void insertUI(String newValue) {
        myui.add(newValue);
    }

    public   ArrayList<String> mytech = new ArrayList<String>();
    /**
     * Used to insert technical words.
     * @param newValue - a string.
     */
    public void insertTech(String newValue) {
        mytech.add(newValue);
    }

    public   ArrayList<String> mytech2 = new ArrayList<String>();
    /**
     * Used to insert technical words.
     * @param newValue - a string.
     */
    public void insertTech2(String newValue) {
        mytech2.add(newValue);
    }

    public   ArrayList<String> mytech3 = new ArrayList<String>();
    /**
     * Used to insert technical words.
     * @param newValue - a string.
     */
    public void insertTech3(String newValue) {
        mytech3.add(newValue);
    }

    public   ArrayList<String> syn = new ArrayList<String>();
    /**
     * Used to insert synonyms in arraylist.
     * @param newValue - a string.
     */
    public void insertSyn(String newValue) {
        syn.add(newValue);
    }

    /**
     * Constructor
     * @param results - a result object.
     */
    public dSeaGate(Results results){
        MyLogger.writeMessage("In constructor "+ getClass().getName(), MyLogger.DebugLevel.CONSTRUCTOR);
        res = results;
    }

    /**
     * Implement exact match policy.
     * @param exm - exact match object.
     */
public void visit(exact_match exm){
    res.writeToStdout(" \n______________________EXACT-MATCH_______________________");
    res.storeNewResult("______________________EXACT-MATCH_______________________");
        for(int i=0; i<mytech.size(); i++){
            String str =  mytech.get(i);
            str = str.replaceAll(",", "");
            String[] mystr = str.split("\\s+");
            ArrayList <String> words = new ArrayList<>();
            for(int a=0; a<mystr.length; a++){
                words.add(mystr[a]);
            }
            for (int j=0; j<myui.size(); j++){
                String strs =  myui.get(j);
                String[] mystrs = strs.split("\\s+");
                ArrayList <String> uiword = new ArrayList<>();
                for(int k=0; k<mystrs.length; k++){
                    uiword.add(mystrs[k]);
                }
                int mylen = uiword.size();
                int count=0;
                for(int len=0; len<words.size(); len++){
                    for(int len1=0; len1<uiword.size(); len1++){
                        if(uiword.get(len1).equals(words.get(len))){
                            //System.out.println("We are same");
                            count++;
                            if(count == mylen){
                                res.writeToStdout(mytech.get(i));
                                res.storeNewResult(mytech.get(i));
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    /**
     * Implement naive_stemming_match policy.
     * @param nsm - naive_stemming_match object.
     */
    public void visit(naive_stemming_match nsm){
         res.writeToStdout(" \n______________________NAIVE-STEMMING-MATCH_______________________");
        res.storeNewResult(" \n______________________NAIVE-STEMMING-MATCH_______________________");
        for(int i=0; i<mytech2.size(); i++){
            String str =  mytech2.get(i);
            str = str.replaceAll(",", "");
            String[] mystr = str.split("\\s+");
            ArrayList <String> words = new ArrayList<>();
            for(int a=0; a<mystr.length; a++){
                words.add(mystr[a]);
            }
            for (int j=0; j<myui.size(); j++){
                String strs =  myui.get(j);
                String[] mystrs = strs.split("\\s+");
                ArrayList <String> uiword = new ArrayList<>();
                for(int k=0; k<mystrs.length; k++){
                    uiword.add(mystrs[k]);
                }
                int mylen = uiword.size();
                int count=0;
                for(int len=0; len<words.size(); len++){
                        if(uiword.get(0).equals(words.get(len))){
                                res.writeToStdout(mytech2.get(i));
                                res.storeNewResult(mytech2.get(i));
                                break;
                            } else {
                            continue; }
                }
            }
        }
    }

    /**
     * Implement semantic_matchh policy.
     * @param sm - semantic_match object.
     */
    public void visit(semantic_match sm){
        res.writeToStdout("\n______________________SEMANTIC-MATCH_______________________");
        res.storeNewResult("\n______________________SEMANTIC-MATCH_______________________");
        //System.out.println(mytech3);
        int ucount=0;
        int check=0;
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int a=0; a<syn.size();a++) {
            String help = syn.get(a);
            String[]mystri = help.split(":", 2);
            ArrayList<String> synwords = new ArrayList<>();
            String[] mystrs1 = mystri[1].split("\\s*,\\s*");
            for (int k = 0; k < mystrs1.length; k++) {
                synwords.add(mystrs1[k]);
            }
            map.put(mystri[0], synwords);
        }


        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> test = new ArrayList<>();
        ArrayList<String> vals = new ArrayList<>();

        for(String alph : map.keySet()){
            keys.add(alph);
        }

        for(int n=0; n<keys.size(); n++) {
            vals = map.get(keys.get(n));
            for (int h=0; h<vals.size(); h++){
                test.add(vals.get(h));
            }
        }

            for (int i = 0; i < mytech3.size(); i++) {
                String str = mytech3.get(i);
                str = str.replaceAll(",", "");
                str = str.replaceAll(",", "");
                String[] mystr = str.split("\\s+");
                ArrayList<String> words = new ArrayList<>();
                for (int a = 0; a < mystr.length; a++) {
                    words.add(mystr[a]);
                }
                int count = 0;

                for (int j = 0; j < myui.size(); j++) {
                    String strs = myui.get(j);
                    String[] mystrs = strs.split("\\s+");
                    ArrayList<String> uiword = new ArrayList<>();
                    for (int k = 0; k < mystrs.length; k++) {
                        uiword.add(mystrs[k]);
                    }

                    int mylen = uiword.size();
                    for (int len = 0; len < words.size(); len++) {
                        for (int len1 = 0; len1 < uiword.size(); len1++) {
                            if(count == mylen){
                                break;
                            }
                            if (uiword.get(len1).equals(words.get(len))) {
                                count++;
                               // System.out.println("a" + count + "word is " + words.get(len));
                                if (count == mylen) {
                                    res.writeToStdout(mytech3.get(i));
                                    res.storeNewResult(mytech3.get(i));
                                    break;
                                }
                            } else if (keys.contains(words.get(len)) && test.contains(uiword.get(len1))) {
                                count++;
                                // System.out.println("b" + count + "word is " + words.get(len));
                                if (count == mylen) {
                                    res.writeToStdout(mytech3.get(i));
                                    res.storeNewResult(mytech3.get(i));
                                    break;
                                }
                            } else if (test.contains(words.get(len)) && keys.contains(uiword.get(len1))) {
                                count++;
                                // System.out.println("c" + count + "word is " + words.get(len));
                                if (count == mylen) {
                                    res.writeToStdout(mytech3.get(i));
                                    res.storeNewResult(mytech3.get(i));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
    }
}