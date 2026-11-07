class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq >= 1 && index < k; freq--) {

            if (bucket[freq] != null) {

                for (int num : bucket[freq]) {
                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}