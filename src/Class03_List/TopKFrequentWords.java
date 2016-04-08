package Class03_List;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a composition with different kinds of words, return a list of the 
 * top K most frequent words in the composition.
 * 
 * Assumptions
 * the composition is not null and is not guaranteed to be sorted
 * K >= 1 and K could be larger than the number of distinct words in the 
 * 	composition, in this case, just return all the distinct words
 * 
 * Return
 * a list of words ordered from most frequent one to least frequent one (the 
 * list could be of size K or smaller than K)
 * 
 * Examples
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], 
 * 									top 2 frequent words are [“b”, “c”]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], 
 * 									top 4 frequent words are [“b”, “c”, "a", "d"]
 * Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"],
 * 									top 5 frequent words are [“b”, “c”, "a", "d"]
 * */

public class TopKFrequentWords {
	public String[] topKFrequent(String[] combo, int k) {
		if(combo.length == 0 || k == 0) {
			return new String[0];
		}
		if(k >= combo.length) {
			k = combo.length;
		}
		// put string in hash map and count frequent
		HashMap<String, Integer> wordsFrequent = new HashMap<String, Integer>();
		for(String word: combo) {
			Integer count = wordsFrequent.get(word);
			if(count == null) {
				wordsFrequent.put(word, 1);
			}
			wordsFrequent.put(word, count + 1);
		}
		// set a max heap
		Comparator<String> stringComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(wordsFrequent.get(o1) == wordsFrequent.get(o2)) {
					return 0;
				}
				return wordsFrequent.get(o1) < wordsFrequent.get(o2)? 1 : -1;
			} 
			
		};
		PriorityQueue<String> minHeap = new PriorityQueue<String>(k, stringComparator);
		
		// get top k frequent string
		for(Map.Entry<String, Integer> entry : wordsFrequent.entrySet()) {
			if(minHeap.size() < k) {
				minHeap.offer(entry.getKey());
			} else if (entry.getValue() > wordsFrequent.get(minHeap.peek())) {
					minHeap.poll();
					minHeap.offer(entry.getKey());
			}
		}
		String[] rsl = new String[k];
		for (int i = k - 1; i >= 0; i--) {
			rsl[i] = minHeap.poll();
		}
		return rsl;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
