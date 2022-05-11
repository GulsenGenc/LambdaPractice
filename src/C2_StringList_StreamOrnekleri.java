import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");
        System.out.println("ılk harfı d veya c ıle bıtenler lıstesı-->"+dcIleBasYaz(list));
        System.out.println("");
        yıldızlıYaz(list);
        System.out.println("\nalfabetık sıralı olarak listesi-->"+alfabetikSira(list));
        System.out.println("");
        lLeriSil(list);
        System.out.println("\niçinde e olanların lıstesı-->"+eOlanlarinlistesi(list));
        System.out.println("\n");
        ilkHarfi3KereYaz(list);
        System.out.println("");
        ilkBuyuksonraKucuk(list);
        System.out.println("\n uzunluğu 4 veya 6 olmayanlar-->"+uzunluk4ve6Haric(list));

    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
    public static List<String> dcIleBasYaz( List<String> l){
        //1.yontem charat() methodu ıle..
      // return l.stream().
      //         filter(t-> t.toLowerCase().charAt(0)=='d'|| t.toLowerCase().charAt(0)=='c').
      //         collect(Collectors.toList());
      //
        //2.yontem startWith() methodu ıle;
        return l.stream().filter(t-> t.startsWith("c")|| t.startsWith("d")).collect(Collectors.toList());
        //startwıth den önce toLowercase yapmaz ısek sadece küçük d ve küçük c olanları alır ,aldı da :)
    }

    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yıldızlıYaz( List<String> l){
        l.stream().map(t-> "*" + t + "*").forEach(t-> System.out.print(t+" "));
    }

    //S3: alfabetik  olarak siralayalim list olarak
    public static  List<String>  alfabetikSira( List<String> l){
     return    l.stream().sorted().collect(Collectors.toList());
    }

    //S4: tum 'l' leri silelim yazdiralim
    public static void lLeriSil( List<String> l){
        l.stream().map(t-> t.replaceAll("l","")).forEach(Methods::stringleriYazdır);
    }

    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static  List<String>  eOlanlarinlistesi( List<String> l){
        return l.stream().filter(t-> t.contains("e")).collect(Collectors.toList());
    }

    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
    public static void ilkHarfi3KereYaz( List<String> l){
        l.stream().map(t-> t.substring(0,1)+t.substring(0,1)+t).forEach(Methods::stringleriYazdır);
    }

    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
    public static void ilkBuyuksonraKucuk( List<String> l){
        l.stream().map(t-> t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).forEach(Methods::stringleriYazdır);
    }

    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
    public static  List<String>  uzunluk4ve6Haric( List<String> l){
       return l.stream().filter(t-> t.length()!=4 && t.length()!=6).collect(Collectors.toList());
    }

}
