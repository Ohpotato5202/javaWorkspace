package com.kh.chap02_byte.run;

import com.kh.chap02_byte.mode.dao.FileByteDao;

public class Run {
      public static void main(String[] args) {
		/*
		 * "바이트 기반 스트림"
		 * 바이트 스트림 : 1byte단위로만 입출력 가능한 통로(xxxInputStream/xxxOutstream)
		 * 기반 스트림 : 외부매체와 직접연결 가능한 스트림.
		 * 
		 * 바이트 기반 스트림 : 외부매체(file,키보드,마우스..)를 지정하고 그 외부매체와 직접 연결되는
		 * 1byte단위 통로를 개설하겠다.
		 * 
		 * xxxInputStream : xxx매체로부터 데이터를 입력 (데이터를 읽어드림)
		 * xxxOutputStream : xxx매체로 데이터를 출력 스트림 (데이터를 쓰기. (내보내기))
		 * 
		 * 
		 * 
		 * 
		 * */
    	  
    	  FileByteDao fbd = new FileByteDao();
    	  //fbd.filesave();
    	  fbd.fileRead();
    	  
	}
}
