import java.text.Collator;
import java.util.Locale;

enum wat{sortString,fastSortStrings,fastSortStrings2}

public class Main {
    static Collator col = Collator.getInstance(new Locale("pl","PL"));
    static String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
            "Zyta", "Órszula", "Świętopełk"};
    public static void main(String[] args) {
        double start = System.nanoTime();
        test(names,wat.sortString,100000);
        System.out.println(System.nanoTime()-start);
        start = System.nanoTime();
        test(names,wat.fastSortStrings,100000);
        System.out.println(System.nanoTime()-start);
        start = System.nanoTime();
        test(names,wat.fastSortStrings2,100000);
        System.out.println(System.nanoTime()-start);

    }

    public static void dispStringTab(String[] strt){
        for (String st:strt){
            System.out.println(st);
        }
    }

    private static void test(String[] s1,wat w1,int probs){
        switch(w1) {
            case sortString:{
                for(int i=0;i<probs;i++){
                    SortUtf8.sortStrings(col,s1.clone());
                }

                break;
            }
            case fastSortStrings:{
                for(int i=0;i<probs;i++){
                    SortUtf8.fastSortStrings(col,s1.clone());
                }
                break;
            }
            case fastSortStrings2:{
                for(int i=0;i<probs;i++){
                    SortUtf8.fastSortStrings2(col,s1.clone());
                }
                break;
            }
            default: {
                System.out.println("Podales zly parament do metody");
                break;
            }
        }
    }
}
