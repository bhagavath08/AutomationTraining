package JavaProgram;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String Bha = "Bhagavath";
String rev = "";
int len =Bha.length(); //leng=10
for(int i= len-1;i>0;i--) {
	rev = rev+ Bha.charAt(i);
}
System.out.println(rev);
	}

}
