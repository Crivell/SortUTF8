import org.junit.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.Assert.*;

public class SortUtf8Test {

    String[] names = {"Łukasz", "Ścibor", "Stefania", "Darek", "Agnieszka",
            "Zyta", "Órszula", "Świętopełk"};

    String[] sortedNames = {"Agnieszka",
            "Darek",
            "Łukasz",
            "Órszula",
            "Stefania",
            "Ścibor",
            "Świętopełk",
            "Zyta"} ;

    Collator col = Collator.getInstance(new Locale("pl","PL"));

    @Test
    public void sortStrings() {
        SortUtf8.sortStrings(col,names);
        assertArrayEquals(names,sortedNames);
    }

    @Test
    public void fastSortStrings() {

        SortUtf8.fastSortStrings(col,names);
        assertArrayEquals(names,sortedNames);
    }

    @Test
    public void fastSortStrings2() {
        SortUtf8.fastSortStrings2(col,names);
        assertArrayEquals(names,sortedNames);
    }

    @Test
    public void allSortTest(){
        String[][] s1 ={names,names,names};

        SortUtf8.sortStrings(col,s1[0]);
        Main.dispStringTab(s1[0]);
        System.out.println();
        SortUtf8.fastSortStrings(col,s1[1]);
        Main.dispStringTab(s1[1]);
        System.out.println();
        SortUtf8.fastSortStrings2(col,s1[2]);
        Main.dispStringTab(s1[2]);

        assertArrayEquals(s1[0],s1[1]);
        assertArrayEquals(s1[1],s1[2]);
        assertArrayEquals(s1[2],s1[0]);
    }
}