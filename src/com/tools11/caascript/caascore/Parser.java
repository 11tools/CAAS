package com.tools11.caascript.caascore;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;


public class Parser {
	
	enum State{
		init,
		working,
		reseting,
		aborting,
		stop,
		error,
		finish;
	}

	private static final String TAG = "Parser";
	
	private String mOriginBuff;
	private int len;
	private State mState;
	private LinkedList<MCBlock> mMcb;
	
	public Parser(){
		len = mOriginBuff.length();
		mMcb = new LinkedList<MCBlock>();
		mState = State.reseting;
	}
	
	public Parser(byte[] buff){
		try {
			mOriginBuff = new String(buff, "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mState = State.error;
		}
		len = mOriginBuff.length();
		mMcb = new LinkedList<MCBlock>();
		mState = State.init;
	}
	
	public Parser(String buff){
		mOriginBuff = buff;
		len = mOriginBuff.length();
		mMcb = new LinkedList<MCBlock>();
		mState = State.init;
	}
	
	public void resetParser(String buff){
		mState = State.reseting;
		mOriginBuff = buff;
		len = mOriginBuff.length();
		mMcb = new LinkedList<MCBlock>();
		mState = State.init;
	}
	
	public void startParser(){
		if(mState == State.init){
			mState = State.working;
			String[] mWordsAll = mOriginBuff.split("\n");
			int wordsAllLen = mWordsAll.length;
			for(int i=0;i<wordsAllLen;i++){
				DBG.DBGV(TAG,mWordsAll[i]);
				String[] mWordsLine = mWordsAll[i].split(" ");
				int wordsLineLen = mWordsLine.length;
				MCBlock mcb = new MCBlock();
				mcb.OPCode = new int[wordsLineLen];
				mcb.OPValue = new String[wordsLineLen];
				for(int j=0;j<wordsLineLen;j++){
					int opCode = ReserveWords.RW2MC(mWordsLine[j].trim());
					if(opCode!=0){
						mcb.OPCodeNum++;
						mcb.OPCode[j] = opCode;
					}else{
						mcb.OPValueNum++;
						mcb.OPValue[j] = mWordsLine[j].trim();
					}
				}
				mMcb.add(mcb);
				DBG.DBGV(TAG,mcb.toString());
			}
		}
	}
	
	public void abortParser(){
		mState = State.aborting;
	}
	
	public LinkedList<MCBlock> getSyntaxList(){
		return mMcb;
	}
	
	public int getLineNum(){
		return 0;
	}
	
}
