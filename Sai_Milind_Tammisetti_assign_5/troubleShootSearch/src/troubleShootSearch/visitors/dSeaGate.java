package troubleShootSearch.visitors;

import troubleShootSearch.util.Results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;


public class dSeaGate implements visitor{

    public   Results res;
    public   ArrayList<String> myui = new ArrayList<String>();
    public void insertUI(String newValue) {
        myui.add(newValue);
    }

    public   ArrayList<String> mytech = new ArrayList<String>();
    public void insertTech(String newValue) {
        mytech.add(newValue);
    }

    public   ArrayList<String> syn = new ArrayList<String>();
    public void insertSyn(String newValue) {
        syn.add(newValue);
    }

    public dSeaGate(Results results){
        res = results;
    }

public void visit(exact_match exm){
    res.storeNewResult("______________________EXACT-MATCH_______________________");
        for(int i=0; i<mytech.size(); i++){
            String str =  mytech.get(i);
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

    public void visit(naive_stemming_match nsm){
        res.storeNewResult(" \n______________________NAIVE-STEMMING-MATCH_______________________");
        for(int i=0; i<mytech.size(); i++){
            String str =  mytech.get(i);
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
                            //System.out.println("We are same");
                                res.storeNewResult(mytech.get(i));
                                break;
                            } else {
                            continue; }
                }
            }
        }
    }

    public void visit(semantic_match sm){
        res.storeNewResult("\n______________________SEMANTIC-MATCH_______________________");
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<mytech.size(); i++){
            String str =  mytech.get(i);
            System.out.println(mytech.get(i));
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

                int mylen = uiword.size();
                int count=0;
                ArrayList<String> keys = new ArrayList<>();
                ArrayList<String> test = new ArrayList<>();
                ArrayList<String> vals = new ArrayList<>();
                for(String alph : map.keySet()){
                    keys.add(alph);
                }
                for(int n=0; n<keys.size(); n++) {
                    vals = map.get(keys.get(n));
                }
                for(int len=0; len<words.size(); len++){
                    if(count == mylen){
                        break;
                    }
                    for(int len1=0; len1<uiword.size(); len1++){
                        if(uiword.get(len1).equals(words.get(len))) {
                            //System.out.println("We are same");
                            count++;
                            System.out.println("a"+count+"word is "+words.get(len));
                            if (count == mylen) {
                                res.storeNewResult(mytech.get(i));
                                break;
                            } else {
                                continue;
                            }
                        }
                            else if(map.containsKey(words.get(len)) && map.containsValue(uiword.get(len1))){
                                count++;
                                System.out.println("b"+count+"word is "+words.get(len));
                                if(count == mylen){
                                  //  System.out+.println(mytech.get(i));
                                    res.storeNewResult(mytech.get(i));
                                    break;
                                }
                                continue;
                            }
                            else if(vals.contains(words.get(len)) && map.containsKey(uiword.get(len1))){
                                count++;
                                System.out.println("c"+count+"word is "+words.get(len));
                                if(count == mylen){
                                    res.storeNewResult(mytech.get(i));
                                    break;
                                }
                                continue;
                            }
                    }
                }
            }
        }
    }

}