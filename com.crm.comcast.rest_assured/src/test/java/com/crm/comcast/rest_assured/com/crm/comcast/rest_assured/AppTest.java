package com.crm.comcast.rest_assured.com.crm.comcast.rest_assured;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	String [] a = {"Vijay", "Viveki", "Rajat"};
    	for(int i=0; i<a.length; i++) {
    		int count=0;
    		for(int j=0; j<a[i].length(); j++) {
    			char b = a[i].charAt(j);
    			if(b=='a'||b=='e'||b=='i'||b=='o'||b=='u') {
    				count++;
    			}
    		}
    		System.out.println(a[i]+":"+count);
    	}
       
    }
}
