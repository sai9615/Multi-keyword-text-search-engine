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

}