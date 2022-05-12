public class Methods {
    public static void stringleriYazdır(String str){
        System.out.print(str+ " ");
    }
    public static void intYazdır(int x){
        System.out.print(x+ " ");
    }

    public static boolean ciftBul(int x){
        return x%2==0;
    }

    public static boolean tekBul(int x){
        return x%2!=0;
    }

    public static boolean negatifMi(Integer x) {
        return x<0;
    }

    public static int kareBul(Integer x) {
        return x*x;
    }

    public static boolean pozıtıfMi(Integer x) {
        return x>0;
    }

    public static int küpBul(Integer x) {
        return x*x*x;
    }

    public static int toplam (int a,int b){
        return a+b;
    }


    public static String buyukYaz(String s) {
        return s.toUpperCase();
    }

    public static boolean eIleBaslıyorMu(String s) {
        return s.startsWith("E");
    }
}
