package etc.stream;

import java.util.Comparator;
import java.util.stream.Collectors;

import static etc.stream.Menu.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Sorting {

    public static void main(String[] args) {

        // 음식 목록 중 칼로리가 낮은 순으로 정렬 (오름차순 정렬)
        menuList.stream()
                .sorted(comparing(Dish::getCalories))
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("=================================================================");
        // 음식 목록 중 칼로리가 높은 순으로 정렬 (내림차순 정렬)
        menuList.stream()
                .sorted(comparing(Dish::getCalories).reversed())
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("=================================================================");
        // 500kcal 보다 낮은 요리중에 top3 필터링
        menuList.stream()
                .filter(dish -> dish.getCalories() < 500) // 500kcal 미만인 요리만 거름
                .sorted(comparing(Dish::getCalories).reversed()) // 걸른 애들 정렬(높은 순)
                .limit(3) // 정렬된 애들 중 상위 3개만 자름
                .collect(toList()) // 리스트로 포장
                .forEach(System.out::println); // 반복해서 println을 일괄 적용.

    }

}
