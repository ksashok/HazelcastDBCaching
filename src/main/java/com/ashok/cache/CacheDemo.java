package com.ashok.cache;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

import com.ashok.dao.UserDAO;
import com.ashok.dao.impl.CacheUserDaoImpl;
import com.ashok.dao.impl.UserDaoImpl;
public class CacheDemo {

	public static void main(String[] args) {
		CachingProvider provider = Caching.getCachingProvider("com.hazelcast.cache.HazelcastCachingProvider");
		CacheManager manager = provider.getCacheManager();
        MutableConfiguration<Integer, String> configuration = new MutableConfiguration<Integer, String>();
        
        Cache<Integer, String> cache = manager.createCache("users", configuration);
        
        UserDAO userdao = new CacheUserDaoImpl(cache, new UserDaoImpl());
        
       
        System.out.println(userdao.findById(2));
        


	}

}
