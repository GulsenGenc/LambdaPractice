import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    //multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc", "Erik"}
        };
        System.out.println("arrayın elemanlarını list halı-->" + listele(arr));
        doubleYaz(arr);
        System.out.println("e ile başlayanların lıstesı->" + eleriListeYaz(arr));
        kBitenlereYildiz(arr);

    }

    // S1 : tum elemanlari list yapalim
    public static List<String> listele(String[][] str) {
        return Arrays.stream(str).//Arrayi akışa aldık
                flatMap(t -> Arrays.stream(t)).//array ıcınde eleman halınde olan arraylerı akışa aldık.düz bır akış elde ettık
                collect(Collectors.toList());
    }


    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void doubleYaz(String[][] str) {
        Arrays.stream(str).
                flatMap(t -> Arrays.stream(t)).
                filter(t -> t.startsWith("E")).
                map(t -> t + t).forEach(Methods::stringleriYazdır);
    }


    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String> eleriListeYaz(String[][] str) {
        return Arrays.stream(str).flatMap(Arrays::stream).filter(t -> t.startsWith("E")).collect(Collectors.toList());
    }


    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void kBitenlereYildiz(String[][] arr) {
        Arrays.stream(arr).
                flatMap(Arrays::stream).filter(t -> t.endsWith("k")).map(t -> t + "*").
                forEach(Methods::stringleriYazdır);
    }
}
