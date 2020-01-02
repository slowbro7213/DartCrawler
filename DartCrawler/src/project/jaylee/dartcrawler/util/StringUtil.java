package project.jaylee.dartcrawler.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import project.jaylee.dartcrawler.dartapi.ResponseDart;
import project.jaylee.dartcrawler.dartcall.DartCall;

public class StringUtil {
	
	public static String removeHtml(String str) {

		// 한줄씩 수집하는걸로 바꾸자.
		
		StringBuffer sb = new StringBuffer(str);
		Matcher matcher = Pattern.compile("<(/)?([a-zA-Z]*)((\\s|\\t)+?[a-zA-Z]*=[^>]*)?(\\s|\\t)*(/)?>").matcher(sb);
		String 	ret 	= matcher.replaceAll("");
				matcher = Pattern.compile("&(#)?[a-zA-Z]+?;").matcher(ret);
				ret 	= matcher.replaceAll("");
				matcher = Pattern.compile("<[!DOCTYPE]+?[^>]+?>").matcher(ret);
				ret 	= matcher.replaceAll("");
				matcher = Pattern.compile("(?i)<[meta]+?[^>]+?>").matcher(ret);
				ret 	= matcher.replaceAll("");
				ret		= ret.trim();
		
		return ret;
	}
	
	public static String removeSeveralCLRF(String str) {
		String CLRF = System.getProperty("line.separator");
		
		StringBuffer sb = new StringBuffer(str);
		Matcher matcher = matcher = Pattern.compile("(((\\s|\\t)*?"+CLRF+")((\\s|\\t)*?"+CLRF+"))((\\s|\\t)*?"+CLRF+")+").matcher(sb);
		String 	ret 	= matcher.replaceAll(CLRF+CLRF+CLRF);
				ret		= ret.trim();
		
		return ret;
	}
	
	
	public static void main(String[] args) {
		
		String htmlDocument = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
		"<HTML style='border:0'>\r\n" + 
		"<HEAD>\r\n" + 
		"<TITLE></TITLE>\r\n" + 
		"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" >\r\n" + 
		"<meta http-equiv=\"X-UA-TextLayoutMetrics\" content=\"gdi\" >\r\n" + 
		"<META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
		"<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/report_xml.css\">\r\n" + 
		"</HEAD>\r\n" + 
		"<BODY bgcolor=\"#FFFFFF\">\r\n" + 
		"<P><BR/></P>\r\n" + 
		"<P class='correction'><A name='toc1'>정 정 신 고 (보고)</A></P>\r\n" + 
		"<TABLE class='nb' width='600'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='600'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='600' height='20' valign='TOP'><BR/></TD>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='600' height='20' align='RIGHT' valign='TOP'>2019년 04월 23일</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<P><BR/></P>\r\n" + 
		"<P><BR/></P>\r\n" + 
		"<P style='font-size:14pt;'>1. 정정대상 공시서류 : 제46기 사업보고서</P>\r\n" + 
		"<P><BR/></P>\r\n" + 
		"<P style='font-size:14pt;'>2. 정정대상 공시서류의 최초제출일 : 2019년 3월 28일</P>\r\n" + 
		"<P><BR/></P>\r\n" + 
		"<P style='font-size:14pt;'>3. 정정사항</P>\r\n" + 
		"<TABLE border='1' width='600'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='150'></COL>\r\n" + 
		"<COL width='150'></COL>\r\n" + 
		"<COL width='150'></COL>\r\n" + 
		"<COL width='150'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<THEAD>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='150' height='20' align='CENTER'>항 &nbsp;목</TH>\r\n" + 
		"  <TH width='150' height='20' align='CENTER'>정정사유 </TH>\r\n" + 
		"  <TH width='150' height='20' align='CENTER'>정 정 전</TH>\r\n" + 
		"  <TH width='150' height='20' align='CENTER'>정 정 후</TH>\r\n" + 
		"</TR>\r\n" + 
		"</THEAD>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='150' height='154' valign='TOP'>\r\n" + 
		"<P style='font-size:9pt;'>VIII. 임원 및 직원 등에 관한 사항</P>\r\n" + 
		"<P style='font-size:9pt;'>1. 임원 및 직원의 현황<BR/>- 직원 현황</P>\r\n" + 
		"</TD>\r\n" + 
		"  <TD width='150' height='154' valign='TOP' style='font-size:9pt;'>단위 오류 수정<BR/>(백만원 =&gt; 천원)</TD>\r\n" + 
		"  <TD width='150' height='154' valign='TOP' style='font-size:9pt;'>주1) 정정 전</TD>\r\n" + 
		"  <TD width='150' height='154' valign='TOP' style='font-size:9pt;color:#004AFF;font-weight:bold;text-decoration:underline;'>주2) 정정 후</TD>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='150' height='134' valign='TOP'>\r\n" + 
		"<P style='font-size:9pt;'>VIII. 임원 및 직원 등에 관한 사항</P>\r\n" + 
		"<P style='font-size:9pt;'>1. 임원 및 직원의 현황<BR/>- 미등기임원 보수 현황</P>\r\n" + 
		"</TD>\r\n" + 
		"  <TD width='150' height='134' valign='TOP' style='font-size:9pt;'>단위 오류 수정<BR/>(백만원 =&gt; 천원)</TD>\r\n" + 
		"  <TD width='150' height='134' valign='TOP' style='font-size:9pt;'>주3) 정정 전</TD>\r\n" + 
		"  <TD width='150' height='134' valign='TOP' style='font-size:9pt;color:#004AFF;font-weight:bold;text-decoration:underline;'>주4) 정정 후</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<P><BR/>주1) 정정 전<BR/><BR/></P>\r\n" + 
		"<P>직원 현황</P>\r\n" + 
		"<TABLE class='nb' width='710'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='80'></COL>\r\n" + 
		"<COL width='152'></COL>\r\n" + 
		"<COL width='126'></COL>\r\n" + 
		"<COL width='352'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='80' height='20' valign='BOTTOM'>(기준일 : </TD>\r\n" + 
		"  <TD width='152' height='20' align='CENTER' valign='BOTTOM'>2018년 12월 31일</TD>\r\n" + 
		"  <TD width='126' height='20' valign='BOTTOM'>)</TD>\r\n" + 
		"  <TD width='352' height='20' align='RIGHT' valign='BOTTOM'>(단위 : 백만원)</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<TABLE border='1' width='709'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='93'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"<COL width='69'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"<COL width='69'></COL>\r\n" + 
		"<COL width='53'></COL>\r\n" + 
		"<COL width='78'></COL>\r\n" + 
		"<COL width='84'></COL>\r\n" + 
		"<COL width='71'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<THEAD>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='93' height='149' rowspan='3' align='CENTER'>사업부문</TH>\r\n" + 
		"  <TH width='48' height='149' rowspan='3' align='CENTER'>성별</TH>\r\n" + 
		"  <TH width='287' height='20' colspan='5' align='CENTER'>직 원 수</TH>\r\n" + 
		"  <TH width='78' height='149' rowspan='3' align='CENTER'>평 균<BR/>근속연수</TH>\r\n" + 
		"  <TH width='84' height='149' rowspan='3' align='CENTER'>연간급여<BR/>총 액</TH>\r\n" + 
		"  <TH width='71' height='149' rowspan='3' align='CENTER'>1인평균<BR/>급여액</TH>\r\n" + 
		"  <TH width='48' height='149' rowspan='3' align='CENTER'>비고</TH>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='117' height='66' colspan='2' align='CENTER'>기간의<BR/>정함이 없는<BR/>근로자</TH>\r\n" + 
		"  <TH width='117' height='66' colspan='2' align='CENTER'>기간제<BR/>근로자</TH>\r\n" + 
		"  <TH width='53' height='119' rowspan='2' align='CENTER'>합 계</TH>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='48' height='43' align='CENTER'>전체</TH>\r\n" + 
		"  <TH width='69' height='43' align='CENTER'>(단시간<BR/>근로자)</TH>\r\n" + 
		"  <TH width='48' height='43' align='CENTER'>전체</TH>\r\n" + 
		"  <TH width='69' height='43' align='CENTER'>(단시간<BR/>근로자)</TH>\r\n" + 
		"</TR>\r\n" + 
		"</THEAD>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='93' height='20' align='CENTER'>악기사업부</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>남</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>61</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='53' height='20' align='RIGHT'>61</TD>\r\n" + 
		"  <TD width='78' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='84' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='71' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='93' height='20' align='CENTER'>\"</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>여</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>16</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='53' height='20' align='RIGHT'>16</TD>\r\n" + 
		"  <TD width='78' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='84' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='71' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='141' height='20' colspan='2' align='CENTER'>합 계</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>77</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='53' height='20' align='RIGHT'>77</TD>\r\n" + 
		"  <TD width='78' height='20' align='RIGHT'>7.8</TD>\r\n" + 
		"  <TD width='84' height='20' align='RIGHT'>5,176,998</TD>\r\n" + 
		"  <TD width='71' height='20' align='RIGHT'>51,257</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<P>* 1인 평균 급여액은 연간 지급액 입니다.<BR/><BR/><SPAN style='color:#004AFF;font-weight:bold;text-decoration:underline;'>주2) 정정 후<BR/></SPAN><BR/>\r\n" + 
		"</P>\r\n" + 
		"<P>직원 현황</P>\r\n" + 
		"<TABLE class='nb' width='710'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='80'></COL>\r\n" + 
		"<COL width='152'></COL>\r\n" + 
		"<COL width='126'></COL>\r\n" + 
		"<COL width='352'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='80' height='20' valign='BOTTOM'>(기준일 : </TD>\r\n" + 
		"  <TD width='152' height='20' align='CENTER' valign='BOTTOM'>2018년 12월 31일</TD>\r\n" + 
		"  <TD width='126' height='20' valign='BOTTOM'>)</TD>\r\n" + 
		"  <TD width='352' height='20' align='RIGHT' valign='BOTTOM' style='color:#004AFF;font-weight:bold;text-decoration:underline;'>(단위 : 천원)</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<TABLE border='1' width='709'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='93'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"<COL width='69'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"<COL width='69'></COL>\r\n" + 
		"<COL width='53'></COL>\r\n" + 
		"<COL width='78'></COL>\r\n" + 
		"<COL width='84'></COL>\r\n" + 
		"<COL width='71'></COL>\r\n" + 
		"<COL width='48'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<THEAD>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='93' height='149' rowspan='3' align='CENTER'>사업부문</TH>\r\n" + 
		"  <TH width='48' height='149' rowspan='3' align='CENTER'>성별</TH>\r\n" + 
		"  <TH width='287' height='20' colspan='5' align='CENTER'>직 원 수</TH>\r\n" + 
		"  <TH width='78' height='149' rowspan='3' align='CENTER'>평 균<BR/>근속연수</TH>\r\n" + 
		"  <TH width='84' height='149' rowspan='3' align='CENTER'>연간급여<BR/>총 액</TH>\r\n" + 
		"  <TH width='71' height='149' rowspan='3' align='CENTER'>1인평균<BR/>급여액</TH>\r\n" + 
		"  <TH width='48' height='149' rowspan='3' align='CENTER'>비고</TH>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='117' height='66' colspan='2' align='CENTER'>기간의<BR/>정함이 없는<BR/>근로자</TH>\r\n" + 
		"  <TH width='117' height='66' colspan='2' align='CENTER'>기간제<BR/>근로자</TH>\r\n" + 
		"  <TH width='53' height='119' rowspan='2' align='CENTER'>합 계</TH>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='48' height='43' align='CENTER'>전체</TH>\r\n" + 
		"  <TH width='69' height='43' align='CENTER'>(단시간<BR/>근로자)</TH>\r\n" + 
		"  <TH width='48' height='43' align='CENTER'>전체</TH>\r\n" + 
		"  <TH width='69' height='43' align='CENTER'>(단시간<BR/>근로자)</TH>\r\n" + 
		"</TR>\r\n" + 
		"</THEAD>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='93' height='20' align='CENTER'>악기사업부</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>남</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>61</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='53' height='20' align='RIGHT'>61</TD>\r\n" + 
		"  <TD width='78' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='84' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='71' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='93' height='20' align='CENTER'>\"</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>여</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>16</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='53' height='20' align='RIGHT'>16</TD>\r\n" + 
		"  <TD width='78' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='84' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='71' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='141' height='20' colspan='2' align='CENTER'>합 계</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>77</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='48' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='69' height='20' align='RIGHT'>-</TD>\r\n" + 
		"  <TD width='53' height='20' align='RIGHT'>77</TD>\r\n" + 
		"  <TD width='78' height='20' align='RIGHT'>7.8</TD>\r\n" + 
		"  <TD width='84' height='20' align='RIGHT'>5,176,998</TD>\r\n" + 
		"  <TD width='71' height='20' align='RIGHT'>51,257</TD>\r\n" + 
		"  <TD width='48' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<P>* 1인 평균 급여액은 연간 지급액 입니다.<BR/><BR/>주3) 정정 전<BR/><BR/></P>\r\n" + 
		"<P>미등기임원 보수 현황</P>\r\n" + 
		"<TABLE class='nb' width='787'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='80'></COL>\r\n" + 
		"<COL width='152'></COL>\r\n" + 
		"<COL width='126'></COL>\r\n" + 
		"<COL width='429'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='80' height='20' valign='BOTTOM'>(기준일 : </TD>\r\n" + 
		"  <TD width='152' height='20' align='CENTER' valign='BOTTOM'>2018년 12월 31일</TD>\r\n" + 
		"  <TD width='126' height='20' valign='BOTTOM'>)</TD>\r\n" + 
		"  <TD width='429' height='20' align='RIGHT' valign='BOTTOM'>(단위 : 백만원)</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<TABLE border='1' width='786'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='119'></COL>\r\n" + 
		"<COL width='119'></COL>\r\n" + 
		"<COL width='165'></COL>\r\n" + 
		"<COL width='164'></COL>\r\n" + 
		"<COL width='219'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<THEAD>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='119' height='20' align='CENTER'>구 분</TH>\r\n" + 
		"  <TH width='119' height='20' align='CENTER'>인원수</TH>\r\n" + 
		"  <TH width='165' height='20' align='CENTER'>연간급여 총액</TH>\r\n" + 
		"  <TH width='164' height='20' align='CENTER'>1인평균 급여액</TH>\r\n" + 
		"  <TH width='219' height='20' align='CENTER'>비고</TH>\r\n" + 
		"</TR>\r\n" + 
		"</THEAD>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='119' height='20' align='CENTER'>미등기임원</TD>\r\n" + 
		"  <TD width='119' height='20' align='RIGHT'>13</TD>\r\n" + 
		"  <TD width='165' height='20' align='RIGHT'>1,287,902</TD>\r\n" + 
		"  <TD width='164' height='20' align='RIGHT'>99,069</TD>\r\n" + 
		"  <TD width='219' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<P><BR/><SPAN style='color:#004AFF;font-weight:bold;text-decoration:underline;'>주4) 정정 후</SPAN><BR/><BR/>\r\n" + 
		"</P>\r\n" + 
		"<P>미등기임원 보수 현황</P>\r\n" + 
		"<TABLE class='nb' width='787'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='80'></COL>\r\n" + 
		"<COL width='152'></COL>\r\n" + 
		"<COL width='126'></COL>\r\n" + 
		"<COL width='429'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='80' height='20' valign='BOTTOM'>(기준일 : </TD>\r\n" + 
		"  <TD width='152' height='20' align='CENTER' valign='BOTTOM'>2018년 12월 31일</TD>\r\n" + 
		"  <TD width='126' height='20' valign='BOTTOM'>)</TD>\r\n" + 
		"  <TD width='429' height='20' align='RIGHT' valign='BOTTOM' style='color:#004AFF;font-weight:bold;text-decoration:underline;'>(단위 : 천원)</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<TABLE border='1' width='786'>\r\n" + 
		"<COLGROUP>\r\n" + 
		"<COL width='119'></COL>\r\n" + 
		"<COL width='119'></COL>\r\n" + 
		"<COL width='165'></COL>\r\n" + 
		"<COL width='164'></COL>\r\n" + 
		"<COL width='219'></COL>\r\n" + 
		"</COLGROUP>\r\n" + 
		"<THEAD>\r\n" + 
		"<TR>\r\n" + 
		"  <TH width='119' height='20' align='CENTER'>구 분</TH>\r\n" + 
		"  <TH width='119' height='20' align='CENTER'>인원수</TH>\r\n" + 
		"  <TH width='165' height='20' align='CENTER'>연간급여 총액</TH>\r\n" + 
		"  <TH width='164' height='20' align='CENTER'>1인평균 급여액</TH>\r\n" + 
		"  <TH width='219' height='20' align='CENTER'>비고</TH>\r\n" + 
		"</TR>\r\n" + 
		"</THEAD>\r\n" + 
		"<TBODY>\r\n" + 
		"<TR>\r\n" + 
		"  <TD width='119' height='20' align='CENTER'>미등기임원</TD>\r\n" + 
		"  <TD width='119' height='20' align='RIGHT'>13</TD>\r\n" + 
		"  <TD width='165' height='20' align='RIGHT'>1,287,902</TD>\r\n" + 
		"  <TD width='164' height='20' align='RIGHT'>99,069</TD>\r\n" + 
		"  <TD width='219' height='20' align='CENTER'>-</TD>\r\n" + 
		"</TR>\r\n" + 
		"</TBODY>\r\n" + 
		"</TABLE>\r\n" + 
		"<P><BR/><BR/><BR/><BR/></P>\r\n" + 
		"<P class='pgbrk'></P>\r\n" + 
		"<P><BR/></P>\r\n" + 
		"</BODY>\r\n" + 
		"</HTML>";
		
		String con = removeHtml(htmlDocument);
		System.out.println(con);
		System.out.println("\n\n==============>>>>>   " + con.length());
		
	}
	
}
