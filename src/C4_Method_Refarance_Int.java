import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL = Arrays.asList(-2, -8, -5, 0, 2, 5, 6, 7, 15, 6, 8);
        tekYaz(intL);
        System.out.println();
        System.out.println("ciftleriCarp(intL) = " + ciftleriCarp(intL));
        System.out.println("kareToplami(intL) = " + kareToplami(intL));
        System.out.println("kupMax(intL) = " + kupMax(intL));

    }

    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekYaz(List<Integer> l) {
        l.stream().filter(Methods::tekBul).forEach(Methods::intYazdır);

    }


    // S2: ciftlerin carpimini bulalim
    public static Optional<Integer> ciftleriCarp(List<Integer> l) {
        return l.stream().filter(Methods::ciftBul).reduce(Math::multiplyExact);
    }


    // S3: negatiflerin kare toplamlarini  bulalim
    public static Optional<Integer> kareToplami(List<Integer> l) {
        return l.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(Methods::toplam);
    }

    // S4: poziflerin kuplerinden max yazdiralim
    public static Optional<Integer> kupMax(List<Integer> l) {
      return   l.stream().filter(Methods::pozıtıfMi).map(Methods::küpBul).reduce(Math::max);
    }}
