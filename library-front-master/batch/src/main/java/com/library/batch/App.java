package com.library.batch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	 new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
