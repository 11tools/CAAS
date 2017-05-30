package com.tools11.caascript.caascore;

public class ReserveWords {
	
	static final String r_start = "��ʼ";
	static final String r_stop = "ֹͣ";
	static final String r_run = "����";
	static final String r_delay = "��ʱ";
	static final String r_common_click = "���";
	static final String r_input = "����";
	static final String r_loop_start = "ѭ��";
	static final String r_loop_stop = "ѭ����";
	static final String r_variable = "����";
	static final String r_break = "����";
	static final String r_function = "����";
	static final String r_return = "����";
	static final String r_finish = "����";
	static final String r_whether = "�Ƿ�";
	static final String r_and = "��";
	static final String r_or = "��";
	static final String r_not = "��";
	static final String r_xor = "���";
	static final String r_switch = "�ж�";
	static final String r_case = "��";
	
	
	static final int c_start = 0x11220000 + 1;
	static final int c_stop = 0x11220000 + 2;
	static final int c_run = 0x11220000 + 3;
	static final int c_delay = 0x11220000 + 4 ;
	static final int c_common_click = 0x11220000 + 5;
	static final int c_input = 0x11220000 + 6;
	static final int c_loop_start = 0x11220000 + 7;
	static final int c_loop_stop = 0x11220000 + 8;
	static final int c_variable = 0x11220000 + 9;
	static final int c_break = 0x11220000 + 10;
	static final int c_function = 0x11220000 + 11;
	static final int c_return = 0x11220000 + 12;
	static final int c_finish = 0x11220000 + 13;
	static final int c_whether = 0x11220000 + 14;
	static final int c_and = 0x11220000 + 15;
	static final int c_or = 0x11220000 + 16;
	static final int c_not = 0x11220000 + 17;
	static final int c_xor = 0x11220000 + 18;
	static final int c_switch = 0x11220000 + 19;
	static final int c_case = 0x11220000 + 20;
	
	
	//Ϊʲô����TreeMap or HashMap����Ϊ���ڽ������̲�����Ҫ����Ч��
	public static int RW2MC(String words){
		if(words.equals(r_start)){
			return  c_start;
		}else if(words.equals(r_stop)){
			return c_stop;
		}else if(words.equals(r_run)){
			return c_run;
		}else if(words.equals(r_delay)){
			return c_delay;
		}else if(words.equals(r_common_click)){
			return c_common_click;
		}else if(words.equals(r_input)){
			return c_input;
		}else if(words.equals(r_loop_start)){
			return c_loop_start;
		}else if(words.equals(r_loop_stop)){
			return c_loop_stop;
		}else if(words.equals(r_break)){
			return c_break;
		}else if(words.equals(r_function)){
			return c_function;
		}else if(words.equals(r_return)){
			return c_return;
		}else if(words.equals(r_finish)){
			return c_finish;
		}else if(words.equals(r_whether)){
			return c_whether;
		}else if(words.equals(r_and)){
			return c_and;
		}else if(words.equals(r_or)){
			return c_or;
		}else if(words.equals(r_not)){
			return c_not;
		}else if(words.equals(r_xor)){
			return c_xor;
		}else if(words.equals(r_switch)){
			return c_switch;
		}else if(words.equals(r_case)){
			return c_case;
		}else{
			return 0;
		}
	}
	
	public static String MC2RW(int mc){
		switch(mc){
		case c_start:
			return r_start;
		case c_stop:
			return r_stop;
		case c_run:
			return r_run;
		case c_delay:
			return r_delay;
		case c_common_click:
			return r_common_click;
		case c_input:
			return r_input;
		case c_loop_start:
			return r_loop_start;
		case c_loop_stop:
			return r_loop_stop;
		case c_break:
			return r_break;
		case c_function:
			return r_function;
		case c_return:
			return r_return;
		case c_finish:
			return r_finish;
		case c_whether:
			return r_whether;
		case c_and:
			return r_and;
		case c_or:
			return r_or;
		case c_not:
			return r_not;
		case c_xor:
			return r_xor;
		case c_switch:
			return r_switch;
		case c_case:
			return r_case;
		default:
			return null;
		}
	}
	

}
