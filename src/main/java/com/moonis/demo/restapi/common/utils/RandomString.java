package com.moonis.demo.restapi.common.utils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomString {

    /**
     * Generate a random string.
     */
	private String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String lower = upper.toLowerCase(Locale.ROOT);

    private static final String digits = "0123456789";
    
    private static final String specialChars="!@#$%&*()_{}[]?"; 

    private static final String alphanum = upper + lower + digits;
    
    private static final String passwordchars= alphanum + specialChars;

    
    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    private RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    private RandomString(int length, Random random) {
        this(length, random, alphanum);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    private RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Create session identifiers.
     */
    private RandomString() {
        this(21);
    }
    
    /*public static void main(String[] args) {
    	for (int i = 0; i < 6000; i++) {
    		String todayAsString = new SimpleDateFormat("ddmmyyss").format(new Date());
        	String hashId = new Hashids().encode(Integer.parseInt(todayAsString));
    		System.out.println("P"+hashId.toUpperCase()+(new RandomString(6, new Random()).nextString().toUpperCase()));
		}
    	
	}*/
    
    
    public static String generateResetoken() {    	
		return (new RandomString(20, new Random(),passwordchars).nextString());
    }
    
    public static String generateJobId() {
    	String todayAsString = new SimpleDateFormat("ddmmyyss").format(new Date());
    	String hashId = new Hashids().encode(Integer.parseInt(todayAsString));
		return ("P"+hashId.toUpperCase()+(new RandomString(6, new Random()).nextString().toUpperCase()));
    }
    
    public static String generateRIPadID() {
    	String todayAsString = new SimpleDateFormat("ddmmyyss").format(new Date());
    	String hashId = new Hashids().encode(Integer.parseInt(todayAsString));
    	return (hashId.toLowerCase()+(new RandomString(20, new Random()).nextString().toLowerCase()));
    }
    
    
    public static String generateQuestionID() {
    	String todayAsString = new SimpleDateFormat("ddmmyyss").format(new Date());
    	String hashId = new Hashids().encode(Integer.parseInt(todayAsString));
		return hashId.toUpperCase() +(new RandomString(3, new Random()).nextString().toUpperCase());
    }
    
    
    public static void main(String args[]) {
    	
    	//System.out.println("Job Id:"+generateQuestionID(TestType.RI)+" | RemoteId "+generateQuestionID(TestType.AT));
    	System.out.println("ashish-->"+generatePassword());
    }
    
    
    public static String generateCandidatedId() {
    	String todayAsString = new SimpleDateFormat("ddmmyyss").format(new Date());
    	String hashId = new Hashids().encode(Integer.parseInt(todayAsString));
    	return ("CD"+hashId.toUpperCase()+(new RandomString(3, new Random()).nextString().toUpperCase()));
    }
    
    
    public static String generatePassword() {
    	return (new RandomString(10, new Random(),passwordchars).nextString());
    }
    
    
		

}