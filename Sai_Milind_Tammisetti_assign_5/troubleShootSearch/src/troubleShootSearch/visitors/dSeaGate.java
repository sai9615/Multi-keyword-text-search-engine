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
}