package com.throwner.engine.character.stats;

public enum XpLevels {
	    LEVEL_1(0, 1),
	    LEVEL_2(10, 2),
	    LEVEL_3(25, 3),
	    LEVEL_4(40, 4),
	    LEVEL_5(60, 5),
	    LEVEL_6(90, 6),
	    LEVEL_7(150, 7);

	    private final int value;
	    private final int level;

	    private XpLevels(final int value, final int level) {
	        this.value = value;
	        this.level = level;
	    }

	    public final int getValue() {
	        return value;
	    }
	    
	    public final int getLevel() {
	        return level;
	    }

	    public static XpLevels lookup(final int v) {
	        final XpLevels[] a = XpLevels.values();
	        int min = 0;
	        int max = a.length  - 1;
	        int i;
	        do {
	            i = (min + max) / 2;
	            final int av = a[i].value;
	            if (v < av) {
	                max = i;
	            } else if (v > av) {
	                if (i + 1 < a.length && v < a[i + 1].value) {
	                    break;
	                }
	                min = i + 1;
	            }
	        } while (v != a[i].value && min < max);
	        if (min == max) {
	            return a[max];
	        }
	        return a[i];
	    }

}
