public class KMP {
    private static int KmpSearch(char[] s, char[] p)
    {
        int i = 0;
        int j = 0;
        int sLen = s.length;
        int pLen = p.length;
        while (i < sLen && j < pLen)
        {
            if (j == -1 || s[i] == p[j])
            {
                i++;
                j++;
            }
            else
            {
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        else
            return -1;
    }
    public static void main(String[] args) {
        String a = "BBC ABCDAB ABCDABCDABDE";
        String b= "ABCDABD";
        int result = KmpSearch(a.toCharArray(), b.toCharArray());
        System.out.println("result>: " + result);
    }
}