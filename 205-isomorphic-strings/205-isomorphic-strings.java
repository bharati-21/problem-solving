class Solution {
    private String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            
            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }
            
            builder.append("" + indexMapping.get(c1) + ",");
        }
        return builder.toString();
    }
    
    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
}

/*
e -> 0
g -> 1

011
a -> 0
d -> 1

s -> 0
t -> 1
e -> 2
n -> 3
o -> 4
g -> 5
r -> 6
a -> 7
p -> 8
h -> 9
i -> 10
c -> 11
s - > 0


l -> 0
o -> 1
g -> 2
a -> 3
r -> 4
i -> 5
t -> 6
h -> 7
m -> 8
s -> 9
x -> 10
o -> 1
x -> 10
*/