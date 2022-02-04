public class String1More{

	public String makeTags(String tag, String word) {
                return ("<"+tag+">"+word+"</"+tag+">");
        }

        public String makeOutWord(String out, String word) {
                return (""+out.substring(0,2)+word+out.substring(2));
        }

        public String extraEnd(String str) {
                return (""+str.substring(str.length()-2)+str.substring(str.length()-2)+
		str.substring(str.length()-2));
        }

	public String firstTwo(String str) {
                if (str.length() < 2) { return str; }
                else {return (str.substring(0,2)); }
        }

        public String firstHalf(String str) {
                return(str.substring(0,(str.length()/2)));
        }

        public String withoutEnd(String str) {
                return (str.substring(1,(str.length()-1)));
        }

        public String comboString(String a, String b) {
                if (a.length()<b.length()) { return (""+a+b+a); }
                else { return (""+b+a+b);}
        }

        public String nonStart(String a, String b) {
                return(a.substring(1)+b.substring(1));
        }

        public String left2(String str) {
                return (str.substring(2)+str.substring(0,2));
        }

	public static void main(String[] args) {
		System.out.println("Compilable!");
	}
}
