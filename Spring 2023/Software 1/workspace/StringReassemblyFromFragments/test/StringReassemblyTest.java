import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void testCombination1() {
        String str1 = "yes  ";
        String str2 = "  no";
        int overlap = 2;
        String ans = StringReassembly.combination(str1, str2, overlap);
        String expect = "yes  no";
        assertEquals(expect, ans);
    }

    @Test
    public void testCombination2() {
        String str1 = "the other day i caught a ";
        String str2 = " big ole floppy salmon";
        int overlap = 1;
        String ans = StringReassembly.combination(str1, str2, overlap);
        String expect = "the other day i caught a big ole floppy salmon";
        assertEquals(expect, ans);
    }

    @Test
    public void testCombination3() {
        String str1 = "something something something ";
        String str2 = "testy testy testy";
        int overlap = 0;
        String ans = StringReassembly.combination(str1, str2, overlap);
        String expect = "something something something testy testy testy";
        assertEquals(expect, ans);
    }

    @Test
    public void testAddToSetAvoidingSubstrings1() {
        Set<String> setStr = new Set1L<>();
        Set<String> setStrAns = new Set1L<>();
        setStr.add("test!");
        setStrAns.add("test!");
        String str1 = "test!";
        String str2 = "test!";
        StringReassembly.addToSetAvoidingSubstrings(setStr, str1);
        assertEquals(setStrAns, setStr);
        assertEquals(str2, str1);
    }

    @Test
    public void testAddToSetAvoidingSubstrings2() {
        Set<String> setStr = new Set1L<>();
        Set<String> setStrAns = new Set1L<>();
        setStr.add("test!");
        setStrAns.add("test!");
        setStrAns.add("wowza");
        String str1 = "wowza";
        String str2 = "wowza";
        StringReassembly.addToSetAvoidingSubstrings(setStr, str1);
        assertEquals(setStrAns, setStr);
        assertEquals(str2, str1);
    }

    @Test
    public void testAddToSetAvoidingSubstrings3() {
        Set<String> setStr = new Set1L<>();
        Set<String> setStrAns = new Set1L<>();
        setStr.add("test!");
        setStr.add("something");
        setStr.add("nothing69");
        setStr.add(" yes))");
        setStr.add("ASBFJDKUYVBWE");
        setStrAns.add("test!");
        setStrAns.add("something");
        setStrAns.add("nothing69");
        setStrAns.add(" yes))");
        setStrAns.add("ASBFJDKUYVBWE");
        setStrAns.add("the real answer nice");
        String str1 = "the real answer nice";
        String str2 = "the real answer nice";
        StringReassembly.addToSetAvoidingSubstrings(setStr, str1);
        assertEquals(setStrAns, setStr);
        assertEquals(str2, str1);
    }

    @Test
    public void testAddToSetAvoidingSubstrings4() {
        Set<String> setStr = new Set1L<>();
        Set<String> setStrAns = new Set1L<>();
        setStr.add("test!");
        setStr.add("something");
        setStr.add("nothing69");
        setStr.add(" yes))");
        setStr.add("ASBFJDKUYVBWE");
        setStrAns.add("test!");
        setStrAns.add("something");
        setStrAns.add("nothing69");
        setStrAns.add(" yes))");
        setStrAns.add("ASBFJDKUYVBWE");
        String str1 = " yes))";
        String str2 = " yes))";
        StringReassembly.addToSetAvoidingSubstrings(setStr, str1);
        assertEquals(setStrAns, setStr);
        assertEquals(str2, str1);
    }

    @Test
    public void testLinesFromInput1() {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        Set<String> set = new Set1L<>();
        SimpleReader inFile = new SimpleReader1L("data/cheerTest.txt");
        Set<String> setAns = new Set1L<>();

        set = StringReassembly.linesFromInput(inFile);
        setAns.add("Bucks -- Beat");
        setAns.add("Go Bucks");
        setAns.add("o Bucks -- B");
        setAns.add("Beat Mich");
        setAns.add("Michigan~");

        assertEquals(setAns, set);

        out.close();
        in.close();
    }

    @Test
    public void testPrintWithLineSeparators1() throws IOException {
        FileReader file = new FileReader("data/cheerTest.txt");
        SimpleWriter out = new SimpleWriter1L();
        String fileString = file.toString();

        out.println("printWithLineSeparators Test Case 1:");
        out.println("------------------------------------");
        out.println("Result: ");
        StringReassembly.printWithLineSeparators(fileString, out);
        out.println();
        out.println("Expected: ");
        out.println("Go Bucks -- Beat Michigan");

        file.close();
    }
}
