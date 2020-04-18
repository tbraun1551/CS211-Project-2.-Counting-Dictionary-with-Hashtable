import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ReadFile {
	private String fileName;
	
	public ReadFile(String s) {
		fileName = s;
	}
	
	public Vector<Word> process() {
		
		File f = new File(fileName);
		Scanner sc = null;
		
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Is it possible that file "+fileName+" does not exist?");
			System.exit(-1);
		}
		
		Vector<Word> toR = new Vector<Word>();
		
		while (sc.hasNext()) {
			toR.add(new Word(sc.next(),(int) (Math.random()*100)));
		}
		
		return toR;
	}

	public static void main(String[] args) {
		int count = 0;
		Vector<Word> list = getList();
		for (Word w : list) {
			System.out.println("testing " +w);
			count++;
		}
		System.out.println(count);
	}

	public static Vector<Word> getList() {
		ReadFile rf = new ReadFile("TextFile1.txt");
		Vector<Word> list = rf.process();
		return list;
	}

	public static CS211CountingDictionaryInterface addFileToDict(CS211CountingDictionaryInterface dict) {
		ReadFile reader = new ReadFile("TextFile1.txt");
		Vector<Word> r = reader.process();
		r.forEach((w) -> dict.insert(w.revealTheString()));
		return dict;
	}

	public static CS211CountingDictionaryInterface addFileToDict(CS211CountingDictionaryInterface dict, CS211CountingDictionaryInterface commonWords) {
		//Creates the Vector for TextFile2
		ReadFile reader = new ReadFile("TextFile2.txt");
		Vector<Word> r = reader.process();

		//Creates the dictionary of the common words
		ReadFile commonReader = new ReadFile("CommonWords.txt"); 
		Vector<Word> rc = commonReader.process();
		rc.forEach((cw) -> commonWords.insert(cw.revealTheString()));

		// r.forEach((c) -> if(-1 == -1) {
		// 	dict.insert(w.revealTheString);
		// });
		//Removes all the words in dict that are in commonDict
		r.removeIf((w) -> commonWords.find(w.revealTheString()) != -1);
		r.forEach(w -> dict.insert(w.revealTheString()));
		return dict;
	}
}
