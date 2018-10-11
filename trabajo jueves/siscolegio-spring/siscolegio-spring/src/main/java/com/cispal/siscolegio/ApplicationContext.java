/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cispal.siscolegio;


import java.net.URISyntaxException;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author JCISNEROSP
 */
@ComponentScan(basePackages = "com.cispal.siscolegio")
@Configuration
@EnableCaching
@EnableTransactionManagement
public class ApplicationContext {

    @Bean
    public CacheManager cacheManager() throws URISyntaxException {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        javax.cache.CacheManager cacheManager = cachingProvider.getCacheManager(
                getClass().getResource("/ehcache.xml").toURI(),
                getClass().getClassLoader());
        

        JCacheCacheManager jcacheManager = new JCacheCacheManager();
        jcacheManager.setCacheManager(cacheManager);
        return jcacheManager;
    }

//    public static void main(String[] args) {
//        try (AnnotationConfigApplicationContext ctx
//                = new AnnotationConfigApplicationContext(
//                        ApplicationContext.class)) {
//
//
//                }
//    }
}
