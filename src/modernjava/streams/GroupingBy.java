package modernjava.streams;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

import java.util.*;

import modernjava.streams.Dish.Type;

public class GroupingBy {

    private static List<Dish> menu = asList(new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {

        Map<Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(groupingBy(d -> {
                            if(d.getCalories() <= 400) return CaloricLevel.DIET;
                            else if(d.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;}));
        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .filter(d -> d.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        System.out.println(caloricDishesByType);

        Map<Dish.Type, List<Dish>> caloricDishesByTypeFiltering = menu.stream()
                .collect(groupingBy(Dish::getType,
                                    filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(caloricDishesByTypeFiltering);

        Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                                    mapping(Dish::getName, toList())));
        System.out.println(dishNamesByType);

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));
        Map<Dish.Type, Set<String>> dishNamesByTypeTags = menu.stream()
                .collect(groupingBy(Dish::getType,
                                    flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
        System.out.println(dishNamesByTypeTags);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                                     else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                                     else return CaloricLevel.FAT;})));
        System.out.println(dishesByTypeCaloricLevel); // {MEAT={FAT=[pork], DIET=[chicken], NORMAL=[beef]}, FISH={DIET=[prawns], NORMAL=[salmon]}, OTHER={DIET=[rice, season fruit], NORMAL=[french fries, pizza]}}


        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(
                groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType); // {MEAT=Optional[pork], FISH=Optional[salmon], OTHER=Optional[pizza]}

        Map<Dish.Type, Dish> mostCaloricByTypeWithoutOptional = menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println(mostCaloricByTypeWithoutOptional); // {MEAT=pork, FISH=salmon, OTHER=pizza}

        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(
                groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType); // {MEAT=1900, FISH=750, OTHER=1550}


        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(
                groupingBy(Dish::getType,
                        mapping(d -> { if (d.getCalories() <= 400) return CaloricLevel.DIET;
                                       else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                                       else return CaloricLevel.FAT; }, toSet())));
        System.out.println(caloricLevelsByType); // {MEAT=[FAT, DIET, NORMAL], FISH=[DIET, NORMAL], OTHER=[DIET, NORMAL]}

        Collection<Dish> dishes = menu.stream().collect(toCollection(ArrayList::new));

    }

    public enum CaloricLevel {DIET, NORMAL, FAT};

}
