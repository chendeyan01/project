package com.xcclass.ehcache1.Control;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private CacheManager cacheManager;
    @RequestMapping("/getCacheUser")
    public String getCacheUser(){
        Cache userCache = cacheManager.getCache("userCache");
        Element element = userCache.get("name");
        if(element==null){
            return "Ehcache缓存为空！！";
        }
        String name = (String) element.getObjectValue();
        return name;
    }

    @RequestMapping("/addCacheUser")
    public String addCacheUser(){
        Cache userCache = cacheManager.getCache("userCache");
        Element name = new Element("name","chendeyan");
        Element age = new Element("age","21");
        Element id= new Element("id","1");
        userCache.put(name);
        userCache.put(age);
        userCache.put(id);
        return "Ehcache缓存添加成功！！";
    }
}
