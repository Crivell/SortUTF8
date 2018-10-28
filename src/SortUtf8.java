
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

public class SortUtf8 {

    public static void sortStrings(Collator collator, String[] words){
        int i=1;
        while(i<(words.length)){
            int j=i;
                while(j>0 && (collator.compare(words[j-1],words[j])>0)){
                    String buf = words[j];
                    words[j]= words[j-1];
                    words[j-1] = buf;
                    j--;
            }
            i++;
        }
    }

    public static void fastSortStrings(Collator collator, String[] words){
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return collator.compare(o1,o2);
            }
        });
    }
    public static void fastSortStrings2(Collator collator, String[] words){
        Arrays.sort(words,(a,b) -> collator.compare(a,b));
    }

}

//  Insertion sort()
//        i ← 1
//        while i < length(A)
//          j ← i
//              while j > 0 and A[j-1] > A[j]
//                  swap A[j] and A[j-1]
//                  j ← j - 1
//              end while
//          i ← i + 1
//        end while

