package week6.ReverseWord;

public class ReverseWords {

	public static void main(String[] args) {
//		String s="i.like.this.program.very.much";
		String s="Hi";
		String str=reverseWords2(s);
		System.out.println(str);

	}
	
	static String reverseWords(String S)
    {
        String[] a=S.split("\\.");
        StringBuilder str=new StringBuilder();
        
        for(int i=a.length-1;i>=0;i--){
            str.append(a[i]);
            if(i>0){
                str.append(".");
                
            }
        }
        
        return str.toString();
    }
	
	static String reverseWords2(String S)
    {
		String str="";
		String ans="";
		boolean isFirst=true;
		for(int i=0; i<S.length();i++) {
			char c=S.charAt(i);
			if(c=='.') {
				if(isFirst) {
					ans=str;
					isFirst=false;
				}
				else {
					
					ans=str+"."+ans;
				}
				str="";
			}
			else {
				str=str+c;
			}
		}
		if(ans=="") {
			return S;
		}
		else {
			
			ans=str+"."+ans;
		}
		return ans;
		
    }

}
