package com.tools11.caascript.caascore;

public class CAASEngine {
	
	private Parser mParser;
	
	public CAASEngine(){
		mParser = new Parser();
	}
	
	public CAASEngine(String buf){
		mParser = new Parser(buf);
	}
	
	public void run(){
		mParser.startParser();
	}
	
	public void run(String buf){
		mParser.resetParser(buf);
		mParser.startParser();
	}
	
	public void runline(){
		
	}
	
	

}
