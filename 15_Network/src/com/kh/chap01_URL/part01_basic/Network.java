package com.kh.chap01_URL.part01_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Network {

	/*
	 * InetAddress IP주소에 대한 정보를 가진 클래스.
	 * 
	 * - IP : 10.10.10.10 4바이트로 이루어진 실제 주소 - HostName : naver.com, daum.com,
	 * google.com == 도메인명
	 * 
	 * InetAddress 내부 메소드는 모드 static
	 */

	public void iNetTest() {

		try {
			InetAddress naver = InetAddress.getByName("naver.com");
			// System.out.println(naver.getHostAddress());
			InetAddress[] arr = InetAddress.getAllByName("daum.com");
			for (InetAddress ip : arr) {
				System.out.println(ip); // hostname / ip;
			}

			// 내 컴퓨터의 IP주소 192.168.30.1 == localhost == 127.0.0.1
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost.getHostAddress());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/*
	 * URL : 인터넷상에 존재하는 서버들의 자원(html, jpg, xml, json ...)들에 접근할 수 있는 주소를 다루는 클래스. 실제
	 * URL자원에 대한 객체를 생성하여 자원에 연결하거나 데이터를 읽어올 수 있음(i/o 가능) 로컬자원에 접근할 때 사용하는 클래스가
	 * File이였다면 원격자원에 접근할 때 사용하는 클래스가 URL이다.
	 * 
	 * (FILE은 객체 생성시 로컬상의 디렉토리명 + 파일명을 제시) URL은 객체 생성시 접근하고자 하는 URL주소값을 제시해야함. 
	 * URL주소 : protocol + hostname + port + 자원경로(path) + 쿼리스트링(옵션) 
	 * khedu.co.kr => hostname :443 => port(생략됨) /upload/contents/mainBanner/2023110614155365392.jpg
	 * \src/com/kh/chap01_URL/part01_basic/Network.java 자원경로
	 * 
	 * 프로토콜 ? 통신규약 http, https, ftp, smtp. .... 네트워크 환경에서 서버와 클라이언트간에 데이터 송수신을 어떤식으로
	 * 할지 미리 표준화한 규칙들의 집합.
	 * 
	 * 포트번호 : 서비스번호 . 컴퓨터(서버)내에 특정 프로그램을 가리키는 논리적인 번호. 
	 *          이 포트번호를 통해 각각 다른 프로그램을 제공해 줄수 있음. --> 프로토콜에 대한 기본포트는 생략이 가능. 
	 *          https-443, http-80, ftp-20
	 * 
	 * 자원경로 : 도메인상의 서버에서 실제로 자원이 존재하는 경로.
	 */
	public void urlTest() {

		try {
			URL url = new URL(
					"https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98");

			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort() != -1 ? url.getPort() : url.getDefaultPort());
			System.out.println(url.getPath());
			System.out.println(url.getQuery()); // 사용자 입력값 (입맛에 맞게 수정가능)
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void urlConnection() {

		String address = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&ssc=tab.nx.all&query=%EC%9D%B4%EC%8A%A4%EB%9D%BC%EC%97%98+%EC%9D%B4%EB%9E%80&oquery=%EC%9D%B4%EC%8A%A4%EB%9D%BC%EC%97%98&tqi=im8h%2BspzLi0ssTrpFbCssssssrw-247062";
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			URL url = new URL(address);

			/*
			 * URLConnection : 원격서버와 통신하여 웹서버의 자원을 입력 할 수 있는 스트림을 가진 클래스. 
			 *                 URL로 연결할 서버 자원을 기술하고, URLConnection의 입력스트림을 통해 자원으로부터
			 *                 입출력이 가능함.
			 */

			URLConnection conn = url.openConnection();

			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			// conn.InputStream()으로 웹서버 자원과 연결.(스트림 생성)
			// InputStreamReader : 바이트스트림으로 읽어들인 데이터를 문자로 바꿔주는 역할을 하는 "보조스트림"
			// BufferedReader : 성능향상(빠른입력)을 위한 보조스트림.
			bw = new BufferedWriter(new FileWriter("search_naver.html"));

			String data = "";
			while ((data = br.readLine()) != null) {
				bw.write(data);
				bw.newLine(); // \n
				//System.out.println(data);
			}
			System.out.println("검색완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
