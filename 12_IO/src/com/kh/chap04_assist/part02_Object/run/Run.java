package com.kh.chap04_assist.part02_Object.run;

import com.kh.chap04_assist.part02_Object.mode.dao.ObjectDao;
import com.kh.chap04_assist.part02_Object.mode.dao.ObjectsDao;

public class Run {

	public static void main(String[] args) {
		
		// 객체단위로 입출력 할 수 있는 기능을 제공하는 보조스트림.
		ObjectDao od = new ObjectDao();
		//od.fileSave();
		//od.fileRead();
		
		ObjectsDao ods = new ObjectsDao();
		ods.fileSave();
		ods.fileRead();
	}
	
	
}
