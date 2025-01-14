package com.kh.practice.chap01_poly.controller;

import java.util.Arrays;

import com.kh.practice.chap01_poly.model.vo.Member.AniBook;
import com.kh.practice.chap01_poly.model.vo.Member.Book;
import com.kh.practice.chap01_poly.model.vo.Member.CookBook;
import com.kh.practice.chap01_poly.model.vo.Member.Member;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];

	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);

	}

	public void insertMember(Member mem) {
		this.mem = mem;
	}

	public Member myInfo() {
		return mem;
	}

	public Book[] selectAll() {
		return bList;

	}

	public Book[] searchBook(String keyword) {
		Book[] bList = new Book[5];

		int index = 0;
		for (Book b : this.bList) {
			if (b.getTitle().equals(keyword)) {
				bList[index++] = b;
			}
		}
		// 원본 : 길이 5 , index : 2
		// [book, book, null, null, null]

		// 복사본 : 길이 2
		// [book, book]
		return Arrays.copyOf(bList, index);

	}

	public int rentBook(int index) {
		int result = 0;
		
		Book b = bList[index];
		
		if(b instanceof AniBook && ((AniBook) b).getAccessAge() >  mem.getAge() ) {
			result = 1;
		}
		else if(b instanceof CookBook && ((CookBook)b).isCoupon()) {
			result = 2;
			mem.setCouponCount(mem.getCouponCount()+1);
		}

		return result;
	}

}
