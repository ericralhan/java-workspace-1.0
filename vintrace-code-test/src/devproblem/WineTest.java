package devproblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class WineTest {

	public static void main(String[] args) {

		Wine w = new Wine("2011 Chardonnay", 1000);
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir"));

		printYearBreakdown(w);
		printVarietyBreakdown(w);

	}

	private static void printVarietyBreakdown(Wine w) {
		System.out.println("******Print Variety Breakdown******");
		Map<Object, Double> map = new LinkedHashMap<Object, Double>();
		List<GrapeComponent> listComp = new ArrayList<GrapeComponent>(w.getComponents());
		Double percentage;

		for (GrapeComponent grapeComp : listComp) {
			// this grapeComp variety already exists in the map, then add the
			// percentage
			if ((percentage = map.get(grapeComp.getVariety())) != null) {
				percentage = percentage + grapeComp.getPercentage();
				map.put(grapeComp.getVariety(), percentage);
			}
			// else simply put this grapeComp variety in the map
			else {
				map.put(grapeComp.getVariety(), grapeComp.getPercentage());
			}
		}

		// in the end sort map
		SortedSet<Map.Entry<Object, Double>> mapSorted = sortMapValues(map);

		for (Map.Entry<Object, Double> entry : mapSorted) {
			System.out.println(entry.getValue() + "% - " + entry.getKey());
		}
	}

	private static void printYearBreakdown(Wine w) {
		System.out.println("******Print Year Breakdown******");
		Map<Object, Double> map = new LinkedHashMap<Object, Double>();
		List<GrapeComponent> listComp = new ArrayList<GrapeComponent>(w.getComponents());
		Double percentage;

		for (GrapeComponent grapeComp : listComp) {
			// this grapeComp year already exists in the map, then add the
			// percentage
			if ((percentage = map.get(grapeComp.getYear())) != null) {
				percentage = percentage + grapeComp.getPercentage();
				map.put(grapeComp.getYear(), percentage);
			}
			// else simply put this grapeComp year in the map
			else {
				map.put(grapeComp.getYear(), grapeComp.getPercentage());
			}
		}

		// in the end sort map
		SortedSet<Map.Entry<Object, Double>> mapSorted = sortMapValues(map);

		for (Map.Entry<Object, Double> entry : mapSorted) {
			System.out.println(entry.getValue() + "% - " + entry.getKey());
		}

	}

	/**
	 * Sort map on percentage in descending order
	 * 
	 * @param map
	 * @return sortedEntries
	 */
	private static SortedSet<Map.Entry<Object, Double>> sortMapValues(Map<Object, Double> map) {
		SortedSet<Map.Entry<Object, Double>> sortedEntries = new TreeSet<Map.Entry<Object, Double>>(
				new Comparator<Map.Entry<Object, Double>>() {
					@Override
					public int compare(Map.Entry<Object, Double> e1, Map.Entry<Object, Double> e2) {
						return e2.getValue().compareTo(e1.getValue());
					}
				});

		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}

}
