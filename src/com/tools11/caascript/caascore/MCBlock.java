package com.tools11.caascript.caascore;

public class MCBlock {
	public int OPCodeNum;
	public int OPValueNum;
	public int[] OPCode;
	public String[] OPValue;
	
	@Override
	public String toString(){

		String outCode = "";
		String outValue = "";
		for(int i=0;i<OPCode.length;i++){
			outCode = outCode + OPCode[i] + " ";
		}
		for(int j=0;j<OPValue.length;j++){
			outValue = outValue + OPValue[j] + " ";
		}
		return outCode + " " + OPCodeNum +  outValue + " " + OPValueNum + "\n";
	}
}
