class Solution {

    private static Map<String, Integer> map = Map.of("I", 1, 
        "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000
    );

    private int recursive(String s){
        if(s.length() == 0){
            return 0;
        }
        if(s.startsWith("IV")){
            return 4 + recursive(s.substring(2, s.length()));
        }

        if(s.startsWith("IX")){
            return 9 + recursive(s.substring(2, s.length()));
        }

        if(s.startsWith("XL")){
            return 40 + recursive(s.substring(2, s.length()));
        }

        if(s.startsWith("XC")){
            return 90 + recursive(s.substring(2, s.length()));
        }

        if(s.startsWith("CD")){
            return 400 + recursive(s.substring(2, s.length()));
        }

        if(s.startsWith("CM")){
            return 900 + recursive(s.substring(2, s.length()));
        }

        return map.get(s.substring(0, 1)) + recursive(s.substring(1, s.length()));
    }
    public int romanToInt(String s) {
        return recursive(s);

        
    }
}