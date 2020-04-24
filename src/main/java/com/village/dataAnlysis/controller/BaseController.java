package com.village.dataAnlysis.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    private static Map<String,Integer> map = new HashMap<>();

   /* @RequestMapping("test")
    public Map<String,Integer> editFamily(){


//        Map<String,Object> map  = new HashMap<>();
        Integer nim = map.get("yj");
        if(nim != null){
            map.put("yj",++nim);
        }else{
            map.put("yj",0);
        }


        return map;

    }*/


}
