class RandomizedSet {
    /** Initialize your data structure here. */
    Map<Integer, Integer> idxMap;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        idxMap = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(idxMap.containsKey(val)){
            return false;
        }
        idxMap.put(val, list.size());
        return list.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!idxMap.containsKey(val)){
            return false;
        }
        int idx = idxMap.get(val);

        /* bring the last one to here */
        int last = list.get(list.size()-1);
        list.set(idx, last);
        idxMap.put(last, idx);

        list.remove(list.size()-1);
        idxMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */