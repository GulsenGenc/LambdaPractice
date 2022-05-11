import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));
        hepsiniYaz(list);
        negatifleriYaz(list);
        System.out.println("\npo<itif olanların listesi-->"+pozitifList(list));
        System.out.println("\nelemanların karelerının listi-->"+kareleriList(list));
        System.out.println("\nelemanların karelerının tekrarsız listi-->"+kareleriTekrarsizList(list));
        sirala(list);
        System.out.println("");
        tersSirala(list);
        System.out.println("");
        System.out.println("pozitiflerin kuplerinden sonu 5 olanların lıstesı-->"+kuplerListe(list));
        System.out.println("");
        System.out.println("pozitiflerin karelerinden sonu 5 olmayanların lıstesı-->"+karelerson5Degil(list));
        System.out.println("");
        System.out.println("listin elemanlarının toplamı-->"+toplam(list));
        System.out.println("");
        System.out.println("negatiflerin karelerinin listi-->"+negatiflerinKareleri(list));
        System.out.println("listede 5den buyuk sayı varmı?-->"+besdenBuyukVarMi(list));
        System.out.println("listenin tüm elemanları 0 dan küçük mü?-->"+sifirdanKucukMu(list));
        System.out.println("listede 100 e eşit eleman yok mu?-->"+yuzeEsıtElemanYokMu(list));
        System.out.println("listede 0 a eşit eleman yok mu?-->"+sıfıraEsıtElemenYokMu(list));
        ilkBesElemanıTopla(list);
        System.out.println("son 5 elemanın listesi-->"+sonBesElemanıListele(list));
    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void hepsiniYaz(List<Integer> l) {
        l.stream().forEach(t-> System.out.print(t+" "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifleriYaz(List<Integer> l) {
        l.stream().filter(t-> t<0).forEach(t->System.out.print(t+" "));
    }

    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitifList(List<Integer> l) {
     return    l.stream().filter(t-> t>0).collect(Collectors.toList());
    }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> kareleriList(List<Integer> l) {
        return l.stream().map(t-> t*t).collect(Collectors.toList());
    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> kareleriTekrarsizList(List<Integer> l) {
        return l.stream().map(t-> t*t).distinct().collect(Collectors.toList());
    }

    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void sirala(List<Integer> l) {
        l.stream().sorted().forEach(t-> System.out.print(t+" "));
    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void tersSirala(List<Integer> l) {
        l.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.print(t+" "));
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> kuplerListe(List<Integer> l) {
     return    l.stream().filter(t->t>0).map(t-> t*t*t).filter(t-> t%10==5).collect(Collectors.toList());
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> karelerson5Degil(List<Integer> l) {
        return l.stream().filter(t-> t>0).map(t-> t*t).filter(t-> t%10!=5).collect(Collectors.toList());
    }

    // S10 :list elemanlarini toplamini bulalim
    public static int toplam(List<Integer> l){
        return l.stream().reduce(0,(t,u)->t+u);//Lamba expression ile
              //  reduce(0, Integer::sum);//method reference ıle
    }

    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKareleri(List<Integer> l) {
        return l.stream().filter(t->t<0).peek(t-> System.out.println("negatifler->"+t)).
                map(t-> t*t).peek(t-> System.out.println("kareleri->"+t)).collect(Collectors.toList());
                //map(Math::sqrt)-> kare almak için method reference
        //peek() methodunu kontorlunu yapmak ıstedıgımız ıslemden sonra yazıyoruz
    }

    // S12 : listeden 5 den buyuk  sayi var mi?
    public static boolean besdenBuyukVarMi(List<Integer> l) {
        return l.stream().anyMatch(t-> t>5);//true..bir tane bıle bulunca true doner. hiç bulamazsa false doner.|| operatoru gıbı
    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean sifirdanKucukMu(List<Integer> l){
        return l.stream().allMatch(t-> t<0);//false döner. hepsi kücükse true döner. bir tane bıle küçük değilse false döner.&& operatoru gıbı.
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsıtElemanYokMu(List<Integer> l){
       return l.stream().noneMatch(t-> t==100);
    }

    // S15: listenin sifira esit elemani yok mu?
    public static boolean sıfıraEsıtElemenYokMu(List<Integer> l){
        return l.stream().noneMatch(t-> t==0);
    }


    // S16:  listenin ilk 5 elemanini topla?
    public  static  void ilkBesElemanıTopla(List<Integer> l){
        System.out.println("ilk 5 elemanın toplamı-->"+l.stream().limit(5).reduce(0, Integer::sum));
    }

    //S17: listenin son bes elemaninin  listele
    public static List<Integer> sonBesElemanıListele(List<Integer> l){
        return l.stream().skip(l.size()-3).collect(Collectors.toList());
    }


}
