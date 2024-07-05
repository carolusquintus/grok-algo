package dev.carv.recursive;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class RecursiveExercises {

    public Integer sum(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        return nums.get(0) + sum(nums.subList(1, nums.size()));
    }

    public Integer sumItems(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        return 1 + sumItems(nums.subList(1, nums.size()));
    }

    public static void main(String[] args) {
        var recursive = new RecursiveExercises();

        List<Integer> nums = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16);

        var sum = recursive.sum(nums);
        log.debug("Sum: {}", sum);

        var sumItems = recursive.sumItems(nums);
        log.debug("Sum items: {}", sumItems);
    }

}
