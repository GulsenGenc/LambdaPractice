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
                {"Havuc","Erik"}
        };


    }
    // S1 : tum elemanlari list yapalim
public static List<String> listele(String[][] str){
        return Arrays.stream(str).flatMap(t->Arrays.stream(t)).collect(Collectors.toList());
}


    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim



    // S3: E ile baslayan elemanlari liste olarak yazdiralim



    //S4 : k ile bitenlerin sonuna '*' ekleyelim
}
