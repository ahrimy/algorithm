package practice;
/*
 * ��������
 * ��� ���� ��������
 * Java
 */
public class CenterLetter {
	  public String solution(String s) {
	      int length = s.length();
	      if(length % 2 == 0){
	            s = s.substring(length/2-1,length/2+1);
	        } else {
	            s = s.substring(length/2, length/2+1);
	        }
	      return s;
	  }
}